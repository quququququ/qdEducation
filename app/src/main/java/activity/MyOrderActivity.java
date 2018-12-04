package activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;
import com.google.gson.Gson;

import net.MyOrderRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import adapter.MyOrderAdapter;
import base.TitleActivity;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import data.MyOrderData;
import tools.DialogUtil;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/12.
 */

public class MyOrderActivity extends TitleActivity implements BGARefreshLayout.BGARefreshLayoutDelegate,View.OnClickListener{
    private LinearLayout llAllOrder,llWaitPay,llOrderSuccess,llOrderFail;
    private TextView tvAllOrder,tvWaitPay,tvOrderSuccess,tvOrderFail;
    private TextView tvAllOrderLine,tvWaitPayLine,tvOrderSuccessLine,tvOrderFailLine;
    private MyOrderAdapter mAdapter;
    private RecyclerView rvCollection;
    private BGARefreshLayout bgaRefreshLayout;
    private boolean isFirst,isLoad,needLoad;
    private int page = 1;
    private int status = 1;
    private LoadingDialog loadingDialog;
    private String sqlString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_my_order);
        setMidTitle("我的订单");
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

        llAllOrder = (LinearLayout) findViewById(R.id.ll_all_order);
        llWaitPay = (LinearLayout) findViewById(R.id.ll_wait_pay);
        llOrderSuccess = (LinearLayout) findViewById(R.id.ll_order_succes);
        llOrderFail = (LinearLayout) findViewById(R.id.ll_order_fail);
        tvAllOrder = (TextView) findViewById(R.id.tv_all_order);
        tvAllOrderLine = (TextView) findViewById(R.id.tv_all_order_line);
        tvWaitPay = (TextView) findViewById(R.id.tv_wait_pay);
        tvWaitPayLine = (TextView) findViewById(R.id.tv_wait_pay_line);
        tvOrderSuccess = (TextView) findViewById(R.id.tv_order_success);
        tvOrderSuccessLine = (TextView) findViewById(R.id.tv_order_success_line);
        tvOrderFail = (TextView) findViewById(R.id.tv_order_fail);
        tvOrderFailLine = (TextView) findViewById(R.id.tv_order_fail_line);

        bgaRefreshLayout = (BGARefreshLayout) findViewById(R.id.bga_my_order);
        bgaRefreshLayout.setDelegate(this);
        bgaRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(this,true));

        mAdapter = new MyOrderAdapter(this);
        rvCollection = (RecyclerView) findViewById(R.id.rv_my_order);
        rvCollection.setLayoutManager(new LinearLayoutManager(this));
        rvCollection.setAdapter(mAdapter);

        llAllOrder.setOnClickListener(this);
        llWaitPay.setOnClickListener(this);
        llOrderSuccess.setOnClickListener(this);
        llOrderFail.setOnClickListener(this);

    }

    private void initData() throws Exception {
        loadingDialog.show();

        HashMap<String, Object> map = new HashMap<>();
        JSONObject object = new JSONObject();
        HashMap<String, Object> publicMap = new HashMap<>();
        try {
            object.put("CurrentIndex", 1);
            object.put("PageSize", 10);
            object.put("SQLStr", sqlString);
            JSONArray array = new JSONArray();
            JSONObject innerObj = new JSONObject();
            innerObj.put("ColumnName", "CreateDate");
            innerObj.put("Order", 1);
            array.put(innerObj);
            object.put("Sorts", array);


            publicMap.put("appId", "123456");
            publicMap.put("timestamp", TimeUTCUtils.getUTCTimeStr());
            publicMap.put("nonce_str", MD5tools.getNonceStr());
            publicMap.put("sign", MD5tools.getSigh("", ""));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        map.put("PageCondition", object);
        map.put("SessionKey", "26ea70c5cea4c244e2dbdb0b8d7c1aac");
        map.put("AppSignModel", publicMap);

        MyOrderRequest myOrderRequest = new MyOrderRequest(this);
        myOrderRequest.setListener(new BaseHttpRequest.IRequestListener<MyOrderData>() {
            @Override
            public void onSuccess(MyOrderData data) {
                if (isLoad) {
                    isLoad = false;
                    if(null != data.getData()) {
                        if (data.getData().size() < 10)
                            needLoad = false;
                        else
                            needLoad = true;
                        mAdapter.setLoadData(data.getData());
                    }else {
                        needLoad = false;
                    }
                    bgaRefreshLayout.endRefreshing();
                    bgaRefreshLayout.endLoadingMore();
                    loadingDialog.dismiss();
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
                loadingDialog.dismiss();
            }

            @Override
            public void onFailed(String msg, String code) {
                mAdapter.clearData();
                bgaRefreshLayout.endRefreshing();
                bgaRefreshLayout.endLoadingMore();
                loadingDialog.dismiss();
                Toast.makeText(MyOrderActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        myOrderRequest.requestMyCollection(new JSONObject(map) + "");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_all_order:
                initBtn();
                status = 1;
                sqlString = "";
                tvAllOrder.setTextColor(Color.parseColor("#6692ff"));
                tvAllOrderLine.setVisibility(View.VISIBLE);
                tvAllOrder.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ll_wait_pay:
                initBtn();
                status = 2;
                sqlString = "paymentstatusid=1";
                tvWaitPay.setTextColor(Color.parseColor("#6692ff"));
                tvWaitPayLine.setVisibility(View.VISIBLE);
                tvWaitPay.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ll_order_succes:
                initBtn();
                status = 3;
                sqlString = "paymentstatusid=2";
                tvOrderSuccess.setTextColor(Color.parseColor("#6692ff"));
                tvOrderSuccessLine.setVisibility(View.VISIBLE);
                tvOrderSuccess.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ll_order_fail:
                initBtn();
                status = 4;
                sqlString = "paymentstatusid=2";
                tvOrderFail.setTextColor(Color.parseColor("#6692ff"));
                tvOrderFailLine.setVisibility(View.VISIBLE);
                tvOrderFail.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void initBtn() {
        isLoad = false;
        isFirst = true;
        page = 1;
        tvAllOrder.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvWaitPay.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvOrderSuccess.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvOrderFail.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvOrderSuccess.setTextColor(Color.parseColor("#666666"));
        tvAllOrder.setTextColor(Color.parseColor("#666666"));
        tvOrderFail.setTextColor(Color.parseColor("#666666"));
        tvWaitPay.setTextColor(Color.parseColor("#666666"));
        tvOrderFailLine.setVisibility(View.INVISIBLE);
        tvOrderSuccessLine.setVisibility(View.INVISIBLE);
        tvWaitPayLine.setVisibility(View.INVISIBLE);
        tvAllOrderLine.setVisibility(View.INVISIBLE);
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
