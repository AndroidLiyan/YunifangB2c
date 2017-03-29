package com.yunifang.my.vholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yunifang.my.R;
import com.yunifang.my.jsonbean.ParticularsData;

import java.util.List;

/**
 * Created by lenovo on 2017/3/28.
 */

public class PThirdViewHolder extends RecyclerView.ViewHolder {

    private final ImageView shop_image_one, shop_image_two, shop_image_three;
    private final TextView shop_text_name, shop_text_price, shop_text_twoname, shop_text_twoprice, shop_text_threename, shop_text_threeprice;

    public PThirdViewHolder(View itemView) {
        super(itemView);
        shop_image_one = (ImageView) itemView.findViewById(R.id.shop_image_one);
        shop_image_two = (ImageView) itemView.findViewById(R.id.shop_image_two);
        shop_image_three = (ImageView) itemView.findViewById(R.id.shop_image_three);
        shop_text_name = (TextView) itemView.findViewById(R.id.shop_text_name);
        shop_text_price = (TextView) itemView.findViewById(R.id.shop_text_price);
        shop_text_twoname = (TextView) itemView.findViewById(R.id.shop_text_twoname);
        shop_text_twoprice = (TextView) itemView.findViewById(R.id.shop_text_twoprice);
        shop_text_threename = (TextView) itemView.findViewById(R.id.shop_text_threename);
        shop_text_threeprice = (TextView) itemView.findViewById(R.id.shop_text_threeprice);
    }

    public void mSetView(Context context, List<ParticularsData.DataBean.GoodsRelDetailsBean> goodsRelDetails) {
        if (goodsRelDetails != null) {
            int size = goodsRelDetails.size();
            switch (size) {
                case 1:
                    Glide.with(context).load(goodsRelDetails.get(0).getGoods_img()).into(shop_image_one);
                    shop_text_name.setText(goodsRelDetails.get(0).getGoods_name());
                    shop_text_price.setText("¥" + goodsRelDetails.get(0).getShop_price());
                    break;
                case 2:
                    Glide.with(context).load(goodsRelDetails.get(0).getGoods_img()).into(shop_image_one);
                    shop_text_name.setText(goodsRelDetails.get(0).getGoods_name());
                    shop_text_price.setText("¥" + goodsRelDetails.get(0).getShop_price());
                    Glide.with(context).load(goodsRelDetails.get(1).getGoods_img()).into(shop_image_two);
                    shop_text_twoname.setText(goodsRelDetails.get(1).getGoods_name());
                    shop_text_twoprice.setText("¥" + goodsRelDetails.get(1).getShop_price());
                    break;
                case 3:
                    Glide.with(context).load(goodsRelDetails.get(0).getGoods_img()).into(shop_image_one);
                    shop_text_name.setText(goodsRelDetails.get(0).getGoods_name());
                    shop_text_price.setText("¥" + goodsRelDetails.get(0).getShop_price());
                    Glide.with(context).load(goodsRelDetails.get(1).getGoods_img()).into(shop_image_two);
                    shop_text_twoname.setText(goodsRelDetails.get(1).getGoods_name());
                    shop_text_twoprice.setText("¥" + goodsRelDetails.get(1).getShop_price());
                    Glide.with(context).load(goodsRelDetails.get(2).getGoods_img()).into(shop_image_three);
                    shop_text_threename.setText(goodsRelDetails.get(2).getGoods_name());
                    shop_text_threeprice.setText("¥" + goodsRelDetails.get(2).getShop_price());
                    break;
            }
        }
    }
}
