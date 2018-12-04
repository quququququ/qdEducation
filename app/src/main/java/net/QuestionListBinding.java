package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.QuestionListResult;
import com.cheng.retrofit20.http.CancelOrderResult;

import java.util.ArrayList;
import java.util.List;

import data.OrderCancelData;
import data.QuestionListData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class QuestionListBinding implements IUiDataBinding<QuestionListData, QuestionListResult> {
    private QuestionListResult mResult;
    private Context mContext;

    public QuestionListBinding(QuestionListResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public QuestionListData getUiData() {
        return getData();
    }

    private QuestionListData getData() {
        QuestionListData data = new QuestionListData();

        if (mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        List<QuestionListData.DataBean> dataList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            QuestionListData.DataBean dataBean = new QuestionListData.DataBean();
            QuestionListResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
            dataBean.setAbilityItemCode(resultBean.getAbilityItemCode());
            dataBean.setAudioAccessoryCode(resultBean.getAudioAccessoryCode());
            dataBean.setAudioPath(resultBean.getAudioPath());
            dataBean.setNo(resultBean.getNo());
            dataBean.setQLevel(resultBean.getQLevel());
            dataBean.setQuestionCode(resultBean.getQuestionCode());
            dataBean.setSubjectContent(resultBean.getSubjectContent());
            dataBean.setTextDescribe(resultBean.getTextDescribe());
            dataBean.setTitle(resultBean.getTitle());
            if (null != resultBean.getSubjectTitle())
                dataBean.setSubjectTitle(resultBean.getSubjectTitle());
            dataBean.setTypeCode(resultBean.getTypeCode());
            List<QuestionListData.DataBean.QuestionOptionsBean> beanList = new ArrayList<>();
            for (int j = 0; j < mResult.getBaseResponseResult().getData().get(i).getQuestionOptions().size(); j++) {
                QuestionListData.DataBean.QuestionOptionsBean beanData = new QuestionListData.DataBean.QuestionOptionsBean();
                QuestionListResult.BaseResponseResultBean.DataBean.QuestionOptionsBean beanResult = mResult.getBaseResponseResult().getData().get(i).getQuestionOptions().get(j);
                beanData.setNo(beanResult.getNo());
                beanData.setAnswer(beanResult.getAnswer());
                beanData.setContent(beanResult.getContent());
                beanData.setCorrect(beanResult.isIsCorrect());
                beanData.setQuestionOptionCode(beanResult.getQuestionOptionCode());
                beanList.add(beanData);
            }
            dataBean.setQuestionOptions(beanList);

            dataList.add(dataBean);
        }
        data.setData(dataList);

        return data;
    }
}
