package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.RandomCodeRequest;

import java.util.HashMap;
import data.RandomCodeData;
import tools.MD5tools;
import tools.TimeUTCUtils;
import tools.VerifyTimerUtil;

/**
 * Created by qupengcheng on 2018/10/15.
 */

public class UserRegisterActivity extends AppCompatActivity {
    private Button tvGetCode,btnToNext;
    private EditText etPhone,etRandomCode;
    private VerifyTimerUtil timerUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_step_one);

        initView();

    }

    private void initView() {
        tvGetCode = (Button) findViewById(R.id.tv_get_code);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etRandomCode = (EditText) findViewById(R.id.et_random_code);
        btnToNext = (Button) findViewById(R.id.btn_to_next);

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
                toNextStep();
            }
        });

    }

    private void toNextStep() {
        if(TextUtils.isEmpty(etPhone.getText().toString().trim())){
            Toast.makeText(this,"请输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(etRandomCode.getText().toString().trim())){
            Toast.makeText(this,"请输入验证码",Toast.LENGTH_SHORT).show();
            return;
        }
//        Intent intent = new Intent(this,);
//        startActivity(intent);
    }

    private void requestRandomCode() throws Exception {
        if(TextUtils.isEmpty(etPhone.getText().toString().trim())){
            Toast.makeText(this,"请输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("appid","123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign",MD5tools.getSigh("",""));

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("appsignmodel",map);
        hashMap.put("PhoneNumber",etPhone.getText().toString().trim());

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
