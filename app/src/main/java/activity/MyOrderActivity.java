package activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qupengcheng.qingdaoeducation.R;

import java.util.HashMap;

import adapter.MyCollectionAdapter;
import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/12.
 */

public class MyOrderActivity extends AppCompatActivity implements BGARefreshLayout.BGARefreshLayoutDelegate{
    private LinearLayout llCourse,llArticle;
    private TextView tvCourse,tvArticle,tvCourseLine,tvArticleLine;
    private MyCollectionAdapter mAdapter;
    private RecyclerView rvCollection;
    private BGARefreshLayout bgaRefreshLayout;
    private boolean isFirst,isLoad,needLoad;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);

        initView();
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {

        bgaRefreshLayout = (BGARefreshLayout) findViewById(R.id.bga_collection);
        bgaRefreshLayout.setDelegate(this);
        bgaRefreshLayout.setRefreshViewHolder(new BGAMeiTuanRefreshViewHolder(this,true));

        mAdapter = new MyCollectionAdapter(this);
        rvCollection = (RecyclerView) findViewById(R.id.rv_collection);
        rvCollection.setLayoutManager(new LinearLayoutManager(this));
        rvCollection.setAdapter(mAdapter);

        llCourse = (LinearLayout) findViewById(R.id.ll_course);
        llArticle = (LinearLayout) findViewById(R.id.ll_article);
        tvCourse = (TextView) findViewById(R.id.tv_course);
        tvArticle = (TextView) findViewById(R.id.tv_article);
        tvCourseLine = (TextView) findViewById(R.id.tv_course_line);
        tvArticleLine = (TextView) findViewById(R.id.tv_article_line);

        llCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvArticle.setTextColor(Color.parseColor("#666666"));
                tvArticleLine.setVisibility(View.GONE);
                tvCourse.setTextColor(Color.parseColor("#6692ff"));
                tvCourseLine.setVisibility(View.VISIBLE);
                isLoad = false;
                isFirst = true;
                page = 1;
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        llArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvArticle.setTextColor(Color.parseColor("#6692ff"));
                tvArticleLine.setVisibility(View.VISIBLE);
                tvCourse.setTextColor(Color.parseColor("#666666"));
                tvCourseLine.setVisibility(View.GONE);
                isLoad = false;
                isFirst = true;
                page = 1;

            }
        });
    }

    private void initData() throws Exception {
        HashMap<String,Object> map = new HashMap<>();
        map.put("appid","123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign",MD5tools.getSigh("",""));

        HashMap<String,Object> requestMain = new HashMap<>();
        requestMain.put("currentindex","1");
        requestMain.put("pagesize","10");
        requestMain.put("sqlstr","333");

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("appsignmodel",map);
        hashMap.put("sessinkey","0af61531c6c04ac4ac910d0cd59e6238");
        hashMap.put("pageconditon",requestMain);


    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        isLoad = false;
        isFirst = true;
        page = 1;
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        isLoad = true;
        isFirst = false;
        page++;
        if (needLoad) {
            try {
                initData();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }
}
