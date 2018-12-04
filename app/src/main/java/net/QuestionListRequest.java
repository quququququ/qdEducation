package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.QuestionListResult;
import com.cheng.retrofit20.http.AbilityItemListCmd;
import com.cheng.retrofit20.http.QuestionListCmd;

import data.AbilityItemListData;
import data.QuestionListData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class QuestionListRequest extends BaseHttpRequest<QuestionListData> {

    private Context mContext;

    public QuestionListRequest(Context context) {
        this.mContext = context;
    }


    public void requestQuestionList(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(QuestionListCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new QuestionListCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<QuestionListResult>() {
            @Override
            public void onSuccess(Response<QuestionListResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new QuestionListBinding(response.body(), mContext).getUiData());
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
