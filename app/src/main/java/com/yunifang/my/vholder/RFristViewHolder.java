package com.yunifang.my.vholder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.yunifang.my.R;
import com.yunifang.my.act.WebViewActivity;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/22.
 */

public class RFristViewHolder extends RecyclerView.ViewHolder {

    private final Banner vp_banner;

    public RFristViewHolder(View itemView) {
        super(itemView);
        vp_banner = (Banner) itemView.findViewById(R.id.frist_banner);
    }

    public void mSetView(final List<HomeData.DataBean.Ad1Bean> ad1, final Context context) {
        List<String> list_banner = new ArrayList<>();
        for (int i = 0; i < ad1.size(); i++) {
            list_banner.add(ad1.get(i).getImage());
        }
        vp_banner.setImages(list_banner).setImageLoader(new GlideImageLoader()).start();
        vp_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("url", ad1.get(position).getAd_type_dynamic_data());
                context.startActivity(intent);
            }
        });
    }
}
