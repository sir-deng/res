package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bvb;
import com.tencent.mm.protocal.c.bvc;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public a(int i, long j, long j2, String str, int i2) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bvb();
        aVar.hnU = new bvc();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoiphangup";
        this.gLB = aVar.Kf();
        bvb bvb = (bvb) this.gLB.hnQ.hnY;
        bvb.wMS = i;
        bvb.xcP = j;
        bvb.wim = j2;
        bvb.xcQ = str;
        bvb.woI = i2;
        bvb.wMR = System.currentTimeMillis();
    }

    public final int getType() {
        return 880;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }
}
