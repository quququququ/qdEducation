package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.data.HttpConfig;
import com.example.qupengcheng.qingdaoeducation.R;

import net.UserInfoRequest;

import java.util.HashMap;

import activity.LoginActivity;
import activity.MyCollecttionActivity;
import activity.MyOrderActivity;
import activity.PracticeListactivity;
import data.UserInfoData;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyPageFragment extends Fragment implements View.OnClickListener{
    private RelativeLayout llMyCollection,rlMyOrder,rlMyPractice,rlLogout;
    private TextView tvName,tvUserPhone;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_page,container,false);
        initView(view);
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void initData() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));


        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("SessionKey", "26ea70c5cea4c244e2dbdb0b8d7c1aac");

        UserInfoRequest mRequest = new UserInfoRequest(getContext().getApplicationContext());
        mRequest.setListener(new BaseHttpRequest.IRequestListener<UserInfoData>() {
            @Override
            public void onSuccess(UserInfoData data) {
                if(!TextUtils.isEmpty(data.getResult_code())){
                    if("SUCCESS".equals(data.getResult_code())){
                        tvName.setText(data.getData().getDisplayName()+"");
                        tvUserPhone.setText(data.getData().getPhoneNumber()+"");
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(getContext(),msg+"",Toast.LENGTH_SHORT).show();
            }
        });
        mRequest.requestUserInfo(JSON.toJSONString(hashMap));
    }


    private void initView(View view) {
        llMyCollection = (RelativeLayout) view.findViewById(R.id.rl_my_collection);
        rlMyOrder = (RelativeLayout) view.findViewById(R.id.rl_my_order);
        rlMyPractice = (RelativeLayout) view.findViewById(R.id.rl_my_practice);
        rlLogout = (RelativeLayout) view.findViewById(R.id.rl_log_out);
        tvName = (TextView) view.findViewById(R.id.tv_user_name);
        tvUserPhone = (TextView) view.findViewById(R.id.tv_user_phone);
        llMyCollection.setOnClickListener(this);
        rlMyOrder.setOnClickListener(this);
        rlMyPractice.setOnClickListener(this);
        rlLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_my_collection:
                jumpNextActivity(MyCollecttionActivity.class);
                break;
            case R.id.rl_my_order:
                jumpNextActivity(MyOrderActivity.class);
                break;
            case R.id.rl_my_practice:
                jumpNextActivity(PracticeListactivity.class);
                break;
            case R.id.rl_log_out:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                HttpConfig.newInstance(getContext()).setUserSession("");
                getActivity().startActivity(intent);
                getActivity().finish();
                break;
        }
    }

    private void jumpNextActivity(Class activityClass) {
        Intent it = new Intent();
        it.setClass(getActivity(), activityClass);
        startActivity(it);
    }
}
