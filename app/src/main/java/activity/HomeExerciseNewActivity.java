package activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.QuestionFiltersRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import base.TitleActivity;
import data.QuestionFiltersData;
import data.QuestionListData;
import tools.DialogUtil;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.MyGridView;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/16.
 */

public class HomeExerciseNewActivity extends TitleActivity implements View.OnClickListener {
    private SeekBar seekBar;
    private TextView tvSelectNum;
    private String strExeGrade = "";
    private String strExeType = "";
    private RadioGroup rbOne, rbTwo, rbExerciseType;
    private Button btnToTest;
    private int questionCount = 20;
    private List<Map<String, Object>> list = new ArrayList();
    private List<Map<String, Object>> listLessonType = new ArrayList();
    private List<Map<String, Object>> listLevel = new ArrayList();
    private SimpleAdapter simpleAdapter,simpleAbilitydapter,simpleLevelAdapter;
    private MyGridView gridView,gridViewType,gridViewLessonType;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_home_exercise_new);
        setMidTitle("练习题");
        initView();
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData() throws Exception {
        loadingDialog.show();
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        QuestionFiltersRequest mRequest = new QuestionFiltersRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<QuestionFiltersData>() {
            @Override
            public void onSuccess(QuestionFiltersData data) {
                if (null != data.getData().getAbilityItems() && data.getData().getAbilityItems().size() != 0) {
                    String[] iconName = new String[data.getData().getQuestionTypes().size()];
                    int[] icon = new int[data.getData().getQuestionTypes().size()];

                    for (int i = 0; i < data.getData().getQuestionTypes().size(); i++) {
                        Log.i("------",data.getData().getQuestionTypes().get(i).getName()+"");
                        iconName[i] = data.getData().getQuestionTypes().get(i).getName();
                        icon[i] = data.getData().getQuestionTypes().get(i).getCode();
                    }

                    if (null != icon && icon.length > 0) {
                        for (int i = 0; i < icon.length; i++) {
                            Map<String, Object> map = new HashMap<>();
                            map.put("image", icon[i]);
                            map.put("text", iconName[i]);

                            list.add(map);
                        }

                        simpleAdapter = new SimpleAdapter(HomeExerciseNewActivity.this, list, R.layout
                                .item_lesson_type, new String[]{"text"}, new int[]{R.id.tv_lesson_type});

                        gridView.setAdapter(simpleAdapter);
                    }

                    String[] iconNameLevel = new String[data.getData().getAbilityItems().size()];
                    int[] iconLevel = new int[data.getData().getAbilityItems().size()];

                    for (int i = 0; i < data.getData().getAbilityItems().size(); i++) {
                        iconNameLevel[i] = data.getData().getAbilityItems().get(i).getName();
                        iconLevel[i] = data.getData().getAbilityItems().get(i).getCode();
                    }

                    if (null != iconLevel && iconLevel.length > 0) {
                        for (int i = 0; i < iconLevel.length; i++) {
                            Map<String, Object> map = new HashMap<>();
                            map.put("image", iconLevel[i]);
                            map.put("text", iconNameLevel[i]);
                            listLessonType.add(map);
                        }

                        simpleAbilitydapter = new SimpleAdapter(HomeExerciseNewActivity.this, listLessonType, R.layout
                                .item_lesson_type, new String[]{"text"}, new int[]{R.id.tv_lesson_type});

                        gridViewLessonType.setAdapter(simpleAbilitydapter);
                    }



                    if (null != data.getData().getQuestionLevels() && data.getData().getQuestionLevels().size() > 0) {
                        for (int i = 0; i < data.getData().getQuestionLevels().size(); i++) {
                            Map<String, Object> map = new HashMap<>();
                            map.put("image", "");
                            map.put("text", "等级"+String.valueOf(data.getData().getQuestionLevels().get(i)));
                            listLevel.add(map);
                        }

                        simpleLevelAdapter = new SimpleAdapter(HomeExerciseNewActivity.this, listLevel, R.layout
                                .item_lesson_type, new String[]{"text"}, new int[]{R.id.tv_lesson_type});

                        gridViewType.setAdapter(simpleLevelAdapter);
                    }
                }
                loadingDialog.dismiss();
            }

            @Override
            public void onFailed(String msg, String code) {
                loadingDialog.dismiss();
            }
        });
        mRequest.requestAbilityItem(JSON.toJSONString(map));
    }

    private void initView() {
        loadingDialog = DialogUtil.createLoaddingDialog(this);
        loadingDialog.setMessage("加载中");
        loadingDialog.setCancelable(true);

        seekBar = (SeekBar) findViewById(R.id.sb_my_exercise);
        tvSelectNum = (TextView) findViewById(R.id.tv_exercise_select_num);
        btnToTest = (Button) findViewById(R.id.btn_to_test);

        btnToTest.setOnClickListener(this);

        gridView = (MyGridView) findViewById(R.id.gv_exercise_type);
        gridViewType = (MyGridView) findViewById(R.id.gv_exercise_level);
        gridViewLessonType = (MyGridView) findViewById(R.id.gv_exercise_lesson_type);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int seekProgress = seekBar.getProgress();
                if (seekProgress < 13) {
                    seekBar.setProgress(0);
                    tvSelectNum.setText("10题");
                    questionCount = 10;
                } else if (seekProgress >= 13 && seekProgress < 38) {
                    seekBar.setProgress(25);
                    tvSelectNum.setText("20题");
                    questionCount = 20;
                } else if (seekProgress >= 38 && seekProgress < 63) {
                    seekBar.setProgress(50);
                    tvSelectNum.setText("50题");
                    questionCount = 50;
                } else if (seekProgress >= 63 && seekProgress < 88) {
                    seekBar.setProgress(75);
                    tvSelectNum.setText("80题");
                    questionCount = 80;
                } else if (seekProgress >= 88) {
                    seekBar.setProgress(100);
                    tvSelectNum.setText("不限");
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_to_test:
                Intent intent = new Intent(HomeExerciseNewActivity.this, TestExerciseActivity.class);
                intent.putExtra(TestExerciseActivity.QUESTION_COUNT, questionCount);
                startActivity(intent);
        }
    }

}
