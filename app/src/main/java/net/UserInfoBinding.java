package net;

import android.content.Context;
import android.util.Log;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.data.UserInfoResult;

import java.util.ArrayList;
import java.util.List;

import data.MyCollectionData;
import data.UserInfoData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class UserInfoBinding implements IUiDataBinding<UserInfoData, UserInfoResult> {
    private UserInfoResult mResult;
    private Context mContext;

    public UserInfoBinding(UserInfoResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public UserInfoData getUiData() {
        return getData();
    }

    private UserInfoData getData() {
        UserInfoData data = new UserInfoData();

        if (mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        UserInfoData.DataBean dataBean = new UserInfoData.DataBean();
        UserInfoResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData();
        dataBean.setDisplayName(resultBean.getDisplayName());
        dataBean.setIsActived(resultBean.isIsActived());
        dataBean.setLoginName(resultBean.getLoginName());
        dataBean.setPassword(resultBean.getPassword());
        dataBean.setPhoneNumber(resultBean.getPhoneNumber());
        dataBean.setSex(resultBean.getSex());
        dataBean.setUserId(resultBean.getUserId());
        data.setData(dataBean);
        return data;
    }
}
