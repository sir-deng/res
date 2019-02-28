package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public com.tencent.mm.ad.b gLB;
    private e gLE;

    public b(String str, int i) {
        a aVar = new a();
        aVar.hnT = new bij();
        aVar.hnU = new bik();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
        this.gLB = aVar.Kf();
        bij bij = (bij) this.gLB.hnQ.hnY;
        bij.vUh = str;
        bij.wSR = i;
        bij.wSS = 4;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1363;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
        return a(eVar, this.gLB, this);
    }
}
