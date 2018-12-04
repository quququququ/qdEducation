package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.BannerListResult;
import com.cheng.retrofit20.http.AbilityItemListCmd;
import com.cheng.retrofit20.http.BannerListCmd;

import data.AbilityItemListData;
import data.BannerListData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class BannerListRequest extends BaseHttpRequest<BannerListData> {

    private Context mContext;

    public BannerListRequest(Context context) {
        this.mContext = context;
    }


    public void requestBannerList(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(BannerListCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new BannerListCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<BannerListResult>() {
            @Override
            public void onSuccess(Response<BannerListResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new BannerListBinding(response.body(), mContext).getUiData());
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
