package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.ModifyPswResult;
import com.cheng.retrofit20.http.AbilityItemListCmd;
import com.cheng.retrofit20.http.ChangePswCmd;

import data.AbilityItemListData;
import data.ModifyPswData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class ModifyPswRequest extends BaseHttpRequest<ModifyPswData> {

    private Context mContext;

    public ModifyPswRequest(Context context) {
        this.mContext = context;
    }


    public void requestModifyPsw(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(ChangePswCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new ChangePswCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<ModifyPswResult>() {
            @Override
            public void onSuccess(Response<ModifyPswResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new ModifyPswBinding(response.body(), mContext).getUiData());
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
