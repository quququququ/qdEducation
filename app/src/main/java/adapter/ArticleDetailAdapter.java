package adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qupengcheng.qingdaoeducation.R;

import java.util.ArrayList;
import java.util.List;

import activity.ArticleDetailActivity;
import activity.ArticleVideoActivity;
import data.ArticleDetailData;
import data.LessonDetailData;

/**
 * Created by cheng on 2018/6/28.
 */

public class ArticleDetailAdapter extends BaseAdapter {
    private Context context;
    private List<ArticleDetailData.DataBean.AbilityItemListBean> mData = new ArrayList<>();
    private String articleCode;

    public ArticleDetailAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ArticleDetailData.DataBean.AbilityItemListBean> data,String articleCode) {
        mData.clear();
        if (null != data && data.size() > 0) {
            this.mData = data;
            this.articleCode = articleCode;
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
            convertView = View.inflate(context, R.layout.item_detail_type, null);
            holder = new ViewHolder();
            holder.tvType = (TextView) convertView.findViewById(R.id.tv_detail_type);
            holder.ivArrowMore = (ImageView) convertView.findViewById(R.id.iv_arrow_more);
            holder.llDetailItem = (LinearLayout) convertView.findViewById(R.id.ll_detail_type);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final ArticleDetailData.DataBean.AbilityItemListBean dataBean = mData.get(position);

        holder.tvType.setText(dataBean.getName());

        holder.llDetailItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ArticleVideoActivity.class);
                intent.putExtra(ArticleVideoActivity.ABILITY_CODE,dataBean.getCode());
                intent.putExtra(ArticleVideoActivity.ABILITY_NAME,dataBean.getName());
                intent.putExtra(ArticleVideoActivity.ARTICLE_CODE,articleCode);
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
        private TextView tvType;
        private ImageView ivArrowMore;
        private LinearLayout llDetailItem;
    }
}
