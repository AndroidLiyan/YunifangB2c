package com.yunifang.my.act;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.yunifang.my.R;
import com.yunifang.my.adp.ParticularsAdapter;
import com.yunifang.my.common.Constants;
import com.yunifang.my.db.ShopDao;
import com.yunifang.my.jsonbean.ParticularsData;
import com.yunifang.my.utils.OkHttpUtils;

public class ParticularsActivity extends AppCompatActivity {

    private RecyclerView particularsRecycler;
    private String id;
    private RadioButton add;
    private RadioButton buy;
    private ShopDao dao;
    private ParticularsData praticularData;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    praticularData = (ParticularsData) msg.obj;
                    ParticularsAdapter particularsAdapter = new ParticularsAdapter(ParticularsActivity.this, praticularData);
                    particularsRecycler.setAdapter(particularsAdapter);
                    break;
            }
        }
    };
    private ImageView image_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        particularsRecycler = (RecyclerView) findViewById(R.id.ParticularsRecycler);
        add = (RadioButton) findViewById(R.id.add);
        buy = (RadioButton) findViewById(R.id.buy);
        image_back = (ImageView) findViewById(R.id.image_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        particularsRecycler.setLayoutManager(new LinearLayoutManager(this));
        initData();
        dao = new ShopDao(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goods_name = praticularData.getData().getGoods().getGoods_name();
                String normal_url = praticularData.getData().getGoods().getGallery().get(0).getNormal_url();
                double shop_price = praticularData.getData().getGoods().getShop_price();
                boolean adddb = dao.adddb(goods_name, normal_url, id, shop_price);
                if(adddb){
                    Toast.makeText(ParticularsActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goods_name = praticularData.getData().getGoods().getGoods_name();
                boolean delete = dao.delete(goods_name);
                if(delete){
                    Toast.makeText(ParticularsActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initData() {
        String url = Constants.PARTICUlLARS + id;
        OkHttpUtils.RequestGet(url, ParticularsData.class, new OkHttpUtils.CallData() {
            @Override
            public void BackData(Object data) {
                ParticularsData particularsData = (ParticularsData) data;
                Message message = new Message();
                message.what = 0;
                message.obj = particularsData;
                handler.sendMessage(message);
            }
        });
    }
}
