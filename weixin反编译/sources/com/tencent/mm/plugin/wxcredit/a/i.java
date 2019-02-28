package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class i extends l {
    private b gLB;
    private e gLE;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new bde();
        aVar.hnU = new bdf();
        aVar.uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
        this.gLB = aVar.Kf();
        bde bde = (bde) this.gLB.hnQ.hnY;
        bde.wPR = str;
        bde.wPQ = bi.getInt(str2, 0);
        bde.vXW = com.tencent.mm.plugin.wallet_core.model.i.bLR();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return 600;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
