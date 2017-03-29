package com.yunifang.my.adp;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunifang.my.R;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.jsonbean.TypeData;
import com.yunifang.my.utils.LogUtil;
import com.yunifang.my.vholder.RSixViewHolder;
import com.yunifang.my.vholder.RTypeFourViewHolder;
import com.yunifang.my.vholder.TypeGongxiaoViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/3/25.
 */

public class RTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final TypeData typeData;
    private final int TYPE_FIRST = 0;
    private final int TYPE_SECOND = 1;
    private final int TYPE_THIRD = 2;
    private final int TYPE_FOUR = 3;
    private int type = 0;

    public RTypeAdapter(Context context, TypeData typeData) {
        this.context = context;
        this.typeData = typeData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.type_shuxin, parent, false);
                viewHolder = new TypeGongxiaoViewHolder(view);
                break;
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.type_gongxiao, parent, false);
                viewHolder = new TypeGongxiaoViewHolder(view1);
                break;
            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.type_fuzhi, parent, false);
                viewHolder = new TypeGongxiaoViewHolder(view2);
                break;
            case 3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.sex_lay, parent, false);
                viewHolder = new RTypeFourViewHolder(view3);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                TypeGongxiaoViewHolder typeshuxinViewHolder = (TypeGongxiaoViewHolder) holder;
                break;
            case 1:
                TypeGongxiaoViewHolder typegongxiaoViewHolder = (TypeGongxiaoViewHolder) holder;
                break;
            case 2:
                TypeGongxiaoViewHolder typefuzhiViewHolder = (TypeGongxiaoViewHolder) holder;
                break;
            case 3:
                List<TypeData.DataBean.GoodsBriefBean> goodsBrief = typeData.getData().getGoodsBrief();
                RTypeFourViewHolder rTypeFourViewHolder = (RTypeFourViewHolder) holder;
                rTypeFourViewHolder.mSetView(context,goodsBrief);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                type = TYPE_FIRST;
                break;
            case 1:
                type = TYPE_SECOND;
                break;
            case 2:
                type = TYPE_THIRD;
                break;
            case 3:
                type = TYPE_FOUR;
                break;
        }
        return type;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
