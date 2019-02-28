package com.tencent.mm.kernel;

import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class h<_Profile extends g> {
    private static h gSE;
    private c gSF = new c();
    private d<_Profile> gSG;
    public byte[] gSH = new byte[0];
    public volatile boolean gSI = false;
    public long gSJ;
    public a gSK = new a();

    /* renamed from: com.tencent.mm.kernel.h$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, Object> {
        final /* synthetic */ g ffq;
        final /* synthetic */ com.tencent.mm.kernel.a.a gSL;

        public AnonymousClass1(com.tencent.mm.kernel.a.a aVar, g gVar) {
            this.gSL = aVar;
            this.ffq = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.a aVar = this.gSL;
            com.tencent.mm.kernel.a.a.a("boot execute tasks...", new Object[0]);
            aVar.gSS.Dz();
            return zLb;
        }
    }

    /* renamed from: com.tencent.mm.kernel.h$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, Object> {
        final /* synthetic */ g ffq;
        final /* synthetic */ com.tencent.mm.kernel.a.a gSL;

        public AnonymousClass2(com.tencent.mm.kernel.a.a aVar, g gVar) {
            this.gSL = aVar;
            this.ffq = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.a aVar = this.gSL;
            g gVar = this.ffq;
            com.tencent.mm.kernel.a.a.a("boot execute extension... ", new Object[0]);
            aVar.gSS.b(gVar);
            return zLb;
        }
    }

    /* renamed from: com.tencent.mm.kernel.h$3 */
    class AnonymousClass3 implements b<Object> {
        final /* synthetic */ long gAc;

        public AnonymousClass3(long j) {
            this.gAc = j;
        }

        public final void aB(Object obj) {
            com.tencent.mm.blink.a.ee("executeBootExtension");
            synchronized (h.this.gSH) {
                h.this.gSI = true;
            }
            com.tencent.mm.kernel.a.a.a("summerboot mmskeleton boot startup finished in [%s]!", com.tencent.mm.kernel.a.a.aH(this.gAc));
            h.this.gSK.um();
            com.tencent.mm.blink.a.ee("onStartupDone");
            h.this.gSJ = System.currentTimeMillis();
        }
    }

    private static class a extends com.tencent.mm.cc.a<com.tencent.mm.kernel.api.g> implements com.tencent.mm.kernel.api.g {
        public a() {
            super(d.zLX);
        }

        public final void um() {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.kernel.api.g>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.g) obj).um();
                }
            });
        }

        public final void aI(final boolean z) {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.kernel.api.g>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.g) obj).aI(z);
                }
            });
        }
    }

    private h(_Profile _profile) {
        this.gSG = new d(_profile);
    }

    public final c Dm() {
        Assert.assertNotNull("mCorePlugins not initialized!", this.gSF);
        return this.gSF;
    }

    public final d<_Profile> Dn() {
        Assert.assertNotNull("mCoreProcess not initialized!", this.gSG);
        return this.gSG;
    }

    public static <_Profile extends g> h<_Profile> Dv() {
        Assert.assertNotNull("Skeleton not initialized!", gSE);
        return gSE;
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        Object obj = null;
        synchronized (this.gSH) {
            if (this.gSI) {
                obj = 1;
            }
        }
        if (obj != null) {
            gVar.um();
        } else {
            this.gSK.aE(gVar);
        }
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        this.gSK.remove(gVar);
    }

    public static synchronized <_Profile extends g> h<_Profile> d(_Profile _profile) {
        h<_Profile> hVar;
        synchronized (h.class) {
            if (gSE != null) {
                j.i("MicroMsg.MMSkeleton", "Kernel not null, has initialized.", new Object[0]);
                hVar = gSE;
            } else {
                j.i("MicroMsg.MMSkeleton", "Initialize skeleton, create whole world.", new Object[0]);
                hVar = new h(_profile);
                gSE = hVar;
            }
        }
        return hVar;
    }
}
