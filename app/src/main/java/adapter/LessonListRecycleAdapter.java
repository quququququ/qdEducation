package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import data.MyCollectionData;
import tools.ConstantUrl;

/**
 * Created by cheng on 2018/6/28.
 */

public class LessonListRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<LessonListData.DataBean> mData = new ArrayList<>();

    public LessonListRecycleAdapter(Context context) {
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
        if (null != data || data.size() == 0) {
            return;
        }
        mData.addAll(data);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_collection, parent, false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof VH) {
            ((VH) holder).tvTitle.setText(mData.get(position).getName());
            ((VH) holder).tvContent.setText(mData.get(position).getInstructionalOBJ());
            if (null != mData.get(position).getPicturePath())
                Glide.with(context).load(ConstantUrl.URL_Base + mData.get(position).getPicturePath()).into(((VH) holder).ivBook);

            if (TextUtils.isEmpty(mData.get(position).getCategoryName())) {
                ((VH) holder).tvClassType.setVisibility(View.INVISIBLE);
            } else {
                ((VH) holder).tvClassType.setVisibility(View.VISIBLE);
                ((VH) holder).tvClassType.setText(mData.get(position).getAbilityItemName());
            }
            if (TextUtils.isEmpty(String.valueOf(mData.get(position).getLevel()))) {
                ((VH) holder).tvClassLevel.setVisibility(View.INVISIBLE);
            } else {
                ((VH) holder).tvClassLevel.setVisibility(View.VISIBLE);
                ((VH) holder).tvClassLevel.setText(mData.get(position).getLevel() + "");
            }
            ((VH) holder).llItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, LessonDetailActivity.class);
                    intent.putExtra(LessonDetailActivity.LESSON_CODE, mData.get(position).getCode());
                    context.startActivity(intent);
                }
            });
        }

    }

    public void clearData() {
        mData.clear();
        notifyDataSetChanged();
    }

    class VH extends RecyclerView.ViewHolder {

        public final RoundedImageView ivBook;
        public final LinearLayout llItemView;
        public final TextView tvTitle, tvContent, tvClassType, tvClassLevel;

        public VH(View itemView) {
            super(itemView);
            ivBook = (RoundedImageView) itemView.findViewById(R.id.iv_book);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_book_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_book_content);
            tvClassType = (TextView) itemView.findViewById(R.id.tv_class_class_name);
            tvClassLevel = (TextView) itemView.findViewById(R.id.tv_class_class_level);
            llItemView = (LinearLayout) itemView.findViewById(R.id.ll_lesson_item);
        }
    }
}
