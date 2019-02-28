package com.tencent.mm.kernel;

import com.tencent.mm.ad.n;
import com.tencent.mm.ad.u;
import com.tencent.mm.f.a.kd;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ah;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    private static ah gRx = null;
    public final a gRt;
    public final n gRu;
    private HashSet<com.tencent.mm.network.n> gRv = new HashSet();
    public com.tencent.mm.network.n gRw = new com.tencent.mm.network.n.a() {
        public final void eq(int i) {
            try {
                HashSet hashSet = new HashSet();
                synchronized (b.this.gRv) {
                    hashSet.addAll(b.this.gRv);
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.network.n) it.next()).eq(i);
                }
            } catch (final Throwable e) {
                x.printErrStackTrace("MMKernel.CoreNetwork", e, "onNetworkChange caught crash", new Object[0]);
                new ag().post(new Runnable() {
                    public final void run() {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    };

    static class a extends com.tencent.mm.cc.a<d> implements d {
        a() {
        }

        public final void b(final e eVar) {
            a(new com.tencent.mm.cc.a.a<d>() {
                public final /* synthetic */ void az(Object obj) {
                    ((d) obj).b(eVar);
                }
            });
        }
    }

    public b(com.tencent.mm.ad.n.a aVar, a aVar2) {
        this.gRu = n.a(aVar);
        this.gRu.hoG = g.Dt();
        u.hpw = new com.tencent.mm.ad.u.b() {
            public final n CO() {
                return b.this.gRu;
            }
        };
        this.gRt = aVar2;
    }

    public final void a(com.tencent.mm.network.n nVar) {
        synchronized (this.gRv) {
            this.gRv.add(nVar);
        }
    }

    public final void b(com.tencent.mm.network.n nVar) {
        synchronized (this.gRv) {
            this.gRv.remove(nVar);
        }
    }

    public static ah CL() {
        return gRx;
    }

    public static void a(ah ahVar) {
        gRx = ahVar;
    }

    public final byte[] CM() {
        try {
            if (this.gRu == null || this.gRu.hoF == null || this.gRu.hoF.KD() == null) {
                return null;
            }
            return this.gRu.hoF.KD().CM();
        } catch (Throwable e) {
            x.w("MMKernel.CoreNetwork", "get session key error, %s", e.getMessage());
            x.e("MMKernel.CoreNetwork", "exception:%s", bi.i(e));
            return null;
        }
    }

    public final n CN() {
        return this.gRu;
    }

    public static void a(int i, int i2, boolean z, String str) {
        com.tencent.mm.sdk.b.b kdVar = new kd();
        kdVar.fCm.status = i;
        kdVar.fCm.fCn = i2;
        kdVar.fCm.fCo = z;
        kdVar.fCm.fCp = str;
        com.tencent.mm.sdk.b.a.xmy.m(kdVar);
    }
}
