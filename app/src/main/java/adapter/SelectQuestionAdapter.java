package adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qupengcheng.qingdaoeducation.R;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import activity.ArticleVideoActivity;
import data.ArticleDetailData;
import data.QuestionListData;
import fm.jiecao.jcvideoplayer_lib.JCUtils;

/**
 * Created by cheng on 2018/6/28.
 */

public class SelectQuestionAdapter extends BaseAdapter {
    private Context context;
    private int typeCode;
    private List<QuestionListData.DataBean.QuestionOptionsBean> mData = new ArrayList<>();

    public SelectQuestionAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<QuestionListData.DataBean.QuestionOptionsBean> data, int typeCode) {
        mData.clear();
        if (null != data && data.size() > 0) {
            this.mData = data;
            this.typeCode = typeCode;
        }
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (null == convertView) {
            convertView = View.inflate(context, R.layout.item_select_question, null);
            holder = new ViewHolder();
            holder.tvType = (TextView) convertView.findViewById(R.id.tv_question_name);
            holder.tvFillNo = (TextView) convertView.findViewById(R.id.tv_question_no);
            holder.etInputContent = (EditText) convertView.findViewById(R.id.et_input_question);
            holder.cbQuestion = (CheckBox) convertView.findViewById(R.id.cb_check_name);
            holder.llSelectType = (LinearLayout) convertView.findViewById(R.id.ll_select_question);
            holder.llInputType = (LinearLayout) convertView.findViewById(R.id.ll_fill_question);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final QuestionListData.DataBean.QuestionOptionsBean dataBean = mData.get(position);

        if (typeCode == 1) {
            holder.llSelectType.setVisibility(View.VISIBLE);
            holder.llInputType.setVisibility(View.GONE);
            holder.cbQuestion.setText(dataBean.getNo());
            holder.tvType.setText(dataBean.getContent());
        } else if (typeCode == 2) {
            holder.llSelectType.setVisibility(View.GONE);
            holder.llInputType.setVisibility(View.VISIBLE);
            holder.tvFillNo.setText(dataBean.getNo());
        }

        if (!dataBean.isCheck()) {
            holder.cbQuestion.setChecked(false);
        }

        holder.cbQuestion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (int i = 0; i < mData.size(); i++) {
                        mData.get(i).setCheck(false);
                    }
                    dataBean.setCheck(true);
                    dataBean.setUserAnswer(dataBean.getNo());
                    if (null != selectQuestionListener)
                        selectQuestionListener.addSelect(dataBean.getNo());
                } else {
                    dataBean.setCheck(false);
                }
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    public void clearData() {
        mData.clear();
        notifyDataSetChanged();
    }


    class ViewHolder {
        private TextView tvType, tvFillNo;
        private EditText etInputContent;
        private CheckBox cbQuestion;
        private LinearLayout llSelectType, llInputType;
    }

    private SelectQuestionListener selectQuestionListener;

    public void setOnSelectQuestionListener(SelectQuestionListener selectQuestionListener) {
        this.selectQuestionListener = selectQuestionListener;
    }

    public interface SelectQuestionListener {
        void addSelect(String answer);
    }

    public String getCode(){
        for (int i = 0; i < mData.size(); i++) {
            if(mData.get(i).isCheck()){
                return mData.get(i).getQuestionOptionCode();
            }
        }
        return "";
    }

    public String getAnswer(){
        for (int i = 0; i < mData.size(); i++) {
            if(mData.get(i).isCheck()){
                return mData.get(i).getUserAnswer();
            }
        }
        return "";
    }

}
