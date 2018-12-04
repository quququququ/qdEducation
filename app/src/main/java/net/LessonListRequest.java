package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.LessonListResult;
import com.cheng.retrofit20.http.LessonListCmd;

import data.LessonListData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class LessonListRequest extends BaseHttpRequest<LessonListData> {

    private Context mContext;

    public LessonListRequest(Context context) {
        this.mContext = context;
    }


    public void requestLessonList(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(LessonListCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new LessonListCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<LessonListResult>() {
            @Override
            public void onSuccess(Response<LessonListResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new LessonListBinding(response.body(), mContext).getUiData());
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
