package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.g;
import com.tencent.mm.protocal.c.bvi;
import com.tencent.mm.protocal.c.bvj;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public d(long j, long j2) {
        a aVar = new a();
        aVar.hnT = new bvi();
        aVar.hnU = new bvj();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipredirect";
        aVar.hnS = g.CTRL_INDEX;
        this.gLB = aVar.Kf();
        bvi bvi = (bvi) this.gLB.hnQ.hnY;
        bvi.xcP = j;
        bvi.wim = j2;
        bvi.wMR = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
