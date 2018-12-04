package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.PracticeListResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.PracticeListData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class PracticeListBinding implements IUiDataBinding<PracticeListData, PracticeListResult> {
    private PracticeListResult mResult;
    private Context mContext;

    public PracticeListBinding(PracticeListResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public PracticeListData getUiData() {
        return getData();
    }

    private PracticeListData getData() {
        PracticeListData data = new PracticeListData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        List<PracticeListData.DataBean> dataList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            PracticeListData.DataBean dataBean = new PracticeListData.DataBean();
            PracticeListResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
            dataBean.setCode(resultBean.getCode());
            dataBean.setCorrectRate(resultBean.getCorrectRate());
            dataBean.setEndTime(resultBean.getEndTime());
            dataBean.setQuestionCount(resultBean.getQuestionCount());
            dataBean.setStartTime(resultBean.getStartTime());
            dataBean.setTitle(resultBean.getTitle());
            dataList.add(dataBean);
        }
        data.setData(dataList);


        return data;
    }
}
