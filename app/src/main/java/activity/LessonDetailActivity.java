package activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.LessonDetailRequest;

import java.util.HashMap;

import adapter.LessonDetailAdapter;
import base.TitleActivity;
import data.LessonDetailData;
import tools.ConstantUrl;
import tools.ListViewForScrollView;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/11/4.
 */

public class LessonDetailActivity extends TitleActivity {
    public static final String LESSON_CODE = "lesson.code";
    public static final String STUDY_SITUATION = "study.situation";
    private ImageView ivLessonTop;
    private TextView tvLessonNum;
    private ListViewForScrollView lvLessonDetail;
    private LessonDetailAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_lesson_detail);
        setMidTitle("课程明细");

        initView();
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        tvLessonNum = (TextView) findViewById(R.id.tv_lesson_num);
        ivLessonTop = (ImageView) findViewById(R.id.iv_lesson0_top);
        lvLessonDetail = (ListViewForScrollView) findViewById(R.id.lv_lesson_detail);
        mAdapter = new LessonDetailAdapter(this);
        lvLessonDetail.setAdapter(mAdapter);
    }

    private void initData() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));


        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("SessionKey", "");
        hashMap.put("LessonCode", getIntent().getStringExtra(LESSON_CODE));

        LessonDetailRequest mRequest = new LessonDetailRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<LessonDetailData>() {
            @Override
            public void onSuccess(LessonDetailData data) {
                if(data.getResult_code().equals("SUCCESS")) {

                    Glide.with(getApplicationContext()).load(ConstantUrl.URL_Base + data.getData().getPicturePath()).into(ivLessonTop);
                    if (null != data.getData().getArticles() && data.getData().getArticles().size() > 0) {
                        tvLessonNum.setText("共"+data.getData().getArticles().size()+"篇文章");
                        mAdapter.setData(data.getData().getArticles(),getIntent().getBooleanExtra(STUDY_SITUATION,false));
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(LessonDetailActivity.this, msg + "", Toast.LENGTH_SHORT).show();
            }
        });
        mRequest.requestLessonDetail(JSON.toJSONString(hashMap));
    }
}
