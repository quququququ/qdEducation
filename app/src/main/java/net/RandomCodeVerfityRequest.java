package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.http.GetRandomCodeVerifyCmd;
import com.cheng.retrofit20.http.RandomCodeCVerifyResult;

import data.RandomCodeVerifyData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class RandomCodeVerfityRequest extends BaseHttpRequest<RandomCodeVerifyData> {

    private Context mContext;

    public RandomCodeVerfityRequest(Context context) {
        this.mContext = context;
    }


    public void requestRandomCodeVerfity(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(GetRandomCodeVerifyCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new GetRandomCodeVerifyCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<RandomCodeCVerifyResult>() {
            @Override
            public void onSuccess(Response<RandomCodeCVerifyResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new RandomCodeVerifyBinding(response.body(), mContext).getUiData());
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
