package activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.RandomCodeRequest;
import net.RandomCodeVerfityRequest;

import java.util.HashMap;

import base.TitleActivity;
import data.RandomCodeData;
import data.RandomCodeVerifyData;
import tools.MD5tools;
import tools.TimeUTCUtils;
import tools.VerifyTimerUtil;

/**
 * Created by qupengcheng on 2018/10/15.
 */

public class UserRegisterActivity extends TitleActivity {
    public static final String IS_REGIST = "is.regist";
    private Button tvGetCode, btnToNext;
    private EditText etPhone, etRandomCode;
    private VerifyTimerUtil timerUtil;
    private boolean isRegist;
    public static UserRegisterActivity userRegisterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_regist_step_one);
        setMidTitle("注册");
        userRegisterActivity = this;
        isRegist = getIntent().getBooleanExtra(IS_REGIST, false);
        initView();

    }

    private void initView() {
        tvGetCode = (Button) findViewById(R.id.tv_get_code);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etRandomCode = (EditText) findViewById(R.id.et_random_code);
        btnToNext = (Button) findViewById(R.id.btn_to_next);
        timerUtil = new VerifyTimerUtil(this, tvGetCode);

        if (!isRegist) {
            etPhone.setHint("已验证手机");
        }
        tvGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    requestRandomCode();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnToNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    toNextStep();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void toNextStep() throws Exception {
        if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etRandomCode.getText().toString().trim())) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("PhoneNumber", etPhone.getText().toString().trim());
        hashMap.put("RandomCode", etRandomCode.getText().toString().trim());

        RandomCodeVerfityRequest mRequest = new RandomCodeVerfityRequest(this);

        mRequest.setListener(new BaseHttpRequest.IRequestListener<RandomCodeVerifyData>() {
            @Override
            public void onSuccess(RandomCodeVerifyData data) {
                if (data.getResult_code().equals("SUCCESS")) {
                    if (data.getData().isFlag()) {
                        if (isRegist) {
                            Intent intent = new Intent(UserRegisterActivity.this, UserRegisterNextActivity.class);
                            intent.putExtra(UserRegisterNextActivity.PHONE_NUM, etPhone.getText().toString().trim());
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(UserRegisterActivity.this, ChangePswActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        mRequest.requestRandomCodeVerfity(JSON.toJSONString(hashMap));

    }

    private void requestRandomCode() throws Exception {
        if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("appid", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("PhoneNumber", etPhone.getText().toString().trim());

        RandomCodeRequest mRequest = new RandomCodeRequest(UserRegisterActivity.this);
        mRequest.setListener(new BaseHttpRequest.IRequestListener<RandomCodeData>() {
            @Override
            public void onSuccess(RandomCodeData data) {
                Toast.makeText(UserRegisterActivity.this, "发送成功，请查收！", Toast.LENGTH_SHORT).show();
                timerUtil.verifyCodeComeDown();
            }

            @Override
            public void onFailed(String msg, String code) {

            }
        });
        mRequest.requestRandomCode(JSON.toJSONString(hashMap));
    }
}
