package com.tencent.mm.ba;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public a(String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new ra();
        aVar.hnU = new rb();
        aVar.uri = "/cgi-bin/micromsg-bin/deletecardimg";
        this.gLB = aVar.Kf();
        ((ra) this.gLB.hnQ.hnY).wgb = str;
    }

    public final int getType() {
        return 576;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gLE.a(i2, i3, str, this);
    }
}
