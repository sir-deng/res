package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a zMg = new a();
    private Handler mHandler;
    public HandlerThread zMf = new HandlerThread("Vending-HeavyWorkThread", 10);

    private a() {
        this.zMf.start();
        this.mHandler = new Handler(this.zMf.getLooper());
    }

    public static a cAR() {
        return zMg;
    }
}
