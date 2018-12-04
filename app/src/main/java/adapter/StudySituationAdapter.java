package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qupengcheng.qingdaoeducation.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import activity.LessonDetailActivity;
import data.MyStudyData;
import tools.ConstantUrl;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class StudySituationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MyStudyData.DataBean> dataBean = new ArrayList<>();
    private Context context;


    public StudySituationAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<MyStudyData.DataBean> data) {
        dataBean.clear();

        if (null != data && data.size() > 0) {
            this.dataBean = data;
        }
        notifyDataSetChanged();
    }

    public void setLoadData(List<MyStudyData.DataBean> data) {
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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_study, parent, false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof VH) {
            MyStudyData.DataBean data = dataBean.get(position);
            ((VH) holder).tvTitle.setText(data.getName());

            ((VH) holder).mySeekBar.setProgress(data.getPlayedVideoAmount()*100/data.getTotalVideoAmount());

            ((VH) holder).tvProgress.setText((data.getPlayedVideoAmount()*100/data.getTotalVideoAmount())+"%");
            if (!TextUtils.isEmpty(dataBean.get(position).getPicturePath()))
                Glide.with(context).load(ConstantUrl.URL_Base + dataBean.get(position).getPicturePath()).into(((VH) holder).ivBook);

            ((VH) holder).llItemLesson.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, LessonDetailActivity.class);
                    intent.putExtra(LessonDetailActivity.LESSON_CODE, dataBean.get(position).getLessonCode());
                    intent.putExtra(LessonDetailActivity.STUDY_SITUATION, true);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataBean.size();
    }

    class VH extends RecyclerView.ViewHolder {

        public final RoundedImageView ivBook;
        public final TextView tvTitle,tvProgress;
        public final ProgressBar mySeekBar;
        public final LinearLayout llItemLesson;

        public VH(View itemView) {
            super(itemView);
            ivBook = (RoundedImageView) itemView.findViewById(R.id.iv_book);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_book_title);
            tvProgress = (TextView) itemView.findViewById(R.id.tv_progress_lesson);
            mySeekBar = (ProgressBar) itemView.findViewById(R.id.sb_my_study);
            llItemLesson = (LinearLayout) itemView.findViewById(R.id.ll_lesson_item);
        }
    }

}
