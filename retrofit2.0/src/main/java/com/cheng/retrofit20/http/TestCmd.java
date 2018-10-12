package com.cheng.retrofit20.http;

import android.content.Context;

import com.cheng.retrofit20.client.BaseHttpCmd;
import com.cheng.retrofit20.client.RequestParams;

import retrofit2.Call;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class TestCmd extends BaseHttpCmd {
    public TestCmd(Context context, RequestParams params) {
        super(context, params);
    }

    @Override
    protected Call<?> getCall() {
        return getApiService().getVersionControl(getParams().getParentParams());
    }
}
