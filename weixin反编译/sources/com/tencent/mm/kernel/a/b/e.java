package com.tencent.mm.kernel.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

public final class e<T> {
    private static e gTS = null;
    private Queue<c> gTL = new LinkedList();
    private int gTM;
    private volatile a gTN;
    private volatile boolean gTO = false;
    private final byte[] gTP = new byte[0];
    private volatile com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> gTQ;
    private volatile c<T> gTR;

    public interface a {
        void DN();

        void DQ();
    }

    public static class c {
        public HandlerThread ffw;
        h gTW;
        Handler handler;
    }

    public static class b implements a {
        private final byte[] gPR = new byte[]{(byte) 0};

        public final void DN() {
            try {
                synchronized (this.gPR) {
                    if (this.gPR[0] == (byte) 0) {
                        j.i("MMSkeleton.Parallels", "Waiting for lock(%s)", this.gPR);
                        this.gPR.wait();
                    } else {
                        j.i("MMSkeleton.Parallels", "Not need wait for lock(%s)", this.gPR);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MMSkeleton.Parallels", e, "", new Object[0]);
            }
        }

        public final void DQ() {
            synchronized (this.gPR) {
                this.gPR[0] = (byte) 1;
                this.gPR.notify();
                j.i("MMSkeleton.Parallels", "Lock(%s) notified", this.gPR);
            }
        }
    }

    public static e DL() {
        return gTS;
    }

    public static e DM() {
        if (gTS == null) {
            gTS = new e();
        }
        return gTS;
    }

    private e() {
    }

    public final synchronized void init(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Queue queue = this.gTL;
            HandlerThread handlerThread = new HandlerThread("parallels-" + i2, -8);
            handlerThread.start();
            c cVar = new c();
            cVar.ffw = handlerThread;
            queue.add(cVar);
        }
        this.gTM = i;
    }

    public final synchronized void prepare() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gTM) {
                c cVar = (c) ((LinkedList) this.gTL).get(i2);
                Handler handler = new Handler(cVar.ffw.getLooper());
                h hVar = new h(handler, cVar.ffw.getName());
                cVar.handler = handler;
                cVar.gTW = hVar;
                i = i2 + 1;
            }
        }
    }

    public final boolean a(a aVar, com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> aVar2, c<T> cVar) {
        synchronized (this.gTP) {
            if (this.gTO) {
                x.w("MMSkeleton.Parallels", "Arrange parallels task failed. It's busy on working.");
                Assert.assertTrue(false);
                return false;
            }
            this.gTN = aVar;
            this.gTQ = aVar2;
            this.gTR = cVar;
            return true;
        }
    }

    public final void a(a aVar, com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> aVar2, c<T> cVar, String str) {
        if (a(aVar, (com.tencent.mm.vending.c.a) aVar2, (c) cVar)) {
            cVar.prepare();
            start(str);
            DN();
        }
    }

    public final void DN() {
        this.gTN.DN();
    }

    public final void start(String str) {
        j.i("MMSkeleton.Parallels", "Start working. For %s", str);
        synchronized (this.gTP) {
            this.gTO = true;
        }
        active();
    }

    public final synchronized List<c> DO() {
        return new LinkedList(this.gTL);
    }

    private synchronized c DP() {
        return (c) this.gTL.poll();
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            this.gTL.add(cVar);
            j.d("MMSkeleton.Parallels", "Parallels check threads idle. %s of %s", Integer.valueOf(this.gTL.size()), Integer.valueOf(this.gTM));
            if (this.gTL.size() != this.gTM) {
                z = false;
            }
        }
        return z;
    }

    private void b(c cVar) {
        if (a(cVar)) {
            synchronized (this.gTP) {
                if (this.gTO) {
                    j.i("MMSkeleton.Parallels", "Parallels notify done", new Object[0]);
                }
                this.gTO = false;
                this.gTN.DQ();
            }
        }
    }

    private void active() {
        while (true) {
            c DP = DP();
            if (DP != null) {
                com.tencent.mm.kernel.a.b.f.a DK = this.gTR.DK();
                if (DK != null) {
                    a(DP, DK);
                } else {
                    b(DP);
                    return;
                }
            }
            return;
        }
    }

    private void a(final c cVar, final com.tencent.mm.kernel.a.b.f.a<T> aVar) {
        cVar.gTW.f(new Runnable() {
            public final void run() {
                com.tencent.mm.kernel.a.a.a.a aVar = aVar;
                com.tencent.mm.vending.c.a a = e.this.gTQ;
                if (!aVar.gTF) {
                    aVar.gUh.gUi.cDg();
                    if (!aVar.gTF) {
                        a.call(aVar);
                        x.d("MMSkeleton.ParallelsDependencies", "consume call functional %s, node %s", a, aVar);
                        aVar.gTF = true;
                    }
                    aVar.gUh.gUi.done();
                }
                e.this.gTR.a(aVar);
                com.tencent.mm.kernel.a.b.f.a DK = e.this.gTR.DK();
                if (DK == null) {
                    e.this.b(cVar);
                    return;
                }
                e.this.a(cVar, DK);
                e.this.active();
            }
        });
    }
}
