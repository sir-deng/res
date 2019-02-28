package com.tencent.mm.pluginsdk.i.a.d;

import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public final class o {
    public final ag handler;
    private volatile ah hoG;
    public final boolean jbr;
    public final r voD;
    public final m voE;
    public final i voF;

    private static final class a {
        private static final o voG = new o();
    }

    private static class b implements Runnable {
        private final Runnable hYX;

        /* synthetic */ b(Runnable runnable, byte b) {
            this(runnable);
        }

        private b(Runnable runnable) {
            this.hYX = runnable;
        }

        public final void run() {
            if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
            if (this.hYX != null) {
                this.hYX.run();
            }
        }
    }

    /* synthetic */ o(byte b) {
        this();
    }

    private o() {
        this.hoG = null;
        p.init();
        this.voD = r.car();
        if (this.voD == null) {
            this.jbr = false;
            this.voE = null;
            this.handler = null;
            this.voF = null;
            return;
        }
        this.jbr = true;
        t tVar = new t();
        this.handler = new ag(Looper.getMainLooper());
        this.voF = new i(Dt().cgs());
        this.voE = new m(tVar, this.voF);
    }

    public final void A(Runnable runnable) {
        Dt().F(new b(runnable, (byte) 0));
    }

    final ah Dt() {
        if (this.hoG == null) {
            this.hoG = new ah("ResDownloader-WorkerThread");
        }
        return this.hoG;
    }

    public final void a(String str, d dVar) {
        x.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", str, dVar);
        if (this.jbr) {
            i iVar = this.voF;
            x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = " + dVar);
            if (dVar != null) {
                int hashCode = str.hashCode();
                synchronized (iVar.voo) {
                    List list = (List) iVar.von.get(hashCode);
                    if (list == null) {
                        list = new LinkedList();
                    }
                    list.add(dVar);
                    iVar.von.put(hashCode, list);
                }
            }
        }
    }

    static com.tencent.mm.pluginsdk.i.a.d.m.a c(k kVar) {
        x.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
        int hashCode = kVar.aam().hashCode();
        for (g gVar : p.caq()) {
            x.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", gVar.getClass().getSimpleName(), gVar.aam());
            if (gVar.aam().hashCode() == hashCode) {
                return gVar.c(kVar);
            }
        }
        return null;
    }

    public final void g(q qVar) {
        if (this.jbr) {
            long Wy = bi.Wy();
            if (this.voD.SB(qVar.field_urlKey) != null) {
                x.i("MicroMsg.ResDownloaderCore", "doUpdate: update existing record");
                this.voD.h(qVar);
            } else {
                x.i("MicroMsg.ResDownloaderCore", "doUpdate: insert new record");
                this.voD.i(qVar);
            }
            x.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, cost = %d", qVar.field_urlKey, Long.valueOf(bi.bA(Wy)));
        }
    }

    public final q SB(String str) {
        if (!this.jbr) {
            return null;
        }
        long Wy = bi.Wy();
        q SB = this.voD.SB(str);
        String str2 = "MicroMsg.ResDownloaderCore";
        String str3 = "doQuery: urlKey = %s, cost = %d";
        Object[] objArr = new Object[2];
        objArr[0] = SB == null ? "null" : SB.field_urlKey;
        objArr[1] = Long.valueOf(bi.bA(Wy));
        x.i(str2, str3, objArr);
        return SB;
    }

    public final int d(k kVar) {
        if (!this.jbr) {
            return -1;
        }
        if (bi.oN(kVar.url)) {
            x.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", kVar.vmK);
            return 3;
        }
        x.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", kVar.vmK);
        return this.voE.b(kVar);
    }

    public final boolean SC(String str) {
        if (!this.jbr) {
            return false;
        }
        if (this.voE.isDownloading(str) || this.voE.Sz(str)) {
            return true;
        }
        return false;
    }

    public final void SD(String str) {
        if (this.jbr) {
            f fVar = this.voE;
            Future future = (Future) fVar.voj.remove(str);
            if (future != null) {
                future.cancel(true);
            }
            fVar.voi.remove(str);
        }
    }
}
