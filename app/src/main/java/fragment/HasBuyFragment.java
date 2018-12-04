package fragment;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.MyLessonListRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import activity.MyCollecttionActivity;
import adapter.HasBuyCourseAdapter;
import adapter.MyCollectionAdapter;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import data.MyLessonListData;
import tools.DialogUtil;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class HasBuyFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate,View.OnClickListener{
    private HasBuyCourseAdapter mAdapter;
    private RecyclerView rvCollection;
    private BGARefreshLayout bgaRefreshLayout;
    private boolean isFirst, isLoad, needLoad;
    private int page = 1;
    private LoadingDialog loadingDialog;
    private TextView tvOne,tvTwo,tvThree,tvFour,tvOneLine,tvTwoLine,tvThreeLine,tvFourLine,tvFive,tvSix,tvFiveLine,tvSixLine;
    private LinearLayout llOne,llTwo,llThree,llFour,llFive,llSix;
    private String sqlString = "AbilityItemCode=68";;
    private RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_has_buy_course,container,false);
        initView(view);
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }


    private void initView(View view) {
        loadingDialog = DialogUtil.createLoaddingDialog(getActivity());
        loadingDialog.setMessage("加载中");
        loadingDialog.setCancelable(true);

//        radioGroup = (RadioGroup) view.findViewById(R.id.rg_lesson_type);
//        for (int i = 0; i < 10; i++) {
//            RadioButton radioButton = new RadioButton(getContext());
//            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(100,50);
//            radioButton.setId(i);
//            radioButton.setText("22222");
//            radioButton.setButtonDrawable(null);
//            radioGroup.addView(radioButton,i,params);
//        }

        llOne = (LinearLayout) view.findViewById(R.id.ll_one);
        llTwo = (LinearLayout) view.findViewById(R.id.ll_two);
        llThree = (LinearLayout) view.findViewById(R.id.ll_three);
        llFour = (LinearLayout) view.findViewById(R.id.ll_four);
        llFive = (LinearLayout) view.findViewById(R.id.ll_five);
        llSix = (LinearLayout) view.findViewById(R.id.ll_six);
        tvOne = (TextView) view.findViewById(R.id.tv_one);
        tvOneLine = (TextView) view.findViewById(R.id.tv_one_line);
        tvTwo = (TextView) view.findViewById(R.id.tv_two);
        tvTwoLine = (TextView) view.findViewById(R.id.tv_two_line);
        tvThree = (TextView) view.findViewById(R.id.tv_three);
        tvThreeLine = (TextView) view.findViewById(R.id.tv_three_line);
        tvFour = (TextView) view.findViewById(R.id.tv_four);
        tvFourLine = (TextView) view.findViewById(R.id.tv_four_line);
        tvFive = (TextView) view.findViewById(R.id.tv_five);
        tvFiveLine = (TextView) view.findViewById(R.id.tv_five_line);
        tvSix = (TextView) view.findViewById(R.id.tv_six);
        tvSixLine = (TextView) view.findViewById(R.id.tv_six_line);

        llOne.setOnClickListener(this);
        llTwo.setOnClickListener(this);
        llThree.setOnClickListener(this);
        llFour.setOnClickListener(this);
        llFive.setOnClickListener(this);
        llSix.setOnClickListener(this);

        bgaRefreshLayout = (BGARefreshLayout) view.findViewById(R.id.bga_has_buy);
        bgaRefreshLayout.setDelegate(this);
        bgaRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(getContext().getApplicationContext(), true));

        mAdapter = new HasBuyCourseAdapter(getActivity());
        rvCollection = (RecyclerView) view.findViewById(R.id.rv_has_buy);
        rvCollection.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
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

        MyLessonListRequest mRequest = new MyLessonListRequest(getContext().getApplicationContext());
        mRequest.setListener(new BaseHttpRequest.IRequestListener<MyLessonListData>() {
            @Override
            public void onSuccess(MyLessonListData data) {
                if(data.getResult_code().equals("SUCCESS")) {
                    if(null != data.getData()) {
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

                        mAdapter.setData(data.getData());
                        if (data.getData().size() < 10)
                            needLoad = false;
                        else
                            needLoad = true;


                        bgaRefreshLayout.endRefreshing();
                        bgaRefreshLayout.endLoadingMore();
                        loadingDialog.dismiss();
                    }else{
                        Toast.makeText(getActivity().getApplicationContext(), "没有数据", Toast.LENGTH_SHORT).show();
                        mAdapter.clearData();
                        bgaRefreshLayout.endRefreshing();
                        bgaRefreshLayout.endLoadingMore();
                        loadingDialog.dismiss();
                    }
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), data.getResult_msg(), Toast.LENGTH_SHORT).show();
                    mAdapter.clearData();
                    bgaRefreshLayout.endRefreshing();
                    bgaRefreshLayout.endLoadingMore();
                    loadingDialog.dismiss();
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(getActivity().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                bgaRefreshLayout.endRefreshing();
                bgaRefreshLayout.endLoadingMore();
                loadingDialog.dismiss();
            }
        });
        mRequest.requestMyLessonList(new JSONObject(map) + "");
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_one:
                initBtnState();
                tvOne.setTextColor(Color.parseColor("#6692ff"));
                tvOneLine.setVisibility(View.VISIBLE);
                sqlString = "AbilityItemCode=68";
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ll_two:
                initBtnState();
                tvTwo.setTextColor(Color.parseColor("#6692ff"));
                tvTwoLine.setVisibility(View.VISIBLE);
                sqlString = "AbilityItemCode=69";
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ll_three:
                initBtnState();
                tvThree.setTextColor(Color.parseColor("#6692ff"));
                tvThreeLine.setVisibility(View.VISIBLE);
                sqlString = "AbilityItemCode=70";
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ll_four:
                initBtnState();
                tvFour.setTextColor(Color.parseColor("#6692ff"));
                tvFourLine.setVisibility(View.VISIBLE);
                sqlString = "AbilityItemCode=71";
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ll_five:
                initBtnState();
                tvFive.setTextColor(Color.parseColor("#6692ff"));
                tvFiveLine.setVisibility(View.VISIBLE);
                sqlString = "AbilityItemCode=80";
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ll_six:
                initBtnState();
                tvSix.setTextColor(Color.parseColor("#6692ff"));
                tvSixLine.setVisibility(View.VISIBLE);
                sqlString = "AbilityItemCode=90";
                try {
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void initBtnState(){
        tvOne.setTextColor(Color.parseColor("#666666"));
        tvOneLine.setVisibility(View.INVISIBLE);
        tvTwo.setTextColor(Color.parseColor("#666666"));
        tvTwoLine.setVisibility(View.INVISIBLE);
        tvThree.setTextColor(Color.parseColor("#666666"));
        tvThreeLine.setVisibility(View.INVISIBLE);
        tvFour.setTextColor(Color.parseColor("#666666"));
        tvFourLine.setVisibility(View.INVISIBLE);
        tvFive.setTextColor(Color.parseColor("#666666"));
        tvFiveLine.setVisibility(View.INVISIBLE);
        tvSix.setTextColor(Color.parseColor("#666666"));
        tvSixLine.setVisibility(View.INVISIBLE);
        isLoad = false;
        isFirst = true;
        page = 1;
    }
}
