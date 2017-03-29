package com.yunifang.my.vholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yunifang.my.R;

/**
 * Created by lenovo on 2017/3/23.
 */

public class RSixItemViewHolder extends RecyclerView.ViewHolder {

    public final ImageView six_item_image;
    public final TextView six_item_name;
    public final TextView six_item_price;
    public final LinearLayout lll_shop;

    public RSixItemViewHolder(View itemView) {
        super(itemView);
        six_item_image = (ImageView) itemView.findViewById(R.id.six_item_image);
        six_item_name = (TextView) itemView.findViewById(R.id.six_item_name);
        six_item_price = (TextView) itemView.findViewById(R.id.six_item_price);
        lll_shop = (LinearLayout) itemView.findViewById(R.id.lll_shop);
    }
}
