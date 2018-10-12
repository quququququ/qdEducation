package activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.MyCollectionRequest;

import java.util.HashMap;

import adapter.MyCollectionAdapter;
import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import data.MyCollectionData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyCollecttionActivity extends AppCompatActivity implements BGARefreshLayout.BGARefreshLayoutDelegate{
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
        initData();
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
                initData();
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
                initData();

            }
        });
    }

    private void initData() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("a","111");
        map.put("b","222");
        map.put("c","333");

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("d",map);

        map.toString();

        MyCollectionRequest mRequest = new MyCollectionRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<MyCollectionData>() {
            @Override
            public void onSuccess(MyCollectionData data) {
                if (isLoad) {
                    isLoad = false;
                    if (data.getData().size() < 10)
                        needLoad = false;
                    else
                        needLoad = true;
                    mAdapter.setLoadData(data.getData());
                    bgaRefreshLayout.endRefreshing();
                    bgaRefreshLayout.endLoadingMore();
                    return;
                }
                mAdapter.clearData();
                mAdapter.setData(data.getData());
                if (data.getData().size() < 10)
                    needLoad = false;
                else
                    needLoad = true;
                bgaRefreshLayout.endRefreshing();
                bgaRefreshLayout.endLoadingMore();
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(MyCollecttionActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        mRequest.requestMyCollection("");
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        isLoad = false;
        isFirst = true;
        page = 1;
        initData();
    }


    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        isLoad = true;
        isFirst = false;
        page++;
        if (needLoad) {
            initData();
            return true;
        } else {
            return false;
        }
    }
}
