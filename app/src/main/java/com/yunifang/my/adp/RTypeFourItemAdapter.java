package com.yunifang.my.adp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.yunifang.my.R;
import com.yunifang.my.jsonbean.TypeData;
import com.yunifang.my.utils.ContextUtil;
import com.yunifang.my.vholder.RTypeFourItemViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/3/26.
 */

public class RTypeFourItemAdapter extends RecyclerView.Adapter<RTypeFourItemViewHolder> {

    private final Context context;
    private final List<TypeData.DataBean.GoodsBriefBean> goodsBrief;

    public RTypeFourItemAdapter(Context context, List<TypeData.DataBean.GoodsBriefBean> goodsBrief) {
        this.context = context;
        this.goodsBrief = goodsBrief;
    }

    @Override
    public RTypeFourItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.six_item_lay, parent, false);
        RTypeFourItemViewHolder rTypeFourItemViewHolder = new RTypeFourItemViewHolder(view);
        return rTypeFourItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RTypeFourItemViewHolder holder, final int position) {
        Glide.with(context).load(goodsBrief.get(position).getGoods_img()).into(holder.six_item_image);
        holder.six_item_name.setText(goodsBrief.get(position).getGoods_name());
        holder.six_item_price.setText("¥"+goodsBrief.get(position).getShop_price());
        holder.lll_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextUtil.mIntentParticulars(context,goodsBrief.get(position).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
