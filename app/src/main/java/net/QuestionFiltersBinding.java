package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.QuestionFiltersResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.QuestionFiltersData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class QuestionFiltersBinding implements IUiDataBinding<QuestionFiltersData, QuestionFiltersResult> {
    private QuestionFiltersResult mResult;
    private Context mContext;

    public QuestionFiltersBinding(QuestionFiltersResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public QuestionFiltersData getUiData() {
        return getData();
    }

    private QuestionFiltersData getData() {
        QuestionFiltersData data = new QuestionFiltersData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        QuestionFiltersData.DataBean dataBeannew = new QuestionFiltersData.DataBean();

        List<QuestionFiltersData.DataBean.AbilityItemsBean> dataList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().getAbilityItems().size(); i++) {
            QuestionFiltersData.DataBean.AbilityItemsBean dataBean = new QuestionFiltersData.DataBean.AbilityItemsBean();
            dataBean.setCode(mResult.getBaseResponseResult().getData().getAbilityItems().get(i).getCode());
            dataBean.setName(mResult.getBaseResponseResult().getData().getAbilityItems().get(i).getName());
            dataList.add(dataBean);
        }

        dataBeannew.setAbilityItems(dataList);

        List<QuestionFiltersData.DataBean.QuestionTypesBean> dataList1 = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().getQuestionTypes().size(); i++) {
            QuestionFiltersData.DataBean.QuestionTypesBean dataBean1 = new QuestionFiltersData.DataBean.QuestionTypesBean();
            dataBean1.setCode(mResult.getBaseResponseResult().getData().getQuestionTypes().get(i).getCode());
            dataBean1.setName(mResult.getBaseResponseResult().getData().getQuestionTypes().get(i).getName());
            dataList1.add(dataBean1);
        }

        dataBeannew.setQuestionTypes(dataList1);
        dataBeannew.setQuestionLevels(mResult.getBaseResponseResult().getData().getQuestionLevels());

        data.setData(dataBeannew);
        return data;
    }
}
