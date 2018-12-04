package net;

import android.content.Context;

import com.cheng.retrofit20.callbacks.BaseCallback;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.HttpCommand;
import com.cheng.retrofit20.client.RequestParams;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.data.MyLessonListResult;
import com.cheng.retrofit20.http.MyCollectionCmd;
import com.cheng.retrofit20.http.MyLessonListCmd;

import data.MyCollectionData;
import data.MyLessonListData;
import retrofit2.Response;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyLessonListRequest extends BaseHttpRequest<MyLessonListData> {

    private Context mContext;

    public MyLessonListRequest(Context context) {
        this.mContext = context;
    }


    public void requestMyLessonList(String data) {
        HttpCommand httpCmd = newHttpCommand(data);
        httpCmd.execute();
    }

    private RequestParams getParams(String data) {
        RequestParams parameters = new RequestParams();
        parameters.putParams(MyLessonListCmd.BODY, data);
        return parameters;
    }

    private HttpCommand newHttpCommand(String data) {
        HttpCommand httpCmd = new MyLessonListCmd(mContext, getParams(data));
        httpCmd.setCallback(new BaseCallback<MyLessonListResult>() {
            @Override
            public void onSuccess(Response<MyLessonListResult> response) {
                if (null != mListener) {
                    mListener.onSuccess(new MyLessonListBinding(response.body(), mContext).getUiData());
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
