package com.yunifang.my.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class DeviceManager {
	private static final String TAG = DeviceManager.class.getSimpleName();

	/**
	 * 获取当前网络连接状态
	 * 
	 * @param context
	 * @return
	 */
	@SuppressLint("InlinedApi")
	public static boolean isNetworkConnected(Context context) {

		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkinfo = manager.getActiveNetworkInfo();
		if (networkinfo != null && networkinfo.isConnected()) {
			String name = networkinfo.getTypeName();
			//Toast.makeText(context, "当前网络"+name, Toast.LENGTH_SHORT).show();
			return true;
		}

		return false;
		
	}
	

	/**
	 * 获取设备唯一标示
	 * 
	 * @param context
	 * @return
	 */
	public static String getDeviceID(Context context) {

		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String deviceId = telephonyManager.getDeviceId();
		if (deviceId == null) {
			deviceId = getLocalMacAddress(context);
		}
		return deviceId;
	}

	/**
	 * 获取本机mac地址
	 *
	 * @param context
	 * @return
	 */
	public static String getLocalMacAddress(Context context) {
		WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = wifi.getConnectionInfo();
		return info.getMacAddress();
	}

}
