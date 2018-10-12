package com.cheng.retrofit20;


import com.cheng.retrofit20.client.BaseHttpResult;
import com.cheng.retrofit20.data.MyCollectionResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by cheng on 2018/5/21.
 */

public interface ApiService {

    /**
     * 更新版本
     */
    @POST("index.php?s=/api/User/tlp_edition")
    @FormUrlEncoded
    Call<BaseHttpResult> getVersionControl(@FieldMap Map<String, String> params);

    /**
     * 我的收藏
     */
    @POST(" ")
    Call<MyCollectionResult> getMyCollection(@Body String params);

}