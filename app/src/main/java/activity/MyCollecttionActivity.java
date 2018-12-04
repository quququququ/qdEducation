package activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.MyCollectionRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import adapter.MyCollectionAdapter;
import base.TitleActivity;
import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import data.MyCollectionData;
import tools.DialogUtil;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyCollecttionActivity extends TitleActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private LinearLayout llCourse, llArticle;
    private TextView tvCourse, tvArticle, tvCourseLine, tvArticleLine;
    private MyCollectionAdapter mAdapter;
    private RecyclerView rvCollection;
    private BGARefreshLayout bgaRefreshLayout;
    private boolean isFirst, isLoad, needLoad;
    private int page = 1;
    private String sqlString = "documenttype=1";
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_my_collection);
        setMidTitle("我的收藏");

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

        bgaRefreshLayout = (BGARefreshLayout) findViewById(R.id.bga_collection);
        bgaRefreshLayout.setDelegate(this);
        bgaRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(this, true));

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
                sqlString = "documenttype=1";
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
                sqlString = "documenttype=2";
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
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

        HashMap<String, Object> requestMain = new HashMap<>();
        requestMain.put("CurrentIndex", page);
        requestMain.put("PageSize", "10");
        requestMain.put("SQLStr", sqlString);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("SessionKey", "26ea70c5cea4c244e2dbdb0b8d7c1aac");
        hashMap.put("PageCondition", requestMain);


        MyCollectionRequest mRequest = new MyCollectionRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<MyCollectionData>() {
            @Override
            public void onSuccess(MyCollectionData data) {
                if (!TextUtils.isEmpty(data.getResult_code())) {
                    if (data.getResult_code().equals("SUCCESS")) {
                        if (isLoad) {
                            isLoad = false;
                            if (null != data.getData()) {
                                if (data.getData().size() < 10)
                                    needLoad = false;
                                else
                                    needLoad = true;
                                mAdapter.setLoadData(data.getData());
                            } else {
                                needLoad = false;
                            }
                            bgaRefreshLayout.endRefreshing();
                            bgaRefreshLayout.endLoadingMore();
                            loadingDialog.dismiss();
                            return;
                        }
                        mAdapter.clearData();
                        for (int i = 0; i < data.getData().size(); i++) {
                            if (sqlString.equals("documenttype=1"))
                                data.getData().get(i).setType(0);
                            else
                                data.getData().get(i).setType(1);
                        }
                        mAdapter.setData(data.getData());
                        if (data.getData().size() < 10)
                            needLoad = false;
                        else
                            needLoad = true;
                        bgaRefreshLayout.endRefreshing();
                        bgaRefreshLayout.endLoadingMore();
                        loadingDialog.dismiss();
                    } else {
                        Toast.makeText(MyCollecttionActivity.this, data.getResult_msg(), Toast.LENGTH_SHORT).show();
                        bgaRefreshLayout.endRefreshing();
                        bgaRefreshLayout.endLoadingMore();
                        loadingDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(MyCollecttionActivity.this, msg, Toast.LENGTH_SHORT).show();
                bgaRefreshLayout.endRefreshing();
                bgaRefreshLayout.endLoadingMore();
                loadingDialog.dismiss();
            }
        });
        mRequest.requestMyCollection(JSON.toJSONString(hashMap));
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
