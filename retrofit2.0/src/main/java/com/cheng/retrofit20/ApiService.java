package com.cheng.retrofit20;


import com.cheng.retrofit20.client.BaseHttpResult;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.ArticleDetailResult;
import com.cheng.retrofit20.data.ArticleHandoutListResult;
import com.cheng.retrofit20.data.ArticleHandoutResult;
import com.cheng.retrofit20.data.BannerListResult;
import com.cheng.retrofit20.data.ExercisesResult;
import com.cheng.retrofit20.data.LessonDetailResult;
import com.cheng.retrofit20.data.LessonListResult;
import com.cheng.retrofit20.data.LoginResult;
import com.cheng.retrofit20.data.ModifyPswResult;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.data.MyLessonListResult;
import com.cheng.retrofit20.data.MyOrderResult;
import com.cheng.retrofit20.data.MyStudyResult;
import com.cheng.retrofit20.data.PracticeDetailResult;
import com.cheng.retrofit20.data.PracticeListResult;
import com.cheng.retrofit20.data.QuestionFiltersResult;
import com.cheng.retrofit20.data.QuestionListResult;
import com.cheng.retrofit20.data.RandomCodeResult;
import com.cheng.retrofit20.data.RegisterResult;
import com.cheng.retrofit20.data.SubmitAnswerResult;
import com.cheng.retrofit20.data.UserInfoResult;
import com.cheng.retrofit20.data.AddCollectionResult;
import com.cheng.retrofit20.http.CancelOrderResult;
import com.cheng.retrofit20.http.RandomCodeCVerifyResult;

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
     * 登录
     */
    @POST("api/account/Login")
    Call<LoginResult> getLogin(@Body String params);

    /**
     * 修改密码
     */
    @POST("api/account/ModifyPwd")
    Call<ModifyPswResult> getModifyPsw(@Body String params);

    /**
     * 获取验证码
     */
    @POST("api/account/SendRandomCode")
    Call<RandomCodeResult> getRandomCode(@Body String params);

    /**
     * 验证验证码
     */
    @POST("api/account/RandomCodeVerify")
    Call<RandomCodeCVerifyResult> getRandomCodeVerify(@Body String params);

    /**
     * 我的收藏
     */
    @POST("api/Collection/MyCollection")
    Call<MyCollectionResult> getMyCollection(@Body String params);

    /**
     * 我的订单
     */
    @POST("api/Order/MyOrderList")
    Call<MyOrderResult> getMyOrder(@Body String params);

    /**
     * 个人信息
     */
    @POST("api/account/UserInfo")
    Call<UserInfoResult> getUserInfo(@Body String params);

    /**
     * 添加收藏
     */
    @POST("api/account/AddCollection")
    Call<AddCollectionResult> getAddCollection(@Body String params);

    /**
     * 获取练习题
     */
    @POST("api/Question/GetQuestion")
    Call<ExercisesResult> getExercises(@Body String params);

    /**
     * 获取已购课程
     */
    @POST("api/Lesson/MyLessonList")
    Call<MyLessonListResult> getMyLessonList(@Body String params);

    /**
     * 取消订单
     */
    @POST("api/Order/CancelOrder")
    Call<CancelOrderResult> getCancelOrder(@Body String params);

    /**
     * 获取课程列表(全部课程、分类课程、免费课程、付费课程、最新课程都调用该接口)
     */
    @POST("api/lesson/GetLessonList")
    Call<LessonListResult> getLessonList(@Body String params);

    /**
     * 获取单个课程
     */
    @POST("api/lesson/GetLessonDetail")
    Call<LessonDetailResult> getLessonDetail(@Body String params);

    /**
     * 获取单个文章
     */
    @POST("api/article/GetArticle")
    Call<ArticleDetailResult> getArticleDetail(@Body String params);

    /**
     * 获取课程类别列表
     */
    @POST("api/lesson/GetAbilityItemList")
    Call<AbilityItemListResult> getAbilityItemList(@Body String params);

    /**
     * 获取文章讲义列表
     */
    @POST("api/ArticleHandouts/GetArticleHandoutList")
    Call<ArticleHandoutListResult> getArticleHandoutList(@Body String params);

    /**
     * 获取单个文章讲义列表
     */
    @POST("api/ArticleHandouts/GetArticleHandout")
    Call<ArticleHandoutResult> getArticleHandout(@Body String params);

    /**
     * 获取练习题
     */
    @POST("api/Question/GetQuestion")
    Call<QuestionListResult> getQuestionList(@Body String params);

    /**
     * 获取整体学习情况
     */
    @POST("api/userStudy/MyStudy")
    Call<MyStudyResult> getMyStudy(@Body String params);

    /**
     * 我的题库
     */
    @POST("api/Question/GetPracticeList")
    Call<PracticeListResult> getPracticeList(@Body String params);

    /**
     * banner图片
     */
    @POST("api/Common/GetBannerList")
    Call<BannerListResult> getBannerList(@Body String params);

    /**
     * 获取练习题筛选模型
     */
    @POST("api/Question/GetQuestionFilters")
    Call<QuestionFiltersResult> getQuestionFilters(@Body String params);

    /**
     * 首页搜索框
     */
    @POST("api/Common/FuzzyQuery")
    Call<LessonListResult> getFuzzyQuery(@Body String params);

    /**
     * 做题提交答案
     */
    @POST("api/Question/SubmitAnswer")
    Call<SubmitAnswerResult> getSubmitAnswer(@Body String params);

    /**
     * 获取单个练习
     */
    @POST("api/Question/GetPracticeDetil")
    Call<PracticeDetailResult> getPracticeDetail(@Body String params);

}