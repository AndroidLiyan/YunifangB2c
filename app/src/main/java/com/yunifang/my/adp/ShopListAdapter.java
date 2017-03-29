package com.yunifang.my.adp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yunifang.my.R;
import com.yunifang.my.jsonbean.ProductInfo;
import com.yunifang.my.utils.ContextUtil;

import java.util.List;

/**
 * Created by lenovo on 2017/3/29.
 */

public class ShopListAdapter extends BaseAdapter {
    private Context context;
    private List<ProductInfo> productInfos;
    private ModifyCountInterface modifycount;

    public ShopListAdapter(Context context, List<ProductInfo> productInfos,ModifyCountInterface modifycount) {
        this.context = context;
        this.productInfos = productInfos;
        this.modifycount = modifycount;
    }

    @Override
    public int getCount() {
        return productInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return productInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder v;
        if (convertView == null) {
            v = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopcart_product, null);
            v.cb_check = (CheckBox) convertView.findViewById(R.id.check_box);

            v.tv_product_name = (TextView) convertView.findViewById(R.id.tv_intro);
            v.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
            v.iv_increase = (TextView) convertView.findViewById(R.id.tv_add);
            v.iv_decrease = (TextView) convertView.findViewById(R.id.tv_reduce);
            v.tv_count = (TextView) convertView.findViewById(R.id.tv_num);
            v.iv_adapter_list_pic = (ImageView) convertView.findViewById(R.id.iv_adapter_list_pic);
            convertView.setTag(v);
        } else {
            v = (ViewHolder) convertView.getTag();
        }
        final ProductInfo productInfo = productInfos.get(position);
        if (productInfo != null) {
            v.tv_product_name.setText(productInfo.getName());
            v.tv_price.setText("￥" + productInfo.getPrice() + "");
            v.tv_count.setText(productInfo.getCount() + "");
            v.cb_check.setChecked(productInfo.isCheck());
            Glide.with(context).load(productInfo.getImageUrl()).into(v.iv_adapter_list_pic);
            v.cb_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productInfo.setCheck(!productInfo.isCheck());
                    modifycount.doinperst();
                }
            });
            //子条目增加监听
            v.iv_increase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productInfo.setCount(productInfo.getCount() + 1);
                    modifycount.doIncrease();
                }
            });
            //子条目减少监听
            v.iv_decrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (productInfo.getCount() > 1) {
                        productInfo.setCount(productInfo.getCount() - 1);
                    }
                    modifycount.doIncrease();
                }
            });
            v.iv_adapter_list_pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ContextUtil.mIntentParticulars(context,productInfo.getSid());
                }
            });
        }

        return convertView;
    }

    private class ViewHolder {
        CheckBox cb_check;
        TextView tv_product_name;
        TextView tv_price;
        TextView iv_increase;
        TextView tv_count;
        TextView iv_decrease;
        ImageView iv_adapter_list_pic;
    }

    public interface ModifyCountInterface {
        public void doIncrease();

        public void doinperst();

    }
}
