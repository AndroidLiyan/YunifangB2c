package com.yunifang.my.adp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.yunifang.my.R;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.vholder.RSixItemViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/3/23.
 */

public class RSixItemAdapter extends RecyclerView.Adapter<RSixItemViewHolder> {
    private Context context;
    private List<HomeData.DataBean.DefaultGoodsListBean> defaultGoodsList;

    public RSixItemAdapter(Context context, List<HomeData.DataBean.DefaultGoodsListBean> defaultGoodsList) {
        this.context = context;
        this.defaultGoodsList = defaultGoodsList;
    }

    @Override
    public RSixItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.six_item_lay, parent, false);
        RSixItemViewHolder rSixItemViewHolder = new RSixItemViewHolder(view);
        return rSixItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RSixItemViewHolder holder, int position) {
        Glide.with(context).load(defaultGoodsList.get(position).getGoods_img()).into(holder.six_item_image);
        holder.six_item_name.setText(defaultGoodsList.get(position).getGoods_name());
        holder.six_item_price.setText("¥"+defaultGoodsList.get(position).getShop_price());
    }

    @Override
    public int getItemCount() {
        return defaultGoodsList.size();
    }
}
