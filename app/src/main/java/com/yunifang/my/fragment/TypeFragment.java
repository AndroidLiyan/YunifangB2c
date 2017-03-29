package com.yunifang.my.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yunifang.my.R;
import com.yunifang.my.adp.RTypeAdapter;
import com.yunifang.my.basic.BaseFragment;
import com.yunifang.my.common.Constants;
import com.yunifang.my.jsonbean.HomeData;
import com.yunifang.my.jsonbean.TypeData;
import com.yunifang.my.utils.LogUtil;
import com.yunifang.my.utils.OkHttpUtils;

/**
 * Created by lenovo on 2017/3/17.
 */

public class TypeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private View view;
    private LinearLayout ll_type;
    private RecyclerView type_recycler;
    private TypeData typeData;
    private SwipeRefreshLayout type_swipeRefresh;
    private RTypeAdapter rTypeAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    typeData = (TypeData) msg.obj;
                    rTypeAdapter = new RTypeAdapter(getActivity(), typeData);
                    type_recycler.setAdapter(rTypeAdapter);
                    break;
            }
        }
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_type, null);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initView() {
        ll_type = (LinearLayout) view.findViewById(R.id.ll_type);
        type_recycler = (RecyclerView) view.findViewById(R.id.type_recycler);
        type_swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.type_swipeRefresh);
        type_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        type_swipeRefresh.setOnRefreshListener(this);
    }

    private void initData() {
        OkHttpUtils mOkHttpUtils = new OkHttpUtils();
        String url = Constants.TYPE_URL;
        mOkHttpUtils.RequestGet(url, TypeData.class, new OkHttpUtils.CallData() {
            @Override
            public void BackData(Object data) {
                TypeData typeData = (TypeData) data;
                Message message = new Message();
                message.what = 0;
                message.obj = typeData;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public void onRefresh() {
        initData();
        rTypeAdapter.notifyDataSetChanged();
        //隐藏小圆圈
        type_swipeRefresh.setRefreshing(false);
    }
}
