package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import junit.framework.Assert;

public class ah {
    private static ag xnQ = null;
    private ag mxw = null;
    public HandlerThread oFY = null;
    private String xnR = null;

    public interface a {
        boolean JH();

        boolean JI();
    }

    public interface b {
        void Du();
    }

    private void VL(String str) {
        this.mxw = null;
        if (bi.oN(str)) {
            str = "MMHandlerThread";
        }
        this.xnR = str;
        this.oFY = e.dc(this.xnR, 0);
        this.oFY.start();
    }

    public static void Dy(int i) {
        try {
            Process.setThreadPriority(i);
            x.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", Integer.valueOf(i));
        } catch (Throwable e) {
            x.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", Integer.valueOf(i), e.getMessage());
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final void cgp() {
        if (this.oFY == null || !this.oFY.isAlive()) {
            x.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
            return;
        }
        int threadId = this.oFY.getThreadId();
        try {
            if (19 == Process.getThreadPriority(threadId)) {
                x.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 19);
            x.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final int cgq() {
        if (this.oFY == null) {
            return -1;
        }
        return this.oFY.getThreadId();
    }

    public final void tT() {
        if (this.oFY == null || !this.oFY.isAlive()) {
            x.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
            return;
        }
        int threadId = this.oFY.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                x.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, -8);
            x.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public final void cgr() {
        if (this.oFY == null || !this.oFY.isAlive()) {
            x.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
            return;
        }
        int threadId = this.oFY.getThreadId();
        try {
            if (Process.getThreadPriority(threadId) == 0) {
                x.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 0);
            x.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
        }
    }

    public ah() {
        x.i("MicroMsg.MMHandlerThread", "init stack:%s", bi.chl());
        VL(null);
    }

    public ah(String str) {
        VL(str);
    }

    public final ag cgs() {
        if (this.mxw == null) {
            this.mxw = new ag(this.oFY.getLooper());
        }
        return this.mxw;
    }

    public final int a(final b bVar) {
        int a;
        x.i("MicroMsg.MMHandlerThread", "syncReset tid[%d] stack:%s", Long.valueOf(Thread.currentThread().getId()), bi.chl());
        Assert.assertTrue("syncReset should in mainThread", isMainThread());
        long id = this.oFY.getId();
        final Object obj = new byte[0];
        final String str = this.xnR;
        a anonymousClass1 = new a() {
            public final boolean JI() {
                x.i("MicroMsg.MMHandlerThread", "syncReset onPostExecute");
                return true;
            }

            public final boolean JH() {
                x.i("MicroMsg.MMHandlerThread", "syncReset doInBackground tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                if (bVar != null) {
                    bVar.Du();
                }
                x.i("MicroMsg.MMHandlerThread", "syncReset doInBackground callback done tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                ah.this.oFY.quit();
                x.i("MicroMsg.MMHandlerThread", "syncReset init start old tid[%d]", Long.valueOf(ah.this.oFY.getId()));
                ah.this.VL(str);
                x.i("MicroMsg.MMHandlerThread", "syncReset init done new tid[%d]", Long.valueOf(ah.this.oFY.getId()));
                synchronized (obj) {
                    x.i("MicroMsg.MMHandlerThread", "syncReset notify tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                    obj.notify();
                }
                return true;
            }
        };
        synchronized (obj) {
            a = a(anonymousClass1);
            x.i("MicroMsg.MMHandlerThread", "syncReset postAtFrontOfWorker ret[%d], oldTid[%d], curTid[%d]", Integer.valueOf(a), Long.valueOf(id), Long.valueOf(this.oFY.getId()));
            if (a == 0 && id == r4) {
                try {
                    obj.wait();
                } catch (Exception e) {
                    x.d("MicroMsg.MMHandlerThread", "syncReset lock wait end with exception[%s]", e.getMessage());
                }
            }
        }
        return a;
    }

    public int F(Runnable runnable) {
        if (runnable == null) {
            return -1;
        }
        cgs().post(runnable);
        return 0;
    }

    public final int J(Runnable runnable) {
        cgs().postAtFrontOfQueueV2(runnable);
        return 0;
    }

    public final int g(Runnable runnable, long j) {
        if (runnable == null) {
            return -1;
        }
        cgs().postDelayed(runnable, j);
        return 0;
    }

    public final int a(final a aVar) {
        return new ag(this.oFY.getLooper()).postAtFrontOfQueueV2(new Runnable() {
            public final void run() {
                aVar.JH();
                ah.cgt().postAtFrontOfQueueV2(new Runnable() {
                    public final void run() {
                        aVar.JI();
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|" + aVar.toString();
            }
        }) ? 0 : -2;
    }

    public static boolean isMainThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    private static ag cgt() {
        if (xnQ == null) {
            xnQ = new ag(Looper.getMainLooper());
        }
        return xnQ;
    }

    public static void y(Runnable runnable) {
        if (runnable != null) {
            cgt().post(runnable);
        }
    }

    public static void h(Runnable runnable, long j) {
        if (runnable != null) {
            cgt().postDelayed(runnable, j);
        }
    }

    public static void K(Runnable runnable) {
        if (runnable != null) {
            cgt().removeCallbacks(runnable);
        }
    }
}
