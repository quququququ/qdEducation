package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.qupengcheng.qingdaoeducation.R;

import activity.MyCollecttionActivity;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyPageFragment extends Fragment implements View.OnClickListener{
    private RelativeLayout llMyCollection;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_page,container,false);
        initView(view);
        return view;
    }


    private void initView(View view) {
        llMyCollection = (RelativeLayout) view.findViewById(R.id.rl_my_collection);
        llMyCollection.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_my_collection:
                Intent intent = new Intent(getActivity(), MyCollecttionActivity.class);
                startActivity(intent);
                break;
        }
    }
}
