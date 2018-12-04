package adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cheng.retrofit20.client.BaseHttpRequest;
import com.example.qupengcheng.qingdaoeducation.R;
import com.makeramen.roundedimageview.RoundedImageView;

import net.OrderCancelRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import data.MyCollectionData;
import data.MyOrderData;
import data.OrderCancelData;
import tools.MD5tools;
import tools.TimeUTCUtils;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MyOrderData.DataBean> dataBean = new ArrayList<>();
    private Context context;


    public MyOrderAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<MyOrderData.DataBean> data) {
        dataBean.clear();

        if (null != data && data.size() > 0) {
            this.dataBean = data;
        }
        notifyDataSetChanged();
    }

    public void setLoadData(List<MyOrderData.DataBean> data) {
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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_order, parent, false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VH) {
            final MyOrderData.DataBean data = dataBean.get(position);
            ((VH) holder).orderNo.setText("订单号：" + data.getCode());
            ((VH) holder).orderTime.setText(data.getCreateDate().substring(0, 19).replace("T", " "));
            String money = data.getOrderTotal();
            if (money.contains(".")) {
                ((VH) holder).orderTotalNum.setText(money.substring(0, money.indexOf(".")));
                ((VH) holder).orderTotalPoint.setText(money.substring(money.indexOf("."), money.length()));
            } else {
                ((VH) holder).orderTotalNum.setText(money);
                ((VH) holder).orderTotalPoint.setText(".00");
            }
            if (data.getPaymentStatusId() == 1) {
                ((VH) holder).tvToCancel.setText("删除订单");
                ((VH) holder).tvToPaay.setVisibility(View.GONE);
            } else {
                ((VH) holder).tvToCancel.setText("取消订单");
                ((VH) holder).tvToPaay.setVisibility(View.VISIBLE);
            }
            int statusId = data.getOrderStatusId();
            if (statusId == 1 || statusId == 4) {
                ((VH) holder).tvOrderStatus.setText("交易关闭");
                ((VH) holder).tvOrderStatus.setTextColor(Color.parseColor("#333333"));
            } else if (statusId == 2) {
                ((VH) holder).tvOrderStatus.setText("待支付");
                ((VH) holder).tvOrderStatus.setTextColor(Color.parseColor("#6692ff"));
            } else if (statusId == 3) {
                ((VH) holder).tvOrderStatus.setText("交易成功");
                ((VH) holder).tvOrderStatus.setTextColor(Color.parseColor("#333333"));
            }


            if (data.getDetials().size() == 1) {
                ((VH) holder).llOrderArticle.setVisibility(View.GONE);
                ((VH) holder).tvOrderArticleLine.setVisibility(View.GONE);

            } else if (data.getDetials().size() == 2) {
                ((VH) holder).llOrderArticle.setVisibility(View.VISIBLE);
                ((VH) holder).tvOrderArticleLine.setVisibility(View.VISIBLE);
                ((VH) holder).tvArticleTitle.setText(data.getDetials().get(1).getTitle());
                ((VH) holder).tvArticleContent.setText(data.getDetials().get(1).getSummary());
            }
            final MyOrderData.DataBean.DetialsBean detailBean = data.getDetials().get(0);

            if (!TextUtils.isEmpty(detailBean.getPicture()))
                Glide.with(context).load(detailBean.getPicture()).into(((VH) holder).riOrderBook);
            ((VH) holder).tvBookTitle.setText(detailBean.getTitle());
            ((VH) holder).tvBookContent.setText(detailBean.getSummary());

            ((VH) holder).tvToCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(data.getPaymentStatusId() != 1){
                        HashMap<String,Object> map = new HashMap<>();
                        map.put("appid","123456");
                        try {
                            map.put("timestamp", TimeUTCUtils.getUTCTimeStr());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        map.put("nonce_str", MD5tools.getNonceStr());
                        try {
                            map.put("sign",MD5tools.getSigh("",""));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        HashMap<String,Object> hashMap = new HashMap<>();
                        hashMap.put("AppSignModel",map);
                        hashMap.put("OrderCode",detailBean.getOrderCode());
                        hashMap.put("SessionKey","26ea70c5cea4c244e2dbdb0b8d7c1aac");
                    }

                    OrderCancelRequest mRequest = new OrderCancelRequest(context);
                    mRequest.setListener(new BaseHttpRequest.IRequestListener<OrderCancelData>() {
                        @Override
                        public void onSuccess(OrderCancelData data) {
                            if(data.getResult_code().equals("Fail")){
                                Toast.makeText(context,data.getResult_msg(),Toast.LENGTH_SHORT).show();
                                return;
                            }else{
                                if(data.getData().isFlag()){
                                    Toast.makeText(context,data.getData().getMsg(),Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                    return;
                                }else{
                                    Toast.makeText(context,data.getData().getMsg(),Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        }

                        @Override
                        public void onFailed(String msg, String code) {
                            Toast.makeText(context,"取消失败",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return dataBean.size();
    }

    class VH extends RecyclerView.ViewHolder {

        public final TextView orderNo, orderTime, orderTotalNum, orderTotalPoint, tvToCancel, tvToPaay;
        public final TextView tvOrderStatus;
        public final LinearLayout llOrderArticle, tvOrderArticleLine;
        public final RoundedImageView riOrderBook;
        public final TextView tvBookTitle, tvBookContent, tvArticleTitle, tvArticleContent;

        public VH(View itemView) {
            super(itemView);
            riOrderBook = (RoundedImageView) itemView.findViewById(R.id.iv_order_book);
            orderNo = (TextView) itemView.findViewById(R.id.tv_order_no);
            orderTime = (TextView) itemView.findViewById(R.id.tv_order_time);
            orderTotalNum = (TextView) itemView.findViewById(R.id.tv_order_money_num);
            orderTotalPoint = (TextView) itemView.findViewById(R.id.tv_order_money_point);
            tvToCancel = (TextView) itemView.findViewById(R.id.tv_to_cancel);
            tvToPaay = (TextView) itemView.findViewById(R.id.tv_to_pay);
            tvOrderStatus = (TextView) itemView.findViewById(R.id.tv_order_status);
            tvOrderArticleLine = (LinearLayout) itemView.findViewById(R.id.tv_order_article_line);
            llOrderArticle = (LinearLayout) itemView.findViewById(R.id.ll_order_article);
            tvBookTitle = (TextView) itemView.findViewById(R.id.tv_order_book_title);
            tvBookContent = (TextView) itemView.findViewById(R.id.tv_order_book_content);
            tvArticleTitle = (TextView) itemView.findViewById(R.id.tv_article_title);
            tvArticleContent = (TextView) itemView.findViewById(R.id.tv_article_content);
        }
    }
}
