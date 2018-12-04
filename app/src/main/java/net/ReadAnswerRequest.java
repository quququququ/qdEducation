package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.PracticeDetailResult;
import com.cheng.retrofit20.http.AbilityItemListCmd;
import com.cheng.retrofit20.http.PracticeDetailCmd;

import data.AbilityItemListData;
import data.PracticeDetailData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class ReadAnswerRequest extends BaseHttpRequest<PracticeDetailData> {

    private Context mContext;

    public ReadAnswerRequest(Context context) {
        this.mContext = context;
    }


    public void requestReadAnswer(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(PracticeDetailCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new PracticeDetailCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<PracticeDetailResult>() {
            @Override
            public void onSuccess(Response<PracticeDetailResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new PracticeResultBinding(response.body(), mContext).getUiData());
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
