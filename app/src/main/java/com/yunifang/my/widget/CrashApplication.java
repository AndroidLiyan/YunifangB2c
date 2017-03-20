package com.yunifang.my.widget;

import android.app.Application;
import android.content.Context;

import com.yunifang.my.common.DeviceManager;
import com.yunifang.my.utils.ContextUtil;

/**
 * Created by jinguo on 2017/3/16.
 */

public class CrashApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        //全局的异常捕获,在跟随整个应用的application调用
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }
}
