package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.MyStudyRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.StudySituationAdapter;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import data.MyStudyData;
import tools.DialogUtil;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.TimeUTCUtils;
import view.ChartView;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class StudyFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private StudySituationAdapter mAdapter;
    private RecyclerView rvCollection;
    private BGARefreshLayout bgaRefreshLayout;
    private boolean isFirst, isLoad, needLoad;
    private int page = 1;
    private LoadingDialog loadingDialog;
    private ChartView chartView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_study_situation, container, false);
        initView(view);
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void initView(View view) {
        loadingDialog = DialogUtil.createLoaddingDialog(getContext().getApplicationContext());
        loadingDialog.setMessage("加载中");
        loadingDialog.setCancelable(true);

        bgaRefreshLayout = (BGARefreshLayout) view.findViewById(R.id.bga_study_situation);
        bgaRefreshLayout.setDelegate(this);
        bgaRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(getContext().getApplicationContext(), true));

        mAdapter = new StudySituationAdapter(getActivity());
        rvCollection = (RecyclerView) view.findViewById(R.id.rv_study_situation);
        rvCollection.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        rvCollection.setAdapter(mAdapter);

        chartView = (ChartView) view.findViewById(R.id.cv_study_time);
        //x轴坐标对应的数据
        List<String> xValue = new ArrayList<>();
        //y轴坐标对应的数据
        List<Integer> yValue = new ArrayList<>();


        //折线对应的数据
        Map<String, Double> value = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            xValue.add((i + 1) + "号");
            value.put((i + 1) + "号", 2.22);
        }

//        int a = (int)Math.ceil(18.6 / 6);
        for (int i = 0; i < 7; i++) {

            yValue.add(i * 5);
//            if (a == 0) {
//                yValue.add(i * 500);
//            } else
//                yValue.add(i * a);
        }

        chartView.setValue(value, xValue, yValue);
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

        MyStudyRequest mRequest = new MyStudyRequest(getActivity());
        mRequest.setListener(new BaseHttpRequest.IRequestListener<MyStudyData>() {
            @Override
            public void onSuccess(MyStudyData data) {
                if (!TextUtils.isEmpty(data.getResult_code())) {
                    if (data.getResult_code().equals("SUCCESS")) {
                        mAdapter.setData(data.getData());
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {

            }
        });

        mRequest.requestMyStudy(JSON.toJSONString(hashMap));
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
