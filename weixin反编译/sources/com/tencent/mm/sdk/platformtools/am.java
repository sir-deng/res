package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class am implements Runnable {
    private static final String xox;
    private static final String xoy;
    long endTime;
    final Handler handler;
    long hkL;
    final String jzA;
    long mHl;
    int priority;
    boolean started = false;
    final Thread thread;
    String xnR;
    final Runnable xoo;
    final Object xop;
    final a xoq;
    long xor;
    long xos;
    long xot;
    long xou;
    long xov;
    float xow = -1.0f;

    public interface a {
        void a(Runnable runnable, am amVar);

        void a(Runnable runnable, Thread thread, long j, long j2, float f);
    }

    am(Thread thread, Handler handler, Runnable runnable, Object obj, a aVar) {
        this.thread = thread;
        if (thread != null) {
            this.xnR = thread.getName();
            this.mHl = thread.getId();
            this.priority = thread.getPriority();
        }
        this.handler = handler;
        this.xoo = runnable;
        String name = runnable.getClass().getName();
        String obj2 = runnable.toString();
        if (!bi.oN(obj2)) {
            int indexOf = obj2.indexOf(124);
            if (indexOf > 0) {
                name = name + "_" + obj2.substring(indexOf + 1);
            }
        }
        this.jzA = name;
        this.xop = obj;
        this.xoq = aVar;
        this.xor = System.currentTimeMillis();
    }

    public final void run() {
        new StringBuilder("/proc/self/task/").append(Process.myTid()).append("/stat");
        this.hkL = System.currentTimeMillis();
        this.xot = Debug.threadCpuTimeNanos();
        this.xou = -1;
        this.xov = -1;
        this.started = true;
        this.xoo.run();
        this.xou = -1 - this.xou;
        this.xov = -1 - this.xov;
        this.endTime = System.currentTimeMillis();
        this.hkL = this.endTime - this.hkL;
        this.xot = (Debug.threadCpuTimeNanos() - this.xot) / 1000000;
        if (this.xov != 0) {
            this.xow = ((float) (100 * this.xou)) / ((float) this.xov);
        }
        if (this.xoq != null) {
            this.xoq.a(this.xoo, this);
            this.xoq.a(this, this.thread, this.hkL, this.xot, this.xow);
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|token = %s");
        stringBuilder.append("|handler = %s");
        stringBuilder.append("|threadName = %s");
        stringBuilder.append("|threadId = %d");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|delayTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        xox = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append(" | addTime = %s");
        stringBuilder.append(" | endTime = %s");
        stringBuilder.append(" | usedTime = %d");
        stringBuilder.append(" | cpuTime = %d");
        stringBuilder.append(" | threadCpuTime = %d");
        stringBuilder.append(" | totalCpuTime = %d");
        stringBuilder.append(" | threadCpuRate = %.1f");
        xoy = stringBuilder.toString();
    }

    public final String dump(boolean z) {
        if (z) {
            return String.format(xox, new Object[]{this.jzA, this.xop, this.handler, this.xnR, Long.valueOf(this.mHl), Integer.valueOf(this.priority), Long.valueOf(this.xor), Long.valueOf(this.xos), Long.valueOf(this.hkL), Long.valueOf(this.xot), Boolean.valueOf(this.started)});
        }
        return String.format(xoy, new Object[]{this.jzA, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.xor)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.hkL), Long.valueOf(this.xot), Long.valueOf(this.xou), Long.valueOf(this.xov), Float.valueOf(this.xow)});
    }
}
