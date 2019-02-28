package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.sdk.f.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class t implements ThreadFactory {
    private static final AtomicInteger voP = new AtomicInteger(1);
    private final AtomicInteger hEO;
    private String hEP;

    public t() {
        this("ResDownloaderPool", "ResDownloaderThread");
    }

    public t(String str, String str2) {
        this.hEO = new AtomicInteger(1);
        this.hEP = String.format("%s-%d-%s-", new Object[]{str, Integer.valueOf(voP.getAndIncrement()), str2});
    }

    public final Thread newThread(Runnable runnable) {
        Thread d = e.d(runnable, this.hEP + this.hEO.getAndIncrement(), 1);
        if (d.isDaemon()) {
            d.setDaemon(false);
        }
        return d;
    }
}
