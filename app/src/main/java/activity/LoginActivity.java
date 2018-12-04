package activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.data.HttpConfig;
import com.example.qupengcheng.qingdaoeducation.R;

import net.LoginRequest;

import java.util.HashMap;

import base.TitleActivity;
import data.LoginData;
import tools.DialogUtil;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/16.
 */

public class LoginActivity extends TitleActivity {
    private TextView tvToRegist, tvToChangePsw, tvUserName, tvUserPsw;
    private Button btnLogin;
    private ImageView ivBack;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_user_login);
        if(!TextUtils.isEmpty(HttpConfig.newInstance(this).getUserSession())){
            Intent intent = new Intent(LoginActivity.this,MainHomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        setMidTitle("登录");
        initView();
    }

    private void initView() {
        loadingDialog = DialogUtil.createLoaddingDialog(this);
        loadingDialog.setMessage("加载中");
        loadingDialog.setCancelable(true);

        ivBack = (ImageView) findViewById(R.id.title_left_back_iv);
        ivBack.setVisibility(View.GONE);
        tvToRegist = (TextView) findViewById(R.id.tv_to_register);
        tvToChangePsw = (TextView) findViewById(R.id.tv_to_change_psw);
        tvUserName = (TextView) findViewById(R.id.et_user_name);
        tvUserPsw = (TextView) findViewById(R.id.et_psw);
        btnLogin = (Button) findViewById(R.id.btn_to_login);

        tvToRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, UserRegisterActivity.class);
                intent.putExtra(UserRegisterActivity.IS_REGIST, true);
                startActivity(intent);
            }
        });

        tvToChangePsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, UserRegisterActivity.class);
                intent.putExtra(UserRegisterActivity.IS_REGIST, false);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    goLogin();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void goLogin() throws Exception {
        if (TextUtils.isEmpty(tvUserName.getText().toString().trim())) {
            Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(tvUserPsw.getText().toString().trim())) {
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        loadingDialog.show();
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));


        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);
        hashMap.put("loginName", tvUserName.getText().toString().trim());
        hashMap.put("hashedPassword", tvUserPsw.getText().toString().trim());
        hashMap.put("deviceType", 1);
        LoginRequest loginRequest = new LoginRequest(LoginActivity.this);
        loginRequest.setListener(new BaseHttpRequest.IRequestListener<LoginData>() {
            @Override
            public void onSuccess(LoginData data) {
                if(!TextUtils.isEmpty(data.getResult_code())){
                    if(data.getResult_code().equals("SUCCESS")){
                        loadingDialog.dismiss();
                        Intent intent = new Intent(LoginActivity.this,MainHomeActivity.class);
                        HttpConfig.newInstance(LoginActivity.this).setUserSession(data.getData().getSessionKey());
                        startActivity(intent);
                        finish();
                    }else{
                        loadingDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "账户名或者用户密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                loadingDialog.dismiss();
                Toast.makeText(LoginActivity.this, "账户名或者用户密码错误", Toast.LENGTH_SHORT).show();
            }
        });
        loginRequest.requestLogin(JSON.toJSONString(hashMap));
    }
}
