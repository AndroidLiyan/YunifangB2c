package com.yunifang.my.vholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunifang.my.R;

/**
 * Created by lenovo on 2017/3/22.
 */

public class ThridRcyclerViewHolder extends RecyclerView.ViewHolder {

    public final ImageView third_recycler_image;
    public final TextView third_text_name;
    public final TextView third_text_price;

    public ThridRcyclerViewHolder(View itemView) {
        super(itemView);
        third_recycler_image = (ImageView) itemView.findViewById(R.id.third_recycler_image);
        third_text_name = (TextView) itemView.findViewById(R.id.third_text_name);
        third_text_price = (TextView) itemView.findViewById(R.id.third_text_price);
    }
}
