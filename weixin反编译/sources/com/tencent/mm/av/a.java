package com.tencent.mm.av;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.protocal.c.bac;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    boolean hJN = false;
    int hJO = 0;

    public a(int i, int i2, String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bab();
        aVar.hnU = new bac();
        aVar.uri = "/cgi-bin/micromsg-bin/pushnewtips";
        aVar.hnS = 597;
        this.gLB = aVar.Kf();
        bab bab = (bab) this.gLB.hnQ.hnY;
        bab.wNz = i;
        bab.wNA = i2;
        bab.vUa = str;
        this.hJO = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            this.hJN = ((bac) ((b) qVar).hnR.hnY).wNB;
            this.gLE.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetScenePushNewTips", "errType:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 597;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetScenePushNewTips", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
