package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bvd;
import com.tencent.mm.protocal.c.bve;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.b gLB;
    private e gLE;

    public b(long j, long j2) {
        a aVar = new a();
        aVar.hnT = new bvd();
        aVar.hnU = new bve();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
        this.gLB = aVar.Kf();
        bvd bvd = (bvd) this.gLB.hnQ.hnY;
        bvd.xcP = j;
        bvd.wim = j2;
        bvd.wMR = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 795;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
