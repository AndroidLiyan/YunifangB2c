package com.yunifang.my.vholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yunifang.my.R;
import com.yunifang.my.adp.RFiveAdapter;
import com.yunifang.my.jsonbean.HomeData;

import java.util.List;

/**
 * Created by lenovo on 2017/3/22.
 */

public class RFiveViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerView five_recycler;

    public RFiveViewHolder(View itemView) {
        super(itemView);
        five_recycler = (RecyclerView) itemView.findViewById(R.id.five_recycler);
    }
    public void mSetView(List<HomeData.DataBean.SubjectsBean> subjects, Context context){
        five_recycler.setLayoutManager(new LinearLayoutManager(context));
        RFiveAdapter rFiveAdapter = new RFiveAdapter(context,subjects);
        five_recycler.setAdapter(rFiveAdapter);

    }
}
