package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g {
    private static Map<String, d> zMb = new ConcurrentHashMap();
    private static Map<Looper, d> zMc = new HashMap();
    private static boolean zMd = false;

    static {
        cAQ();
    }

    public static void a(String str, d dVar) {
        Assert.assertNotNull("Scheduler type is null", str);
        String toUpperCase = str.toUpperCase();
        if (zMb.containsKey(toUpperCase)) {
            IllegalStateException illegalStateException = new IllegalStateException("Fatal error! Duplicate scheduler type " + str.toUpperCase());
        }
        zMb.put(toUpperCase, dVar);
        if (dVar instanceof h) {
            synchronized (g.class) {
                zMc.put(((h) dVar).mLooper, dVar);
            }
        }
    }

    public static void aaY(String str) {
        zMb.remove(str.toUpperCase());
    }

    public static d aaZ(String str) {
        Assert.assertNotNull("Scheduler type is null", str);
        d dVar = (d) zMb.get(str.toUpperCase());
        Assert.assertNotNull("Scheduler type not found: " + str.toUpperCase(), dVar);
        return dVar;
    }

    public static synchronized d cAP() {
        d cVar;
        synchronized (g.class) {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                a.w("Vending.SchedulerProvider", "This is not a handler thread! %s", Thread.currentThread());
                cVar = new c();
            } else {
                cVar = (d) zMc.get(myLooper);
                if (cVar == null) {
                    cVar = new h(myLooper, myLooper.toString());
                    zMc.put(myLooper, cVar);
                }
            }
        }
        return cVar;
    }

    static synchronized void cAQ() {
        synchronized (g.class) {
            if (!zMd) {
                a.i("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
                zMd = true;
                a("Vending.UI", d.zLX);
                a("Vending.LOGIC", d.zLY);
                a("Vending.HEAVY_WORK", d.zLZ);
            }
        }
    }
}
