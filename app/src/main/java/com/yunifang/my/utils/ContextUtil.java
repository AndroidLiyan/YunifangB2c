package com.yunifang.my.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.yunifang.my.widget.CrashApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinguo on 2017/3/16.
 */

public class ContextUtil {


    private static final String TAG = "ContextUtil";
    private static List<Activity> activityList = new ArrayList<Activity>();

    // 添加Activity到容器中
    public static void addActivity(Activity activity) {
        if (activityList != null && activity != null) {
            activityList.add(activity);
        }
    }

    // 遍历所有Activity并finish

    public static void exit() {

        try {
            for (Activity activity : activityList) {
                if (activity != null) {
                    activity.finish();
                }
            }
            activityList.clear();
        } catch (Exception e) {
            LogUtil.i(TAG, e.toString());
        } finally {
            // System.exit(0);
        }

    }

   /* //判断网络是否连接 TODO
    public static boolean mIsNetConnect(Context context) {
        int netWorkType = IsNetUtils.getNetWorkType(context);
        LogUtil.i("iii", netWorkType + "");
        if (netWorkType == 0) {
            return false;
        }
        return true;
    }*/
}
