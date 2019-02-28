package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auv;
import com.tencent.mm.protocal.c.auw;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public c(int i, String str) {
        a aVar = new a();
        aVar.hnT = new auv();
        aVar.hnU = new auw();
        aVar.uri = "/cgi-bin/mmoctv/optvhist";
        this.gLB = aVar.Kf();
        auv auv = (auv) this.gLB.hnQ.hnY;
        auv.nne = i;
        auv.wJy = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1740;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
