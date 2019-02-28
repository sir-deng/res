package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.protocal.c.axw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class c extends l {
    private b gLB;
    private e gLE;
    public axl tiZ = null;

    public c(String str) {
        a aVar = new a();
        aVar.hnT = new axv();
        aVar.hnU = new axw();
        aVar.uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
        aVar.hnS = 1520;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        axv axv = (axv) this.gLB.hnQ.hnY;
        if (!bi.oN(str)) {
            axv.pgO = str;
        }
    }

    public final int getType() {
        return 1520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.gLE.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            axw axw = (axw) ((b) qVar).hnR.hnY;
            this.tiZ = axw.wLJ;
            if (axw.wLJ != null) {
                x.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + axw.wLJ.pgO);
            } else {
                x.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
            }
        }
    }
}
