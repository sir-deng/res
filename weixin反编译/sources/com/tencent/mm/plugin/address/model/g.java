package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.protocal.c.bcg;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public g(int i) {
        a aVar = new a();
        aVar.hnT = new bcf();
        aVar.hnU = new bcg();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
        aVar.hnV = d.CTRL_INDEX;
        aVar.hnW = 1000000204;
        this.gLB = aVar.Kf();
        ((bcf) this.gLB.hnQ.hnY).id = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bcg bcg = (bcg) ((b) qVar).hnR.hnY;
            if (bcg.wOW.wOZ != null) {
                x.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + bcg.wOW.wOZ.size());
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().q(bcg.wOW.wOZ);
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().XR();
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 419;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
