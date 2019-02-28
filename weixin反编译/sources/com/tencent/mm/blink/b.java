package com.tencent.mm.blink;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b {
    private static b gza = new b();
    private final Queue<a> gzb = new LinkedList();
    private boolean gzc = false;
    private volatile boolean gzd = false;
    private boolean gze = true;
    private volatile c gzf = g.cAN();
    private AtomicBoolean gzg = new AtomicBoolean(false);
    private ah gzh = new ah("pending-stage");

    private enum b {
        Now,
        Timeout,
        FirstScreen
    }

    private static class a implements e {
        private d ffx;
        private Runnable mRunnable;

        public a(Runnable runnable, d dVar) {
            this.mRunnable = runnable;
            this.ffx = dVar;
        }

        public final Object call(Object obj) {
            x.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", this.mRunnable, this.ffx.getType());
            this.mRunnable.run();
            return null;
        }

        public final String wE() {
            if (!(this.ffx instanceof com.tencent.mm.vending.h.c)) {
                return this.ffx.getType();
            }
            if (d.cAP() instanceof com.tencent.mm.vending.h.c) {
                return d.zLX.mType;
            }
            return d.cAP().getType();
        }
    }

    public static b wv() {
        return gza;
    }

    public final synchronized void ww() {
        this.gzc = true;
    }

    public final synchronized void wx() {
        this.gze = true;
        if (this.gzc) {
            wB();
        }
    }

    public final synchronized void wy() {
        this.gze = false;
    }

    public final synchronized void wz() {
        if (this.gzc) {
            this.gzc = false;
            wB();
        }
    }

    public final synchronized void f(Runnable runnable) {
        d cAP = d.cAP();
        if (!(cAP instanceof com.tencent.mm.vending.h.c)) {
            com.tencent.mm.vending.h.g.a(cAP.getType(), cAP);
        }
        if (wA()) {
            x.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement arrange runnable postToMainThread %s", runnable);
            this.gzf.b(new a(runnable, cAP));
        } else {
            x.i("MicroMsg.FirstScreenArrangement", "arrange first screen runnable: %s, %s, %s, %s", Boolean.valueOf(this.gzc), Boolean.valueOf(this.gze), Boolean.valueOf(this.gzd), this.gzb);
            this.gzb.add(new a(runnable, cAP));
        }
    }

    private synchronized boolean wA() {
        boolean z;
        z = (!this.gzc || this.gze) && this.gzd;
        return z;
    }

    private void wB() {
        a(b.FirstScreen);
        wC();
    }

    private synchronized void wC() {
        if (wA()) {
            while (true) {
                a aVar = (a) this.gzb.poll();
                if (aVar == null) {
                    break;
                }
                x.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", aVar.mRunnable, aVar.ffx.getType());
                this.gzf.b(aVar);
            }
        }
    }

    private void a(final b bVar) {
        if (!this.gzg.compareAndSet(false, true)) {
            return;
        }
        if (bVar == b.Now) {
            x.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
            com.tencent.mm.kernel.a.c.DA().DB();
            synchronized (this) {
                this.gzd = true;
                wC();
            }
            return;
        }
        d hVar = new h(new com.tencent.mm.cc.d(this.gzh.cgs()), "pending-stage");
        synchronized (this) {
            this.gzf.a(hVar).b(new com.tencent.mm.vending.c.a<Object, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    return wD();
                }

                private Object wD() {
                    x.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
                    com.tencent.mm.kernel.a.c.DA().DB();
                    synchronized (this) {
                        b.this.gzd = true;
                        b.this.wC();
                    }
                    return null;
                }
            });
        }
    }

    public final synchronized void aT(boolean z) {
        x.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", Boolean.valueOf(z));
        if (z) {
            a(b.Now);
        } else {
            ah.h(new Runnable() {
                public final void run() {
                    b.this.a(b.Timeout);
                }
            }, 1000);
        }
    }
}
