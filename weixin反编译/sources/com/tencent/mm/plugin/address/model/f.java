package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.protocal.c.bce;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public int iop = 0;

    public f(int i) {
        a aVar = new a();
        aVar.hnT = new bcd();
        aVar.hnU = new bce();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
        aVar.hnS = 416;
        aVar.hnV = 201;
        aVar.hnW = 1000000201;
        this.gLB = aVar.Kf();
        this.iop = i;
        x.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id " + i);
        ((bcd) this.gLB.hnQ.hnY).id = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bce bce = (bce) ((b) qVar).hnR.hnY;
            if (bce.wOW.wOZ != null) {
                x.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + bce.wOW.wOZ.size());
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().q(bce.wOW.wOZ);
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().XR();
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 416;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
