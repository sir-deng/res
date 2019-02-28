package com.tencent.mm.as;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqi;
import com.tencent.mm.protocal.c.bqj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ad.b gLB;
    private e gLE;

    public b() {
        a aVar = new a();
        aVar.hnT = new bqi();
        aVar.hnU = new bqj();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
        this.gLB = aVar.Kf();
        ((bqi) this.gLB.hnQ.hnY).vQC = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 550;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            as.Hm();
            c.Db().set(286722, "");
            as.Hm();
            c.Db().set(286721, "");
            as.Hm();
            c.Db().set(286723, "");
        }
        this.gLE.a(i2, i3, str, this);
    }
}
