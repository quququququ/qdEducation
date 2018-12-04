package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.LoginResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.LoginData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class LoginBinding implements IUiDataBinding<LoginData, LoginResult> {
    private LoginResult mResult;
    private Context mContext;

    public LoginBinding(LoginResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public LoginData getUiData() {
        return getData();
    }

    private LoginData getData() {
        LoginData data = new LoginData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        LoginData.DataBean dataBean = new LoginData.DataBean();
        if (null != mResult.getBaseResponseResult().getData().getSessionKey())
            dataBean.setSessionKey(mResult.getBaseResponseResult().getData().getSessionKey());
        if (null != mResult.getBaseResponseResult().getData().getLogonUser()) {
            LoginResult.BaseResponseResultBean.DataBean.LogonUserBean resultBean = mResult.getBaseResponseResult().getData().getLogonUser();
            LoginData.DataBean.LogonUserBean logonUserBean = new LoginData.DataBean.LogonUserBean();
            logonUserBean.setDisplayName(resultBean.getDisplayName());
            logonUserBean.setIsActive(resultBean.isIsActive());
            logonUserBean.setLoginName(resultBean.getLoginName());
            logonUserBean.setPassword(resultBean.getPassword());
            logonUserBean.setSex(resultBean.getSex());
            logonUserBean.setUserId(resultBean.getUserId());
            dataBean.setLogonUser(logonUserBean);
        }
        data.setData(dataBean);
        return data;
    }
}
