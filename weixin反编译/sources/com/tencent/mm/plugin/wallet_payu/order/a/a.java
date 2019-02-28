package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axo;
import com.tencent.mm.protocal.c.axp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class a extends l {
    public b gLB;
    private e gLE;

    public a(int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new axo();
        aVar.hnU = new axp();
        aVar.uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
        this.gLB = aVar.Kf();
        axo axo = (axo) this.gLB.hnQ.hnY;
        axo.nol = 10;
        axo.vUN = i;
        x.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10" + ",offset:" + i);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.gLE.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((axp) ((b) qVar).hnR.hnY).wLG);
        }
    }

    public final int bOj() {
        return ((axp) this.gLB.hnR.hnY).wLG;
    }

    public final int getType() {
        return 1519;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
