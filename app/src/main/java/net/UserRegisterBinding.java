package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.RandomCodeResult;
import com.cheng.retrofit20.data.RegisterResult;

import data.RandomCodeData;
import data.UserRegisterData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class UserRegisterBinding implements IUiDataBinding<UserRegisterData, RegisterResult> {
    private RegisterResult mResult;
    private Context mContext;

    public UserRegisterBinding(RegisterResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public UserRegisterData getUiData() {
        return getData();
    }

    private UserRegisterData getData() {
        UserRegisterData data = new UserRegisterData();

        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (mResult.getBaseResponseResult().getResult_msg().equals("FAIL")) {
            return data;
        }
        data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        UserRegisterData.DataBean userBean = new UserRegisterData.DataBean();
        RegisterResult.BaseResponseResultBean.DataBean loginUserBean = mResult.getBaseResponseResult().getData();
        if (null != mResult.getBaseResponseResult().getData()) {
            userBean.setActive(loginUserBean.isIsActived());
            userBean.setDisplayName(loginUserBean.getNickName());
            userBean.setLoginName(loginUserBean.getUserName());
            userBean.setPassword(loginUserBean.getPassword());
            userBean.setPhoneNumber(loginUserBean.getPhoneNumber());
            userBean.setSex(loginUserBean.getSex());
        }

        data.setData(userBean);
        return data;
    }
}
