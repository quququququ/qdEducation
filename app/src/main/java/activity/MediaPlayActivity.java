package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.ArticleHandoutRequest;

import java.util.HashMap;

import adapter.ArticleVideoShowAdapter;
import base.TitleActivity;
import data.ArticleHandoutData;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import tools.ConstantUrl;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/11/14.
 */

public class MediaPlayActivity extends TitleActivity implements ArticleVideoShowAdapter.DeviceListListener {
    public static final String CODE = "code";
    private String video;
    private ArticleVideoShowAdapter mAdapter;
    private ListView lvVideoList;
    private JCVideoPlayerStandard player;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_article_video_show);
        setMidTitle("视频播放");

        initView();
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {

        player = (JCVideoPlayerStandard) findViewById(R.id.video_show_new);
        lvVideoList = (ListView) findViewById(R.id.lv_video_list_show);
        mAdapter = new ArticleVideoShowAdapter(this);
        lvVideoList.setAdapter(mAdapter);
        mAdapter.setOnIPostPackageNoListener(this);

        ivBack = (ImageView) findViewById(R.id.title_left_back_iv);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JCVideoPlayer.releaseAllVideos();
                finish();
            }
        });
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
        hashMap.put("ArticleHandoutsCode", getIntent().getStringExtra(CODE));

        ArticleHandoutRequest mRequest = new ArticleHandoutRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<ArticleHandoutData>() {
            @Override
            public void onSuccess(ArticleHandoutData data) {
                if (null != data && data.getData().getVideos().size() > 0) {
                    video = ConstantUrl.URL_Base + data.getData().getVideos().get(0).getVideoAccessoryPath().replace("\\", "/").replace(" ", "%20");

                    player.setUp(video, JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
                    player.startPlayLocic();

                    mAdapter.setData(data.getData().getVideos());
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(MediaPlayActivity.this, msg + "", Toast.LENGTH_SHORT).show();
            }
        });
        mRequest.requestAbilityItem(JSON.toJSONString(hashMap));
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress())
            return;
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void reduceNo(String path) {
        player.setUp(path, JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        player.startPlayLocic();
    }
}
