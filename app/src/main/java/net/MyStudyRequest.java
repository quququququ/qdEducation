package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.MyStudyResult;
import com.cheng.retrofit20.http.AbilityItemListCmd;
import com.cheng.retrofit20.http.MystudyCmd;

import data.AbilityItemListData;
import data.MyStudyData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyStudyRequest extends BaseHttpRequest<MyStudyData> {

    private Context mContext;

    public MyStudyRequest(Context context) {
        this.mContext = context;
    }


    public void requestMyStudy(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(MystudyCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new MystudyCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<MyStudyResult>() {
            @Override
            public void onSuccess(Response<MyStudyResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new MyStudyBinding(response.body(), mContext).getUiData());
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
