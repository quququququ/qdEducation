package net;

import android.content.Context;

import com.cheng.retrofit20.client.IUiDataBinding;
import com.cheng.retrofit20.data.MyCollectionResult;
import com.cheng.retrofit20.data.RandomCodeResult;

import java.util.ArrayList;
import java.util.List;

import data.MyCollectionData;
import data.RandomCodeData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class RandomCodeBinding implements IUiDataBinding<RandomCodeData, RandomCodeResult> {
    private RandomCodeResult mResult;
    private Context mContext;

    public RandomCodeBinding(RandomCodeResult result, Context context) {
        this.mResult = result;
        this.mContext = context;
    }

    @Override
    public RandomCodeData getUiData() {
        return getData();
    }

    private RandomCodeData getData() {
        RandomCodeData data = new RandomCodeData();

        data.setResult_code(mResult.getBaseResponseResult().getResult_code());
        data.setResult_msg(mResult.getBaseResponseResult().getResult_msg());
        data.setRandomCode(mResult.getBaseResponseResult().getData().getRandomCode());
        return data;
    }
}
