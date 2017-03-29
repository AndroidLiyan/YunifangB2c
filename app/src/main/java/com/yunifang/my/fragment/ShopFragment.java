package com.yunifang.my.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yunifang.my.R;
import com.yunifang.my.adp.ShopListAdapter;
import com.yunifang.my.basic.BaseFragment;
import com.yunifang.my.db.ShopDao;
import com.yunifang.my.jsonbean.GroupInfo;
import com.yunifang.my.jsonbean.ProductInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/3/17.
 */

public class ShopFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private View view;
    private ListView listview;
    private ShopDao dao;
    private List<ProductInfo> productInfos;
    private ShopListAdapter shopListAdapter;
    private SwipeRefreshLayout shop_swipe;
    private CheckBox all_chekbox;
    private TextView tv_total_price;
    private TextView tv_go_to_pay;
    private TextView tv_delete;
    private TextView tt;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dao = new ShopDao(getActivity());
        initView();
        initData();
        shop_swipe.setOnRefreshListener(this);
    }

    private void initView() {
        listview = (ListView) view.findViewById(R.id.listView);
        shop_swipe = (SwipeRefreshLayout) view.findViewById(R.id.shop_swipe);
        all_chekbox = (CheckBox) view.findViewById(R.id.all_chekbox);
        tv_delete = (TextView) view.findViewById(R.id.tv_delete);
        tv_total_price = (TextView) view.findViewById(R.id.tv_total_price);
        tv_go_to_pay = (TextView) view.findViewById(R.id.tv_go_to_pay);
        all_chekbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < productInfos.size(); i++) {
                    if (all_chekbox.isChecked()) {
                        productInfos.get(i).setCheck(true);
                    } else {
                        productInfos.get(i).setCheck(false);
                    }
                    shopListAdapter.notifyDataSetChanged();
                }
                calculate();
            }
        });
        tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < productInfos.size(); i++) {
                    ProductInfo productInfo = productInfos.get(i);
                    if(productInfo.isCheck()){
                        dao.delete(productInfo.getName());
                        initData();
                    }
                }
            }
        });

    }

    private void initData() {
        productInfos = dao.findAll();
        shopListAdapter = new ShopListAdapter(getActivity(), productInfos, new ShopListAdapter.ModifyCountInterface() {
            @Override
            public void doIncrease() {
                shopListAdapter.notifyDataSetChanged();
            }

            @Override
            public void doinperst() {
                boolean allCheck = isAllCheck();
                calculate();
                all_chekbox.setChecked(allCheck);
            }
        });
        listview.setAdapter(shopListAdapter);
    }


    @Override
    public void onRefresh() {
        initData();
        //隐藏小圆圈
        shop_swipe.setRefreshing(false);
    }

    private void calculate() {
        int totalCount = 0;
        double totalPrice = 0.00;
        for (int i = 0; i < productInfos.size(); i++) {
            ProductInfo productInfo = productInfos.get(i);
            if (productInfo.isCheck()) {
                totalCount += productInfo.getCount();
                totalPrice += productInfo.getPrice() * productInfo.getCount();
            }
        }
        tv_total_price.setText("￥" + totalPrice);
        tv_go_to_pay.setText("去支付(" + totalCount + ")");
    }

    private boolean isAllCheck() {

        for (ProductInfo group : productInfos) {
            if (!group.isCheck())
                return false;

        }
        return true;
    }
}
