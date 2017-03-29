package com.yunifang.my.vholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yunifang.my.R;
import com.yunifang.my.adp.RSixItemAdapter;
import com.yunifang.my.adp.RTypeFourItemAdapter;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.jsonbean.TypeData;

import java.util.List;

/**
 * Created by lenovo on 2017/3/26.
 */

public class RTypeFourViewHolder extends RecyclerView.ViewHolder {
    private final RecyclerView sex_recycler;

    public RTypeFourViewHolder(View itemView) {
        super(itemView);
        sex_recycler = (RecyclerView) itemView.findViewById(R.id.sex_recycler);
    }

    public void mSetView(Context context, List<TypeData.DataBean.GoodsBriefBean> goodsBrief) {
        sex_recycler.setLayoutManager(new GridLayoutManager(context, 2));
        RTypeFourItemAdapter rTypeFourItemAdapter = new RTypeFourItemAdapter(context, goodsBrief);
        sex_recycler.setAdapter(rTypeFourItemAdapter);
    }
}
