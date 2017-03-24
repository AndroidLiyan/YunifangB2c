package com.yunifang.my.vholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.yunifang.my.R;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/22.
 */

public class RSecondViewHolder extends RecyclerView.ViewHolder {


    private final ImageView second_image_one, second_image_two, second_image_three, second_image_four;
    private final TextView second_text_one, second_text_two, second_text_three, second_text_four;
    private final List<ImageView> list_image;
    private final List<TextView> list_text;

    public RSecondViewHolder(View itemView) {
        super(itemView);
        second_image_one = (ImageView) itemView.findViewById(R.id.second_image_one);
        second_image_two = (ImageView) itemView.findViewById(R.id.second_image_two);
        second_image_three = (ImageView) itemView.findViewById(R.id.second_image_three);
        second_image_four = (ImageView) itemView.findViewById(R.id.second_image_four);
        list_image = new ArrayList<>();
        list_image.add(second_image_one);
        list_image.add(second_image_two);
        list_image.add(second_image_three);
        list_image.add(second_image_four);
        second_text_one = (TextView) itemView.findViewById(R.id.second_text_one);
        second_text_two = (TextView) itemView.findViewById(R.id.second_text_two);
        second_text_three = (TextView) itemView.findViewById(R.id.second_text_three);
        second_text_four = (TextView) itemView.findViewById(R.id.second_text_four);
        list_text = new ArrayList<>();
        list_text.add(second_text_one);
        list_text.add(second_text_two);
        list_text.add(second_text_three);
        list_text.add(second_text_four);
    }

    public void mSetView(List<HomeData.DataBean.Ad5Bean> ad5, Context context) {
        for (int i = 0; i < ad5.size(); i++) {
            Glide.with(context)
                    .load(ad5.get(i).getImage())
                    .into(list_image.get(i));
            list_text.get(i).setText(ad5.get(i).getTitle());
        }
    }
}
