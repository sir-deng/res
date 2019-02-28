package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d {
    public static final h zLX = new h(Looper.getMainLooper(), "Vending.UI");
    public static final h zLY = new h(b.cAS().zMh.getLooper(), "Vending.LOGIC");
    public static final h zLZ = new h(a.cAR().zMf.getLooper(), "Vending.HEAVY_WORK");

    public abstract void cancel();

    public abstract void f(Runnable runnable);

    public abstract void f(Runnable runnable, long j);

    public abstract String getType();

    static {
        g.cAQ();
    }

    public static synchronized d cAP() {
        d cAP;
        synchronized (d.class) {
            cAP = g.cAP();
        }
        return cAP;
    }
}
