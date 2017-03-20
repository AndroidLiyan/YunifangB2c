package com.yunifang.my.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.youth.banner.Banner;
import com.yunifang.my.R;
import com.yunifang.my.basic.BaseFragment;
import com.yunifang.my.common.Constants;
import com.yunifang.my.common.DeviceManager;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.utils.GlideImageLoader;
import com.yunifang.my.utils.LogUtil;
import com.yunifang.my.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/17.
 */

public class HomeFragment extends BaseFragment {

    private View view;
    private ImageView net_image;
    private PullToRefreshScrollView pulltorefresh;
    private Banner banner;
    private List<HomeData.DataBean.Ad1Bean> ad1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    HomeData homeData = (HomeData) msg.obj;
                    ad1 = homeData.getData().getAd1();
                    mSetView();
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //首先进行网络判断
        boolean mIsNet = DeviceManager.isNetworkConnected(getActivity());
        if (!mIsNet) {
            net_image.setVisibility(View.VISIBLE);
            net_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean mIsNet = DeviceManager.isNetworkConnected(getActivity());
                    if (mIsNet) {
                        net_image.setVisibility(View.GONE);
                        initData();
                    }
                }
            });
        }
        initData();
    }

    private void initView() {
        net_image = (ImageView) view.findViewById(R.id.net_image);
        pulltorefresh = (PullToRefreshScrollView) view.findViewById(R.id.pulltorefresh);
        banner = (Banner) view.findViewById(R.id.banner);
        pulltorefresh.setMode(PullToRefreshBase.Mode.BOTH);
    }

    private void initData() {
        OkHttpUtils mOkHttpUtils = new OkHttpUtils();
        String url = Constants.HOME_URL;
        mOkHttpUtils.RequestGet(url, HomeData.class, new OkHttpUtils.CallData() {
            @Override
            public void BackData(Object data) {
                HomeData homedata = (HomeData) data;
                Message message = new Message();
                message.what = 0;
                message.obj = homedata;
                handler.sendMessage(message);
            }
        });

    }

    private void mSetView() {
        List<String> list_banner = new ArrayList<>();
        for (int i = 0; i < ad1.size(); i++) {
            list_banner.add(ad1.get(i).getImage());
        }
        banner.setImages(list_banner).setImageLoader(new GlideImageLoader()).start();
    }
}
