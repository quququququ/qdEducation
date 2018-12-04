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
import com.cheng.retrofit20.data.HttpConfig;
import com.example.qupengcheng.qingdaoeducation.R;

import net.ModifyPswRequest;

import java.util.HashMap;

import base.TitleActivity;
import data.RandomCodeVerifyData;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/16.
 */

public class ChangePswActivity extends TitleActivity {
    private Button btnSetNewPsw;
    private EditText etNewPsw, etComfirmNewPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_change_psw);
        setMidTitle("设置新密码");
        initView();
    }

    private void initView() {
        etNewPsw = (EditText) findViewById(R.id.et_re_phone);
        etComfirmNewPsw = (EditText) findViewById(R.id.et_phone);
        btnSetNewPsw = (Button) findViewById(R.id.btn_set_new_psw);
        btnSetNewPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    toChangePsw();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void toChangePsw() throws Exception {
        if (TextUtils.isEmpty(etNewPsw.getText().toString().trim())) {
            Toast.makeText(this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etComfirmNewPsw.getText().toString().trim())) {
            Toast.makeText(this, "请输入确认新密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (etComfirmNewPsw.getText().toString().trim().equals(etNewPsw.getText().toString().trim())) {
            Toast.makeText(this, "请确认两次密码一致", Toast.LENGTH_SHORT).show();
            return;
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("SessionKey", "26ea70c5cea4c244e2dbdb0b8d7c1aac");
        hashMap.put("NewPwd", etComfirmNewPsw.getText().toString().trim());

        ModifyPswRequest mRequest = new ModifyPswRequest(this);

        mRequest.setListener(new BaseHttpRequest.IRequestListener<RandomCodeVerifyData>() {
            @Override
            public void onSuccess(RandomCodeVerifyData data) {
                if (data.getResult_code().equals("SUCCESS")) {
                    if (data.getData().isFlag()) {
                        Intent intent = new Intent(ChangePswActivity.this, LoginActivity.class);
                        HttpConfig.newInstance(ChangePswActivity.this).setUserSession("");
                        startActivity(intent);
                        finish();
                        UserRegisterActivity.userRegisterActivity.finish();
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        mRequest.requestModifyPsw(JSON.toJSONString(hashMap));

    }
}
