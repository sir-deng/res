package com.tencent.mm.as;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hb;
import com.tencent.mm.protocal.c.hc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new hb();
        aVar.hnU = new hc();
        aVar.uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
        this.gLB = aVar.Kf();
        hb hbVar = (hb) this.gLB.hnQ.hnY;
        hbVar.vQC = 1;
        hbVar.vSK = i;
        hbVar.vSL = str;
        hbVar.vSM = str2;
        hbVar.vSN = str3;
        hbVar.vSO = str4;
        hbVar.vSP = str5;
        hbVar.vSQ = str6;
        hbVar.vSR = str7;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 549;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        hb hbVar = (hb) this.gLB.hnQ.hnY;
        if (i2 == 0 && i3 == 0) {
            as.Hm();
            c.Db().set(286722, hbVar.vSM);
            as.Hm();
            c.Db().set(286721, hbVar.vSL);
            as.Hm();
            c.Db().set(286723, hbVar.vSN);
        }
        this.gLE.a(i2, i3, str, this);
    }
}
