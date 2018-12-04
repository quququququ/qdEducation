package activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.MyOrderRequest;
import net.PracticeListRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import adapter.MyOrderAdapter;
import adapter.MyPracticeListAdapter;
import base.TitleActivity;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import data.MyOrderData;
import data.PracticeListData;
import tools.DialogUtil;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/11/18.
 */

public class PracticeListactivity extends TitleActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private boolean isFirst,isLoad,needLoad;
    private int page = 1;
    private RecyclerView rvCollection;
    private BGARefreshLayout bgaRefreshLayout;
    private LoadingDialog loadingDialog;
    private MyPracticeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_my_practice_list);
        setMidTitle("我的题库");
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

        bgaRefreshLayout = (BGARefreshLayout) findViewById(R.id.bga_my_practice);
        bgaRefreshLayout.setDelegate(this);
        bgaRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(this,true));

        mAdapter = new MyPracticeListAdapter(this);
        rvCollection = (RecyclerView) findViewById(R.id.rc_my_practice);
        rvCollection.setLayoutManager(new LinearLayoutManager(this));
        rvCollection.setAdapter(mAdapter);
    }

    private void initData() throws Exception {
        loadingDialog.show();

        HashMap<String, Object> map = new HashMap<>();
        JSONObject object = new JSONObject();
        HashMap<String, Object> publicMap = new HashMap<>();
        try {
            object.put("CurrentIndex", 1);
            object.put("PageSize", 10);
            object.put("SQLStr", "");
            JSONArray array = new JSONArray();
            JSONObject innerObj = new JSONObject();
            innerObj.put("ColumnName", "StartTime");
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

        PracticeListRequest myOrderRequest = new PracticeListRequest(this);
        myOrderRequest.setListener(new BaseHttpRequest.IRequestListener<PracticeListData>() {
            @Override
            public void onSuccess(PracticeListData data) {
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
                Toast.makeText(PracticeListactivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        myOrderRequest.requestPracticeList(new JSONObject(map) + "");
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
