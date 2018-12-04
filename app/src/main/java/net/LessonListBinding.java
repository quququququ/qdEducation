package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.LessonListResult;
import com.cheng.retrofit20.data.MyCollectionResult;

import java.util.ArrayList;
import java.util.List;

import data.LessonListData;
import data.MyCollectionData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class LessonListBinding implements IUiDataBinding<LessonListData, LessonListResult> {
    private LessonListResult mResult;
    private Context mContext;

    public LessonListBinding(LessonListResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public LessonListData getUiData() {
        return getData();
    }

    private LessonListData getData() {
        LessonListData data = new LessonListData();

        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        List<LessonListData.DataBean> dataBeanList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            LessonListResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
            LessonListData.DataBean dataBean = new LessonListData.DataBean();

            if (null != resultBean.getRemark())
                dataBean.setRemark(resultBean.getRemark());

            if (null != resultBean.getCreateDate())
                dataBean.setCreateDate(resultBean.getCreateDate());

            if (null != resultBean.getAbilityItemName())
                dataBean.setAbilityItemName(resultBean.getAbilityItemName());

            dataBean.setAbilityItemCode(resultBean.getAbilityItemCode());

            dataBean.setCategoryCode(resultBean.getCategoryCode());

            if (null != resultBean.getCategoryName())
                dataBean.setCategoryName(resultBean.getCategoryName());

            if (null != resultBean.getCode())
                dataBean.setCode(resultBean.getCode());

            if (null != resultBean.getInstructionalOBJ())
                dataBean.setInstructionalOBJ(resultBean.getInstructionalOBJ());

            dataBean.setLessonHour(resultBean.getLessonHour());

            dataBean.setLevel(resultBean.getLevel());

            if (null != resultBean.getName())
                dataBean.setName(resultBean.getName());

            if (null != resultBean.getNo())
                dataBean.setNo(resultBean.getNo());

            if (null != resultBean.getPictureCode())
                dataBean.setPictureCode(resultBean.getPictureCode());
            if (null != resultBean.getPictureCode())
                dataBean.setPicturePath(resultBean.getPicturePath());

            dataBean.setAbilityItemCode(resultBean.getAbilityItemCode());


            dataBeanList.add(dataBean);
        }
        data.setData(dataBeanList);
        return data;
    }
}
