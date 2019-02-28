package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qu;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public i(String str) {
        x.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", str);
        a aVar = new a();
        aVar.hnT = new qu();
        aVar.hnU = new qv();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
        this.gLB = aVar.Kf();
        qu quVar = (qu) this.gLB.hnQ.hnY;
        quVar.vTX = str;
        quVar.wfV = com.tencent.mm.bp.b.be(new byte[0]);
    }

    public final int getType() {
        return 1067;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }
}
