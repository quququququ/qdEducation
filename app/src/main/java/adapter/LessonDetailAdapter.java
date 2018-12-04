package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qupengcheng.qingdaoeducation.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import activity.ArticleDetailActivity;
import activity.ArticleDetailNewActivity;
import data.LessonDetailData;
import data.LessonListData;

/**
 * Created by cheng on 2018/6/28.
 */

public class LessonDetailAdapter extends BaseAdapter {
    private Context context;
    private Boolean isStudy;
    private List<LessonDetailData.DataBean.ArticlesBean> mData = new ArrayList<>();

    public LessonDetailAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<LessonDetailData.DataBean.ArticlesBean> data, boolean isStudy) {
        mData.clear();
        if (null != data && data.size() > 0) {
            this.mData = data;
            this.isStudy = isStudy;
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
            convertView = View.inflate(context, R.layout.item_lesson_detail, null);
            holder = new ViewHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_article_title);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_article_content);
            holder.tvBuyNot = (TextView) convertView.findViewById(R.id.tv_buy_not);
            holder.ivBuyNot = (ImageView) convertView.findViewById(R.id.iv_buy_not);
            holder.llArticleDetail = (LinearLayout) convertView.findViewById(R.id.ll_article_detail);
            holder.llBuyOrNot = (LinearLayout) convertView.findViewById(R.id.ll_buy_or_not);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final LessonDetailData.DataBean.ArticlesBean dataBean = mData.get(position);
        if (!isStudy) {
            holder.llBuyOrNot.setVisibility(View.VISIBLE);
            if (dataBean.isIsPurchased()) {
                holder.ivBuyNot.setBackground(context.getResources().getDrawable(R.drawable.tip_bye_y));
                holder.tvBuyNot.setText("已购");
                holder.tvBuyNot.setTextColor(Color.parseColor("#34c84a"));
            } else {
                holder.ivBuyNot.setBackground(context.getResources().getDrawable(R.drawable.tip_bye_cart));
                holder.tvBuyNot.setText("购买");
                holder.tvBuyNot.setTextColor(Color.parseColor("#6692ff"));
            }
        }else {
            holder.llBuyOrNot.setVisibility(View.GONE);
        }
        holder.tvTitle.setText(dataBean.getArticleSummary());
        holder.tvContent.setText(dataBean.getContent());
        holder.llArticleDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ArticleDetailNewActivity.class);
                intent.putExtra(ArticleDetailNewActivity.ARTICLE_CODE, dataBean.getCode());
                intent.putExtra(ArticleDetailNewActivity.ARTICLE_TITLE, dataBean.getTitle() + "");
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
        private TextView tvTitle, tvContent, tvBuyNot;
        private LinearLayout llArticleDetail;
        private ImageView ivBuyNot;
        private LinearLayout llBuyOrNot;
    }
}
