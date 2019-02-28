package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class a extends l {
    private b gLB;
    private e gLE;

    public final int getType() {
        return 1554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayUCheckJsApi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        axq axq = (axq) ((b) qVar).hnR.hnY;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetScenePayUCheckJsApi", "rr " + axq.lUc);
        }
        this.gLE.a(i, i2, axq.lUd, this);
    }
}
