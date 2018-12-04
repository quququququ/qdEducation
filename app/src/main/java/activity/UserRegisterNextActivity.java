package activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.UserRegistRequest;

import java.util.HashMap;

import base.TitleActivity;
import data.RandomCodeData;
import data.UserConfig;
import data.UserRegisterData;
import retrofit2.http.POST;
import tools.MD5tools;
import tools.TimeUTCUtils;
import tools.VerifyTimerUtil;

/**
 * Created by qupengcheng on 2018/10/15.
 */

public class UserRegisterNextActivity extends TitleActivity {
    public static final String PHONE_NUM = "phone.num";
    private Button btnToRegister;
    private EditText etUserName, etPsw, etConfirmPsw;
    private String sex;
    private LinearLayout llSexMale, llSexFemale;
    private TextView tvSexMale, tvSexFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_regist_step_two);
        setMidTitle("注册");

        initView();

    }

    private void initView() {
        llSexMale = (LinearLayout) findViewById(R.id.ll_sex_male);
        llSexFemale = (LinearLayout) findViewById(R.id.ll_sex_female);
        etUserName = (EditText) findViewById(R.id.et_user_name);
        etPsw = (EditText) findViewById(R.id.et_psw);
        etConfirmPsw = (EditText) findViewById(R.id.et_comfirm_psw);
        btnToRegister = (Button) findViewById(R.id.btn_to_register);
        tvSexMale = (TextView) findViewById(R.id.tv_sex_male);
        tvSexFemale = (TextView) findViewById(R.id.tv_sex_female);
        btnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    toRegister();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        llSexMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llSexMale.setBackgroundColor(Color.parseColor("#6692ff"));
                llSexFemale.setBackgroundColor(Color.parseColor("#ffffff"));
                tvSexMale.setTextColor(Color.parseColor("#ffffff"));
                tvSexFemale.setTextColor(Color.parseColor("#666666"));
                sex = "m";
            }
        });

        llSexFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llSexFemale.setBackgroundColor(Color.parseColor("#6692ff"));
                llSexMale.setBackgroundColor(Color.parseColor("#ffffff"));
                tvSexMale.setTextColor(Color.parseColor("#666666"));
                tvSexFemale.setTextColor(Color.parseColor("#ffffff"));
                sex = "f";
            }
        });

    }

    private void toRegister() throws Exception {
        if (TextUtils.isEmpty(etUserName.getText().toString().trim())) {
            Toast.makeText(UserRegisterNextActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etPsw.getText().toString().trim())) {
            Toast.makeText(UserRegisterNextActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etConfirmPsw.getText().toString().trim())) {
            Toast.makeText(UserRegisterNextActivity.this, "请输入确认密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!etPsw.getText().toString().trim().equals(etConfirmPsw.getText().toString().trim())) {
            Toast.makeText(UserRegisterNextActivity.this, "保持密码输入一致", Toast.LENGTH_SHORT).show();
            return;
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));


        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("UserName", etUserName.getText().toString().trim());
        hashMap.put("Password", etPsw.getText().toString().trim());
        hashMap.put("Sex", sex);
        hashMap.put("PhoneNumber", getIntent().getStringExtra(PHONE_NUM));


        UserRegistRequest mRequest = new UserRegistRequest(this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<UserRegisterData>() {
            @Override
            public void onSuccess(UserRegisterData data) {
//                    UserConfig.newInstance(UserRegisterNextActivity.this).setUserSession(data.getData().getSessionKey());
                Toast.makeText(UserRegisterNextActivity.this, data.getResult_msg(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserRegisterNextActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(UserRegisterNextActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        mRequest.requestUserRegister(JSON.toJSONString(hashMap));

    }

}
