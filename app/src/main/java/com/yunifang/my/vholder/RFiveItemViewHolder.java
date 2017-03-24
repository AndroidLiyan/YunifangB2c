package com.yunifang.my.vholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yunifang.my.R;
import com.yunifang.my.adp.RFiveItemAdapter;
import com.yunifang.my.jsonbean.HomeData;

import java.util.List;

/**
 * Created by lenovo on 2017/3/23.
 */

public class RFiveItemViewHolder extends RecyclerView.ViewHolder {

    private final ImageView five__item_image;
    private final RecyclerView five_item_recycler;

    public RFiveItemViewHolder(View itemView) {
        super(itemView);
        five__item_image = (ImageView) itemView.findViewById(R.id.five__item_image);
        five_item_recycler = (RecyclerView) itemView.findViewById(R.id.five_item_recycler);
    }
    public void mSetView(List<HomeData.DataBean.SubjectsBean> subjects, Context context, int position){
        Glide.with(context).load(subjects.get(position).getImage()).into(five__item_image);
        List<HomeData.DataBean.SubjectsBean.GoodsListBean> goodsList = subjects.get(position).getGoodsList();
        RFiveItemAdapter rFiveItemAdapter = new RFiveItemAdapter(context,goodsList);
        five_item_recycler.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        five_item_recycler.setAdapter(rFiveItemAdapter);
    }
}
