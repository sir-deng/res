package com.tencent.mm.kiss.a;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a gUD = new a();
    public HandlerThread gUC = new HandlerThread("InflateThread", 5);
    private Handler mHandler;

    private a() {
        this.gUC.start();
        this.mHandler = new Handler(this.gUC.getLooper());
    }

    public static a Ee() {
        return gUD;
    }
}
