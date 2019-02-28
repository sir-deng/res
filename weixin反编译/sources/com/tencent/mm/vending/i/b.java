package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class b {
    private static b zMi = new b();
    private Handler mHandler;
    public HandlerThread zMh = new HandlerThread("Vending-LogicThread");

    private b() {
        this.zMh.start();
        this.mHandler = new Handler(this.zMh.getLooper());
    }

    public static b cAS() {
        return zMi;
    }
}
