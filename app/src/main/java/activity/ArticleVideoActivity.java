package activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.ArticleHandoutListRequest;
import net.ArticleHandoutRequest;

import java.util.HashMap;

import adapter.ArticleVideoAdapter;
import base.TitleActivity;
import data.ArticleHandoutData;
import data.ArticleHandoutListData;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import tools.ConstantUrl;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/11/13.
 */

public class ArticleVideoActivity extends TitleActivity {
    public static final String ABILITY_CODE = "ability.code";
    public static final String ARTICLE_CODE = "article.code";
    public static final String ABILITY_NAME = "article.name";
    private ArticleVideoAdapter mAdapter;
    private ListView lvVideoList;
    private String video;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_article_video);
        setMidTitle(getIntent().getStringExtra(ABILITY_NAME));

        initView();
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        lvVideoList = (ListView) findViewById(R.id.lv_video_list);
        mAdapter = new ArticleVideoAdapter(this);
        lvVideoList.setAdapter(mAdapter);

    }

    private void initData() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);

        hashMap.put("AbilityItemCode", getIntent().getIntExtra(ABILITY_CODE, 0));
        hashMap.put("ArticleCode", getIntent().getStringExtra(ARTICLE_CODE));

        ArticleHandoutListRequest mRequest = new ArticleHandoutListRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<ArticleHandoutListData>() {
            @Override
            public void onSuccess(ArticleHandoutListData data) {
                if (null != data.getData() && data.getData().size() > 0)
                    mAdapter.setData(data.getData());
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(ArticleVideoActivity.this, msg + "", Toast.LENGTH_SHORT).show();
            }
        });
        mRequest.requestArticleHandoutList(JSON.toJSONString(hashMap));
    }

//    @Override
//    public void onBackPressed() {
//        if (JCVideoPlayer.backPress())
//            return;
//        super.onBackPressed();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        JCVideoPlayer.releaseAllVideos();
//    }
}
