package activity;

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

import net.ReadAnswerRequest;

import org.w3c.dom.Text;

import java.util.HashMap;

import adapter.RedAnswerAdapter;
import base.TitleActivity;
import data.PracticeDetailData;
import tools.DialogUtil;
import tools.ListViewForScrollView;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/12/2.
 */

public class ReadAnswerActivity extends TitleActivity {
    public static final String CODE = "code";
    private int questionNum;
    private TextView tvTitle, tvContent, tvQuestionNo, tvQuestionCurrentNo, tvQuestionAllNo, tvQuestionTitle;
    private int questionNo = 0;
    private RedAnswerAdapter mAdapter;
    private ListViewForScrollView lvQuestionList;
    private int allNo;
    private Button btnPreQuestion, btnNextQuestion;
    private LoadingDialog loadingDialog;
    private TextView tvAnswerDescribe, tvYourAnswer, tvCorrectAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_read_answer);
        setMidTitle("阅卷");
        initView();
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {

        loadingDialog = DialogUtil.createLoaddingDialog(this);
        loadingDialog.setMessage("加载中");
        loadingDialog.setCancelable(true);

        tvTitle = (TextView) findViewById(R.id.tv_question_name);
        tvQuestionTitle = (TextView) findViewById(R.id.tv_question_title);
        lvQuestionList = (ListViewForScrollView) findViewById(R.id.lv_question_list);
        tvContent = (TextView) findViewById(R.id.tv_question_content);
        tvYourAnswer = (TextView) findViewById(R.id.tv_correct_answer);
        tvCorrectAnswer = (TextView) findViewById(R.id.tv_your_answer);
        tvAnswerDescribe = (TextView) findViewById(R.id.tv_answer_describe);
        tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        tvQuestionNo = (TextView) findViewById(R.id.tv_question_no);
        tvQuestionCurrentNo = (TextView) findViewById(R.id.tv_current_question_no);
        tvQuestionAllNo = (TextView) findViewById(R.id.tv_question_all_np);
        mAdapter = new RedAnswerAdapter(this);
        lvQuestionList.setAdapter(mAdapter);
        btnPreQuestion = (Button) findViewById(R.id.btn_pre_question);
        btnNextQuestion = (Button) findViewById(R.id.btn_next_question);

        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (questionNo < allNo - 1) {

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
        hashMap.put("PracticeCode", getIntent().getStringExtra(CODE));

        ReadAnswerRequest mRequest = new ReadAnswerRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<PracticeDetailData>() {
            @Override
            public void onSuccess(PracticeDetailData data) {
                if (!TextUtils.isEmpty(data.getResult_code()) && "SUCCESS".equals(data.getResult_code())) {
                    if (null != data.getData() && data.getData().getPracticeDetail().size() > 0) {
                        allNo = data.getData().getPracticeDetail().size();
                        int no = questionNo + 1;
                        if (allNo == no) {
                            btnNextQuestion.setText("最后一题");
                            btnPreQuestion.setVisibility(View.GONE);
                        } else {
                            btnNextQuestion.setText("下一题");
                        }
//                        questionCode = data.getData().get(questionNo).getQuestionCode();

                        if (!TextUtils.isEmpty(data.getData().getPracticeDetail().get(questionNo).getSubjectTitle()))
                            tvTitle.setText(data.getData().getPracticeDetail().get(questionNo).getSubjectTitle());
                        if (!TextUtils.isEmpty(data.getData().getPracticeDetail().get(questionNo).getSubjectContent()))
                            tvContent.setText(Html.fromHtml(data.getData().getPracticeDetail().get(questionNo).getSubjectContent()));
                        if (!TextUtils.isEmpty(data.getData().getPracticeDetail().get(questionNo).getTitle()))
                            tvQuestionTitle.setText(Html.fromHtml(data.getData().getPracticeDetail().get(questionNo).getTitle()));
                        if (!TextUtils.isEmpty(data.getData().getPracticeDetail().get(questionNo).getNo()))
                            tvQuestionNo.setText(data.getData().getPracticeDetail().get(questionNo).getNo());
                        tvQuestionCurrentNo.setText(String.valueOf(questionNo + 1));
                        tvQuestionAllNo.setText("/" + data.getData().getPracticeDetail().size());
                        tvAnswerDescribe.setText(data.getData().getPracticeDetail().get(questionNo).getTextDescribe() + "");
                        tvYourAnswer.setText(data.getData().getPracticeDetail().get(questionNo).getUserOptions().get(0).getAnswer() + "");
                        for (int i = 0; i < data.getData().getPracticeDetail().get(questionNo).getQuestionOptions().size(); i++) {
                            if (data.getData().getPracticeDetail().get(questionNo).getQuestionOptions().get(i).isIsCorrect()) {
                                tvCorrectAnswer.setText(data.getData().getPracticeDetail().get(questionNo).getQuestionOptions().get(i).getNo() + "");
                            }
                        }
                        if (TextUtils.isEmpty(data.getData().getPracticeDetail().get(questionNo).getUserOptions().get(0).getAnswer())) {
                            tvYourAnswer.setText("未答题");
                        } else
                            tvYourAnswer.setText(data.getData().getPracticeDetail().get(questionNo).getUserOptions().get(0).getAnswer() + "");

                        if (data.getData().getPracticeDetail().get(questionNo).getTypeCode() == 2) {
                            //填空
                            mAdapter.setData(data.getData().getPracticeDetail().get(questionNo).getQuestionOptions(), 2, data.getData().getPracticeDetail().get(questionNo).getUserOptions().get(0).getAnswer());
                        } else if (data.getData().getPracticeDetail().get(questionNo).getTypeCode() == 1) {
                            //选择
                            mAdapter.setData(data.getData().getPracticeDetail().get(questionNo).getQuestionOptions(), 1, data.getData().getPracticeDetail().get(questionNo).getUserOptions().get(0).getAnswer());
                        }
                        loadingDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(ReadAnswerActivity.this, msg + "", Toast.LENGTH_SHORT).show();
                loadingDialog.dismiss();
            }
        });
        mRequest.requestReadAnswer(JSON.toJSONString(hashMap));
    }

}
