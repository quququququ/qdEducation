package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.PracticeDetailResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.PracticeDetailData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class PracticeResultBinding implements IUiDataBinding<PracticeDetailData, PracticeDetailResult> {
    private PracticeDetailResult mResult;
    private Context mContext;

    public PracticeResultBinding(PracticeDetailResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public PracticeDetailData getUiData() {
        return getData();
    }

    private PracticeDetailData getData() {
        PracticeDetailData data = new PracticeDetailData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        PracticeDetailData.DataBean dataBean = new PracticeDetailData.DataBean();
        dataBean.setCode(mResult.getBaseResponseResult().getData().getCode());
        dataBean.setCorrectRate(mResult.getBaseResponseResult().getData().getCorrectRate());
        dataBean.setEndTime(mResult.getBaseResponseResult().getData().getEndTime());
        dataBean.setQuestionCount(mResult.getBaseResponseResult().getData().getQuestionCount());
        dataBean.setStartTime(mResult.getBaseResponseResult().getData().getStartTime());
        dataBean.setTitle(mResult.getBaseResponseResult().getData().getTitle());
        List<PracticeDetailData.DataBean.PracticeDetailBean> practiceDetailList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().getPracticeDetail().size(); i++) {
            PracticeDetailData.DataBean.PracticeDetailBean practiceDetailBean = new PracticeDetailData.DataBean.PracticeDetailBean();
            PracticeDetailResult.BaseResponseResultBean.DataBean.PracticeDetailBean resultBean = mResult.getBaseResponseResult().getData().getPracticeDetail().get(i);
            practiceDetailBean.setTitle(resultBean.getTitle());
            practiceDetailBean.setAbilityItemCode(resultBean.getAbilityItemCode());
            practiceDetailBean.setAudioAccessoryCode(resultBean.getAudioAccessoryCode());
            practiceDetailBean.setAudioPath(resultBean.getAudioPath());
            practiceDetailBean.setNo(resultBean.getNo());
            practiceDetailBean.setQLevel(resultBean.getQLevel());
            practiceDetailBean.setQuestionCode(resultBean.getQuestionCode());
            practiceDetailBean.setSubjectContent(resultBean.getSubjectContent());
            practiceDetailBean.setTypeCode(resultBean.getTypeCode());
            practiceDetailBean.setSubjectTitle(resultBean.getSubjectTitle());
            practiceDetailBean.setTextDescribe(resultBean.getTextDescribe());

            List<PracticeDetailData.DataBean.PracticeDetailBean.QuestionOptionsBean> questionOptionList = new ArrayList<>();
            for (int j = 0; j < mResult.getBaseResponseResult().getData().getPracticeDetail().get(i).getQuestionOptions().size(); j++) {
                PracticeDetailData.DataBean.PracticeDetailBean.QuestionOptionsBean questionOptionBean = new PracticeDetailData.DataBean.PracticeDetailBean.QuestionOptionsBean();
                PracticeDetailResult.BaseResponseResultBean.DataBean.PracticeDetailBean.QuestionOptionsBean questionOptionResult = mResult.getBaseResponseResult().getData().getPracticeDetail().get(i).getQuestionOptions().get(j);
                questionOptionBean.setAnswer(questionOptionResult.getAnswer());
                questionOptionBean.setIsCorrect(questionOptionResult.isIsCorrect());
                questionOptionBean.setContent(questionOptionResult.getContent());
                questionOptionBean.setNo(questionOptionResult.getNo());
                questionOptionBean.setQuestionOptionCode(questionOptionResult.getQuestionOptionCode());
                questionOptionList.add(questionOptionBean);
            }
            practiceDetailBean.setQuestionOptions(questionOptionList);

            List<PracticeDetailData.DataBean.PracticeDetailBean.UserOptionsBean> userOptionList = new ArrayList<>();
            for (int j = 0; j < mResult.getBaseResponseResult().getData().getPracticeDetail().get(i).getUserOptions().size(); j++) {
                PracticeDetailData.DataBean.PracticeDetailBean.UserOptionsBean userOptionBean = new PracticeDetailData.DataBean.PracticeDetailBean.UserOptionsBean();
                PracticeDetailResult.BaseResponseResultBean.DataBean.PracticeDetailBean.UserOptionsBean userOptionResult = mResult.getBaseResponseResult().getData().getPracticeDetail().get(i).getUserOptions().get(j);
                userOptionBean.setAnswer(userOptionResult.getAnswer());
                userOptionBean.setQuestionOptionCode(userOptionResult.getQuestionOptionCode());
                userOptionList.add(userOptionBean);
            }
            practiceDetailBean.setUserOptions(userOptionList);

            practiceDetailList.add(practiceDetailBean);
        }
        dataBean.setPracticeDetail(practiceDetailList);
        data.setData(dataBean);


        return data;
    }
}
