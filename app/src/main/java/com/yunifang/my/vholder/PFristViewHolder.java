package com.yunifang.my.vholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.youth.banner.Banner;
import com.yunifang.my.R;
import com.yunifang.my.jsonbean.ParticularsData;
import com.yunifang.my.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/28.
 */

public class PFristViewHolder extends RecyclerView.ViewHolder {

    private final Banner particulars_frist_banner;

    public PFristViewHolder(View itemView) {
        super(itemView);
        particulars_frist_banner = (Banner) itemView.findViewById(R.id.particulars_frist_banner);
        particulars_frist_banner.isAutoPlay(false);
    }

    public void mSetView(Context context, List<ParticularsData.DataBean.GoodsBean.GalleryBean> gallery) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < gallery.size(); i++) {
            list.add(gallery.get(i).getNormal_url());
        }
        particulars_frist_banner.setImages(list).setImageLoader(new GlideImageLoader()).start();
    }
}
