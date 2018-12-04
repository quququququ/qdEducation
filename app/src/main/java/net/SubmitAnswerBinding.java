package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.SubmitAnswerResult;

import data.SubmitAnswerData;

/**
 * Created by qupengcheng on 2018/12/2.
 */

public class SubmitAnswerBinding implements IUiDataBinding<SubmitAnswerData, SubmitAnswerResult> {
    private SubmitAnswerResult mResult;
    private Context context;

    public SubmitAnswerBinding(SubmitAnswerResult mResult, Context context) {
        this.mResult = mResult;
        this.context = context;
    }

    @Override
    public SubmitAnswerData getUiData() {
        SubmitAnswerData data = new SubmitAnswerData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        SubmitAnswerData.DataBean dataBean = new SubmitAnswerData.DataBean();
        dataBean.setFlag(mResult.getBaseResponseResult().getData().isFlag());
        dataBean.setPracticeCode(mResult.getBaseResponseResult().getData().getPracticeCode());
        dataBean.setMsg(mResult.getBaseResponseResult().getData().getMsg());

        data.setData(dataBean);
        return data;
    }
}
