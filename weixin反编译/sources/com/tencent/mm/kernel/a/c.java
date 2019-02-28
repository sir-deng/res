package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ag;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class c implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, f {
    private static c gTd = new c();
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> gTg = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            if (aVar.gUf.gTI == com.tencent.mm.kernel.b.b.class) {
                com.tencent.mm.kernel.b.f fVar = (com.tencent.mm.kernel.b.f) aVar.gTE;
                if (fVar.isConfigured()) {
                    x.i("MicroMsg.CallbacksProxy", "skip configure for plugin %s.", fVar);
                } else {
                    x.i("MicroMsg.CallbacksProxy", "configuring plugin [%s]...", fVar);
                    fVar.invokeConfigure(g.Dn().CU());
                }
            }
            return zLb;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> gTh = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            if (aVar.gUf.gTI == com.tencent.mm.kernel.a.c.b.class) {
                c.a((com.tencent.mm.kernel.a.c.b) aVar.gTE, g.Dn().CU());
            }
            return zLb;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> gTi = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            x.i("MicroMsg.CallbacksProxy", "before running %s", aVar.gTE);
            if (aVar.gUf.gTI == h.class) {
                ((h) aVar.gTE).Dx();
            } else if (aVar.gUf.gTI == com.tencent.mm.kernel.api.a.class) {
                g.Dq().a(g.Dq().gRU.clJ(), ((com.tencent.mm.kernel.api.a) aVar.gTE).collectDatabaseFactory());
            } else if (aVar.gUf.gTI == com.tencent.mm.kernel.api.e.class) {
                ((com.tencent.mm.kernel.api.e) aVar.gTE).onDataBaseOpened(g.Dq().gRU, g.Dq().gRV);
            } else if (aVar.gUf.gTI == ag.class) {
                g.Dq().a((ag) aVar.gTE);
            } else if (aVar.gUf.gTI == com.tencent.mm.kernel.api.c.class) {
                ((com.tencent.mm.kernel.api.c) aVar.gTE).onAccountInitialized(g.Do().gQZ);
            }
            x.i("MicroMsg.CallbacksProxy", "[account-init] for phase(%s) subject(%s)", aVar.gUf.gTI, aVar.gTE);
            return zLb;
        }
    };
    private static Map<Integer, Map> gTj = new ConcurrentHashMap();
    private boolean gSV = true;
    public final com.tencent.mm.kernel.a.b.g gSW = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g gSX = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g gSY = new com.tencent.mm.kernel.a.b.g();
    public final b gSZ = new b();
    public final c gTa = new c();
    public final a gTb = new a();
    public final d gTc = new d();
    public volatile boolean gTe = false;
    private AtomicBoolean gTf = new AtomicBoolean(false);
    private Set<Looper> gTk = new HashSet();
    private ConcurrentHashMap<Object, e> gTl = new ConcurrentHashMap();
    public ConcurrentHashMap gTm = new ConcurrentHashMap();

    private static final class e {
        private long gTy;
        private int mStatus;

        public e() {
            this.gTy = 0;
            this.mStatus = 0;
            this.gTy = Thread.currentThread().getId();
        }

        public final synchronized boolean DC() {
            boolean z = false;
            synchronized (this) {
                if (!(this.mStatus == 1 && this.gTy == Thread.currentThread().getId())) {
                    if (this.mStatus != 2) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public final synchronized void gE(int i) {
            if (i > this.mStatus) {
                this.mStatus = i;
            }
        }
    }

    static class a extends com.tencent.mm.cc.a<com.tencent.mm.kernel.api.b> implements com.tencent.mm.kernel.api.b {
        private boolean gTo = false;

        a() {
        }

        public final /* synthetic */ com.tencent.mm.vending.b.b aE(Object obj) {
            return a((com.tencent.mm.kernel.api.b) obj);
        }

        public final synchronized com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> a(com.tencent.mm.kernel.api.b bVar) {
            com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> aE;
            aE = super.aE(bVar);
            if (this.gTo) {
                List collectStoragePaths = bVar.collectStoragePaths();
                if (collectStoragePaths != null && collectStoragePaths.size() > 0) {
                    b(collectStoragePaths, g.Dq().gRT);
                }
                x.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", bVar);
            }
            return aE;
        }

        public final List<String> collectStoragePaths() {
            LinkedList cAE = cAE();
            List<String> linkedList = new LinkedList();
            Iterator it = cAE.iterator();
            while (it.hasNext()) {
                com.tencent.mm.vending.b.b bVar = (com.tencent.mm.vending.b.b) it.next();
                if (bVar != null) {
                    Collection collectStoragePaths = ((com.tencent.mm.kernel.api.b) bVar.zKW).collectStoragePaths();
                    if (collectStoragePaths != null) {
                        linkedList.addAll(collectStoragePaths);
                    }
                }
            }
            return linkedList;
        }

        public final synchronized void fQ(String str) {
            List collectStoragePaths = collectStoragePaths();
            this.gTo = true;
            x.i("MicroMsg.CallbacksProxy", "all account storage folder %s", collectStoragePaths.toString());
            b(collectStoragePaths, str);
        }

        private static void b(List<String> list, String str) {
            int i = 0;
            String[] strArr = new String[(list.size() + 1)];
            strArr[0] = str;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    strArr[i2 + 1] = str + ((String) list.get(i2));
                    i = i2 + 1;
                } else {
                    com.tencent.mm.a.e.c(strArr);
                    return;
                }
            }
        }
    }

    private static class b extends com.tencent.mm.cc.a<com.tencent.mm.kernel.api.c> implements com.tencent.mm.kernel.api.c {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void onAccountInitialized(final com.tencent.mm.kernel.e.c cVar) {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.kernel.api.c>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.c) obj).onAccountInitialized(cVar);
                }
            });
        }

        public final void onAccountRelease() {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.kernel.api.c>() {
                public final /* synthetic */ void az(Object obj) {
                    com.tencent.mm.kernel.api.c cVar = (com.tencent.mm.kernel.api.c) obj;
                    if (c.a(c.DA().gSY, com.tencent.mm.kernel.api.c.class, cVar)) {
                        cVar.onAccountRelease();
                    }
                }
            });
        }
    }

    static class c extends com.tencent.mm.cc.a<com.tencent.mm.kernel.api.e> implements com.tencent.mm.kernel.api.e {
        c() {
        }

        public final void onDataBaseOpened(final com.tencent.mm.bx.h hVar, final com.tencent.mm.bx.h hVar2) {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.kernel.api.e>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseOpened(hVar, hVar2);
                }
            });
        }

        public final void onDataBaseClosed(final com.tencent.mm.bx.h hVar, final com.tencent.mm.bx.h hVar2) {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.kernel.api.e>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseClosed(hVar, hVar2);
                }
            });
        }
    }

    static class d extends com.tencent.mm.cc.a<f> implements f {
        private boolean gTu = false;
        private String gTv;

        d() {
        }

        public final /* synthetic */ com.tencent.mm.vending.b.b aE(Object obj) {
            return a((f) obj);
        }

        public final void Dw() {
            a(new com.tencent.mm.cc.a.a<f>() {
                public final /* synthetic */ void az(Object obj) {
                    ((f) obj).Dw();
                }
            });
        }

        public final synchronized com.tencent.mm.vending.b.b<f> a(f fVar) {
            com.tencent.mm.vending.b.b<f> aE;
            aE = super.aE(fVar);
            if (this.gTu) {
                fVar.fP(this.gTv);
                x.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", fVar);
            }
            return aE;
        }

        public final synchronized void fP(final String str) {
            a(new com.tencent.mm.cc.a.a<f>() {
                public final /* synthetic */ void az(Object obj) {
                    ((f) obj).fP(str);
                }
            });
            this.gTu = true;
            this.gTv = str;
        }
    }

    static /* synthetic */ void a(com.tencent.mm.kernel.a.c.b bVar, com.tencent.mm.kernel.b.g gVar) {
        if (gTj.containsKey(Integer.valueOf(bVar.hashCode()))) {
            a.a("skip task %s execution hash %s", bVar.name(), Integer.valueOf(bVar.hashCode()));
            return;
        }
        bVar.execute(gVar);
        gTj.put(Integer.valueOf(bVar.hashCode()), gTj);
        a.a("boot task executing [%s] hash %s...", bVar.name(), Integer.valueOf(bVar.hashCode()));
    }

    private c() {
    }

    public static c DA() {
        return gTd;
    }

    public static boolean a(com.tencent.mm.kernel.a.b.g gVar, Class cls, Object obj) {
        com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) gVar.p(cls).aG(obj);
        if (aVar == null) {
            return false;
        }
        return aVar.gTF;
    }

    public final void aC(Object obj) {
        if (!((com.tencent.mm.kernel.b.h) g.Dn().CU()).DZ()) {
            x.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
        } else if (com.tencent.mm.kernel.f.aA(obj)) {
            x.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
        } else {
            this.gSY.aL(obj);
        }
    }

    public final void Dw() {
        this.gTc.Dw();
    }

    public final void fP(String str) {
        this.gTb.fQ(str);
        this.gTc.fP(str);
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (this.gSV) {
            com.tencent.mm.blink.a.ee("beforeAccountInit");
            this.gSY.b(com.tencent.mm.kernel.api.c.class, true);
            com.tencent.mm.kernel.a.b.e DL = com.tencent.mm.kernel.a.b.e.DL();
            DL.a(new com.tencent.mm.kernel.a.b.e.b(), gTi, this.gSY);
            this.gSY.DX();
            DL.start("account-init from onAccountInitialized");
            DL.DN();
            return;
        }
        this.gSZ.onAccountInitialized(cVar);
    }

    public final void onAccountRelease() {
        this.gSZ.onAccountRelease();
        this.gSY.b(h.class, true);
    }

    public final void onDataBaseOpened(com.tencent.mm.bx.h hVar, com.tencent.mm.bx.h hVar2) {
        if (!this.gSV) {
            this.gTa.onDataBaseOpened(hVar, hVar2);
        }
    }

    public final void onDataBaseClosed(com.tencent.mm.bx.h hVar, com.tencent.mm.bx.h hVar2) {
        this.gTa.onDataBaseClosed(hVar, hVar2);
    }

    public final void add(Object obj) {
        if (obj instanceof com.tencent.mm.kernel.api.c) {
            this.gSZ.aE((com.tencent.mm.kernel.api.c) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.e) {
            this.gTa.aE((com.tencent.mm.kernel.api.e) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.b) {
            this.gTb.a((com.tencent.mm.kernel.api.b) obj);
        }
        if (obj instanceof f) {
            this.gTc.a((f) obj);
        }
    }

    public final void b(Looper looper) {
        x.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", looper);
        this.gTk.add(looper);
    }

    public final void aD(Object obj) {
        if (this.gTf.get() && !this.gTe) {
            int i;
            if (!((com.tencent.mm.kernel.b.h) g.Dn().CU()).DZ()) {
                i = 0;
            } else if (this.gTk.contains(Looper.myLooper())) {
                x.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", Looper.myLooper());
                i = 0;
            } else if (g.Dr().gSp.gSI) {
                i = 1;
            } else {
                x.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
                i = 0;
            }
            if (i == 0) {
                x.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", obj);
                return;
            }
            if (!this.gTl.containsKey(obj)) {
                this.gTl.putIfAbsent(obj, new e());
            }
            e eVar = (e) this.gTl.get(obj);
            if (eVar.DC()) {
                long currentTimeMillis = System.currentTimeMillis();
                x.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", obj);
                x.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
                a aVar = (a) this.gSY.gUp.get(obj);
                int i2 = (aVar == null || !aVar.DY()) ? 0 : 1;
                if (i2 == 0) {
                    x.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
                    this.gSY.aL(obj);
                }
                try {
                    com.tencent.mm.kernel.a.b.f.a aK;
                    eVar.gE(1);
                    if (obj instanceof com.tencent.mm.kernel.b.f) {
                        if (!((com.tencent.mm.kernel.b.f) obj).isConfigured()) {
                            aK = this.gSX.p(com.tencent.mm.kernel.b.b.class).aK((com.tencent.mm.kernel.b.b) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gTg);
                        }
                        aK = this.gSW.p(com.tencent.mm.kernel.a.c.b.class).aK((com.tencent.mm.kernel.a.c.b) obj);
                        Assert.assertNotNull(aK);
                        aK.a(gTh);
                    }
                    if (g.Do().CF()) {
                        if (obj instanceof h) {
                            aK = this.gSY.p(h.class).aK((h) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gTi);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.a) {
                            aK = this.gSY.p(com.tencent.mm.kernel.api.a.class).aK((com.tencent.mm.kernel.api.a) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gTi);
                        }
                        if (obj instanceof ag) {
                            aK = this.gSY.p(ag.class).aK((ag) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gTi);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.e) {
                            aK = this.gSY.p(com.tencent.mm.kernel.api.e.class).aK((com.tencent.mm.kernel.api.e) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gTi);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.c) {
                            aK = this.gSY.p(com.tencent.mm.kernel.api.c.class).aK((com.tencent.mm.kernel.api.c) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gTi);
                        }
                        eVar.gE(2);
                        x.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    x.i("MicroMsg.CallbacksProxy", "account not init, return.");
                    eVar.gE(2);
                    x.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    eVar.gE(2);
                    x.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    public final void DB() {
        com.tencent.mm.blink.a.ee("initializePendingPlugins");
        if (this.gTf.compareAndSet(false, true)) {
            x.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
            c cVar = gTd;
            for (com.tencent.mm.kernel.b.f aC : g.Dm().CT()) {
                cVar.aC(aC);
            }
            com.tencent.mm.blink.a.ee("makePluginsParallelsDependency");
            for (Object next : this.gTm.keySet()) {
                g.Dr().a((com.tencent.mm.kernel.b.h) g.Dn().CU(), next);
                gTd.aC(next);
            }
            com.tencent.mm.blink.a.ee("configureAndExecutePendingPlugins");
            this.gSX.b(com.tencent.mm.kernel.b.b.class, false);
            com.tencent.mm.kernel.a.b.e.DL().a(new com.tencent.mm.kernel.a.b.e.b(), gTg, this.gSX, "configure-functional from pending plugins");
            this.gSW.b(com.tencent.mm.kernel.a.c.b.class, false);
            com.tencent.mm.kernel.a.b.e.DL().a(new com.tencent.mm.kernel.a.b.e.b(), gTh, this.gSW, "task-functional from pending plugins");
            com.tencent.mm.blink.a.ee("configureAndExecutePendingPlugins done");
            if (((com.tencent.mm.kernel.b.h) g.Dn().CU()).DZ() && g.Do().CF()) {
                this.gSY.b(h.class, false);
                com.tencent.mm.kernel.a.b.e DL = com.tencent.mm.kernel.a.b.e.DL();
                DL.a(new com.tencent.mm.kernel.a.b.e.b(), gTi, this.gSY);
                this.gSY.DX();
                DL.start("account-init from pending plugins");
                DL.DN();
            }
            this.gTe = true;
            if (((com.tencent.mm.kernel.b.h) g.Dn().CU()).DZ()) {
                g.Do().Cw();
            }
            com.tencent.mm.blink.a.ee("initializePendingPlugins done");
            if ((com.tencent.mm.protocal.d.vHo || com.tencent.mm.protocal.d.vHn) && ((com.tencent.mm.kernel.b.h) g.Dn().CU()).DZ() && g.Do().CF()) {
                a(this.gSW);
                a(this.gSX);
                a(this.gSY);
            }
            com.tencent.mm.blink.a.ee("checkAllUnConsumed done");
        }
    }

    private static void a(com.tencent.mm.kernel.a.b.g gVar) {
        Map hashMap = new HashMap();
        for (com.tencent.mm.kernel.a.b.f fVar : gVar.gUj.values()) {
            List DR = fVar.DR();
            if (DR.size() > 0) {
                hashMap.put(fVar, DR);
            }
        }
        String str = "MicroMsg.CallbacksProxy";
        String str2 = "do parallels result check, %s for %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(hashMap.size() > 0);
        objArr[1] = gVar;
        x.i(str, str2, objArr);
        if (hashMap.size() > 0) {
            com.tencent.mm.blink.a.j(0, 1);
            Map hashMap2 = new HashMap();
            String str3 = "BlinkStartup";
            StringBuilder stringBuilder = new StringBuilder();
            for (com.tencent.mm.kernel.a.b.f fVar2 : hashMap.keySet()) {
                List list = (List) hashMap.get(fVar2);
                stringBuilder.append(fVar2.gTY);
                stringBuilder.append(" : ");
                stringBuilder.append(list.toString());
                stringBuilder.append("\n");
            }
            x.e("MicroMsg.CallbacksProxy", "unconsumed message %s", stringBuilder.toString());
            x.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
            com.tencent.mm.plugin.report.d.pVE.c(str3, r0, hashMap2);
        }
    }
}
