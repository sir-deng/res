package com.tencent.mm.ad;

import com.tencent.mm.cc.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import junit.framework.Assert;

public class a<_Resp extends bek> {
    public b gLB;
    b<_Resp> hnG = new b(this);
    private f<a<_Resp>> hnH;

    public static class a<T extends bek> {
        public int errCode;
        public int errType;
        public T fKE;
        public String foE;
        public k frW;
        public a hnJ;

        public static <T extends bek> a<T> a(int i, int i2, String str, T t, k kVar, a aVar) {
            a<T> aVar2 = new a();
            aVar2.errType = i;
            aVar2.errCode = i2;
            aVar2.foE = str;
            aVar2.fKE = t;
            aVar2.frW = kVar;
            aVar2.hnJ = aVar;
            if (aVar != null) {
                aVar.a(i, i2, str, t, kVar);
            }
            return aVar2;
        }
    }

    private static class b<_Resp extends bek> extends k {
        e gQm = null;
        final k hnK = this;
        b hnL;
        com.tencent.mm.vending.g.b hnM;
        a hnN;
        private k hnO = new k() {
            public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
                com.tencent.mm.vending.g.b bVar = b.this.hnM;
                Object[] objArr = new Object[1];
                objArr[0] = a.a(i2, i3, str, (bek) b.this.hnL.hnR.hnY, b.this, b.this.hnN);
                g.a(bVar, objArr);
                b.this.gQm.a(i2, i3, str, b.this.hnK);
                x.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(b.this.hnK.hashCode()), Integer.valueOf(b.this.getType()), Long.valueOf(bi.Wy() - b.this.mStartTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
            }
        };
        final long mStartTime = bi.Wy();

        public b(a aVar) {
            this.hnN = aVar;
        }

        protected final int Bo() {
            return 1;
        }

        public final int getType() {
            return this.hnL.hnS;
        }

        public final int a(e eVar, e eVar2) {
            this.gQm = eVar2;
            int a = a(eVar, this.hnL, this.hnO);
            x.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.hnK.hashCode()), Integer.valueOf(this.hnL.hnS), Integer.valueOf(a), Long.valueOf(bi.Wy() - this.mStartTime));
            if (a < 0) {
                g.a(this.hnM, a.a(3, -1, "", (bek) this.hnL.hnR.hnY, this, this.hnN));
            }
            return a;
        }
    }

    public synchronized f<a<_Resp>> Kb() {
        Assert.assertNotNull("You should set a CommReqResp!", this.gLB);
        Assert.assertTrue("RunCgi NetSceneQueue not ready!", u.La());
        if (this.hnH == null) {
            this.hnH = com.tencent.mm.cc.g.c(new com.tencent.mm.vending.g.c.a<a<_Resp>>() {
                public final /* synthetic */ Object call() {
                    com.tencent.mm.vending.g.b cAO = g.cAO();
                    a.this.hnG.hnM = cAO;
                    a.this.hnG.hnL = a.this.gLB;
                    if (!u.hpw.CO().a(a.this.hnG, 0)) {
                        x.e("MicroMsg.Cgi", "RunCgi doScene failed!");
                        g.a(cAO);
                    }
                    return null;
                }
            });
        }
        return this.hnH;
    }

    public void a(int i, int i2, String str, _Resp _resp, k kVar) {
    }
}
