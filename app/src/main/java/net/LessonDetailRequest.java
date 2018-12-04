package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.LessonDetailResult;
import com.cheng.retrofit20.http.LessonDetailCmd;

import data.LessonDetailData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class LessonDetailRequest extends BaseHttpRequest<LessonDetailData> {

    private Context mContext;

    public LessonDetailRequest(Context context) {
        this.mContext = context;
    }


    public void requestLessonDetail(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(LessonDetailCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new LessonDetailCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<LessonDetailResult>() {
            @Override
            public void onSuccess(Response<LessonDetailResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new LessonDetailBinding(response.body(), mContext).getUiData());
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
