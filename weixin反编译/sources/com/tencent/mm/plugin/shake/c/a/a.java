package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.kk;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public a(String str, String str2) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new kj();
        aVar.hnU = new kk();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
        this.gLB = aVar.Kf();
        kj kjVar = (kj) this.gLB.hnQ.hnY;
        kjVar.kPy = str;
        kjVar.fHQ = str2;
    }

    public final int getType() {
        return 1252;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = 1252" + " errType = " + i2 + " errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
