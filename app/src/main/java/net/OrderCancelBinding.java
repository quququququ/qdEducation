package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.http.CancelOrderResult;

import java.util.ArrayList;
import java.util.List;

import data.MyCollectionData;
import data.OrderCancelData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class OrderCancelBinding implements IUiDataBinding<OrderCancelData, CancelOrderResult> {
    private CancelOrderResult mResult;
    private Context mContext;

    public OrderCancelBinding(CancelOrderResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public OrderCancelData getUiData() {
        return getData();
    }

    private OrderCancelData getData() {
        OrderCancelData data = new OrderCancelData();

        if (mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        OrderCancelData.DataBean dataBean = new OrderCancelData.DataBean();
        dataBean.setFlag(mResult.getBaseResponseResult().getData().isFlag());
        dataBean.setMsg(mResult.getBaseResponseResult().getData().getMsg());
        return data;
    }
}
