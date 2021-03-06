package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.LoginResult;
import com.cheng.retrofit20.http.AbilityItemListCmd;
import com.cheng.retrofit20.http.LoginCmd;

import data.AbilityItemListData;
import data.LoginData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class LoginRequest extends BaseHttpRequest<LoginData> {

    private Context mContext;

    public LoginRequest(Context context) {
        this.mContext = context;
    }


    public void requestLogin(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(LoginCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new LoginCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<LoginResult>() {
            @Override
            public void onSuccess(Response<LoginResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new LoginBinding(response.body(), mContext).getUiData());
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                mListener.onFailed(msg, code);
            }

        });
        return httpCmd;
    }
}
