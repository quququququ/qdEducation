package net;

import android.content.Context;
import android.text.TextUtils;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.ArticleHandoutResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.ArticleHandoutData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class ArticleHandoutBinding implements IUiDataBinding<ArticleHandoutData, ArticleHandoutResult> {
    private ArticleHandoutResult mResult;
    private Context mContext;

    public ArticleHandoutBinding(ArticleHandoutResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public ArticleHandoutData getUiData() {
        return getData();
    }

    private ArticleHandoutData getData() {
        ArticleHandoutData data = new ArticleHandoutData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        ArticleHandoutData.DataBean dataBean = new ArticleHandoutData.DataBean();
        ArticleHandoutResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData();
        dataBean.setSort(resultBean.getSort());
        dataBean.setPPTAccessoryCode(resultBean.getPPTAccessoryCode());
        dataBean.setSummary(resultBean.getSummary());
        dataBean.setAbilityItemCode(resultBean.getAbilityItemCode());
        dataBean.setCode(resultBean.getCode());
        dataBean.setAbilityItemName(resultBean.getCode());
        dataBean.setIMGAccessoryCode(resultBean.getIMGAccessoryCode());
        dataBean.setIMGPath(resultBean.getIMGPath());
        dataBean.setTitle(resultBean.getTitle());

        List<ArticleHandoutData.DataBean.VideosBean> datalist = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().getVideos().size(); i++) {
            ArticleHandoutData.DataBean.VideosBean videoBean = new ArticleHandoutData.DataBean.VideosBean();
            ArticleHandoutResult.BaseResponseResultBean.DataBean.VideosBean resultDataBean = mResult.getBaseResponseResult().getData().getVideos().get(i);
            videoBean.setCode(resultDataBean.getCode());
            videoBean.setFileName(resultDataBean.getFileName());
            videoBean.setLastStudyDate(resultDataBean.getLastStudyDate());
            videoBean.setLength(resultDataBean.getLength());
            videoBean.setSort(resultDataBean.getSort());
            videoBean.setVideoAccessoryCode(resultDataBean.getVideoAccessoryCode());
            videoBean.setVideoAccessoryPath(resultDataBean.getVideoAccessoryPath());
            if (!TextUtils.isEmpty(resultDataBean.getPircturePath()))
                videoBean.setPircturePath(resultDataBean.getPircturePath());
            datalist.add(videoBean);
        }
        dataBean.setVideos(datalist);

        data.setData(dataBean);
        return data;
    }
}
