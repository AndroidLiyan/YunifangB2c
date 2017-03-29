package com.yunifang.my.common;

/**
 * Created by admin on 15/12/30.
 */

/**
 * 常量类
 *
 * @author KingKong-HE
 * @Time 2014-12-31
 * @Email KingKong@QQ.COM
 */
public final class Constants {


    private Constants() {
    }

    /**
     * 与服务器端连接的协议名
     */
    public static final String PROTOCOL = "http://";

    /**
     * 服务器域名
     */
//    public static final String HOST = "b2b.huatuoyf.com";//101.201.197.50www.htyyao.com  b2b.huatuoyf.com 测试地址    原来的地址

    public static final String HOST = "b2b.htyyao.com";//101.201.197.50  b2b.huatuoyf.com 测试地址    test1.htyyao.com原来的地址

    /**
     * IM服务器地址、端口号
     */
    public static final String IM_HOST = PROTOCOL + "121.43.11test0.146:8095";//www.shopnctest.com:8095 原来的地址

    /**
     * 服务器端口号
     */
    public static final String PORT = "80";

    /**
     * 应用上下文名
     */
    public static final String APP = "/mobile";///mobile

    /**
     * 首页的地址
     */
    public static final String HOME_URL = "http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447";

    public static final String TYPE_URL = "http://m.yunifang.com/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414";

    public static final String PARTICUlLARS = "http://m.yunifang.com/yunifang/mobile/goods/detail?random=46389&encode=70ed2ed2facd7a812ef46717b37148d6&id=";

    //调试控制台日志
    public static final boolean DEBUG = true;
    //是否打印log
    public static final boolean LOG_ENABLE = DEBUG ? true : false;
    //是否弹出测试toast
    public static final boolean TOAST_ENABLE = DEBUG ? true : false;
    //是否将LOG写到sd上
    public static final boolean LOG2SD_ENABLE = false;

    // Log文件目录名称
    public static final String LOG_PATH_NAME = "YNFCrashLog";

}

