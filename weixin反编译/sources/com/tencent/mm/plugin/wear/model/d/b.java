package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.caw;
import com.tencent.mm.protocal.c.cax;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bb;

public final class b extends k implements com.tencent.mm.network.k {
    private e gLE;
    private com.tencent.mm.ad.b hGV;

    public b(String str) {
        a aVar = new a();
        aVar.uri = "/cgi-bin/micromsg-bin/sendyo";
        aVar.hnT = new caw();
        aVar.hnU = new cax();
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hGV = aVar.Kf();
        caw caw = (caw) this.hGV.hnQ.hnY;
        caw.npV = str;
        caw.wGf = caw.pgR;
        caw.pgR = (int) bb.hU(str);
        caw.kzz = 63;
        caw.xgX = 1;
        caw.kyA = 1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 976;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }
}
