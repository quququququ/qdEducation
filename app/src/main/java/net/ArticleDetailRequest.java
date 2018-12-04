package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.ArticleDetailResult;
import com.cheng.retrofit20.http.ArticleDetailCmd;

import data.ArticleDetailData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class ArticleDetailRequest extends BaseHttpRequest<ArticleDetailData> {

    private Context mContext;

    public ArticleDetailRequest(Context context) {
        this.mContext = context;
    }


    public void requestArticleDetail(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(ArticleDetailCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new ArticleDetailCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<ArticleDetailResult>() {
            @Override
            public void onSuccess(Response<ArticleDetailResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new ArticleDetailBinding(response.body(), mContext).getUiData());
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
