package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class f {
    private static final AtomicInteger iOS = new AtomicInteger();
    private static final AtomicLong iOT = new AtomicLong();
    private static boolean iOU;

    public static void bF(long j) {
        if (iOU && j > 0) {
            x.v("MicroMsg.FPSCollector", "collect(cost : %s)", Long.valueOf(j));
            iOT.addAndGet(j);
            iOS.getAndIncrement();
        }
    }

    public static void reset() {
        iOS.set(0);
        iOT.set(0);
    }

    public static void cv(boolean z) {
        iOU = z;
    }

    public static boolean abH() {
        return iOU;
    }

    public static String abI() {
        float f = 0.0f;
        int i = iOS.get();
        long j = iOT.get();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("fps : ");
        int i2 = iOS.get();
        long j2 = iOT.get();
        float f2 = (!iOU || j2 <= 0) ? 0.0f : (((float) i2) * 1000.0f) / ((float) j2);
        append.append(f2);
        stringBuilder.append("\ncount : ").append(i);
        StringBuilder append2 = stringBuilder.append("\naverage cost : ");
        if (i > 0) {
            f = (1.0f * ((float) j)) / ((float) i);
        }
        append2.append(f);
        return stringBuilder.toString();
    }
}
