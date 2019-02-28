package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.protocal.c.bnt;
import com.tencent.mm.protocal.c.bnu;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public String pjR;

    public k(bke bke) {
        a aVar = new a();
        aVar.hnT = new bnt();
        aVar.hnU = new bnu();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
        this.gLB = aVar.Kf();
        ((bnt) this.gLB.hnQ.hnY).wXG = bke;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bnu bnu = (bnu) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + bnu.wXH);
            this.pjR = bnu.wXH;
        }
        x.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + i3 + ", errMsg " + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 557;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
