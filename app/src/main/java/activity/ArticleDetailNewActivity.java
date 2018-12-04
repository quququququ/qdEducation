package activity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;
import net.ArticleHandoutListRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import adapter.ArticleDetailNewAdapter;
import base.TitleActivity;
import data.ArticleHandoutListData;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/11/13.
 */

public class ArticleDetailNewActivity extends TitleActivity {
    public static final String ARTICLE_CODE = "article.code";
    public static final String ARTICLE_TITLE = "article.title";
    private TextView tvTitle;
    private ExpandableListView lvArticleDetail;
    private ArticleDetailNewAdapter mAdapter;
    private List<ArticleHandoutListData.DataBean> groupArray = new ArrayList<>();
    private List<List<ArticleHandoutListData.DataBean.ArticleHandoutsBean>> childArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_article_detail_new);
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
        tvTitle.setText(getIntent().getStringExtra(ARTICLE_TITLE));
        lvArticleDetail = (ExpandableListView) findViewById(R.id.lv_article_type);

    }

    private void initData() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("ArticleCode", getIntent().getStringExtra(ARTICLE_CODE));

        ArticleHandoutListRequest mRequest = new ArticleHandoutListRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<ArticleHandoutListData>() {
            @Override
            public void onSuccess(ArticleHandoutListData data) {
                if (null != data && "SUCCESS".equals(data.getResult_code())) {
                    if (null != data.getData()) {
                        for (int i = 0; i < data.getData().size(); i++) {
                            groupArray.add(data.getData().get(i));
                        }
                        for (int i = 0; i < groupArray.size(); i++) {
                            childArray.add(data.getData().get(i).getArticleHandouts());
                        }
                        mAdapter = new ArticleDetailNewAdapter(ArticleDetailNewActivity.this,groupArray,childArray);
                        lvArticleDetail.setGroupIndicator(null);
                        lvArticleDetail.setAdapter(mAdapter);
                        for (int i = 0; i < groupArray.size(); i++) {
                            lvArticleDetail.expandGroup(i);
                        }
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(ArticleDetailNewActivity.this, msg + "", Toast.LENGTH_SHORT).show();
            }
        });
        mRequest.requestArticleHandoutList(JSON.toJSONString(hashMap));
    }

}
