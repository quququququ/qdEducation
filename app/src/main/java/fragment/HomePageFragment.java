package fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import net.AbilityItemRequest;
import net.BannerListRequest;
import net.LessonListRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import activity.FreeLessonsActivity;
import activity.HomeExerciseActivity;
import activity.HomeExerciseNewActivity;
import activity.MyOrderActivity;
import adapter.LessonListAdapter;
import data.AbilityItemListData;
import data.BannerListData;
import data.LessonListData;
import tools.ConstantUrl;
import tools.ListViewForScrollView;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class HomePageFragment extends Fragment implements View.OnClickListener ,OnBannerListener {
    private LinearLayout llHomeExercise, llFreeLessons, llPriceLesson, llAllLesson;
    private ListViewForScrollView lvLastCourses, lvFreeCourses;
    private TextView tvAllLastLesson, tvAllFreeLesson;
    private ImageView ivToMyOrder;
    private LessonListAdapter lessonListAdapter;
    private int page = 1;
    private String sqlString = "";
    private LinearLayout llTypeLessons;
    private GridView gridView;
    private ImageView ivSearch;
    private EditText etInputSearch;
    private int pageSize;
    private List<Map<String, Object>> list = new ArrayList();
    private SimpleAdapter simpleAdapter;
    private Banner banner;
    private ArrayList<String> list_path = new ArrayList<>();
    private ScrollView scrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_page, container, false);
        initView(view);

        try {
            initBannerData();
            initLastData();
            initFreeData();
            initGridData();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    private void initBannerData() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);

        BannerListRequest bannerListRequest = new BannerListRequest(getContext().getApplicationContext());
        bannerListRequest.setListener(new BaseHttpRequest.IRequestListener<BannerListData>() {
            @Override
            public void onSuccess(BannerListData data) {
                showBanner(data);
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(getContext().getApplicationContext(), msg + "", Toast.LENGTH_SHORT).show();
            }
        });
        bannerListRequest.requestBannerList(JSON.toJSONString(hashMap));
    }

    private void showBanner(BannerListData data){
        if(null!=data.getData() && data.getData().size()>0){
            for (int i = 0; i < data.getData().size(); i++) {
                list_path.add(ConstantUrl.URL_Base+data.getData().get(i).getPicturePath());
            }
            banner.setImageLoader(new MyLoader());
            banner.setImages(list_path);
            banner.setDelayTime(3000);
            banner.setIndicatorGravity(BannerConfig.CENTER)
                    //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                    .setOnBannerListener(this)
                    //必须最后调用的方法，启动轮播图。
                    .start();
        }
    }

    @Override
    public void OnBannerClick(int position) {

    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }

    private void initGridData() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appId", "123456");
        map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
        map.put("nonce_str", MD5tools.getNonceStr());
        map.put("sign", MD5tools.getSigh("", ""));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("AppSignModel", map);

        AbilityItemRequest abilityItemRequest = new AbilityItemRequest(getContext().getApplicationContext());
        abilityItemRequest.setListener(new BaseHttpRequest.IRequestListener<AbilityItemListData>() {
            @Override
            public void onSuccess(AbilityItemListData data) {
                if (data.getData().size() != 0) {
                    String[] iconName = new String[data.getData().size()];
                    int[] icon = new int[data.getData().size()];

                    for (int i = 0; i < data.getData().size(); i++) {
                        iconName[i] = data.getData().get(i).getName();
                        icon[i] = data.getData().get(i).getCode();
                    }

                    if (null != icon && icon.length > 0) {
                        for (int i = 0; i < icon.length; i++) {
                            Map<String, Object> map = new HashMap<>();
                            map.put("image", icon[i]);
                            map.put("text", iconName[i]);
                            list.add(map);
                        }

                        simpleAdapter = new SimpleAdapter(getContext().getApplicationContext(), list, R.layout
                                .item_lesson_type, new String[]{"text"}, new int[]{R.id.tv_lesson_type});

                        gridView.setAdapter(simpleAdapter);
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {
                Toast.makeText(getContext().getApplicationContext(), msg + "", Toast.LENGTH_SHORT).show();
            }
        });
        abilityItemRequest.requestAbilityItem(JSON.toJSONString(hashMap));
    }

    private void initLastData() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        JSONObject object = new JSONObject();
        HashMap<String, Object> publicMap = new HashMap<>();
        try {
            object.put("CurrentIndex", 1);
            object.put("PageSize", 2);
            object.put("SQLStr", sqlString);
            JSONArray array = new JSONArray();
            JSONObject innerObj = new JSONObject();
            innerObj.put("ColumnName", "CreateDate");
            innerObj.put("Order", 1);
            array.put(innerObj);
            object.put("Sorts", array);


            publicMap.put("appId", "123456");
            publicMap.put("timestamp", TimeUTCUtils.getUTCTimeStr());
            publicMap.put("nonce_str", MD5tools.getNonceStr());
            publicMap.put("sign", MD5tools.getSigh("", ""));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        map.put("PageCondition", object);
//        map.put("SessionKey", "26ea70c5cea4c244e2dbdb0b8d7c1aac");
        map.put("AppSignModel", publicMap);


        LessonListRequest mRequest = new LessonListRequest(getActivity().getApplicationContext());
        mRequest.setListener(new BaseHttpRequest.IRequestListener<LessonListData>() {
            @Override
            public void onSuccess(LessonListData data) {
                if (!TextUtils.isEmpty(data.getResult_code())) {
                    if (data.getResult_code().equals("SUCCESS")) {
                        lessonListAdapter.setData(data.getData());
                    }
                }
            }

            @Override
            public void onFailed(String msg, String code) {

            }
        });
        mRequest.requestLessonList(new JSONObject(map) + "");
    }

    private void initFreeData() {

    }

    private void initView(View view) {
        scrollView = (ScrollView) view.findViewById(R.id.sl_home_page);
        banner = (Banner) view.findViewById(R.id.banner);
        llHomeExercise = (LinearLayout) view.findViewById(R.id.ll_home_exercises);
        llFreeLessons = (LinearLayout) view.findViewById(R.id.ll_free_lessons);
        llPriceLesson = (LinearLayout) view.findViewById(R.id.ll_price_lessons);
        llTypeLessons = (LinearLayout) view.findViewById(R.id.ll_type_lessons);
        llAllLesson = (LinearLayout) view.findViewById(R.id.ll_all_lesson);
        lvLastCourses = (ListViewForScrollView) view.findViewById(R.id.lv_last_courses);
        tvAllLastLesson = (TextView) view.findViewById(R.id.tv_all_last_lesson);
        ivToMyOrder = (ImageView) view.findViewById(R.id.tv_to_my_order);

        lvFreeCourses = (ListViewForScrollView) view.findViewById(R.id.lv_free_courses);
        tvAllFreeLesson = (TextView) view.findViewById(R.id.tv_all_free_lesson);

        gridView = (GridView) view.findViewById(R.id.gv_lesson_type);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FreeLessonsActivity.class);
                intent.putExtra(FreeLessonsActivity.TYPE_NAME, list.get(position).get("text").toString());
                intent.putExtra(FreeLessonsActivity.TYPE_CODE, list.get(position).get("image").toString());
                getActivity().startActivity(intent);
            }
        });

        ivSearch = (ImageView) view.findViewById(R.id.iv_to_search);
        etInputSearch = (EditText) view.findViewById(R.id.et_search_input);

        lessonListAdapter = new LessonListAdapter(getActivity());
        lvLastCourses.setAdapter(lessonListAdapter);
        lvFreeCourses.setAdapter(lessonListAdapter);
        lvLastCourses.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        return true;
                    default:
                        break;
                }
                return true;
            }
        });
        lvFreeCourses.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        return true;
                    default:
                        break;
                }
                return true;
            }
        });


        llHomeExercise.setOnClickListener(this);
        llFreeLessons.setOnClickListener(this);
        llAllLesson.setOnClickListener(this);
        llPriceLesson.setOnClickListener(this);
        tvAllLastLesson.setOnClickListener(this);
        llTypeLessons.setOnClickListener(this);
        tvAllFreeLesson.setOnClickListener(this);
        ivToMyOrder.setOnClickListener(this);

        etInputSearch.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //重写onTouch()事件,在事件里通过requestDisallowInterceptTouchEvent(boolean)
                //方法来设置父类的不可用,true表示父类的不可用
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    scrollView.requestDisallowInterceptTouchEvent(false);
                } else {
                    scrollView.requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });

        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etInputSearch.getText().toString().trim())) {
                    Toast.makeText(getContext().getApplicationContext(), "输入搜索内容", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    sqlString = etInputSearch.getText().toString().trim();
                    Intent intent = new Intent(getActivity(), FreeLessonsActivity.class);
                    intent.putExtra(FreeLessonsActivity.LESSON_TYPE, 9);
                    intent.putExtra(FreeLessonsActivity.SEARCH_SQL,etInputSearch.getText().toString().trim() );
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home_exercises:
                //练习题
                jumpToNext(HomeExerciseActivity.class);
                break;
            case R.id.ll_free_lessons:
                //免费体验
                Intent intent = new Intent(getActivity(), FreeLessonsActivity.class);
                intent.putExtra(FreeLessonsActivity.LESSON_TYPE, 0);
                startActivity(intent);
                break;
            case R.id.ll_price_lessons:
                //付费精品
                Intent intent1 = new Intent(getActivity(), FreeLessonsActivity.class);
                intent1.putExtra(FreeLessonsActivity.LESSON_TYPE, 1);
                startActivity(intent1);
                break;
            case R.id.ll_all_lesson:
                //付费精品
                Intent intent2 = new Intent(getActivity(), FreeLessonsActivity.class);
                intent2.putExtra(FreeLessonsActivity.LESSON_TYPE, 2);
                startActivity(intent2);
                break;
            case R.id.tv_all_last_lesson:
                //所有最新课程
                Intent intent3 = new Intent(getActivity(), FreeLessonsActivity.class);
                intent3.putExtra(FreeLessonsActivity.LESSON_TYPE, 3);
                startActivity(intent3);
                break;
            case R.id.ll_type_lessons:
                //所有课目类别
                Intent intent4 = new Intent(getActivity(), FreeLessonsActivity.class);
                intent4.putExtra(FreeLessonsActivity.LESSON_TYPE, 4);
                startActivity(intent4);
                break;
            case R.id.tv_all_free_lesson:
                //所有体检课程
                Intent intent5 = new Intent(getActivity(), FreeLessonsActivity.class);
                intent5.putExtra(FreeLessonsActivity.LESSON_TYPE, 5);
                startActivity(intent5);
                break;
//            case R.id.ll_all_type_lesson:
//                //所有类型课程
//                Intent intent6 = new Intent(getActivity(), FreeLessonsActivity.class);
//                intent6.putExtra(FreeLessonsActivity.LESSON_TYPE, 6);
//                startActivity(intent6);
//                break;
            case R.id.tv_to_my_order:
                //去我的订单
                Intent intent7 = new Intent(getActivity(), MyOrderActivity.class);
                startActivity(intent7);
                break;
        }
    }

    private void jumpToNext(Class activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }

}
