package com.yunifang.my.adp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunifang.my.R;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.vholder.RFiveItemViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/3/23.
 */

public class RFiveAdapter extends RecyclerView.Adapter<RFiveItemViewHolder> {
    private final List<HomeData.DataBean.SubjectsBean> subjects;
    private Context context;

    public RFiveAdapter(Context context, List<HomeData.DataBean.SubjectsBean> subjects) {
        this.context = context;
        this.subjects = subjects;
    }

    @Override
    public RFiveItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.five_item_lay, parent, false);
        RFiveItemViewHolder viewHolder = new RFiveItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RFiveItemViewHolder holder, int position) {
        RFiveItemViewHolder rFiveItemViewHolder = holder;
        rFiveItemViewHolder.mSetView(subjects,context,position);

    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }
}
