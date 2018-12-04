package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.QuestionFiltersResult;
import com.cheng.retrofit20.http.AbilityItemListCmd;
import com.cheng.retrofit20.http.QuestionFiltersCmd;

import data.AbilityItemListData;
import data.QuestionFiltersData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class QuestionFiltersRequest extends BaseHttpRequest<QuestionFiltersData> {

    private Context mContext;

    public QuestionFiltersRequest(Context context) {
        this.mContext = context;
    }


    public void requestAbilityItem(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(QuestionFiltersCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new QuestionFiltersCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<QuestionFiltersResult>() {
            @Override
            public void onSuccess(Response<QuestionFiltersResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new QuestionFiltersBinding(response.body(), mContext).getUiData());
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
