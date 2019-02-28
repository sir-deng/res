package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.byh;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;
    public byg nLo = null;
    public byh nLp = null;

    public j(String str) {
        a aVar = new a();
        aVar.hnT = new byg();
        aVar.hnU = new byh();
        aVar.hnS = 277;
        aVar.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nLo = (byg) this.gLB.hnQ.hnY;
        this.nLo.vPI = str;
        x.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", this.nLo.vPI);
    }

    public final int getType() {
        return 277;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLp = (byh) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
