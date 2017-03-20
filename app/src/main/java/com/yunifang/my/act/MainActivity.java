package com.yunifang.my.act;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yunifang.my.R;
import com.yunifang.my.basic.BaseActivity;
import com.yunifang.my.common.DeviceManager;
import com.yunifang.my.fragment.HomeFragment;
import com.yunifang.my.fragment.MyFragment;
import com.yunifang.my.fragment.ShopFragment;
import com.yunifang.my.fragment.TypeFragment;
import com.yunifang.my.utils.ContextUtil;
import com.yunifang.my.widget.CrashApplication;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton rb_home;
    private RadioButton rb_type;
    private RadioButton rb_shop;
    private RadioButton rb_my;
    private RadioGroup rg;
    private FragmentManager fm;
    private String fragment1Tag = "f1";
    private String fragment2Tag = "f2";
    private String fragment3Tag = "f3";
    private String fragment4Tag = "f4";
    private List<RadioButton> list_rb = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_type = (RadioButton) findViewById(R.id.rb_type);
        rb_shop = (RadioButton) findViewById(R.id.rb_shop);
        rb_my = (RadioButton) findViewById(R.id.rb_my);
        list_rb.add(rb_home);
        list_rb.add(rb_type);
        list_rb.add(rb_shop);
        list_rb.add(rb_my);
        rb_home.setOnClickListener(this);
        rb_type.setOnClickListener(this);
        rb_shop.setOnClickListener(this);
        rb_my.setOnClickListener(this);
        fm = getSupportFragmentManager();
        Fragment fragment1 = new HomeFragment();
            fm.beginTransaction().add(R.id.fl, fragment1, fragment1Tag).commit();
            rb_home.setChecked(true);
            rbColor(0);
    }

    @Override
    public void onClick(View v) {
        //开启事物
        FragmentTransaction ft = fm.beginTransaction();
        //设置tag
        Fragment fragment1 = fm.findFragmentByTag(fragment1Tag);
        Fragment fragment2 = fm.findFragmentByTag(fragment2Tag);
        Fragment fragment3 = fm.findFragmentByTag(fragment3Tag);
        Fragment fragment4 = fm.findFragmentByTag(fragment4Tag);
        //首先将是所有的都隐藏
        if (fragment1 != null) {
            ft.hide(fragment1);
        }
        if (fragment2 != null) {
            ft.hide(fragment2);
        }
        if (fragment3 != null) {
            ft.hide(fragment3);
        }
        if (fragment4 != null) {
            ft.hide(fragment4);
        }
        switch (v.getId()) {
            case R.id.rb_home:
                if (fragment1 == null) {
                    fragment1 = new HomeFragment();
                    ft.add(R.id.fl, fragment1, fragment1Tag);
                } else {
                    ft.show(fragment1);
                }
                rbColor(0);
                break;
            case R.id.rb_type:
                if (fragment2 == null) {
                    fragment2 = new TypeFragment();
                    ft.add(R.id.fl, fragment2, fragment2Tag);
                } else {
                    ft.show(fragment2);
                }
                rbColor(1);
                break;
            case R.id.rb_shop:
                if (fragment3 == null) {
                    fragment3 = new ShopFragment();
                    ft.add(R.id.fl, fragment3, fragment3Tag);
                } else {
                    ft.show(fragment3);
                }
                rbColor(2);
                break;
            case R.id.rb_my:
                if (fragment4 == null) {
                    fragment4 = new MyFragment();
                    ft.add(R.id.fl, fragment4, fragment4Tag);
                } else {
                    ft.show(fragment4);
                }
                rbColor(3);
                break;
        }
        ft.commit();
    }
    //切换背景的颜色图片
    private void rbColor(int i) {
            for (int j = 0; j < 4; j++) {
                if (j == i) {
                    list_rb.get(j).setTextColor(Color.RED);
                } else {
                    list_rb.get(j).setTextColor(Color.BLACK);
                }
            }
    }


}
