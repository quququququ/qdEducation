package net;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.BaseHttpResult;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.http.TestCmd;

import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class TestRequest extends BaseHttpRequest<BaseHttpResult> {
    private Context mContext;

    public TestRequest(Context context) {
        this.mContext = context;
    }


    public void requestVesionControl(String version) {
        HttpCommand httpCmd = newHttpCommand(version);
        httpCmd.execute();
    }

    private RequestParams getParams(String version) {
        RequestParams parameters = new RequestParams();

        return parameters;
    }

    private HttpCommand newHttpCommand(String version) {
        HttpCommand httpCmd = new TestCmd(mContext, getParams(version));
        httpCmd.setCallback(new BaseCallback<BaseHttpResult>() {
            @Override
            public void onSuccess(Response<BaseHttpResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(response.body());
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
