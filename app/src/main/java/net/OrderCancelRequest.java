package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.http.CancelOrderCmd;
import com.cheng.retrofit20.http.CancelOrderResult;
import com.cheng.retrofit20.http.MyCollectionCmd;

import data.MyCollectionData;
import data.OrderCancelData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class OrderCancelRequest extends BaseHttpRequest<OrderCancelData> {

    private Context mContext;

    public OrderCancelRequest(Context context) {
        this.mContext = context;
    }


    public void requestOrderCancel(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(CancelOrderCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new CancelOrderCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<CancelOrderResult>() {
            @Override
            public void onSuccess(Response<CancelOrderResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new OrderCancelBinding(response.body(), mContext).getUiData());
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
