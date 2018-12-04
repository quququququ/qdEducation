package adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
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

import activity.ArticleVideoActivity;
import activity.MediaPlayActivity;
import data.ArticleDetailData;
import data.ArticleHandoutListData;
import tools.ConstantUrl;

/**
 * Created by cheng on 2018/6/28.
 */

public class ArticleVideoAdapter extends BaseAdapter {
    private Context context;
    private List<ArticleHandoutListData.DataBean> mData = new ArrayList<>();

    public ArticleVideoAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ArticleHandoutListData.DataBean> data) {
        mData.clear();
        if (null != data && data.size() > 0) {
            this.mData = data;
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
            convertView = View.inflate(context, R.layout.view_item_articlevideo, null);
            holder = new ViewHolder();
            holder.tvType = (TextView) convertView.findViewById(R.id.tv_book_title);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_book_content);
            holder.ivBook = (RoundedImageView) convertView.findViewById(R.id.iv_book);
            holder.llDetailItem = (LinearLayout) convertView.findViewById(R.id.ll_lesson_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final ArticleHandoutListData.DataBean dataBean = mData.get(position);

//        holder.tvType.setText(dataBean.getTitle());
//        holder.tvContent.setText(dataBean.getSummary());
//        if (!TextUtils.isEmpty(dataBean.getIMGFilePath())) {
//            Glide.with(context).load(ConstantUrl.URL_Base + dataBean.getIMGFilePath()).into((holder).ivBook);
//        }
//
//        holder.llDetailItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, MediaPlayActivity.class);
//                intent.putExtra(MediaPlayActivity.CODE,dataBean.getCode());
//                context.startActivity(intent);
//            }
//        });
        return convertView;
    }

    public void clearData() {
        mData.clear();
        notifyDataSetChanged();
    }


    class ViewHolder {
        private RoundedImageView ivBook;
        private TextView tvType,tvContent;
        private LinearLayout llDetailItem;
    }
}
