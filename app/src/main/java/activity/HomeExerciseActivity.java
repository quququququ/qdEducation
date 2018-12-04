package activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.qupengcheng.qingdaoeducation.R;

import base.TitleActivity;

/**
 * Created by qupengcheng on 2018/10/16.
 */

public class HomeExerciseActivity extends TitleActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener,CompoundButton.OnCheckedChangeListener {
    private SeekBar seekBar;
    private TextView tvSelectNum;
    private CheckBox rbClassOne, rbClassTwo, rbClassThree, rbClassFour, rbClassFive, rbClassSix;
    private String strExeGrade = "";
    private String strExeType = "111";
    private RadioGroup rbOne, rbTwo, rbExerciseType;
    private Button btnToTest;
    private int questionCount = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_home_exercise);
        setMidTitle("练习题");
        initView();
    }

    private void initView() {
        seekBar = (SeekBar) findViewById(R.id.sb_my_exercise);
        tvSelectNum = (TextView) findViewById(R.id.tv_exercise_select_num);
        btnToTest = (Button) findViewById(R.id.btn_to_test);

        rbClassOne = (CheckBox) findViewById(R.id.btn_class_one);
        rbClassTwo = (CheckBox) findViewById(R.id.btn_class_two);
        rbClassThree = (CheckBox) findViewById(R.id.btn_class_three);
        rbClassFour = (CheckBox) findViewById(R.id.btn_class_four);
        rbClassFive = (CheckBox) findViewById(R.id.btn_class_five);
        rbClassSix = (CheckBox) findViewById(R.id.btn_class_six);
        rbClassOne.setOnCheckedChangeListener(this);
        rbClassTwo.setOnCheckedChangeListener(this);
        rbClassThree.setOnCheckedChangeListener(this);
        rbClassFour.setOnCheckedChangeListener(this);
        rbClassFive.setOnCheckedChangeListener(this);
        rbClassSix.setOnCheckedChangeListener(this);
        btnToTest.setOnClickListener(this);

        rbOne = (RadioGroup) findViewById(R.id.rg_grade_one);
        rbTwo = (RadioGroup) findViewById(R.id.rg_grade_two);
        rbExerciseType = (RadioGroup) findViewById(R.id.rg_exercise_type);
        rbOne.setOnCheckedChangeListener(this);
        rbTwo.setOnCheckedChangeListener(this);
        rbExerciseType.setOnCheckedChangeListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int seekProgress = seekBar.getProgress();
                if (seekProgress < 13) {
                    seekBar.setProgress(0);
                    tvSelectNum.setText("10题");
                    questionCount = 10;
                } else if (seekProgress >= 13 && seekProgress < 38) {
                    seekBar.setProgress(25);
                    tvSelectNum.setText("20题");
                    questionCount = 20;
                } else if (seekProgress >= 38 && seekProgress < 63) {
                    seekBar.setProgress(50);
                    tvSelectNum.setText("50题");
                    questionCount = 50;
                } else if (seekProgress >= 63 && seekProgress < 88) {
                    seekBar.setProgress(75);
                    tvSelectNum.setText("80题");
                    questionCount = 80;
                } else if (seekProgress >= 88) {
                    seekBar.setProgress(100);
                    tvSelectNum.setText("不限");
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_to_test:
                Intent intent = new Intent(HomeExerciseActivity.this,TestExerciseActivity.class);
                intent.putExtra(TestExerciseActivity.QUESTION_COUNT,questionCount);
                startActivity(intent);
        }
    }



    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        switch (compoundButton.getId()){

            case R.id.btn_class_one:
                if(b){

                    rbClassOne.setChecked(true);
                    rbClassOne.setTextColor(getResources().getColor(R.color.main_blue));
                }else{

                    rbClassOne.setChecked(false);
                    rbClassOne.setTextColor(getResources().getColor(R.color.c1));
                }
                break;
            case R.id.btn_class_two:
                if(b){
                    rbClassTwo.setChecked(true);
                    rbClassTwo.setTextColor(getResources().getColor(R.color.main_blue));
                }else{
                    rbClassTwo.setChecked(false);
                    rbClassTwo.setTextColor(getResources().getColor(R.color.c1));
                }
                break;
            case R.id.btn_class_three:
                if(b){
                    rbClassThree.setChecked(true);
                    rbClassThree.setTextColor(getResources().getColor(R.color.main_blue));
                }else{
                    rbClassThree.setChecked(false);
                    rbClassThree.setTextColor(getResources().getColor(R.color.c1));
                }
                break;
            case R.id.btn_class_four:
                if(b){
                    rbClassFour.setChecked(true);
                    rbClassFour.setTextColor(getResources().getColor(R.color.main_blue));
                }else{
                    rbClassFour.setChecked(false);
                    rbClassFour.setTextColor(getResources().getColor(R.color.c1));
                }
                break;
            case R.id.btn_class_five:
                if(b){
                    rbClassFive.setChecked(true);
                    rbClassFive.setTextColor(getResources().getColor(R.color.main_blue));
                }else{
                    rbClassFive.setChecked(false);
                    rbClassFive.setTextColor(getResources().getColor(R.color.c1));
                }
                break;
            case R.id.btn_class_six:
                if(b){
                    rbClassSix.setChecked(true);
                    rbClassSix.setTextColor(getResources().getColor(R.color.main_blue));
                }else{
                    rbClassSix.setChecked(false);
                    rbClassSix.setTextColor(getResources().getColor(R.color.c1));
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if (radioGroup != null && checkedId > 0) {
            if (radioGroup == rbOne) {
                rbTwo.clearCheck();
                if (checkedId == R.id.btn_grade_one) {
                    strExeGrade = "111";
                }
                if (checkedId == R.id.btn_grade_two) {
                    strExeGrade = "222";
                }
                if (checkedId == R.id.btn_grade_three) {
                    strExeGrade = "333";
                }
            } else if (radioGroup == rbTwo) {
                rbOne.clearCheck();
                if (checkedId == R.id.btn_grade_four) {
                    strExeGrade = "444";
                }
                if (checkedId == R.id.btn_grade_five) {
                    strExeGrade = "555";
                }
            }
            radioGroup.check(checkedId);
            Log.i("-----", strExeGrade);
            if (radioGroup.getId() == R.id.rg_exercise_type) {
                if (checkedId == R.id.btn_type_one) {
                    strExeType = "111";
                }
                if (checkedId == R.id.btn_type_two) {
                    strExeType = "222";
                }
                if (checkedId == R.id.btn_type_three) {
                    strExeType = "333";
                }
            }
        }
    }
}
