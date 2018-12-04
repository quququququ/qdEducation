package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.LessonDetailResult;
import com.cheng.retrofit20.data.LessonListResult;

import java.util.ArrayList;
import java.util.List;

import data.LessonDetailData;
import data.LessonListData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class LessonDetailBinding implements IUiDataBinding<LessonDetailData, LessonDetailResult> {
    private LessonDetailResult mResult;
    private Context mContext;

    public LessonDetailBinding(LessonDetailResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public LessonDetailData getUiData() {
        return getData();
    }

    private LessonDetailData getData() {
        LessonDetailData data = new LessonDetailData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        LessonDetailData.DataBean dataBean = new LessonDetailData.DataBean();
        dataBean.setPictureCode(mResult.getBaseResponseResult().getData().getPictureCode());
        dataBean.setPicturePath(mResult.getBaseResponseResult().getData().getPicturePath());
        dataBean.setName(mResult.getBaseResponseResult().getData().getName());

        List<LessonDetailData.DataBean.ArticlesBean> articleList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().getArticles().size(); i++) {
            LessonDetailData.DataBean.ArticlesBean articleBean = new LessonDetailData.DataBean.ArticlesBean();
            LessonDetailResult.BaseResponseResultBean.DataBean.ArticlesBean articleResult = mResult.getBaseResponseResult().getData().getArticles().get(i);
            articleBean.setAboutHoursLong(articleResult.getAboutHoursLong());
            articleBean.setAnalysis(articleResult.getAnalysis()+"");
            articleBean.setArticleSummary(articleResult.getArticleSummary()+"");
            articleBean.setCode(articleResult.getCode()+"");
            articleBean.setContent(articleResult.getContent()+"");
            articleBean.setIsPurchased(articleResult.isIsPurchased());
            articleBean.setLevel(articleResult.getLevel());
            articleBean.setPrice(articleResult.getPrice());
            articleBean.setSort(articleResult.getSort());
            articleBean.setTitle(articleResult.getTitle()+"");
            articleList.add(articleBean);
        }
        dataBean.setArticles(articleList);

        data.setData(dataBean);
        return data;
    }
}
