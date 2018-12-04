package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.MyStudyResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.MyStudyData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyStudyBinding implements IUiDataBinding<MyStudyData, MyStudyResult> {
    private MyStudyResult mResult;
    private Context mContext;

    public MyStudyBinding(MyStudyResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public MyStudyData getUiData() {
        return getData();
    }

    private MyStudyData getData() {
        MyStudyData data = new MyStudyData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        List<MyStudyData.DataBean> dataList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            MyStudyData.DataBean dataBean = new MyStudyData.DataBean();
            MyStudyResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
            dataBean.setPicturePath(resultBean.getPicturePath());
            dataBean.setName(resultBean.getName());
            dataBean.setLastStudyTime(resultBean.getLastStudyTime());
            dataBean.setLessonCode(resultBean.getLessonCode());
            dataBean.setNickName(resultBean.getNickName());
            dataBean.setNo(resultBean.getNo());
            dataBean.setPictureCode(resultBean.getPictureCode());
            dataBean.setPlayedVideoAmount(resultBean.getPlayedVideoAmount());
            dataBean.setPlayedVideoLength(resultBean.getPlayedVideoLength());
            dataBean.setTotalVideoAmount(resultBean.getTotalVideoAmount());
            dataBean.setTotalVideoLength(resultBean.getTotalVideoLength());
            dataBean.setUserCode(resultBean.getUserCode());

            dataList.add(dataBean);
        }
        data.setData(dataList);


        return data;
    }
}
