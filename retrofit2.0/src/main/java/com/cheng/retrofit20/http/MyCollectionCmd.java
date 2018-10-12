package com.cheng.retrofit20.http;

import android.content.Context;

import com.cheng.retrofit20.client.BaseHttpCmd;
import com.cheng.retrofit20.client.BaseHttpCmdCps;
import com.cheng.retrofit20.client.RequestParams;

import retrofit2.Call;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyCollectionCmd extends BaseHttpCmdCps {
    public static final String BODY = "body";

    public MyCollectionCmd(Context context, RequestParams params) {
        super(context, params);
    }

    @Override
    protected Call<?> getCall() {
        return getApiService().getMyCollection(getParams().getChildParams().get("body").toString());
    }
}
