package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e implements a {
    private static b xsA;
    private static e xsu;
    static int[] xsv = new int[]{19, 16, 13, 10, 0, -2, -4, -5, -6, -8};
    static long xsw = 0;
    static long xsx = 0;
    private static b xsy;
    private static a xsz;
    private boolean fob = false;
    volatile boolean fwD = false;
    Object lock = new Object();
    private f xsm = new f(this.xsn + 2, TimeUnit.SECONDS, this.xso, this);
    private int xsn = chF();
    private PriorityBlockingQueue<Runnable> xso = new PriorityBlockingQueue(33);
    private LinkedList<g> xsp = new LinkedList();
    private ArrayList<g> xsq = new ArrayList();
    private HashMap<g, Thread> xsr = new HashMap();
    private ArrayList<c> xss = new ArrayList();
    private c xst;

    public interface b {
    }

    class a implements c {
        private final Runnable r;

        public a(Runnable runnable) {
            this.r = runnable;
        }

        public final void z(Runnable runnable) {
            if (runnable.equals(this.r)) {
                synchronized (this.r) {
                    this.r.notifyAll();
                    e.c(this);
                }
            }
        }
    }

    class c extends ag {
        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    removeMessages(message.what);
                    if (e.this.fwD) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (e.xsw > 0 && Math.abs(e.xsx - currentTimeMillis) > e.xsw) {
                            x.i("MicroMsg.ThreadPool", "|MMThreadPool thread pool is auto wakeup");
                            e eVar = e.this;
                            synchronized (eVar.lock) {
                                eVar.fwD = false;
                                e.xsx = 0;
                                e.xsw = 0;
                            }
                        }
                        sendEmptyMessageDelayed(1, 1000);
                        return;
                    }
                    e.a(e.this);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void a(e eVar) {
        synchronized (eVar.lock) {
            if (!eVar.xsp.isEmpty()) {
                Iterator it = eVar.xsp.iterator();
                if (it != null && it.hasNext()) {
                    g gVar = (g) it.next();
                    it.remove();
                    eVar.chG();
                    eVar.xsm.execute(gVar);
                    it = new ArrayList(eVar.xss).iterator();
                    while (it.hasNext()) {
                        it.next();
                        Runnable runnable = gVar.xoo;
                        eVar.xsm.getActiveCount();
                    }
                }
            }
            if (!eVar.xsp.isEmpty()) {
                eVar.xst.sendEmptyMessage(1);
            }
        }
    }

    public static e chE() {
        if (xsu == null) {
            synchronized (e.class) {
                if (xsu == null) {
                    xsu = new e();
                }
            }
        }
        return xsu;
    }

    private e() {
        HandlerThread WL = WL("THREAD_POOL_HANDLER");
        WL.start();
        this.xst = new c(WL.getLooper());
    }

    private static int chF() {
        int availableProcessors = (Runtime.getRuntime().availableProcessors() * 4) + 2;
        if (availableProcessors > 32) {
            return 32;
        }
        return availableProcessors;
    }

    public final void beforeExecute(Thread thread, Runnable runnable) {
        int i = 10;
        synchronized (this.lock) {
            Iterator it = this.xsq.iterator();
            if (it != null) {
                Object obj;
                g gVar = (g) runnable;
                int i2 = gVar.priority;
                if (i2 <= 0) {
                    i = 1;
                } else if (i2 <= 10) {
                    i = i2;
                }
                thread.setPriority(i);
                thread.setName(gVar.jzA);
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    this.xsr.put(gVar, thread);
                    ArrayList arrayList = new ArrayList(this.xss);
                    if (!this.fob) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                    }
                    this.fob = true;
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        it3.next();
                        Runnable runnable2 = gVar.xoo;
                    }
                }
            }
        }
    }

    public final void P(Runnable runnable) {
        synchronized (this.lock) {
            g gVar = (g) runnable;
            Iterator it = this.xsr.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Iterator it2 = new ArrayList(this.xss).iterator();
                    while (it2.hasNext()) {
                        ((c) it2.next()).z(gVar.xoo);
                    }
                }
            }
            int activeCount = this.xsm.getActiveCount();
            int size = this.xsm.getQueue().size();
            int corePoolSize = this.xsm.getCorePoolSize();
            if (activeCount == 1 && size == 0) {
                if (corePoolSize > 0) {
                    this.xsn = chF();
                    this.xsm.setCorePoolSize(0);
                    this.xsm.setMaximumPoolSize(this.xsn + 2);
                }
                Iterator it3 = new ArrayList(this.xss).iterator();
                while (it3.hasNext()) {
                    it3.next();
                }
                this.fob = false;
            }
        }
    }

    public static void a(c cVar) {
        chE().b(cVar);
    }

    private void b(c cVar) {
        synchronized (this.lock) {
            if (!this.xss.contains(cVar)) {
                this.xss.add(cVar);
            }
        }
    }

    public static void c(c cVar) {
        e chE = chE();
        synchronized (chE.lock) {
            chE.xss.remove(cVar);
        }
    }

    public static void post(Runnable runnable, String str) {
        chE().c(runnable, str, 5);
    }

    public static void b(Runnable runnable, String str, int i) {
        chE().c(runnable, str, i);
    }

    private void c(Runnable runnable, String str, int i) {
        synchronized (this.lock) {
            g gVar = new g(runnable, str, i, true, xsA);
            this.xsp.add(gVar);
            this.xsq.add(gVar);
            this.xst.sendEmptyMessage(1);
            lM(false);
        }
    }

    public static void a(Runnable runnable, String str) {
        e chE = chE();
        synchronized (chE.lock) {
            Object gVar = new g(runnable, str, Integer.MAX_VALUE, true, xsA);
            chE.xsq.add(gVar);
            chE.xsm.execute(gVar);
            if (chE.xsm.getActiveCount() < chE.xsn || chE.xsn >= chF() * 2) {
                chE.chG();
            } else {
                chE.xsn++;
                chE.xsm.setCorePoolSize(chE.xsn);
                chE.xsm.setMaximumPoolSize(chE.xsn);
                x.i("MicroMsg.ThreadPool", "|MMThreadPool postAtFront expand core pool size=" + chE.xsn);
            }
            Iterator it = new ArrayList(chE.xss).iterator();
            while (it.hasNext()) {
                it.next();
                Runnable runnable2 = gVar.xoo;
            }
            chE.lM(false);
        }
    }

    public static void Q(Runnable runnable) {
        e chE = chE();
        synchronized (chE.lock) {
            Thread R = chE.R(runnable);
            if (R != null) {
                R.interrupt();
            } else {
                chE.X(runnable);
            }
        }
    }

    private Thread R(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        synchronized (this.lock) {
            Iterator it = this.xsr.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    obj = (g) it.next();
                    if (obj != null && obj.xoo.equals(runnable)) {
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Thread thread = (Thread) this.xsr.get(obj);
                    return thread;
                }
            }
            return null;
        }
    }

    public static void S(Runnable runnable) {
        chE().T(runnable);
    }

    private void T(Runnable runnable) {
        Assert.assertNotNull("join arg runnable is null!", runnable);
        Object obj = null;
        synchronized (this.lock) {
            if (W(runnable)) {
                obj = new a(runnable);
                b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (this.xss.contains(obj)) {
                    runnable.wait();
                } else {
                    x.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static void U(Runnable runnable) {
        int i = 1;
        e chE = chE();
        Assert.assertNotNull("join arg runnable is null!", runnable);
        if (5000 < 0) {
            throw new IllegalArgumentException();
        }
        int i2;
        if (5000 >= 9223372036854L) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (5000 != 0) {
            i = 0;
        }
        if ((i | i2) != 0) {
            chE.T(runnable);
            return;
        }
        Object obj = null;
        synchronized (chE.lock) {
            if (chE.W(runnable)) {
                obj = new a(runnable);
                chE().b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (chE.xss.contains(obj)) {
                    runnable.wait(5000, 0);
                } else {
                    x.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static boolean V(Runnable runnable) {
        return chE().W(runnable);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean W(java.lang.Runnable r6) {
        /*
        r5 = this;
        r2 = 1;
        r1 = 0;
        if (r6 != 0) goto L_0x0006;
    L_0x0004:
        r0 = r1;
    L_0x0005:
        return r0;
    L_0x0006:
        r3 = r5.lock;
        monitor-enter(r3);
        r0 = r5.xsq;	 Catch:{ all -> 0x0052 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0052 }
        if (r4 == 0) goto L_0x002a;
    L_0x0011:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x002a;
    L_0x0017:
        r0 = r4.next();	 Catch:{ all -> 0x0052 }
        r0 = (com.tencent.mm.sdk.f.g) r0;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0011;
    L_0x001f:
        r0 = r0.xoo;	 Catch:{ all -> 0x0052 }
        r0 = r0.equals(r6);	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0011;
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r2;
        goto L_0x0005;
    L_0x002a:
        r0 = r5.xsr;	 Catch:{ all -> 0x0052 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0052 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0052 }
        if (r4 == 0) goto L_0x004f;
    L_0x0036:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x004f;
    L_0x003c:
        r0 = r4.next();	 Catch:{ all -> 0x0052 }
        r0 = (com.tencent.mm.sdk.f.g) r0;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0036;
    L_0x0044:
        r0 = r0.xoo;	 Catch:{ all -> 0x0052 }
        r0 = r0.equals(r6);	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0036;
    L_0x004c:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r2;
        goto L_0x0005;
    L_0x004f:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r1;
        goto L_0x0005;
    L_0x0052:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.f.e.W(java.lang.Runnable):boolean");
    }

    public static boolean remove(Runnable runnable) {
        return chE().X(runnable);
    }

    private boolean X(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        synchronized (this.lock) {
            Iterator it = this.xsq.iterator();
            if (it != null) {
                Runnable runnable2;
                while (it.hasNext()) {
                    runnable2 = (g) it.next();
                    if (runnable2 != null && runnable2.xoo.equals(runnable)) {
                        it.remove();
                        break;
                    }
                }
                runnable2 = null;
                if (runnable2 != null) {
                    this.xsm.remove(runnable2);
                    return true;
                }
            }
            return false;
        }
    }

    private void chG() {
        if (this.xsm.getCorePoolSize() < this.xsn) {
            this.xsm.setCorePoolSize(this.xsn);
            this.xsm.setMaximumPoolSize(this.xsn);
        }
    }

    public static void chH() {
        chE().lM(true);
    }

    private void lM(boolean z) {
        if (z) {
            synchronized (this.lock) {
                x.i("MicroMsg.ThreadPool", "------------------------------------------");
                Iterator it = this.xsp.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        x.i("MicroMsg.ThreadPool", "|MMThreadPool adding task{" + ((g) it.next()) + "}");
                    }
                }
                x.i("MicroMsg.ThreadPool", "-----------");
                it = this.xsq.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        x.i("MicroMsg.ThreadPool", "|MMThreadPool waiting task{" + ((g) it.next()) + "}");
                    }
                }
                x.i("MicroMsg.ThreadPool", "-----------");
                it = this.xsr.keySet().iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        x.i("MicroMsg.ThreadPool", "|MMThreadPool running task{" + ((g) it.next()) + "}");
                    }
                }
                x.i("MicroMsg.ThreadPool", "-----------");
                x.i("MicroMsg.ThreadPool", "|MMThreadPool poolSize=" + this.xsm.getPoolSize() + "|activeCount=" + this.xsm.getActiveCount() + "|corePoolSize=" + this.xsm.getPoolSize() + "|largestPoolSize=" + this.xsm.getLargestPoolSize() + "|maximuPoolSize=" + this.xsm.getMaximumPoolSize());
                x.i("MicroMsg.ThreadPool", "------------------------------------------");
            }
        }
    }

    private static b chI() {
        if (xsy == null) {
            xsy = new b(xsA);
        }
        return xsy;
    }

    public static Thread b(Runnable runnable, String str) {
        return chI().a(runnable, str, 5);
    }

    public static Thread d(Runnable runnable, String str, int i) {
        return chI().a(runnable, str, i);
    }

    private static a chJ() {
        if (xsz == null) {
            xsz = new a(xsA);
        }
        return xsz;
    }

    public static HandlerThread WL(String str) {
        chJ();
        return a.db(str, 0);
    }

    public static HandlerThread dc(String str, int i) {
        chJ();
        return a.db(str, i);
    }
}
