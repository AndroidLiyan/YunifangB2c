package com.yunifang.my.adp;

import android.content.Context;
import android.content.res.ObbInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunifang.my.R;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.vholder.RFristViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/22.
 */

public class RHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private HomeData homeData;
    private static final int FRIST_TYPE = 0;
    private int type = 0;

    public RHomeAdapter(Context context, HomeData homeData) {
        this.context = context;
        this.homeData = homeData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.frist_lay, parent, false);
                viewHolder = new RFristViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                List<HomeData.DataBean.Ad1Bean> ad1 = homeData.getData().getAd1();
                RFristViewHolder rFristViewHolder = (RFristViewHolder) holder;
                rFristViewHolder.mSetView(ad1);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                type = FRIST_TYPE;
                break;
        }
        return type;
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
