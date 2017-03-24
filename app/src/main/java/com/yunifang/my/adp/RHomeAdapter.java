package com.yunifang.my.adp;

import android.content.Context;
import android.content.res.ObbInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunifang.my.R;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.vholder.RFiveViewHolder;
import com.yunifang.my.vholder.RFourViewHolder;
import com.yunifang.my.vholder.RFristViewHolder;
import com.yunifang.my.vholder.RSecondViewHolder;
import com.yunifang.my.vholder.RSixViewHolder;
import com.yunifang.my.vholder.RThridViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/22.
 */

public class RHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private HomeData homeData;
    private static final int FRIST_TYPE = 0;
    private static final int SECOND_TYPE = 1;
    private static final int THRID_TYPE = 2;
    private static final int FOUR_TYPE = 3;
    private static final int FIVE_TYPE = 4;
    private static final int SEX_TYPE = 5;
    private int type = 0;

    public RHomeAdapter(Context context, HomeData homeData) {
        this.context = context;
        this.homeData = homeData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.frist_lay, parent, false);
                viewHolder = new RFristViewHolder(view);
                break;
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.second_lay, parent, false);
                viewHolder = new RSecondViewHolder(view1);
                break;
            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.third_lay, parent, false);
                viewHolder = new RThridViewHolder(view2);
                break;
            case 3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.four_lay, parent, false);
                viewHolder = new RFourViewHolder(view3);
                break;
            case 4:
                View view4 = LayoutInflater.from(context).inflate(R.layout.five_lay, parent, false);
                viewHolder = new RFiveViewHolder(view4);
                break;
            case 5:
                View view5 = LayoutInflater.from(context).inflate(R.layout.sex_lay, parent, false);
                viewHolder = new RSixViewHolder(view5);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                List<HomeData.DataBean.Ad1Bean> ad1 = homeData.getData().getAd1();
                RFristViewHolder rFristViewHolder = (RFristViewHolder) holder;
                rFristViewHolder.mSetView(ad1);
                break;
            case 1:
                List<HomeData.DataBean.Ad5Bean> ad5 = homeData.getData().getAd5();
                RSecondViewHolder rSecondViewHolder = (RSecondViewHolder) holder;
                rSecondViewHolder.mSetView(ad5, context);
                break;
            case 2:
                List<HomeData.DataBean.BestSellersBean.GoodsListBeanX> goodsList = homeData.getData().getBestSellers().get(0).getGoodsList();
                RThridViewHolder rThridViewHolder = (RThridViewHolder) holder;
                rThridViewHolder.mSetView(goodsList, context);
                break;
            case 3:
                List<HomeData.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList = homeData.getData().getActivityInfo().getActivityInfoList();
                RFourViewHolder rFourViewHolder = (RFourViewHolder) holder;
                rFourViewHolder.mSetView(activityInfoList);
                break;
            case 4:
                List<HomeData.DataBean.SubjectsBean> subjects = homeData.getData().getSubjects();
                RFiveViewHolder rFiveViewHolder = (RFiveViewHolder) holder;
                rFiveViewHolder.mSetView(subjects, context);
                break;
            case 5:
                List<HomeData.DataBean.DefaultGoodsListBean> defaultGoodsList = homeData.getData().getDefaultGoodsList();
                RSixViewHolder rSixViewHolder = (RSixViewHolder) holder;
                rSixViewHolder.mSetView(context,defaultGoodsList);
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
                type = THRID_TYPE;
                break;
            case 3:
                type = FOUR_TYPE;
                break;
            case 4:
                type = FIVE_TYPE;
                break;
            case 5:
                type = SEX_TYPE;
                break;
        }
        return type;
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
