package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.ExercisesResult;
import com.cheng.retrofit20.data.MyCollectionResult;

import java.util.ArrayList;
import java.util.List;

import data.ExercisesData;
import data.MyCollectionData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyExerciseBinding implements IUiDataBinding<ExercisesData, ExercisesResult> {
    private ExercisesResult mResult;
    private Context mContext;

    public MyExerciseBinding(ExercisesResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public ExercisesData getUiData() {
        return getData();
    }

    private ExercisesData getData() {
        ExercisesData data = new ExercisesData();

        if (mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        List<MyCollectionData.DataBean> dataBeanList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            ExercisesResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
            ExercisesData.DataBean dataBean = new ExercisesData.DataBean();
            dataBean.setAbilityItemCode(resultBean.getAbilityItemCode());
//            if (null != resultBean.getAbilityItemName())
//                dataBean.setAbilityItemName(resultBean.getAbilityItemName());
//            dataBean.setCategoryCode(resultBean.getCategoryCode());
//            if (null != resultBean.getCategoryName())
//                dataBean.setCategoryName(resultBean.getCategoryName());
//            if (null != resultBean.getDocumentCode())
//                dataBean.setDocumentCode(resultBean.getDocumentCode());
//            dataBean.setDocumentType(resultBean.getDocumentType());
//            dataBean.setLevel(resultBean.getLevel());
//            if (null != resultBean.getPicture())
//                dataBean.setPicture(resultBean.getPicture());
//            dataBean.setPrice(resultBean.getPrice());
//            if (null != resultBean.getRemark())
//                dataBean.setRemark(resultBean.getRemark());
//            if (null != resultBean.getTitle())
//                dataBean.setTitle(resultBean.getTitle());
//            if (null != resultBean.getSummary())
//                dataBean.setSummary(resultBean.getSummary());
//            dataBeanList.add(dataBean);
        }
//        data.setData(dataBeanList);
        return data;
    }
}
