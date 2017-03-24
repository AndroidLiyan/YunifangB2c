package com.yunifang.my.vholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yunifang.my.R;
import com.yunifang.my.adp.RSixItemAdapter;
import com.yunifang.my.jsonbean.HomeData;

import java.util.List;

/**
 * Created by lenovo on 2017/3/23.
 */

public class RSixViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerView sex_recycler;

    public RSixViewHolder(View itemView) {
        super(itemView);
        sex_recycler = (RecyclerView) itemView.findViewById(R.id.sex_recycler);
    }
    public void mSetView(Context context, List<HomeData.DataBean.DefaultGoodsListBean> defaultGoodsList){
        sex_recycler.setLayoutManager(new GridLayoutManager(context,2));
        RSixItemAdapter rSixItemAdapter = new RSixItemAdapter(context,defaultGoodsList);
        sex_recycler.setAdapter(rSixItemAdapter);
    }
}
