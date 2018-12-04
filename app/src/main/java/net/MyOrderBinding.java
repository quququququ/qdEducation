package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.data.MyOrderResult;

import java.util.ArrayList;
import java.util.List;

import data.MyCollectionData;
import data.MyOrderData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyOrderBinding implements IUiDataBinding<MyOrderData, MyOrderResult> {
    private MyOrderResult mResult;
    private Context mContext;

    public MyOrderBinding(MyOrderResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public MyOrderData getUiData() {
        return getData();
    }

    private MyOrderData getData() {
        MyOrderData data = new MyOrderData();

        if (mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        List<MyOrderData.DataBean> dataBeanList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            MyOrderResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
            MyOrderData.DataBean dataBean = new MyOrderData.DataBean();
            if (null != resultBean.getCode())
                dataBean.setCode(resultBean.getCode());

            if (null != resultBean.getCreateDate())
                dataBean.setCreateDate(resultBean.getCreateDate());

            if (null != resultBean.getModifyDate())
                dataBean.setModifyDate(resultBean.getModifyDate());

            dataBean.setOrderTotal(resultBean.getOrderTotal());
            if (null != resultBean.getPayDate())
                dataBean.setPayDate(resultBean.getPayDate());

            dataBean.setPaymentStatusId(resultBean.getPaymentStatus());
            dataBean.setOrderStatusId(resultBean.getOrderStatus());

            List<MyOrderData.DataBean.DetialsBean> beanList = new ArrayList<>();
            for (int j = 0; j < mResult.getBaseResponseResult().getData().get(i).getOrderDetials().size(); j++) {
                MyOrderResult.BaseResponseResultBean.DataBean.OrderDetialsBean resultNextBean = mResult.getBaseResponseResult().getData().get(i).getOrderDetials().get(j);
                MyOrderData.DataBean.DetialsBean dataNextBean = new MyOrderData.DataBean.DetialsBean();
                if (null != resultNextBean.getBuyDocumentCode())
                    dataNextBean.setBuyDocumentCode(resultNextBean.getBuyDocumentCode());
//                dataNextBean.setBuyDocumentCodeType(resultNextBean.getBuyDocumentCodeType());
                if (null != resultNextBean.getBuyDocumentCode())
                    dataNextBean.setOrderCode(resultNextBean.getBuyDocumentCode());

                if (null != resultNextBean.getPicturePath())
                    dataNextBean.setPicture(resultNextBean.getPicturePath());

                dataNextBean.setPrice(resultNextBean.getPrice());
                if (null != resultNextBean.getSummary())
                    dataNextBean.setSummary(resultNextBean.getSummary());
                if (null != resultNextBean.getTitle())
                    dataNextBean.setTitle(resultNextBean.getTitle());
                beanList.add(dataNextBean);
            }
            dataBean.setDetials(beanList);
            dataBeanList.add(dataBean);
        }

        data.setData(dataBeanList);
        return data;
    }
}
