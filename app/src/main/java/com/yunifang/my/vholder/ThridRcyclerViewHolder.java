package com.yunifang.my.vholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yunifang.my.R;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.utils.ContextUtil;

import java.util.List;

/**
 * Created by lenovo on 2017/3/22.
 */

public class ThridRcyclerViewHolder extends RecyclerView.ViewHolder  {

    public final ImageView third_recycler_image;
    public final TextView third_text_name;
    public final TextView third_text_price;
    public final LinearLayout ll_shop;
    private Context context;
    private List<HomeData.DataBean.BestSellersBean.GoodsListBeanX> goodsList;

    public ThridRcyclerViewHolder(View itemView) {
        super(itemView);
        third_recycler_image = (ImageView) itemView.findViewById(R.id.third_recycler_image);
        third_text_name = (TextView) itemView.findViewById(R.id.third_text_name);
        third_text_price = (TextView) itemView.findViewById(R.id.third_text_price);
        ll_shop = (LinearLayout) itemView.findViewById(R.id.ll_shop);
    }
}
