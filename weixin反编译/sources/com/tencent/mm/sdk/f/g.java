package com.tencent.mm.sdk.f;

import android.os.Debug;
import com.tencent.mm.sdk.f.e.b;
import junit.framework.Assert;

final class g implements Comparable<g>, Runnable {
    private static final String hTT;
    private static int xsD = 1000;
    long hkL;
    final String jzA;
    final int priority;
    boolean started = false;
    final Runnable xoo;
    long xor;
    long xot;
    final boolean xsE;
    b xsF;

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int abs = (int) (Math.abs(System.currentTimeMillis() - this.xor) / ((long) xsD));
        int i = this.priority;
        if (abs > 0) {
            i += abs;
        }
        return gVar.priority - i;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|pooled = %b");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        hTT = stringBuilder.toString();
    }

    g(Runnable runnable, String str, int i, boolean z, b bVar) {
        Assert.assertNotNull("ThreadTask arg task is null!", runnable);
        Assert.assertNotNull("ThreadTask arg name is null!", str);
        this.xoo = runnable;
        this.jzA = str;
        this.priority = i;
        this.xsE = z;
        this.xor = System.currentTimeMillis();
        this.xsF = bVar;
    }

    public final void run() {
        this.hkL = System.currentTimeMillis();
        this.xot = Debug.threadCpuTimeNanos();
        this.started = true;
        this.xoo.run();
        this.hkL = System.currentTimeMillis() - this.hkL;
        this.xot = Debug.threadCpuTimeNanos() - this.xot;
    }

    public final String toString() {
        return String.format(hTT, new Object[]{this.jzA, Integer.valueOf(this.priority), Boolean.valueOf(this.xsE), Long.valueOf(this.xor), Long.valueOf(this.hkL), Long.valueOf(this.xot), Boolean.valueOf(this.started)});
    }
}
