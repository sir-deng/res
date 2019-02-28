package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.compatible.e.w;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class m extends f<k> {
    private final a voy;
    public final c voz;

    private static final class c extends PriorityBlockingQueue<Runnable> {
        public final /* synthetic */ boolean offer(Object obj) {
            Runnable runnable = (Runnable) obj;
            boolean offer = super.offer(runnable);
            x.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "offer() | tid = %d | " + H(runnable), Long.valueOf(Thread.currentThread().getId()));
            return offer;
        }

        public final /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
            Runnable runnable = (Runnable) super.poll(j, timeUnit);
            if (runnable != null) {
                x.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "poll(long, TimeUnit) | tid = %d | " + H(runnable), Long.valueOf(Thread.currentThread().getId()));
            }
            return runnable;
        }

        public c() {
            super(11, new Comparator<Runnable>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    int random;
                    Runnable runnable = (Runnable) obj;
                    Runnable runnable2 = (Runnable) obj2;
                    if ((runnable instanceof c) && (runnable2 instanceof c) && (((c) runnable).vol instanceof k) && (((c) runnable2).vol instanceof k)) {
                        k kVar = (k) ((c) runnable).vol;
                        k kVar2 = (k) ((c) runnable2).vol;
                        int i = kVar.priority - kVar2.priority;
                        random = (kVar.caa() && kVar2.caa()) ? i != 0 ? i : ((int) (Math.random() * 50.0d)) - 25 : i;
                    } else {
                        random = 0;
                    }
                    return 0 - random;
                }
            });
        }

        private static String H(Runnable runnable) {
            if (!(runnable instanceof c)) {
                return String.format("unknown runnable = %s", new Object[]{runnable});
            } else if (((c) runnable).vol instanceof k) {
                return String.format("priority = %d, urlKey = %s", new Object[]{Integer.valueOf(((k) ((c) runnable).vol).priority), ((c) runnable).vol.bZW()});
            } else {
                return String.format("unknown request = %s", new Object[]{((c) runnable).vol});
            }
        }
    }

    public static abstract class a<Req extends k> extends d<Req> implements e {
        private static final ThreadLocal<j> voA = new ThreadLocal<j>() {
            protected final /* synthetic */ Object initialValue() {
                return new j();
            }
        };
        private final int vmU;
        private final AtomicInteger voB = new AtomicInteger(this.vmU);
        public volatile c voC;

        public a(Req req) {
            super(req);
            this.vmU = req.vmU;
        }

        public l a(j jVar) {
            if (!aaq()) {
                return jVar.a(this);
            }
            q SB = a.voG.SB(bZW());
            if (SB != null) {
                SB.field_status = 1;
                a.voG.g(SB);
            }
            return jVar.a(this);
        }

        public boolean aaq() {
            return true;
        }

        public final void run() {
            l a = a((j) voA.get());
            if (a != null) {
                this.voC.a(this, a);
                return;
            }
            x.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", aam());
        }

        public boolean aan() {
            return false;
        }

        public boolean aao() {
            return true;
        }

        public boolean aap() {
            return false;
        }

        public boolean aar() {
            return true;
        }

        public String getURL() {
            return ((k) aat()).url;
        }

        public final String caj() {
            return "GET";
        }

        public final Collection<b> cak() {
            Map requestHeaders = ((k) aat()).getRequestHeaders();
            if (requestHeaders == null || requestHeaders.size() == 0) {
                return null;
            }
            Set<String> keySet = requestHeaders.keySet();
            if (keySet == null || keySet.size() == 0) {
                return null;
            }
            Collection<b> linkedList = new LinkedList();
            for (String str : keySet) {
                String str2 = (String) requestHeaders.get(str);
                if (!bi.oN(str2)) {
                    linkedList.add(new b(str, str2));
                }
            }
            return linkedList;
        }

        public final int getConnectTimeout() {
            return ((k) aat()).getConnectTimeout();
        }

        public final int getReadTimeout() {
            return ((k) aat()).getReadTimeout();
        }

        public final int cal() {
            return ((k) aat()).cal();
        }

        public final String cam() {
            return "application/x-www-form-urlencoded;charset=utf-8";
        }

        public final String bZW() {
            return ((k) aat()).vmK;
        }

        public final String getFilePath() {
            return ((k) aat()).getFilePath();
        }

        public boolean aas() {
            boolean z = this.voB.decrementAndGet() > 0;
            this.voC.q(bZW(), this.vmU, this.voB.get());
            return z;
        }

        public boolean bE(long j) {
            this.voC.s(bZW(), j);
            x.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", bZW(), Long.valueOf(ax.cgQ()));
            if (ax.cgQ() >= j) {
                return true;
            }
            return false;
        }
    }

    private static class b extends a<k> {
        b(k kVar) {
            super(kVar);
        }

        public final String aam() {
            return "ResDownload";
        }
    }

    public m(t tVar, c cVar) {
        this(tVar, cVar, (byte) 0);
    }

    private m(t tVar, c cVar, byte b) {
        this.voy = new a(4, 4, 3000, TimeUnit.MILLISECONDS, new c(), tVar);
        this.voy.setKeepAliveTime(30000, TimeUnit.MILLISECONDS);
        this.voy.allowCoreThreadTimeOut(true);
        this.voz = cVar;
    }

    public int b(k kVar) {
        int i = 0;
        if (Sz(kVar.vmK) || isDownloading(kVar.vmK)) {
            x.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", kVar.vmK);
            return 0;
        }
        int zc = w.zc();
        x.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", Integer.valueOf(zc), Integer.valueOf(kVar.networkType));
        if (zc != 0) {
            if (2 == kVar.networkType) {
                zc = 1;
            } else if (zc == 1) {
                zc = 1;
            }
            if (zc != 0) {
                x.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", kVar.vmK);
                return 1;
            }
            if (this.voy.isShutdown() || this.voy.isTerminated() || this.voy.isTerminating()) {
                i = 1;
            }
            if (i != 0) {
                return 4;
            }
            super.b(kVar);
            return 2;
        }
        zc = 0;
        if (zc != 0) {
            i = 1;
            if (i != 0) {
                return 4;
            }
            super.b(kVar);
            return 2;
        }
        x.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", kVar.vmK);
        return 1;
    }

    public final boolean isDownloading(String str) {
        return this.voj.containsKey(str);
    }

    protected final a cad() {
        return this.voy;
    }

    public d a(k kVar) {
        x.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + kVar.getClass().getSimpleName());
        a.voG;
        d c = o.c(kVar);
        if (c == null) {
            x.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
            c = new b(kVar);
        }
        c.voC = this.voz;
        return c;
    }

    public void shutdown() {
        this.voy.shutdownNow();
        for (String str : this.voj.keySet()) {
            Future future = (Future) this.voj.get(str);
            if (future != null) {
                future.cancel(true);
            }
        }
        this.voi.clear();
        this.voj.clear();
    }
}
