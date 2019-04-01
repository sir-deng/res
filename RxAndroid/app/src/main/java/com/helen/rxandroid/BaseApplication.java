package com.helen.rxandroid;

import android.app.Application;

public class BaseApplication extends Application {
    private static Application instance;
    public static Application getAppcontext() {
        return instance;
    }
    public static boolean isNetConnected() {
        boolean i = false;
//        NetworkInfo localNetworkInfo = ((ConnectivityManager).getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
//        if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
//            return true;
        return false;
    }
    @Override
    public void onCreate() {
        super.onCreate();
            instance = this;
    }
}
