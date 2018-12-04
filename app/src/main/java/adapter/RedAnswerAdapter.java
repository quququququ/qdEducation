package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qupengcheng.qingdaoeducation.R;

import java.util.ArrayList;
import java.util.List;

import data.PracticeDetailData;
import data.QuestionListData;

/**
 * Created by cheng on 2018/6/28.
 */

public class RedAnswerAdapter extends BaseAdapter {
    private Context context;
    private int typeCode;
    private String answer;
    private List<PracticeDetailData.DataBean.PracticeDetailBean.QuestionOptionsBean> mData = new ArrayList<>();

    public RedAnswerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<PracticeDetailData.DataBean.PracticeDetailBean.QuestionOptionsBean> data, int typeCode,String answer) {
        mData.clear();
        if (null != data && data.size() > 0) {
            this.mData = data;
            this.typeCode = typeCode;
            this.answer = answer;
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
            convertView = View.inflate(context, R.layout.item_read_answer, null);
            holder = new ViewHolder();
            holder.tvType = (TextView) convertView.findViewById(R.id.tv_question_name);
            holder.tvFillNo = (TextView) convertView.findViewById(R.id.tv_question_no);
            holder.etInputContent = (EditText) convertView.findViewById(R.id.et_input_question);
            holder.cbQuestion = (TextView) convertView.findViewById(R.id.cb_check_name);
            holder.llSelectType = (LinearLayout) convertView.findViewById(R.id.ll_select_question);
            holder.llInputType = (LinearLayout) convertView.findViewById(R.id.ll_fill_question);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final PracticeDetailData.DataBean.PracticeDetailBean.QuestionOptionsBean dataBean = mData.get(position);

        if (typeCode == 1) {
            holder.llSelectType.setVisibility(View.VISIBLE);
            holder.llInputType.setVisibility(View.GONE);
            holder.cbQuestion.setText(dataBean.getNo());
            holder.tvType.setText(dataBean.getContent());
            if(dataBean.isIsCorrect()){
                holder.cbQuestion.setBackground(context.getResources().getDrawable(R.drawable.green_select_bg));
                holder.cbQuestion.setTextColor(Color.parseColor("#ffffff"));
            }else if(dataBean.getNo().equals(answer)){
                holder.cbQuestion.setBackground(context.getResources().getDrawable(R.drawable.blue_select_bg));
                holder.cbQuestion.setTextColor(Color.parseColor("#ffffff"));
            }else{
                holder.cbQuestion.setBackground(context.getResources().getDrawable(R.drawable.white_select_bg));
                holder.cbQuestion.setTextColor(Color.parseColor("#000000"));
            }
        } else if (typeCode == 2) {
            holder.llSelectType.setVisibility(View.GONE);
            holder.llInputType.setVisibility(View.VISIBLE);
            holder.tvFillNo.setText(dataBean.getNo());
        }

        return convertView;
    }

    public void clearData() {
        mData.clear();
        notifyDataSetChanged();
    }


    class ViewHolder {
        private TextView tvType, tvFillNo;
        private EditText etInputContent;
        private TextView cbQuestion;
        private LinearLayout llSelectType, llInputType;
    }
}
