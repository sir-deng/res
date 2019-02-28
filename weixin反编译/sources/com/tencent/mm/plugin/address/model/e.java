package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcb;
import com.tencent.mm.protocal.c.bcc;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    public String fqG;
    private b gLB;
    private com.tencent.mm.ad.e gLE;
    public boolean ioo;
    public String username;

    public e(String str, String str2, int i) {
        a aVar = new a();
        aVar.hnT = new bcb();
        aVar.hnU = new bcc();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
        this.gLB = aVar.Kf();
        bcb bcb = (bcb) this.gLB.hnQ.hnY;
        bcb.cRQ = 0;
        bcb.wPj = str;
        bcb.fGh = str2;
        bcb.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        boolean z = true;
        x.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bcc bcc = (bcc) ((b) qVar).hnR.hnY;
            this.username = bcc.mcb;
            this.fqG = bcc.wPm;
            if (bcc.wPl != 1) {
                z = false;
            }
            this.ioo = z;
            if (bcc.wOW.wOZ != null) {
                x.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + bcc.wOW.wOZ.size());
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().q(bcc.wOW.wOZ);
                com.tencent.mm.plugin.address.a.a.XN();
                com.tencent.mm.plugin.address.a.a.XP().XR();
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 417;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
