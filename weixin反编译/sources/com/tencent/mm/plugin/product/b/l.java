package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.protocal.c.bnw;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends com.tencent.mm.wallet_core.c.l implements k {
    private b gLB;
    private e gLE;
    public String pjR;

    public l(bke bke, String str) {
        a aVar = new a();
        aVar.hnT = new bnv();
        aVar.hnU = new bnw();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallorder";
        this.gLB = aVar.Kf();
        bnv bnv = (bnv) this.gLB.hnQ.hnY;
        bnv.wXG = bke;
        bnv.wXI = str;
    }

    public final int getType() {
        return 556;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        bnw bnw = (bnw) ((b) qVar).hnR.hnY;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + bnw.wXH);
            this.pjR = bnw.wXH;
        }
        x.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + i2 + ", errMsg " + str);
        this.gLE.a(i, i2, str, this);
    }
}
