package com.yunifang.my.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yunifang.my.R;
import com.yunifang.my.adp.ShopCarExpandableListviewAdapter;
import com.yunifang.my.basic.BaseFragment;
import com.yunifang.my.jsonbean.GroupInfo;
import com.yunifang.my.jsonbean.ProductInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/3/17.
 */

public class ShopFragment extends BaseFragment implements ShopCarExpandableListviewAdapter.CheckInterface, ShopCarExpandableListviewAdapter.ModifyCountInterface, View.OnClickListener{

    private View view;
    private Context context;
    private ExpandableListView exListView;
    private CheckBox cb_check_all;
    private TextView tv_total_price;
    private TextView tv_delete;
    private TextView tv_go_to_pay;
    private List<GroupInfo> groups = new ArrayList<GroupInfo>();// 组元素数据列表
    private Map<String, List<ProductInfo>> children = new HashMap<String, List<ProductInfo>>();// 子元素数据列表
    private ShopCarExpandableListviewAdapter selva;
    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initEvents();
    }
    private void initView() {
        context = getActivity();
        virtualData();
        exListView = (ExpandableListView) view.findViewById(R.id.exListView);
        cb_check_all = (CheckBox) view.findViewById(R.id.all_chekbox);
        tv_total_price = (TextView) view.findViewById(R.id.tv_total_price);
        tv_delete = (TextView) view.findViewById(R.id.tv_delete);
        tv_go_to_pay = (TextView) view.findViewById(R.id.tv_go_to_pay);
    }

    private void initEvents() {
        selva = new ShopCarExpandableListviewAdapter(groups, children, getActivity());
        selva.setCheckInterface(this);// 关键步骤1,设置复选框接口
        selva.setModifyCountInterface(this);// 关键步骤2,设置数量增减接口
        exListView.setAdapter(selva);
        for (int i = 0; i < selva.getGroupCount(); i++) {
            exListView.expandGroup(i);// 关键步骤3,初始化时，将ExpandableListView以展开的方式呈现
        }
        cb_check_all.setOnClickListener(this);
        tv_delete.setOnClickListener(this);
        tv_go_to_pay.setOnClickListener(this);
    }

    /**
     * 模拟数据<br>
     * 遵循适配器的数据列表填充原则，组元素被放在一个List中，对应的组元素下辖的子元素被放在Map中，<br>
     * 其键是组元素的Id(通常是一个唯一指定组元素身份的值)
     */
    private void virtualData() {

        for (int i = 0; i < 6; i++) {

            groups.add(new GroupInfo(i + "", "第八号当铺" + (i + 1) + "号店"));

            List<ProductInfo> products = new ArrayList<ProductInfo>();
            for (int j = 0; j <= i; j++) {

                products.add(new ProductInfo(j + "", "商品", "", groups.get(i).getName() + "的第" + (j + 1) + "个商品", 120.00 + i * j, 1));
            }
            children.put(groups.get(i).getId(), products);// 将组元素的一个唯一值，这里取Id，作为子元素List的Key
        }
    }

    @Override
    public void onClick(View v) {
        AlertDialog alert;
        switch (v.getId()) {
            case R.id.all_chekbox:
                doCheckAll();
                break;
            case R.id.tv_go_to_pay:
                if (totalCount == 0) {
                    Toast.makeText(context, "请选择要支付的商品", Toast.LENGTH_LONG).show();
                    return;
                }
                alert = new AlertDialog.Builder(context).create();
                alert.setTitle("操作提示");
                alert.setMessage("总计:\n" + totalCount + "种商品\n" + totalPrice + "元");
                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alert.show();
                break;
            case R.id.tv_delete:
                if (totalCount == 0) {
                    Toast.makeText(context, "请选择要移除的商品", Toast.LENGTH_LONG).show();
                    return;
                }
                alert = new AlertDialog.Builder(context).create();
                alert.setTitle("操作提示");
                alert.setMessage("您确定要将这些商品从购物车中移除吗？");
                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doDelete();
                    }
                });
                alert.show();
                break;
        }
    }

    //父复选框
    @Override
    public void checkGroup(int groupPosition, boolean isChecked) {
        GroupInfo group = groups.get(groupPosition);//根据下标得到当前父item的
        List<ProductInfo> productInfos = children.get(group.getId());//根据父item的id来得到相对应的子item
        for (int i = 0; i < productInfos.size(); i++) {//当点击父check之后得到子集合遍历全选
            productInfos.get(i).setChoosed(isChecked);
        }
        if (isAllCheck()) {
            cb_check_all.setChecked(true);
        } else {
            cb_check_all.setChecked(false);
        }
        selva.notifyDataSetChanged();
        calculate();
    }

    //子复选框
    @Override
    public void checkChild(int groupPosition, int childPosition, boolean isChecked) {
        boolean b = true;
        GroupInfo group = groups.get(groupPosition);
        List<ProductInfo> productInfos = children.get(group.getId());
        for (int i = 0; i < productInfos.size(); i++) {
            if (productInfos.get(i).isChoosed() != isChecked) {
                b = false;
            }
        }
        if (b) {
            group.setChoosed(isChecked);
        } else {
            group.setChoosed(false);
        }
        if (isAllCheck())
            cb_check_all.setChecked(true);
        else
            cb_check_all.setChecked(false);
        selva.notifyDataSetChanged();
        calculate();
    }

    //增加操作
    @Override
    public void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        ProductInfo prout = (ProductInfo) selva.getChild(groupPosition, childPosition);
        int count = prout.getCount();
        count++;
        prout.setCount(count);
        ((TextView) showCountView).setText(count + "");
        selva.notifyDataSetChanged();
        calculate();
    }

    //删减操作
    @Override
    public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        ProductInfo prout = (ProductInfo) selva.getChild(groupPosition, childPosition);
        int count = prout.getCount();
        if (count == 1)
            return;
        count--;
        prout.setCount(count);
        ((TextView) showCountView).setText(count + "");
        selva.notifyDataSetChanged();
        calculate();
    }

    private void doDelete() {
        List<GroupInfo> todeletGroup = new ArrayList<>();
        for (int i = 0; i < groups.size(); i++) {
            GroupInfo groupInfo = groups.get(i);
            if (groupInfo.isChoosed()) {
                todeletGroup.add(groupInfo);
            }
            List<ProductInfo> todeletProdut = new ArrayList<>();
            List<ProductInfo> child = children.get(groupInfo.getId());
            for (int j = 0; j < child.size(); j++) {
                if (child.get(j).isChoosed()) {
                    todeletProdut.add(child.get(j));
                }
            }
            child.removeAll(todeletProdut);
        }
        groups.removeAll(todeletGroup);
    }

    /**
     * 全选或反选
     */
    private void doCheckAll() {
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).setChoosed(cb_check_all.isChecked());
            GroupInfo group = groups.get(i);
            List<ProductInfo> childs = children.get(group.getId());
            for (int j = 0; j < childs.size(); j++) {
                childs.get(j).setChoosed(cb_check_all.isChecked());
            }
        }
        selva.notifyDataSetChanged();
        calculate();
    }

    /**
     * 统计操作<br>
     * 1.先清空全局计数器<br>
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作<br>
     * 3.给底部的textView进行数据填充
     */
    private void calculate() {
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < groups.size(); i++) {
            GroupInfo group = groups.get(i);
            List<ProductInfo> childs = children.get(group.getId());
            for (int j = 0; j < childs.size(); j++) {
                ProductInfo productInfo = childs.get(j);
                if (productInfo.isChoosed()) {
                    totalCount++;
                    totalPrice += productInfo.getPrice() * productInfo.getCount();
                }
            }
        }
        tv_total_price.setText("￥" + totalPrice);
        tv_go_to_pay.setText("去支付(" + totalCount + ")");
    }
    //当每个父check都是选中的就返回true
    private boolean isAllCheck() {

        for (GroupInfo group : groups) {
            if (!group.isChoosed())
                return false;

        }
        return true;
    }

}
