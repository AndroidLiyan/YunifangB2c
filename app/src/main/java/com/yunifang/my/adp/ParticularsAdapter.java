package com.yunifang.my.adp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunifang.my.R;
import com.yunifang.my.act.ParticularsActivity;
import com.yunifang.my.jsonbean.ParticularsData;
import com.yunifang.my.vholder.PFristViewHolder;
import com.yunifang.my.vholder.PSecondViewHolder;
import com.yunifang.my.vholder.PThirdViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/3/27.
 */

public class ParticularsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int type = 0;
    private Context context;
    private static final int FRIST_TYPE = 0;
    private static final int SECOND_TYPE = 1;
    private static final int THIRD_TYPE = 2;
    private ParticularsData praticularData;

    public ParticularsAdapter(Context context, ParticularsData praticularData) {
        this.context = context;
        this.praticularData = praticularData;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.particulars_frist, parent, false);
                viewHolder = new PFristViewHolder(view);
                break;
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.particulars_second, parent, false);
                viewHolder = new PSecondViewHolder(view1);
                break;
            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.particulars_third, parent, false);
                viewHolder = new PThirdViewHolder(view2);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                PFristViewHolder pFristViewHolder = (PFristViewHolder) holder;
                List<ParticularsData.DataBean.GoodsBean.GalleryBean> gallery = praticularData.getData().getGoods().getGallery();
                pFristViewHolder.mSetView(context, gallery);
                break;
            case 1:
                PSecondViewHolder pSecondViewHolder = (PSecondViewHolder) holder;
                ParticularsData.DataBean.GoodsBean goods = praticularData.getData().getGoods();
                pSecondViewHolder.particulars_second_name.setText(goods.getGoods_name());
                pSecondViewHolder.particulars_second_price.setText("¥" + goods.getShop_price());
                pSecondViewHolder.particulars_second_info.setText("运费¥" + goods.getShipping_fee() + "      销量" + goods.getSales_volume() + "     收藏" + goods.getStock_number());
                break;
            case 2:
                PThirdViewHolder pThirdViewHolder = (PThirdViewHolder) holder;
                List<ParticularsData.DataBean.GoodsRelDetailsBean> goodsRelDetails = praticularData.getData().getGoodsRelDetails();
                pThirdViewHolder.mSetView(context,goodsRelDetails);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {

        switch (position) {
            case 0:
                type = FRIST_TYPE;
                break;
            case 1:
                type = SECOND_TYPE;
                break;
            case 2:
                type = THIRD_TYPE;
                break;
        }
        return type;

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
