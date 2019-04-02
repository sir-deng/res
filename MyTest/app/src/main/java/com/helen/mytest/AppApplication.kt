package com.helen.mytest

import com.helen.baselib.baseapp.BaseApplication
import com.helen.baselib.commountutils.LogUtils

public class AppApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        LogUtils.logInit(BuildConfig.DEBUG);
    }
}