package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qq;
import com.tencent.mm.protocal.c.qr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class a extends k implements com.tencent.mm.network.k {
    private String ffG;
    private b gLB;
    private e gLE;

    public a(String str) {
        this.ffG = str;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new qq();
        aVar.hnU = new qr();
        aVar.uri = "/cgi-bin/micromsg-bin/delsafedevice";
        this.gLB = aVar.Kf();
        ((qq) this.gLB.hnQ.hnY).wfU = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            qr qrVar = (qr) this.gLB.hnR.hnY;
            as.Hm();
            c.Db().set(64, Integer.valueOf(qrVar.vMj));
            x.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + qrVar.vMj);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 362;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bi.oN(this.ffG)) {
            x.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
            return -1;
        }
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
