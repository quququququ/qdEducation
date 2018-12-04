package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.LessonDetailResult;
import com.cheng.retrofit20.data.RandomCodeResult;
import com.cheng.retrofit20.http.RandomCodeCVerifyResult;

import data.LessonDetailData;
import data.RandomCodeVerifyData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class RandomCodeVerifyBinding implements IUiDataBinding<RandomCodeVerifyData, RandomCodeCVerifyResult> {
    private RandomCodeCVerifyResult mResult;
    private Context mContext;

    public RandomCodeVerifyBinding(RandomCodeCVerifyResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public RandomCodeVerifyData getUiData() {
        return getData();
    }

    private RandomCodeVerifyData getData() {
        RandomCodeVerifyData data = new RandomCodeVerifyData();

        if (null != mResult.getBaseResponseResult().getResult_msg())
            data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());
        data.setResult_code(mResult.getBaseResponseResult().getResult_code());
        if (mResult.getBaseResponseResult().getResult_code().equals("FAIL")) {
            return data;
        }

        RandomCodeVerifyData.DataBean dataBean = new RandomCodeVerifyData.DataBean();
        dataBean.setFlag(mResult.getBaseResponseResult().getData().isFlag());
        dataBean.setMsg(mResult.getBaseResponseResult().getData().getMsg());
        data.setData(dataBean);
        return data;
    }
}
