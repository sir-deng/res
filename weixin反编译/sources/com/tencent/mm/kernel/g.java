package com.tencent.mm.kernel;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.n;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.api.b;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bw;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g {
    private static g gSo;
    public final a gRt = new a();
    public h<h> gSp;
    private ah gSq;
    private bw gSr = null;
    public e gSs;
    public a gSt;
    public b gSu;
    public final a gSv = new a();
    private final boolean gSw;
    private ConcurrentHashMap gSx = new ConcurrentHashMap();
    public volatile boolean gSy = false;

    private static class a extends com.tencent.mm.cc.a<com.tencent.mm.ad.n.a> implements com.tencent.mm.ad.n.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(final n nVar, final boolean z) {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.ad.n.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.ad.n.a) obj).a(nVar, z);
                }
            });
        }

        public final void a(final n nVar) {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.ad.n.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.ad.n.a) obj).a(nVar);
                }
            });
        }
    }

    private g(final h hVar) {
        this.gSp = h.d(hVar);
        this.gSw = ((h) this.gSp.Dn().CU()).DZ();
        if (this.gSw) {
            this.gSr = new bw();
            this.gSq = new ah("worker");
            this.gSq.F(new Runnable() {
                public final void run() {
                    ao.eU(ad.getContext());
                }
            });
        }
        this.gSp.Dm().gRK = new com.tencent.mm.kernel.c.a() {
            public final void b(f fVar) {
                g.this.a(hVar, (Object) fVar);
            }

            public final void a(com.tencent.mm.kernel.c.a aVar) {
                g.this.a(hVar, (Object) aVar);
                c.DA().aC(aVar);
            }

            public final void b(com.tencent.mm.kernel.c.a aVar) {
                g gVar = g.this;
                h hVar = hVar;
                c DA = c.DA();
                if (aVar instanceof com.tencent.mm.kernel.api.c) {
                    DA.gSZ.remove((com.tencent.mm.kernel.api.c) aVar);
                }
                if (aVar instanceof e) {
                    DA.gTa.remove((e) aVar);
                }
                if (aVar instanceof b) {
                    DA.gTb.remove((b) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.f) {
                    DA.gTc.remove((com.tencent.mm.kernel.api.f) aVar);
                }
                if (aVar instanceof ApplicationLifeCycle) {
                    hVar.gUw.remove((ApplicationLifeCycle) aVar);
                }
                if (aVar instanceof d) {
                    gVar.gRt.remove((d) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.g) {
                    gVar.gSp.b((com.tencent.mm.kernel.api.g) aVar);
                }
            }

            public final void c(f fVar) {
                c DA = c.DA();
                if (fVar != null) {
                    DA.aD(fVar);
                }
            }

            public final void c(com.tencent.mm.kernel.c.a aVar) {
                c DA = c.DA();
                if (aVar != null) {
                    DA.aD(aVar);
                }
            }
        };
    }

    public final void a(h hVar, Object obj) {
        if (this.gSx.containsKey(obj)) {
            x.i("MicroMsg.MMKernel", "Already add, skip it[%s].", obj);
        } else if (this.gSx.putIfAbsent(obj, this.gSx) != null) {
            x.i("MicroMsg.MMKernel", "Already add, skip[%s].", obj);
        } else {
            c.DA().add(obj);
            if (obj instanceof ApplicationLifeCycle) {
                hVar.gUw.aE((ApplicationLifeCycle) obj);
            }
            if (obj instanceof d) {
                this.gRt.aE((d) obj);
            }
            if (obj instanceof com.tencent.mm.kernel.api.g) {
                this.gSp.a((com.tencent.mm.kernel.api.g) obj);
            }
        }
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        this.gSp.a(gVar);
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        this.gSp.b(gVar);
    }

    public static c Dm() {
        Assert.assertNotNull("mCorePlugins not initialized!", Dr().gSp.Dm());
        return Dr().gSp.Dm();
    }

    public static d<h> Dn() {
        Assert.assertNotNull("mCoreProcess not initialized!", Dr().gSp.Dn());
        return Dr().gSp.Dn();
    }

    public static a Do() {
        Assert.assertNotNull("mCoreAccount not initialized!", Dr().gSt);
        return Dr().gSt;
    }

    public static b Dp() {
        Assert.assertNotNull("mCoreNetwork not initialized!", Dr().gSu);
        return Dr().gSu;
    }

    public static e Dq() {
        Assert.assertNotNull("mCoreStorage not initialized!", Dr().gSs);
        return Dr().gSs;
    }

    public static g Dr() {
        Assert.assertNotNull("Kernel not initialized by MMApplication!", gSo);
        return gSo;
    }

    public static <T extends com.tencent.mm.kernel.b.a> T k(Class<T> cls) {
        Dr();
        return Dm().k(cls);
    }

    public static <T extends com.tencent.mm.kernel.c.a> T h(Class<T> cls) {
        Dr();
        return Dm().h(cls);
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, N n) {
        Dr();
        Dm().a((Class) cls, new com.tencent.mm.kernel.c.d(n));
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        Dr();
        Dm().a((Class) cls, (com.tencent.mm.kernel.c.c) cVar);
    }

    public static void j(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        Dr();
        Dm().j(cls);
    }

    public static n CN() {
        Dr();
        return Dp().gRu;
    }

    public static bw Ds() {
        Assert.assertTrue(Dr().gSw);
        return Dr().gSr;
    }

    public static ah Dt() {
        Assert.assertTrue(Dr().gSw);
        return Dr().gSq;
    }

    public static synchronized void b(h hVar) {
        synchronized (g.class) {
            if (gSo != null) {
                h hVar2 = (h) gSo.gSp.Dn().CU();
                Application application = hVar.gUt;
                hVar2.gUv = hVar.gUv;
                hVar2.gUt = application;
                x.i("MicroMsg.MMKernel", "Kernel not null, has initialized.");
            } else {
                j.a(new com.tencent.mm.kernel.j.a() {
                    public final void e(String str, String str2, Object... objArr) {
                        x.e(str, str2, objArr);
                    }

                    public final void w(String str, String str2, Object... objArr) {
                        x.w(str, str2, objArr);
                    }

                    public final void i(String str, String str2, Object... objArr) {
                        x.i(str, str2, objArr);
                    }

                    public final void d(String str, String str2, Object... objArr) {
                        x.d(str, str2, objArr);
                    }

                    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                        x.printErrStackTrace(str, th, str2, objArr);
                    }
                });
                x.i("MicroMsg.MMKernel", "Initialize kernel, create whole WeChat world.");
                gSo = new g(hVar);
            }
        }
    }

    public static void gD(int i) {
        a Do = Do();
        if (a.gA(i) && a.gQV.Cn() == i && Do.CF()) {
            x.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", Integer.valueOf(i));
            return;
        }
        synchronized (Do.gQU) {
            a.gQV.eE(i);
            Do.Cu();
            Do.gRh = SystemClock.elapsedRealtime();
            Do.bx(true);
        }
    }

    public final void fO(String str) {
        x.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", o.getString(a.Cn()), str, bi.chl());
        a.fI(bi.chl().toString() + str);
        this.gSt.Cx().aS((long) a.Cn());
        releaseAll();
        a.Cs();
        a.by(false);
    }

    public final void releaseAll() {
        String str = "MicroMsg.MMKernel";
        String str2 = "release uin:%s ";
        Object[] objArr = new Object[1];
        objArr[0] = this.gSt != null ? o.getString(a.Cn()) : "-1";
        x.w(str, str2, objArr);
        if (this.gSu.gRu != null) {
            this.gSu.gRu.reset();
        }
        if (this.gSq != null) {
            this.gSq.a(new ah.b() {
                public final void Du() {
                    if (g.this.gSt != null) {
                        g.this.gSt.release();
                    }
                }
            });
        }
    }
}
