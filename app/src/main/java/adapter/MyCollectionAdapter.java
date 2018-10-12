package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qupengcheng.qingdaoeducation.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import data.MyCollectionData;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyCollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MyCollectionData.DataBean> dataBean = new ArrayList<>();
    private Context context;

    public enum Item_Type {
        RECYCLEVIEW_ITEM_TYPE_1,
        RECYCLEVIEW_ITEM_TYPE_2
    }


    public MyCollectionAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<MyCollectionData.DataBean> data) {
        dataBean.clear();
        if (null != dataBean && dataBean.size() > 0) {
            this.dataBean = data;
        }
        notifyDataSetChanged();
    }

    public void setLoadData(List<MyCollectionData.DataBean> data) {
        if (null != dataBean || dataBean.size() == 0) {
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
        if(viewType == Item_Type.RECYCLEVIEW_ITEM_TYPE_1.ordinal()) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_collection, parent, false);
            VH vh = new VH(v);
            return vh;
        }
        else if(viewType == Item_Type.RECYCLEVIEW_ITEM_TYPE_2.ordinal()) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_collection_artical, parent, false);
            ArticalVh articalVh = new ArticalVh(v);
            return articalVh;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof VH){
            ((VH)holder).tvTitle.setText("");
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(dataBean.get(position).getType() == 0){
            return Item_Type.RECYCLEVIEW_ITEM_TYPE_1.ordinal();
        }else if(dataBean.get(position).getType() == 1){
            return Item_Type.RECYCLEVIEW_ITEM_TYPE_2.ordinal();
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return dataBean.size();
    }

    class VH extends RecyclerView.ViewHolder {

        public final RoundedImageView ivBook;
        public final TextView tvTitle;
        public final TextView tvContent;

        public VH(View itemView) {
            super(itemView);
            ivBook = (RoundedImageView) itemView.findViewById(R.id.iv_book);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_book_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_book_content);
        }
    }

    class ArticalVh extends RecyclerView.ViewHolder{

        public final TextView tvArticalTitle;
        public final TextView tvArticalContent;

        public ArticalVh(View itemView) {
            super(itemView);

            tvArticalTitle = (TextView) itemView.findViewById(R.id.tv_article_title);
            tvArticalContent = (TextView) itemView.findViewById(R.id.tv_article_content);
        }
    }
}
