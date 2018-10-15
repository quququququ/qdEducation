package activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class UserRegisterNextActivity extends AppCompatActivity {
    private Button btnToRegister;
    private EditText etUserName,etPsw,etConfirmPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_step_two);

        initView();

    }

    private void initView() {
        etUserName = (EditText) findViewById(R.id.et_user_name);
        etPsw = (EditText) findViewById(R.id.et_psw);
        etConfirmPsw = (EditText) findViewById(R.id.et_comfirm_psw);
        btnToRegister = (Button) findViewById(R.id.btn_to_register);
        btnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRegister();
            }
        });

    }

    private void toRegister() {
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
        if(etPsw.getText().toString().trim().equals(etConfirmPsw.getText().toString().trim())){
            Toast.makeText(UserRegisterNextActivity.this, "保持密码输入一致", Toast.LENGTH_SHORT).show();
            return;
        }


    }

}
