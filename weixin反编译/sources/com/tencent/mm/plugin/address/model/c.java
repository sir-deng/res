package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbv;
import com.tencent.mm.protocal.c.bbw;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public c(com.tencent.mm.plugin.address.d.b bVar) {
        a aVar = new a();
        aVar.hnT = new bbv();
        aVar.hnU = new bbw();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
        this.gLB = aVar.Kf();
        bbv bbv = (bbv) this.gLB.hnQ.hnY;
        bbv.wOV = new bca();
        bbv.wOV.wPc = new bet().Vf(bi.aD(bVar.ioG, ""));
        bbv.wOV.wPa = new bet().Vf(bi.aD(bVar.ioE, ""));
        bbv.wOV.wPf = new bet().Vf(bi.aD(bVar.ioJ, ""));
        bbv.wOV.wPd = new bet().Vf(bi.aD(bVar.ioH, ""));
        bbv.wOV.wPg = new bet().Vf(bi.aD(bVar.ioK, ""));
        bbv.wOV.wPh = new bet().Vf(bi.aD(bVar.ioL, ""));
        bbv.wOV.wPb = new bet().Vf(bi.aD(bVar.ioF, ""));
        bbv.wOV.wPe = new bet().Vf(bi.aD(bVar.ioI, ""));
        bbv.wOV.wPi = new bet().Vf(bi.aD(bVar.ioM, ""));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bbw bbw = (bbw) ((b) qVar).hnR.hnY;
            if (bbw.wOW.wOZ != null) {
                x.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + bbw.wOW.wOZ.size());
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().q(bbw.wOW.wOZ);
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().XR();
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 415;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
