package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.data.MyOrderResult;
import com.cheng.retrofit20.http.MyCollectionCmd;
import com.cheng.retrofit20.http.MyOrderCmd;

import data.MyCollectionData;
import data.MyOrderData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyOrderRequest extends BaseHttpRequest<MyOrderData> {

    private Context mContext;

    public MyOrderRequest(Context context) {
        this.mContext = context;
    }


    public void requestMyCollection(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(MyOrderCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new MyOrderCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<MyOrderResult>() {
            @Override
            public void onSuccess(Response<MyOrderResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new MyOrderBinding(response.body(), mContext).getUiData());
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
