package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.ct;
import com.tencent.mm.protocal.c.cu;

public final class x extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    int vlk;
    w vll;

    public x(int i, w wVar) {
        this.vlk = i;
        a aVar = new a();
        aVar.hnT = new ct();
        aVar.hnU = new cu();
        aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
        this.gLB = aVar.Kf();
        ct ctVar = (ct) this.gLB.hnQ.hnY;
        byte[] aRE = wVar.aRE();
        if (aRE != null) {
            ctVar.vOw = new bes().bl(aRE);
        }
        ctVar.kzz = i;
        this.vll = wVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.vll.az(n.a(((cu) this.gLB.hnR.hnY).vOx));
            this.vll.a(i, i2, i3, str, this.gLB, bArr);
            this.gLE.a(i2, i3, str, this);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 452;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
