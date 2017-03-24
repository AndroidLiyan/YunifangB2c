package com.yunifang.my.vholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.youth.banner.Banner;
import com.yunifang.my.R;
import com.yunifang.my.adp.RThirdAdapter;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/22.
 */

public class RThridViewHolder extends RecyclerView.ViewHolder {


    private final RecyclerView third_recycler;

    public RThridViewHolder(View itemView) {
        super(itemView);
        third_recycler = (RecyclerView) itemView.findViewById(R.id.third_recycler);
    }

    public void mSetView(List<HomeData.DataBean.BestSellersBean.GoodsListBeanX> goodsList, Context context) {
        third_recycler.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        RThirdAdapter rThirdAdapter = new RThirdAdapter(context,goodsList);
        third_recycler.setAdapter(rThirdAdapter);
    }
}
