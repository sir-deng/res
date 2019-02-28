package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g;

public final class u extends g {
    public akb oiH;

    public u(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new aka();
        aVar.hnU = new akb();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        aka aka = (aka) this.gLB.hnQ.hnY;
        aka.oeH = str;
        aka.lnQ = str2;
        aka.oje = str3;
        x.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", str, str3);
    }

    protected final void b(int i, int i2, String str, q qVar) {
        this.oiH = (akb) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", Integer.valueOf(this.oiH.lot), this.oiH.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        akb akb = (akb) ((b) qVar).hnR.hnY;
        this.zQy = akb.lot;
        this.zQz = akb.lou;
    }

    public final int getType() {
        return 2929;
    }
}
