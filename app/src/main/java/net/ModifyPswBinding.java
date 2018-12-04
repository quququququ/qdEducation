package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.ModifyPswResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.ModifyPswData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class ModifyPswBinding implements IUiDataBinding<ModifyPswData, ModifyPswResult> {
    private ModifyPswResult mResult;
    private Context mContext;

    public ModifyPswBinding(ModifyPswResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public ModifyPswData getUiData() {
        return getData();
    }

    private ModifyPswData getData() {
        ModifyPswData data = new ModifyPswData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        ModifyPswData.DataBean dataBean = new ModifyPswData.DataBean();
        dataBean.setFlag(mResult.getBaseResponseResult().getData().isFlag());
        dataBean.setMsg(mResult.getBaseResponseResult().getData().getMsg());
        data.setData(dataBean);
        return data;
    }
}
