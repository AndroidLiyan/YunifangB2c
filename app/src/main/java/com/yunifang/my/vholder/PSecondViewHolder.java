package com.yunifang.my.vholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yunifang.my.R;

/**
 * Created by lenovo on 2017/3/28.
 */

public class PSecondViewHolder extends RecyclerView.ViewHolder {

    public final TextView particulars_second_name, particulars_second_price, particulars_second_info;

    public PSecondViewHolder(View itemView) {
        super(itemView);
        particulars_second_name = (TextView) itemView.findViewById(R.id.particulars_second_name);
        particulars_second_price = (TextView) itemView.findViewById(R.id.particulars_second_price);
        particulars_second_info = (TextView) itemView.findViewById(R.id.particulars_second_info);
    }
}
