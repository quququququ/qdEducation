package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.LessonListResult;
import com.cheng.retrofit20.data.PracticeListResult;
import com.cheng.retrofit20.http.LessonListCmd;
import com.cheng.retrofit20.http.PracticeListCmd;

import data.LessonListData;
import data.PracticeListData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class PracticeListRequest extends BaseHttpRequest<PracticeListData> {

    private Context mContext;

    public PracticeListRequest(Context context) {
        this.mContext = context;
    }


    public void requestPracticeList(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(PracticeListCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new PracticeListCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<PracticeListResult>() {
            @Override
            public void onSuccess(Response<PracticeListResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new PracticeListBinding(response.body(), mContext).getUiData());
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
