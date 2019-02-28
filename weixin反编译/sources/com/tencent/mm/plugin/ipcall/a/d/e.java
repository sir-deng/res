package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private com.tencent.mm.ad.e gLE = null;
    private ail nLd = null;
    public aim nLe = null;

    public e() {
        a aVar = new a();
        aVar.hnT = new ail();
        aVar.hnU = new aim();
        aVar.hnS = 831;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcopackageproductlist";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nLd = (ail) this.gLB.hnQ.hnY;
        x.i("MicroMsg.NetSceneIPCallGetPackageProductList", "NetSceneIPCallGetPackageProductList");
    }

    public final int getType() {
        return 831;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetPackageProductList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLe = (aim) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
