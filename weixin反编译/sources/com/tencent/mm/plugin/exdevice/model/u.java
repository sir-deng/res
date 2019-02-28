package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfy;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends k implements com.tencent.mm.network.k {
    b gLB = null;
    private e gLE = null;

    public u(String str) {
        a aVar = new a();
        aVar.hnT = new bfy();
        aVar.hnU = new bfz();
        aVar.uri = "/cgi-bin/micromsg-bin/searchharddevice";
        aVar.hnS = 540;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((bfy) this.gLB.hnQ.hnY).wRP = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneSearchHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 540;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
