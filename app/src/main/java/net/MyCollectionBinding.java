package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.MyCollectionResult;

import java.util.ArrayList;
import java.util.List;

import data.MyCollectionData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyCollectionBinding implements IUiDataBinding<MyCollectionData, MyCollectionResult> {
    private MyCollectionResult mResult;
    private Context mContext;

    public MyCollectionBinding(MyCollectionResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public MyCollectionData getUiData() {
        return getData();
    }

    private MyCollectionData getData() {
        MyCollectionData data = new MyCollectionData();

        data.setResult_code(mResult.getBaseResponseResult().getResult_code());
        data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());
        List<MyCollectionData.DataBean> dataBeanList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            MyCollectionResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
            MyCollectionData.DataBean dataBean = new MyCollectionData.DataBean();
            dataBean.setAbilityItemCode(resultBean.getAbilityItemCode());
            dataBean.setAbilityItemName(resultBean.getAbilityItemName());
            dataBean.setCategoryCode(resultBean.getCategoryCode());
            dataBean.setCategoryName(resultBean.getCategoryName());
            dataBean.setDocumentCode(resultBean.getDocumentCode());
            dataBean.setDocumentType(resultBean.getDocumentType());
            dataBean.setLevel(resultBean.getLevel());
            dataBean.setPicture(resultBean.getPicture());
            dataBean.setPrice(resultBean.getPrice());
            dataBean.setRemark(resultBean.getRemark());
            dataBean.setTitle(resultBean.getTitle());
            dataBeanList.add(dataBean);
        }
        data.setData(dataBeanList);
        return data;
    }
}
