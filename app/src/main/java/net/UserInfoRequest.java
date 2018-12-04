package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.data.UserInfoResult;
import com.cheng.retrofit20.http.MyCollectionCmd;
import com.cheng.retrofit20.http.UserInfoCmd;

import data.MyCollectionData;
import data.UserInfoData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class UserInfoRequest extends BaseHttpRequest<UserInfoData> {

    private Context mContext;

    public UserInfoRequest(Context context) {
        this.mContext = context;
    }


    public void requestUserInfo(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(UserInfoCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new UserInfoCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<UserInfoResult>() {
            @Override
            public void onSuccess(Response<UserInfoResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new UserInfoBinding(response.body(), mContext).getUiData());
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
