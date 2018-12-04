package adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qupengcheng.qingdaoeducation.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import activity.ArticleDetailActivity;
import activity.ArticleDetailNewActivity;
import activity.LessonDetailActivity;
import data.MyCollectionData;
import tools.ConstantUrl;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyCollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MyCollectionData.DataBean> dataBean = new ArrayList<>();
    private Context context;

    private static final int TYPE_ME = 0;
    private static final int TYPE_FRIEND = 1;


    public MyCollectionAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<MyCollectionData.DataBean> data) {
        dataBean.clear();

        if (null != data && data.size() > 0) {
            this.dataBean = data;
        }
        notifyDataSetChanged();
    }

    public void setLoadData(List<MyCollectionData.DataBean> data) {
        if (null != data || data.size() == 0) {
            return;
        }
        dataBean.addAll(data);
        notifyDataSetChanged();

    }

    public void clearData() {
        dataBean.clear();
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ME) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_collection, parent, false);
            VH vh = new VH(v);
            return vh;
        } else if (viewType == TYPE_FRIEND) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_collection_artical, parent, false);
            ArticalVh articalVh = new ArticalVh(v);
            return articalVh;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof VH) {
            ((VH) holder).tvTitle.setText(dataBean.get(position).getTitle());
            ((VH) holder).tvContent.setText(dataBean.get(position).getSummary());
            if (TextUtils.isEmpty(dataBean.get(position).getCategoryName())) {
                ((VH) holder).tvClassType.setVisibility(View.INVISIBLE);
            } else {
                ((VH) holder).tvClassType.setVisibility(View.VISIBLE);
                ((VH) holder).tvClassType.setText(dataBean.get(position).getCategoryName());
            }
            if (TextUtils.isEmpty(String.valueOf(dataBean.get(position).getLevel()))) {
                ((VH) holder).tvClassLevel.setVisibility(View.INVISIBLE);
            } else {
                ((VH) holder).tvClassLevel.setVisibility(View.VISIBLE);
                ((VH) holder).tvClassLevel.setText(dataBean.get(position).getLevel() + "");
            }
            if (!TextUtils.isEmpty(dataBean.get(position).getPicturePath()))
                Glide.with(context).load(ConstantUrl.URL_Base + dataBean.get(position).getPicturePath()).into(((VH) holder).ivBook);

            ((VH) holder).llLessonItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, LessonDetailActivity.class);
                    intent.putExtra(LessonDetailActivity.LESSON_CODE, dataBean.get(position).getDocumentCode());
                    context.startActivity(intent);
                }
            });
        } else if (holder instanceof ArticalVh) {
            ((ArticalVh) holder).tvArticalTitle.setText(dataBean.get(position).getTitle());
            ((ArticalVh) holder).tvArticalContent.setText(dataBean.get(position).getSummary());

            ((ArticalVh) holder).llArtivleItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ArticleDetailNewActivity.class);
                    intent.putExtra(ArticleDetailNewActivity.ARTICLE_CODE,dataBean.get(position).getCategoryCode());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return dataBean.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return dataBean.size();
    }

    class VH extends RecyclerView.ViewHolder {
        public LinearLayout llLessonItem;
        public final RoundedImageView ivBook;
        public final TextView tvTitle, tvContent, tvClassType, tvClassLevel;

        public VH(View itemView) {
            super(itemView);
            ivBook = (RoundedImageView) itemView.findViewById(R.id.iv_book);
            llLessonItem = (LinearLayout) itemView.findViewById(R.id.ll_lesson_item);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_book_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_book_content);
            tvClassType = (TextView) itemView.findViewById(R.id.tv_class_class_name);
            tvClassLevel = (TextView) itemView.findViewById(R.id.tv_class_class_level);
        }
    }

    class ArticalVh extends RecyclerView.ViewHolder {

        public final TextView tvArticalTitle;
        public final TextView tvArticalContent;
        public final LinearLayout llArtivleItem;

        public ArticalVh(View itemView) {
            super(itemView);

            tvArticalTitle = (TextView) itemView.findViewById(R.id.tv_article_title);
            llArtivleItem = (LinearLayout) itemView.findViewById(R.id.ll_article_item);
            tvArticalContent = (TextView) itemView.findViewById(R.id.tv_article_content);
        }
    }
}
