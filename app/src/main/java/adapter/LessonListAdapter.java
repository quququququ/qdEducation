package adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qupengcheng.qingdaoeducation.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import activity.LessonDetailActivity;
import data.LessonListData;
import tools.ConstantUrl;

/**
 * Created by cheng on 2018/6/28.
 */

public class LessonListAdapter extends BaseAdapter {
    private Context context;
    private List<LessonListData.DataBean> mData = new ArrayList<>();

    public LessonListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<LessonListData.DataBean> data) {
        mData.clear();
        if (null != data && data.size() > 0) {
            this.mData = data;

        }
        notifyDataSetChanged();
    }

    public void setLoadData(List<LessonListData.DataBean> data) {
        if (null == data || data.size() == 0 || mData == null)
            return;
        mData.addAll(data);
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
            convertView = View.inflate(context, R.layout.view_item_collection, null);
            holder = new ViewHolder();
            holder.ivBook = (RoundedImageView) convertView.findViewById(R.id.iv_book);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_book_title);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_book_content);
            holder.tvClassType = (TextView) convertView.findViewById(R.id.tv_class_class_name);
            holder.tvClassLevel = (TextView) convertView.findViewById(R.id.tv_class_class_level);
            holder.llItemView = (LinearLayout) convertView.findViewById(R.id.ll_lesson_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        LessonListData.DataBean dataBean = mData.get(position);
        holder.tvTitle.setText(dataBean.getName());
        holder.tvContent.setText(dataBean.getInstructionalOBJ()); //课程内容字段
        if(TextUtils.isEmpty(dataBean.getCategoryName())){
            holder.tvClassType.setVisibility(View.INVISIBLE);
        }else {
            holder.tvClassType.setVisibility(View.VISIBLE);
            holder.tvClassType.setText(dataBean.getCategoryName());
        }
        if(TextUtils.isEmpty(String.valueOf(dataBean.getLevel()))){
            holder.tvClassLevel.setVisibility(View.INVISIBLE);
        }else {
            holder.tvClassLevel.setVisibility(View.VISIBLE);
            holder.tvClassLevel.setText(dataBean.getLevel()+"");
        }

        Glide.with(context).load(ConstantUrl.URL_Base + dataBean.getPicturePath()).into(holder.ivBook);

        holder.llItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LessonDetailActivity.class);
                intent.putExtra(LessonDetailActivity.LESSON_CODE, mData.get(position).getCode());
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public void clearData() {
        mData.clear();
        notifyDataSetChanged();
    }


    class ViewHolder {
        private RoundedImageView ivBook;
        private TextView tvTitle,tvContent,tvClassType,tvClassLevel;
        private LinearLayout llItemView;
    }
}
