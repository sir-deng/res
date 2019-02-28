package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbh;
import com.tencent.mm.protocal.c.bbi;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public u(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new bbh();
        aVar.hnU = new bbi();
        aVar.uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
        this.gLB = aVar.Kf();
        bbh bbh = (bbh) this.gLB.hnQ.hnY;
        bbh.vUh = str;
        bbh.vUb = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1358;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
        return a(eVar, this.gLB, this);
    }
}
