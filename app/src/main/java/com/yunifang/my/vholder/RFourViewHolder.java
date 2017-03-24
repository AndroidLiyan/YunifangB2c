package com.yunifang.my.vholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.yunifang.my.R;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/22.
 */

public class RFourViewHolder extends RecyclerView.ViewHolder {

    private final Banner four_banner;

    public RFourViewHolder(View itemView) {
        super(itemView);
        four_banner = (Banner) itemView.findViewById(R.id.four_banner);
        four_banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        four_banner.isAutoPlay(false);
        four_banner.setBannerAnimation(Transformer.ZoomOutSlide);
    }
    public void mSetView(List<HomeData.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList){
        List<String> list_banner = new ArrayList<>();
        for (int i = 0; i < activityInfoList.size(); i++) {
            list_banner.add(activityInfoList.get(i).getActivityImg());
        }
        four_banner.setImages(list_banner).setImageLoader(new GlideImageLoader()).start();
    }
}
