package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.BannerListResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.BannerListData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class BannerListBinding implements IUiDataBinding<BannerListData, BannerListResult> {
    private BannerListResult mResult;
    private Context mContext;

    public BannerListBinding(BannerListResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public BannerListData getUiData() {
        return getData();
    }

    private BannerListData getData() {
        BannerListData data = new BannerListData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        List<BannerListData.DataBean> dataList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            BannerListData.DataBean dataBean = new BannerListData.DataBean();
            BannerListResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
            dataBean.setBannerCategoryId(resultBean.getBannerCategoryId());
            dataBean.setCode(resultBean.getCode());
            dataBean.setCreateDate(resultBean.getCreateDate());
            dataBean.setDescprition(resultBean.getDescprition());
            dataBean.setIsActived(resultBean.isIsActived());
            dataBean.setName(resultBean.getName());
            dataBean.setPictureCode(resultBean.getPictureCode());
            dataBean.setPicturePath(resultBean.getPicturePath());
            dataBean.setStatus(resultBean.getStatus());
            dataBean.setSubmiterCode(resultBean.getSubmiterCode());
            dataBean.setUrl(resultBean.getUrl());

            dataList.add(dataBean);
        }
        data.setData(dataList);


        return data;
    }
}
