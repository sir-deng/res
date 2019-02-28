package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends k implements com.tencent.mm.network.k {
    private g rYi;

    private class a implements a {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final void bDu() {
            d.this.aLm();
        }

        public final void yq(int i) {
            d.this.cC(3, i);
        }
    }

    public abstract void aLm();

    public abstract void cC(int i, int i2);

    public abstract void d(int i, int i2, String str, q qVar);

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        boolean z = true;
        x.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.rYi = new g(new a());
        this.rYi.rYl = -3202;
        g gVar = this.rYi;
        if (i2 == 4 && i3 == -3200) {
            com.tencent.d.b.a.a(new b<c>() {
                public final /* synthetic */ void a(e eVar) {
                    c cVar = (c) eVar;
                    x.i("MicroMsg.SoterNetDelegateUtil", "generate and upload ask onResult errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.foE);
                    if (!cVar.isSuccess()) {
                        a.dQ(1, cVar.errCode);
                        if (g.this.rYk != null) {
                            g.this.rYk.yq(cVar.errCode);
                        }
                    } else if (g.this.rYk != null) {
                        g.this.rYk.bDu();
                    }
                }
            }, true, new e());
        } else if (i2 != 4 || i3 != gVar.rYl) {
            z = false;
        } else if (gVar.rYk != null) {
            gVar.rYk.bDu();
        }
        if (!z) {
            d(i2, i3, str, qVar);
        }
    }
}
