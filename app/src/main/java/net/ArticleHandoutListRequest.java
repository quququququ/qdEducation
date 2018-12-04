package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.ArticleHandoutListResult;
import com.cheng.retrofit20.http.AbilityItemListCmd;
import com.cheng.retrofit20.http.ArticleHandoutListCmd;

import data.AbilityItemListData;
import data.ArticleHandoutListData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class ArticleHandoutListRequest extends BaseHttpRequest<ArticleHandoutListData> {

    private Context mContext;

    public ArticleHandoutListRequest(Context context) {
        this.mContext = context;
    }


    public void requestArticleHandoutList(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(ArticleHandoutListCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new ArticleHandoutListCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<ArticleHandoutListResult>() {
            @Override
            public void onSuccess(Response<ArticleHandoutListResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new ArticleHandoutListBinding(response.body(), mContext).getUiData());
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
