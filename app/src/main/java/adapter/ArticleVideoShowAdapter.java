package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
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
import java.util.HashMap;
import java.util.List;

import activity.MediaPlayActivity;
import data.ArticleHandoutData;
import data.ArticleHandoutListData;
import tools.ConstantUrl;

/**
 * Created by cheng on 2018/6/28.
 */

public class ArticleVideoShowAdapter extends BaseAdapter {
    private Context context;
    private List<ArticleHandoutData.DataBean.VideosBean> mData = new ArrayList<>();

    public ArticleVideoShowAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ArticleHandoutData.DataBean.VideosBean> data) {
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
        final ArticleHandoutData.DataBean.VideosBean dataBean = mData.get(position);

        holder.tvType.setText(dataBean.getFileName());
        Glide.with(context).load(ConstantUrl.URL_Base + dataBean.getPircturePath()).into((holder).ivBook);


        holder.llDetailItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != deviceListListener){
                    deviceListListener.reduceNo(ConstantUrl.URL_Base+dataBean.getVideoAccessoryPath().replace("\\","/").replace(" ","%20"));
                }
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
        private TextView tvType,tvContent;
        private LinearLayout llDetailItem;
    }

    private DeviceListListener deviceListListener;

    public void setOnIPostPackageNoListener(DeviceListListener deviceListListener) {
        this.deviceListListener = deviceListListener;
    }

    public interface DeviceListListener {
        void reduceNo(String path);

    }

    public static Bitmap retriveVideoFrameFromVideo(String videoPath)
            throws Throwable
    {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try
        {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            if (Build.VERSION.SDK_INT >= 14)
                mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
            else
                mediaMetadataRetriever.setDataSource(videoPath);
            bitmap = mediaMetadataRetriever.getFrameAtTime();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Throwable(
                    "Exception in retriveVideoFrameFromVideo(String videoPath)"
                            + e.getMessage());

        }
        finally
        {
            if (mediaMetadataRetriever != null)
            {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }
}
