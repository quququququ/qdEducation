package activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.cheng.retrofit20.client.BaseHttpResult;
import com.example.qupengcheng.qingdaoeducation.R;

import net.TestRequest;

import java.util.HashMap;

import fragment.HasBuyFragment;
import fragment.HomePageFragment;
import fragment.MyPageFragment;
import fragment.StudyFragment;
import tools.MD5tools;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MainHomeActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout llHomePage, llStudy, llHasBuy, llMyPage;
    private ImageView ivHomePage, ivStudy, ivHasBuy, ivMyPage;
    private TextView tvHomePage, tvStudy, tvHasBuy, tvMyPage;
    private HomePageFragment homeFagment;
    private StudyFragment studyFragment;
    private HasBuyFragment hasBuyFragment;
    private MyPageFragment myFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        initView();
        initData();
    }

    private void initData() {
        String a = null;
        try {
            a = MD5tools.getSigh("123456","1482812036067");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("走不走",a.toString());
        Log.i("走不走------",MD5tools.getNonceStr());

    }

    private void initView() {
        llHomePage = (LinearLayout) findViewById(R.id.ll_home_page);
        llStudy = (LinearLayout) findViewById(R.id.ll_study);
        llHasBuy = (LinearLayout) findViewById(R.id.ll_has_buy);
        llMyPage = (LinearLayout) findViewById(R.id.ll_my_page);
        ivHomePage = (ImageView) findViewById(R.id.iv_home_page);
        ivStudy = (ImageView) findViewById(R.id.iv_study);
        ivHasBuy = (ImageView) findViewById(R.id.iv_has_buy);
        ivMyPage = (ImageView) findViewById(R.id.iv_my_page);
        tvHomePage = (TextView) findViewById(R.id.tv_home_page);
        tvStudy = (TextView) findViewById(R.id.tv_study);
        tvHasBuy = (TextView) findViewById(R.id.tv_has_buy);
        tvMyPage = (TextView) findViewById(R.id.tv_my_page);

        homeFagment = new HomePageFragment();
        studyFragment = new StudyFragment();
        hasBuyFragment = new HasBuyFragment();
        myFragment = new MyPageFragment();
        llHomePage.setOnClickListener(this);
        llStudy.setOnClickListener(this);
        llMyPage.setOnClickListener(this);
        llHasBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home_page:
                initState();
                changeFragment(homeFagment);
                ivHomePage.setImageDrawable(getResources().getDrawable(R.drawable.home));
                tvHomePage.setTextColor(Color.parseColor("#6692ff"));
                break;
            case R.id.ll_study:
                initState();
                changeFragment(studyFragment);
                ivStudy.setImageDrawable(getResources().getDrawable(R.drawable.study));
                tvStudy.setTextColor(Color.parseColor("#6692ff"));
                break;
            case R.id.ll_has_buy:
                initState();
                changeFragment(hasBuyFragment);
                ivHasBuy.setImageDrawable(getResources().getDrawable(R.drawable.has_buy));
                tvHasBuy.setTextColor(Color.parseColor("#6692ff"));
                break;
            case R.id.ll_my_page:
                initState();
                changeFragment(myFragment);
                ivMyPage.setImageDrawable(getResources().getDrawable(R.drawable.my));
                tvMyPage.setTextColor(Color.parseColor("#6692ff"));
                break;
        }
    }

    private void initState() {
        ivHomePage.setImageDrawable(getResources().getDrawable(R.drawable.un_home));
        ivStudy.setImageDrawable(getResources().getDrawable(R.drawable.un_study));
        ivHasBuy.setImageDrawable(getResources().getDrawable(R.drawable.un_has_buy));
        ivMyPage.setImageDrawable(getResources().getDrawable(R.drawable.un_my));
        tvHomePage.setTextColor(Color.parseColor("#999999"));
        tvStudy.setTextColor(Color.parseColor("#999999"));
        tvHasBuy.setTextColor(Color.parseColor("#999999"));
        tvMyPage.setTextColor(Color.parseColor("#999999"));
    }

    //切换fragment
    public void changeFragment(Fragment ment) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        if (fm != null) {
            transaction.hide(fm);
        }
        // isAdded:是否被添加过 被添加过 is true 反之
        if (!ment.isAdded()) {
            // 调用replace 添加fragment
            transaction.add(R.id.frag_main, ment);
        } else {
            // 显示出来
            transaction.show(ment);
        }
        // 提交
        transaction.commit();
        // 记录当前的Fragment
        fm = ment;
    }


}
