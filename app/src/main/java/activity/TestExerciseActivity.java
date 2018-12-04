package activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.QuestionListRequest;
import net.SubmitAnswerRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import adapter.SelectQuestionAdapter;
import base.TitleActivity;
import data.QuestionListData;
import data.SubmitAnswerData;
import tools.DialogUtil;
import tools.ListViewForScrollView;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.TimeUTCUtils;


/**
 * Created by qupengcheng on 2018/11/14.
 */

public class TestExerciseActivity extends TitleActivity implements SelectQuestionAdapter.SelectQuestionListener {
    public static final String QUESTION_COUNT = "question.num";
    private int questionNum;
    private TextView tvTitle, tvContent, tvQuestionNo, tvQuestionCurrentNo, tvQuestionAllNo, tvQuestionTitle;
    private int questionNo = 0;
    private SelectQuestionAdapter mAdapter;
    private ListViewForScrollView lvQuestionList;
    private int allNo;
    private Button btnPreQuestion, btnNextQuestion;
    private LoadingDialog loadingDialog;
    private JSONArray arrayList = new JSONArray();
    private String date;
    private String questionCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_start_exercise);
        setMidTitle("开始答题");
        initView();
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initView() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        date = simpleDateFormat.format(new Date(System.currentTimeMillis()));


        loadingDialog = DialogUtil.createLoaddingDialog(this);
        loadingDialog.setMessage("加载中");
        loadingDialog.setCancelable(true);

        questionNum = getIntent().getIntExtra(QUESTION_COUNT, 0);
        tvTitle = (TextView) findViewById(R.id.tv_question_name);
        tvQuestionTitle = (TextView) findViewById(R.id.tv_question_title);
        lvQuestionList = (ListViewForScrollView) findViewById(R.id.lv_question_list);
        tvContent = (TextView) findViewById(R.id.tv_question_content);
        tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        tvQuestionNo = (TextView) findViewById(R.id.tv_question_no);
        tvQuestionCurrentNo = (TextView) findViewById(R.id.tv_current_question_no);
        tvQuestionAllNo = (TextView) findViewById(R.id.tv_question_all_np);
        mAdapter = new SelectQuestionAdapter(this);
        lvQuestionList.setAdapter(mAdapter);
        btnPreQuestion = (Button) findViewById(R.id.btn_pre_question);
        btnNextQuestion = (Button) findViewById(R.id.btn_next_question);

        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnNextQuestion.getText().equals("完成")) {
                    try {
                        submitAnswer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (questionNo < allNo - 1) {

                    saveAnswer(questionNo);
                    questionNo = questionNo + 1;
                    try {
                        initData();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnPreQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionNo > 0) {
                    questionNo = questionNo - 1;
                    try {
                        initData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private void initData() throws Exception {
        loadingDialog.show();
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("Questionlevel", "");
        hashMap.put("QuestionType", "1");
        hashMap.put("QuestionCount", questionNum);
        hashMap.put("AbilityItems", "");

        QuestionListRequest mRequest = new QuestionListRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<QuestionListData>() {
            @Override
            public void onSuccess(QuestionListData data) {
                if (!TextUtils.isEmpty(data.getResult_code()) && "SUCCESS".equals(data.getResult_code())) {
                    if (null != data.getData() && data.getData().size() > 0) {
                        allNo = data.getData().size();
                        int no = questionNo + 1;
                        if (allNo == no) {
                            btnNextQuestion.setText("完成");
                            btnPreQuestion.setVisibility(View.GONE);
                        } else {
                            btnNextQuestion.setText("下一题");
                        }
                        questionCode = data.getData().get(questionNo).getQuestionCode();
                        if (!TextUtils.isEmpty(data.getData().get(questionNo).getSubjectTitle()))
                            tvTitle.setText(data.getData().get(questionNo).getSubjectTitle());
                        if (!TextUtils.isEmpty(data.getData().get(questionNo).getSubjectContent()))
                            tvContent.setText(Html.fromHtml(data.getData().get(questionNo).getSubjectContent()));
                        if (!TextUtils.isEmpty(data.getData().get(questionNo).getTitle()))
                            tvQuestionTitle.setText(Html.fromHtml(data.getData().get(questionNo).getTitle()));
                        if (!TextUtils.isEmpty(data.getData().get(questionNo).getNo()))
                            tvQuestionNo.setText(data.getData().get(questionNo).getNo());
                        tvQuestionCurrentNo.setText(String.valueOf(questionNo + 1));
                        tvQuestionAllNo.setText("/" + data.getData().size());
                        if (data.getData().get(questionNo).getTypeCode() == 2) {
                            //填空
                            mAdapter.setData(data.getData().get(questionNo).getQuestionOptions(), 2);
                        } else if (data.getData().get(questionNo).getTypeCode() == 1) {
                            //选择
                            mAdapter.setData(data.getData().get(questionNo).getQuestionOptions(), 1);
                        }
                        loadingDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(TestExerciseActivity.this, msg + "", Toast.LENGTH_SHORT).show();
                loadingDialog.dismiss();
            }
        });
        mRequest.requestQuestionList(JSON.toJSONString(hashMap));
    }

    @Override
    public void addSelect(String answer) {

    }

    private void saveAnswer(int postion) {
        JSONArray array = new JSONArray();

        JSONObject innerObj = new JSONObject();
        try {
            innerObj.put("QuestionOptionCode", "");
            innerObj.put("Answer", mAdapter.getAnswer());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        array.put(innerObj);

        JSONObject innerObjList = new JSONObject();
        try {
            innerObjList.put("QuestionCode", questionCode);
            innerObjList.put("UserOptions", array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.put(innerObjList);

    }

    private void submitAnswer() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> publicMap = new HashMap<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        String endTime = simpleDateFormat.format(new Date(System.currentTimeMillis()));

        try {
            publicMap.put("appId", "123456");
            publicMap.put("timestamp", TimeUTCUtils.getUTCTimeStr());
            publicMap.put("nonce_str", MD5tools.getNonceStr());
            publicMap.put("sign", MD5tools.getSigh("", ""));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        map.put("Questions", arrayList);
        map.put("SessionKey", "26ea70c5cea4c244e2dbdb0b8d7c1aac");
        map.put("AppSignModel", publicMap);
        map.put("StartTime", date);
        map.put("EndTime", endTime);
        map.put("Title", "等级 1 雅思");

        SubmitAnswerRequest mRequest = new SubmitAnswerRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<SubmitAnswerData>() {
            @Override
            public void onSuccess(SubmitAnswerData data) {
                if (data.getResult_code().equals("SUCCESS")) {
                    Intent intent = new Intent(TestExerciseActivity.this, ReadAnswerActivity.class);
                    intent.putExtra(ReadAnswerActivity.CODE, data.getData().getPracticeCode());
                    startActivity(intent);
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(TestExerciseActivity.this, msg + "", Toast.LENGTH_SHORT).show();
            }
        });
        mRequest.requestSubmitAnswer(new JSONObject(map) + "");
    }
}
