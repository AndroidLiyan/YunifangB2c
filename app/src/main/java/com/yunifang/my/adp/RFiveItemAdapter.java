package com.yunifang.my.adp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.yunifang.my.R;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.vholder.ThridRcyclerViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/3/23.
 */

public class RFiveItemAdapter extends RecyclerView.Adapter<ThridRcyclerViewHolder> {
    private final List<HomeData.DataBean.SubjectsBean.GoodsListBean> goodsList;
    private Context context;

    public RFiveItemAdapter(Context context, List<HomeData.DataBean.SubjectsBean.GoodsListBean> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @Override
    public ThridRcyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.third_recycler_item_lay, parent, false);
        ThridRcyclerViewHolder viewHolder = new ThridRcyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ThridRcyclerViewHolder holder, int position) {
        Glide.with(context).load(goodsList.get(position).getGoods_img()).into(holder.third_recycler_image);
        holder.third_text_name.setText(goodsList.get(position).getGoods_name());
        holder.third_text_price.setText("¥"+goodsList.get(position).getShop_price()+" ");
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }
}
