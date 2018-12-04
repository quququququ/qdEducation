package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.RandomCodeResult;
import com.cheng.retrofit20.http.GetRandomCodeCmd;

import data.RandomCodeData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class RandomCodeRequest extends BaseHttpRequest<RandomCodeData> {

    private Context mContext;

    public RandomCodeRequest(Context context) {
        this.mContext = context;
    }


    public void requestRandomCode(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(GetRandomCodeCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new GetRandomCodeCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<RandomCodeResult>() {
            @Override
            public void onSuccess(Response<RandomCodeResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new RandomCodeBinding(response.body(), mContext).getUiData());
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
