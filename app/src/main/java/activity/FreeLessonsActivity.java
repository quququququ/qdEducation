package activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;

import net.LessonListRequest;
import net.SearchResultRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import adapter.LessonListRecycleAdapter;
import base.TitleActivity;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import data.LessonListData;
import tools.DialogUtil;
import tools.LoadingDialog;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/11/1.
 */

public class FreeLessonsActivity extends TitleActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {
    public static final String LESSON_TYPE = "lesson.type";
    public static final String TYPE_NAME = "type.name";
    public static final String TYPE_CODE = "type.code";
    public static final String SEARCH_SQL = "search.sql";
    private boolean isFirst, isLoad, needLoad;
    private int page = 1;
    private String sqlString = "price=0";
    private LessonListRecycleAdapter lessonListAdapter;
    private LoadingDialog loadingDialog;
    private RecyclerView rvCollection;
    private BGARefreshLayout bgaRefreshLayout;
    private int type;
    private LinearLayout llSearchLesson;
    private String sqlLesson;
    private ImageView ivToSearch;
    private EditText etToSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_free_lesson_list);

        type = getIntent().getIntExtra(LESSON_TYPE, 0);
        sqlLesson = getIntent().getStringExtra(SEARCH_SQL);
        if (TextUtils.isEmpty(getIntent().getStringExtra(TYPE_NAME))) {
            if (type == 0) {
                setMidTitle("体验课程");
                sqlString = "price=0";
            } else if (type == 1) {
                setMidTitle("付费精品");
                sqlString = "price>0";
            } else if (type == 2) {
                setMidTitle("全部课程");
                sqlString = "";
            } else if (type == 3) {
                setMidTitle("全部最新课程");
                sqlString = "";
            } else if (type == 4) {
                setMidTitle("全部课程");
                sqlString = "";
            } else if (type == 5) {
                setMidTitle("全部推荐课程");
                sqlString = "";
            } else if (type == 6) {
                setMidTitle("全部课程");
                sqlString = "";
            } else if (type == 9) {
                setMidTitle("搜索结果");
                sqlString = getIntent().getStringExtra(SEARCH_SQL);
            }
        } else {
            setMidTitle(getIntent().getStringExtra(TYPE_NAME));
//            Log.i("走不走",getIntent().getStringExtra(TYPE_CODE)+"22222");
            sqlString = "AbilityItemCode=" + getIntent().getStringExtra(TYPE_CODE);

        }
        initView();
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initView() {
        loadingDialog = DialogUtil.createLoaddingDialog(this);
        loadingDialog.setMessage("加载中");
        loadingDialog.setCancelable(true);

        bgaRefreshLayout = (BGARefreshLayout) findViewById(R.id.bga_my_free_lesson);
        bgaRefreshLayout.setDelegate(this);
        bgaRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(this, true));

        lessonListAdapter = new LessonListRecycleAdapter(this);
        rvCollection = (RecyclerView) findViewById(R.id.rv_my_free_lesson);
        rvCollection.setLayoutManager(new LinearLayoutManager(this));
        rvCollection.setAdapter(lessonListAdapter);
        llSearchLesson = (LinearLayout) findViewById(R.id.ll_search_lesson);
        ivToSearch = (ImageView) findViewById(R.id.iv_to_search);
        etToSearch = (EditText) findViewById(R.id.et_search_input);
        ivToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etToSearch.getText().toString().trim())) {
                    Toast.makeText(FreeLessonsActivity.this, "输入搜索内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    sqlString = etToSearch.getText().toString().trim();
                    initData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initData() throws Exception {
        if (TextUtils.isEmpty(getIntent().getStringExtra(SEARCH_SQL))) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("appId", "123456");
            map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
            map.put("nonce_str", MD5tools.getNonceStr());
            map.put("sign", MD5tools.getSigh("", ""));

            HashMap<String, Object> requestMain = new HashMap<>();
            requestMain.put("CurrentIndex", page);
            requestMain.put("PageSize", "10");
            requestMain.put("SQLStr", sqlString);

            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("AppSignModel", map);
//        hashMap.put("SessionKey", "26ea70c5cea4c244e2dbdb0b8d7c1aac");
            hashMap.put("PageCondition", requestMain);

            LessonListRequest mRequest = new LessonListRequest(this);
            mRequest.setListener(new BaseHttpRequest.IRequestListener<LessonListData>() {
                @Override
                public void onSuccess(LessonListData data) {
                    if (!TextUtils.isEmpty(data.getResult_code()) && null != data.getData()) {
                        if (data.getData().size() == 0) {
                            bgaRefreshLayout.endRefreshing();
                            bgaRefreshLayout.endLoadingMore();
                            loadingDialog.dismiss();
                            Toast.makeText(FreeLessonsActivity.this, "没有数据", Toast.LENGTH_SHORT).show();
                        } else if (data.getResult_code().equals("SUCCESS")) {
                            if (isLoad) {
                                isLoad = false;
                                if (null != data.getData()) {
                                    if (data.getData().size() < 10)
                                        needLoad = false;
                                    else
                                        needLoad = true;
                                    lessonListAdapter.setLoadData(data.getData());
                                } else {
                                    needLoad = false;
                                }
                                bgaRefreshLayout.endRefreshing();
                                bgaRefreshLayout.endLoadingMore();
                                loadingDialog.dismiss();
                                return;
                            }
                            lessonListAdapter.clearData();
                            lessonListAdapter.setData(data.getData());
                            if (data.getData().size() < 10)
                                needLoad = false;
                            else
                                needLoad = true;
                            bgaRefreshLayout.endRefreshing();
                            bgaRefreshLayout.endLoadingMore();
                            loadingDialog.dismiss();
                        }
                    } else {
                        bgaRefreshLayout.endRefreshing();
                        bgaRefreshLayout.endLoadingMore();
                        loadingDialog.dismiss();
                        Toast.makeText(FreeLessonsActivity.this, "没有数据", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailed(String msg, String code) {
                    bgaRefreshLayout.endRefreshing();
                    bgaRefreshLayout.endLoadingMore();
                    loadingDialog.dismiss();
                    Toast.makeText(FreeLessonsActivity.this, msg + "", Toast.LENGTH_SHORT).show();
                }
            });
            mRequest.requestLessonList(JSON.toJSONString(hashMap));
        } else {
            HashMap<String, Object> map = new HashMap<>();
            JSONObject object = new JSONObject();
            HashMap<String, Object> publicMap = new HashMap<>();
            try {
                object.put("CurrentIndex", 1);
                object.put("PageSize", 10);
                object.put("SQLStr", "");
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
            map.put("SessionKey", "26ea70c5cea4c244e2dbdb0b8d7c1aac");
            map.put("AppSignModel", publicMap);
            map.put("Text", sqlString);

            SearchResultRequest mRequest = new SearchResultRequest(this);
            mRequest.setListener(new BaseHttpRequest.IRequestListener<LessonListData>() {
                @Override
                public void onSuccess(LessonListData data) {
                    if (!TextUtils.isEmpty(data.getResult_code()) && null != data.getData()) {
                        if (data.getResult_code().equals("SUCCESS")) {
                            if (isLoad) {
                                isLoad = false;
                                if (null != data.getData()) {
                                    if (data.getData().size() < 10)
                                        needLoad = false;
                                    else
                                        needLoad = true;
                                    lessonListAdapter.setLoadData(data.getData());
                                } else {
                                    needLoad = false;
                                }
                                bgaRefreshLayout.endRefreshing();
                                bgaRefreshLayout.endLoadingMore();
                                loadingDialog.dismiss();
                                return;
                            }
                            lessonListAdapter.clearData();
                            lessonListAdapter.setData(data.getData());
                            if (data.getData().size() < 10)
                                needLoad = false;
                            else
                                needLoad = true;
                            bgaRefreshLayout.endRefreshing();
                            bgaRefreshLayout.endLoadingMore();
                            loadingDialog.dismiss();
                        }
                    }
                }

                @Override
                public void onFailed(String msg, String code) {
                    bgaRefreshLayout.endRefreshing();
                    bgaRefreshLayout.endLoadingMore();
                    loadingDialog.dismiss();
                    Toast.makeText(FreeLessonsActivity.this, msg + "", Toast.LENGTH_SHORT).show();
                }
            });
            mRequest.requestSearchResult(new JSONObject(map) + "");

        }
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        isLoad = false;
        isFirst = true;
        page = 1;
        try {
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        isLoad = true;
        isFirst = false;
        page++;
        if (needLoad) {
            try {
                initData();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }
}
