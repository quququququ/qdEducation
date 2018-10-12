package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.http.MyCollectionCmd;

import data.MyCollectionData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyCollectionRequest extends BaseHttpRequest<MyCollectionData> {

    private Context mContext;

    public MyCollectionRequest(Context context) {
        this.mContext = context;
    }


    public void requestMyCollection(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(MyCollectionCmd.KEY_BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new MyCollectionCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<MyCollectionResult>() {
            @Override
            public void onSuccess(Response<MyCollectionResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new MyCollectionBinding(response.body(), mContext).getUiData());
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
