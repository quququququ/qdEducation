package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.ArticleHandoutResult;
import com.cheng.retrofit20.http.ArticleHandoutCmd;

import data.ArticleHandoutData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class ArticleHandoutRequest extends BaseHttpRequest<ArticleHandoutData> {

    private Context mContext;

    public ArticleHandoutRequest(Context context) {
        this.mContext = context;
    }


    public void requestAbilityItem(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(ArticleHandoutCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new ArticleHandoutCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<ArticleHandoutResult>() {
            @Override
            public void onSuccess(Response<ArticleHandoutResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new ArticleHandoutBinding(response.body(), mContext).getUiData());
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
