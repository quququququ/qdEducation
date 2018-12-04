package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.qupengcheng.qingdaoeducation.R;

import java.util.ArrayList;
import java.util.List;

import activity.ReadAnswerActivity;
import data.PracticeListData;
import view.XCRoundProgressBar;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyPracticeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PracticeListData.DataBean> dataBean = new ArrayList<>();
    private Context context;


    public MyPracticeListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<PracticeListData.DataBean> data) {
        dataBean.clear();

        if (null != data && data.size() > 0) {
            this.dataBean = data;
        }
        notifyDataSetChanged();
    }

    public void setLoadData(List<PracticeListData.DataBean> data) {
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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_practice, parent, false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VH) {
            final PracticeListData.DataBean data = dataBean.get(position);
            ((VH) holder).tvTitle.setText(data.getTitle());
            ((VH) holder).tvNo.setText("共"+data.getQuestionCount()+"题");
            ((VH) holder).tvEndTime.setText(data.getEndTime().replace("T"," "));
            ((VH) holder).tvTime.setText("");
            if("0".equals(data.getCorrectRate())){
                ((VH) holder).progressBar.setProgress(0);
            }else {
                ((VH) holder).progressBar.setProgress(Integer.parseInt(data.getCorrectRate()));
            }
            ((VH) holder).progressBar.setTextColor(Color.parseColor("#3F51B5"));

            ((VH) holder).rlPracticeItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ReadAnswerActivity.class);
                    intent.putExtra(ReadAnswerActivity.CODE,data.getCode());
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

        public final TextView tvTitle,tvNo,tvTime,tvEndTime;
        public final XCRoundProgressBar progressBar;
        public final RelativeLayout rlPracticeItem;

        public VH(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_practice_title);
            tvNo = (TextView) itemView.findViewById(R.id.tv_practice_no);
            tvTime = (TextView) itemView.findViewById(R.id.tv_practice_time);
            tvEndTime = (TextView) itemView.findViewById(R.id.tv_practice_end_time);
            progressBar = (XCRoundProgressBar) itemView.findViewById(R.id.progress);
            rlPracticeItem = (RelativeLayout) itemView.findViewById(R.id.rl_practice_item);
        }
    }
}
