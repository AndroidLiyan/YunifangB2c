package com.yunifang.my.act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yunifang.my.R;
import com.yunifang.my.common.DataClearManager;

import java.io.File;

public class SetActivity extends AppCompatActivity {

    private TextView clear_text;
    private RelativeLayout clear_carch;
    private File cacheDir;
    private ImageView im_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        clear_text = (TextView) findViewById(R.id.clear_text);
        clear_carch = (RelativeLayout) findViewById(R.id.clear_carch);
        im_back = (ImageView) findViewById(R.id.im_back);
        cacheDir = getCacheDir();
        try {
            String cacheSize = DataClearManager.getCacheSize(cacheDir);
            clear_text.setText("已缓存" + cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clear_carch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataClearManager.deleteFolderFile(cacheDir.getAbsolutePath(), true);
                String size = null;
                try {
                    size = DataClearManager.getCacheSize(cacheDir);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                clear_text.setText(size);
            }
        });
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
