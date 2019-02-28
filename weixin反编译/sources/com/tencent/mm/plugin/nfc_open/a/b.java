package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.po;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public com.tencent.mm.ad.b gLB;
    private e gLE;

    public b(int i) {
        a aVar = new a();
        aVar.hnT = new po();
        aVar.hnU = new pp();
        aVar.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
        this.gLB = aVar.Kf();
        ((po) this.gLB.hnQ.hnY).version = i;
    }

    public final int getType() {
        return 1561;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gLE.a(i2, i3, str, this);
    }
}
