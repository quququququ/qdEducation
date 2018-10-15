package com.cheng.retrofit20;


import com.cheng.retrofit20.client.BaseHttpResult;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.data.MyOrderResult;
import com.cheng.retrofit20.data.RandomCodeResult;
import com.cheng.retrofit20.data.RegisterResult;

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
     * 注册
     */
    @POST("api/account/Register")
    Call<RegisterResult> getToRegister(@Body String params);

    /**
     * 获取验证码
     */
    @POST("api/account/SendRandomCode")
    Call<RandomCodeResult> getRandomCode(@Body String params);

    /**
     * 我的收藏
     */
    @POST("api/Collection/MyCollection")
    Call<MyCollectionResult> getMyCollection(@Body String params);

    /**
     * 我的订单
     */
    @POST("api/account/MyOrders")
    Call<MyOrderResult> getMyOrder(@Body String params);

}