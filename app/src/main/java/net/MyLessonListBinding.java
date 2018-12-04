package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.ExercisesResult;
import com.cheng.retrofit20.data.MyLessonListResult;

import java.util.ArrayList;
import java.util.List;

import data.ExercisesData;
import data.MyCollectionData;
import data.MyLessonListData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyLessonListBinding implements IUiDataBinding<MyLessonListData, MyLessonListResult> {
    private MyLessonListResult mResult;
    private Context mContext;

    public MyLessonListBinding(MyLessonListResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public MyLessonListData getUiData() {
        return getData();
    }

    private MyLessonListData getData() {
        MyLessonListData data = new MyLessonListData();
        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());
        if (mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }

        if(null != mResult.getBaseResponseResult().getData()) {

            List<MyLessonListData.DataBean> dataBeanList = new ArrayList<>();
            for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
                MyLessonListResult.BaseResponseResultBean.DataBean resultBean = mResult.getBaseResponseResult().getData().get(i);
                MyLessonListData.DataBean dataBean = new MyLessonListData.DataBean();
                dataBean.setAbilityItemCode(resultBean.getAbilityItemCode());
                if (null != resultBean.getAbilityItemName())
                    dataBean.setAbilityItemName(resultBean.getAbilityItemName());
                dataBean.setCategoryCode(resultBean.getCategoryCode());
                if (null != resultBean.getCategoryName())
                    dataBean.setCategoryName(resultBean.getCategoryName());
                if (null != resultBean.getCode())
                    dataBean.setCode(resultBean.getCode());

                if (null != resultBean.getCreateDate())
                    dataBean.setCreateDate(resultBean.getCreateDate());

                if (null != resultBean.getInstructionalOBJ())
                    dataBean.setInstructionalOBJ(resultBean.getInstructionalOBJ());
                if (null != resultBean.getPicturePath())
                    dataBean.setPicturePath(resultBean.getPicturePath());

                dataBean.setLessonHour(resultBean.getLessonHour());

                dataBean.setLevel(resultBean.getLevel());

                if (null != resultBean.getName())
                    dataBean.setName(resultBean.getName());

                if (null != resultBean.getNo())
                    dataBean.setNo(resultBean.getNo());

                if (null != resultBean.getPictureCode())
                    dataBean.setPictureCode(resultBean.getPictureCode());

                if (null != resultBean.getRemark())
                    dataBean.setRemark(resultBean.getRemark());

                dataBeanList.add(dataBean);
            }
            data.setData(dataBeanList);
        }

        return data;
    }
}
