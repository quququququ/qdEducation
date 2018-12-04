package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.SubmitAnswerResult;
import com.cheng.retrofit20.http.AbilityItemListCmd;
import com.cheng.retrofit20.http.SubmitAnswerCmd;

import data.AbilityItemListData;
import data.SubmitAnswerData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class SubmitAnswerRequest extends BaseHttpRequest<SubmitAnswerData> {

    private Context mContext;

    public SubmitAnswerRequest(Context context) {
        this.mContext = context;
    }


    public void requestSubmitAnswer(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(SubmitAnswerCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new SubmitAnswerCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<SubmitAnswerResult>() {
            @Override
            public void onSuccess(Response<SubmitAnswerResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new SubmitAnswerBinding(response.body(), mContext).getUiData());
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
