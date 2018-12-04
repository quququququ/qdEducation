package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.RegisterResult;
import com.cheng.retrofit20.http.UserRegisterCmd;

import data.UserRegisterData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/16.
 */

public class UserRegistRequest extends BaseHttpRequest<UserRegisterData> {
    private Context mContext;

    public UserRegistRequest(Context context) {
        this.mContext = context;
    }


    public void requestUserRegister(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(UserRegisterCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new UserRegisterCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<RegisterResult>() {
            @Override
            public void onSuccess(Response<RegisterResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new UserRegisterBinding(response.body(), mContext).getUiData());
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
