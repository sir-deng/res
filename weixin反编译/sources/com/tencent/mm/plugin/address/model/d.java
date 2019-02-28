package com.tencent.mm.plugin.address.model;

import com.tencent.mm.a.o;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbx;
import com.tencent.mm.protocal.c.bby;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public int status;

    public d(String str, String str2, o oVar) {
        boolean z = true;
        a aVar = new a();
        aVar.hnT = new bbx();
        aVar.hnU = new bby();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
        String str3 = "MicroMsg.NetSceneRcptInfoImportYiXun";
        StringBuilder append = new StringBuilder("a2key is ").append(!bi.oN(str)).append(", newa2key is ");
        if (bi.oN(str2)) {
            z = false;
        }
        x.d(str3, append.append(z).toString());
        this.gLB = aVar.Kf();
        bbx bbx = (bbx) this.gLB.hnQ.hnY;
        bbx.vPZ = new bes().bl(bi.Wj(str));
        bbx.wOX = new bes().bl(bi.Wj(str2));
        bbx.cEt = oVar.intValue();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bby bby = (bby) ((b) qVar).hnR.hnY;
            this.status = bby.wOY;
            x.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
            if (bby.wOW.wOZ != null && this.status == 0) {
                x.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + bby.wOW.wOZ.size());
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().q(bby.wOW.wOZ);
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().XR();
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 582;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
