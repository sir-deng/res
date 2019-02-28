package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.ipcinvoker.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class n {
    private static volatile n gOw;
    ExecutorService gOx;
    private int gOy = 3;
    private ag mHandler;

    private static n BE() {
        if (gOw == null) {
            synchronized (n.class) {
                if (gOw == null) {
                    gOw = new n();
                }
            }
        }
        return gOw;
    }

    static n BF() {
        return new n();
    }

    private n() {
        final HandlerThread WL = e.WL("IPCThreadPool#WorkerThread-" + hashCode());
        WL.start();
        this.mHandler = new ag(WL.getLooper());
        this.gOx = Executors.newScheduledThreadPool(this.gOy, new ThreadFactory() {
            int index = 0;

            public final Thread newThread(final Runnable runnable) {
                StringBuilder stringBuilder = new StringBuilder("IPCThreadPool#Thread-");
                int i = this.index;
                this.index = i + 1;
                Thread thread = new Thread(new Runnable() {
                    public final void run() {
                        ThreadLocal threadLocal = (ThreadLocal) new a(Looper.class, "sThreadLocal").BI();
                        if (threadLocal == null || threadLocal.get() != null) {
                            x.d("IPC.IPCThreadPool", "ThreadLocal Looper variable is null or has set.(%s)", threadLocal);
                        } else {
                            x.d("IPC.IPCThreadPool", "create a new Looper ThreadLocal variable.");
                            threadLocal.set(WL.getLooper());
                        }
                        runnable.run();
                    }
                }, stringBuilder.append(i).toString());
                x.i("IPC.IPCThreadPool", "newThread(thread : %s)", r0);
                return thread;
            }
        });
        x.i("IPC.IPCThreadPool", "initialize IPCInvoker IPCThreadPool(hashCode : %s)", Integer.valueOf(hashCode()));
    }

    public static boolean post(Runnable runnable) {
        BE().gOx.execute(runnable);
        return true;
    }

    public static boolean h(Runnable runnable) {
        return BE().mHandler.postDelayed(runnable, 2000);
    }
}
