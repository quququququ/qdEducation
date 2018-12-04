package activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.ArticleDetailRequest;

import java.util.HashMap;

import adapter.ArticleDetailAdapter;
import base.TitleActivity;
import data.ArticleDetailData;
import tools.ListViewForScrollView;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/11/13.
 */

public class ArticleDetailActivity extends TitleActivity {
    public static final String ARTICLE_CODE = "article.code";
    private TextView tvTitle;
    private ListViewForScrollView lvArticleDetail;
    private ArticleDetailAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_article_detail);
        setMidTitle("文章明细");

        initView();
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_article_title);
        lvArticleDetail = (ListViewForScrollView) findViewById(R.id.lv_article_type);
        mAdapter = new ArticleDetailAdapter(this);
        lvArticleDetail.setAdapter(mAdapter);
    }

    private void initData() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("SessionKey", "26ea70c5cea4c244e2dbdb0b8d7c1aac");
        hashMap.put("ArticleCode", getIntent().getStringExtra(ARTICLE_CODE));

        ArticleDetailRequest mRequest = new ArticleDetailRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<ArticleDetailData>() {
            @Override
            public void onSuccess(ArticleDetailData data) {
                if (null != data && "SUCCESS".equals(data.getResult_code())) {
                    if (null != data.getData()) {
                        tvTitle.setText(data.getData().getTitle());
                        if (null != data.getData().getAbilityItemList()) {
                            mAdapter.setData(data.getData().getAbilityItemList(),getIntent().getStringExtra(ARTICLE_CODE));
                        }
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(ArticleDetailActivity.this, msg + "", Toast.LENGTH_SHORT).show();
            }
        });
        mRequest.requestArticleDetail(JSON.toJSONString(hashMap));
    }

}
