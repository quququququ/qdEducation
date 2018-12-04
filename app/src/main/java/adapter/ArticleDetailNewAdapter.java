package adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.qupengcheng.qingdaoeducation.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
import activity.MediaPlayActivity;
import data.ArticleHandoutListData;
import tools.ConstantUrl;

/**
 * Created by qupengcheng on 2018/11/27.
 */

public class ArticleDetailNewAdapter extends BaseExpandableListAdapter {
    private List<ArticleHandoutListData.DataBean> groupList;//外层的数据源
    private List<List<ArticleHandoutListData.DataBean.ArticleHandoutsBean>> childList;//里层的数据源
    private Context context;

    public ArticleDetailNewAdapter(Context context, List<ArticleHandoutListData.DataBean> groupList, List<List<ArticleHandoutListData.DataBean.ArticleHandoutsBean>> childList) {
        this.context = context;
        this.childList = childList;
        this.groupList = groupList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_detail_type, null);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_detail_type);
            groupViewHolder.ivArrowMore = (ImageView) convertView.findViewById(R.id.iv_arrow_more);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvTitle.setText(groupList.get(groupPosition).getAbilityItemName());
        if(isExpanded){
            groupViewHolder.ivArrowMore.setBackground(context.getResources().getDrawable(R.drawable.arrowdown));
        }else{
            groupViewHolder.ivArrowMore.setBackground(context.getResources().getDrawable(R.drawable.arrowmore));
        }
        return convertView;

    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup viewGroup) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.view_item_articlevideo,null);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_book_title);
            childViewHolder.tvBookContent = (TextView) convertView.findViewById(R.id.tv_book_content);
            childViewHolder.ivBook = (RoundedImageView) convertView.findViewById(R.id.iv_book);
            childViewHolder.llItem = (LinearLayout) convertView.findViewById(R.id.ll_lesson_item);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MediaPlayActivity.class);
                intent.putExtra(MediaPlayActivity.CODE,childList.get(groupPosition).get(childPosition).getCode());
                context.startActivity(intent);
            }
        });
        childViewHolder.tvName.setText(childList.get(groupPosition).get(childPosition).getTitle());
        childViewHolder.tvBookContent.setText(childList.get(groupPosition).get(childPosition).getSummary());
        if (!TextUtils.isEmpty(childList.get(groupPosition).get(childPosition).getIMGPath())) {
            Glide.with(context).load(ConstantUrl.URL_Base + childList.get(groupPosition).get(childPosition).getIMGPath()).into(childViewHolder.ivBook);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class GroupViewHolder {
        TextView tvTitle;
        ImageView ivArrowMore;
    }

    static class ChildViewHolder {
        TextView tvName,tvBookContent;
        RoundedImageView ivBook;
        LinearLayout llItem;
    }
}
