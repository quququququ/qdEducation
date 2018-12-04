package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.ArticleHandoutListResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.ArticleHandoutListData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class ArticleHandoutListBinding implements IUiDataBinding<ArticleHandoutListData, ArticleHandoutListResult> {
    private ArticleHandoutListResult mResult;
    private Context mContext;

    public ArticleHandoutListBinding(ArticleHandoutListResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public ArticleHandoutListData getUiData() {
        return getData();
    }

    private ArticleHandoutListData getData() {
        ArticleHandoutListData data = new ArticleHandoutListData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        List<ArticleHandoutListData.DataBean> dataList = new ArrayList<>();

        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            ArticleHandoutListData.DataBean dataBean = new ArticleHandoutListData.DataBean();
            ArticleHandoutListResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
            dataBean.setAbilityItemCode(resultBean.getAbilityItemCode());
            dataBean.setAbilityItemName(resultBean.getAbilityItemName());
            List<ArticleHandoutListData.DataBean.ArticleHandoutsBean> list = new ArrayList<>();
            for (int j = 0; j < mResult.getBaseResponseResult().getData().get(i).getArticleHandouts().size(); j++) {
                ArticleHandoutListData.DataBean.ArticleHandoutsBean beanData = new ArticleHandoutListData.DataBean.ArticleHandoutsBean();
                ArticleHandoutListResult.BaseResponseResultBean.DataBean.ArticleHandoutsBean beanResult = mResult.getBaseResponseResult().getData().get(i).getArticleHandouts().get(j);
                beanData.setAbilityItemCode(beanResult.getAbilityItemCode());
                beanData.setAbilityItemName(beanResult.getAbilityItemName());
                beanData.setCode(beanResult.getCode());
                beanData.setIMGAccessoryCode(beanResult.getIMGAccessoryCode());
                beanData.setIMGPath(beanResult.getIMGPath());
                beanData.setPPTAccessoryCode(beanResult.getPPTAccessoryCode());
                beanData.setSort(beanResult.getSort());
                beanData.setSummary(beanResult.getSummary());
                beanData.setTitle(beanResult.getTitle());
                list.add(beanData);
            }
            dataBean.setArticleHandouts(list);

            dataList.add(dataBean);
        }
        data.setData(dataList);


        return data;
    }
}
