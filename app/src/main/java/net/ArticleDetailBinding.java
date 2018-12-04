package net;

import android.content.Context;
import android.util.Log;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.ArticleDetailResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.ArticleDetailData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class ArticleDetailBinding implements IUiDataBinding<ArticleDetailData, ArticleDetailResult> {
    private ArticleDetailResult mResult;
    private Context mContext;

    public ArticleDetailBinding(ArticleDetailResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public ArticleDetailData getUiData() {
        return getData();
    }

    private ArticleDetailData getData() {
        ArticleDetailData data = new ArticleDetailData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());
        
        ArticleDetailData.DataBean dataBean = new ArticleDetailData.DataBean();
        dataBean.setContent(mResult.getBaseResponseResult().getData().getContent());
        dataBean.setTitle(mResult.getBaseResponseResult().getData().getTitle());

        List<ArticleDetailData.DataBean.AbilityItemListBean> itemList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().getAbilityItemList().size(); i++) {
            ArticleDetailData.DataBean.AbilityItemListBean abilityItemListBean = new ArticleDetailData.DataBean.AbilityItemListBean();
            abilityItemListBean.setCode(mResult.getBaseResponseResult().getData().getAbilityItemList().get(i).getCode());
            abilityItemListBean.setName(mResult.getBaseResponseResult().getData().getAbilityItemList().get(i).getName());
            itemList.add(abilityItemListBean);
        }
        dataBean.setAbilityItemList(itemList);
        data.setData(dataBean);
        return data;
    }
}
