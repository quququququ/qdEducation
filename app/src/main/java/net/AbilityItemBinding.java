package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.AbilityItemListResult;
import com.cheng.retrofit20.data.LessonDetailResult;

import java.util.ArrayList;
import java.util.List;

import data.AbilityItemListData;
import data.LessonDetailData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class AbilityItemBinding implements IUiDataBinding<AbilityItemListData, AbilityItemListResult> {
    private AbilityItemListResult mResult;
    private Context mContext;

    public AbilityItemBinding(AbilityItemListResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public AbilityItemListData getUiData() {
        return getData();
    }

    private AbilityItemListData getData() {
        AbilityItemListData data = new AbilityItemListData();
        if (null == mResult.getBaseResponseResult().getResult_code() || mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());

        List<AbilityItemListData.DataBean> dataList = new ArrayList<>();
        for (int i = 0; i < mResult.getBaseResponseResult().getData().size(); i++) {
            AbilityItemListData.DataBean dataBean = new AbilityItemListData.DataBean();
            dataBean.setCode(mResult.getBaseResponseResult().getData().get(i).getCode());
            dataBean.setName(mResult.getBaseResponseResult().getData().get(i).getName());

            dataList.add(dataBean);
        }
        data.setData(dataList);


        return data;
    }
}
