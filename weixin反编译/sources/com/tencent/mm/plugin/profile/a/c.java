package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bnz;
import com.tencent.mm.protocal.c.boa;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public c(String str, boolean z) {
        a aVar = new a();
        aVar.hnT = new bnz();
        aVar.hnU = new boa();
        aVar.uri = "/cgi-bin/mmocbiz-bin/switchbrand";
        this.gLB = aVar.Kf();
        bnz bnz = (bnz) this.gLB.hnQ.hnY;
        bnz.vUh = str;
        bnz.wXJ = z;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1394;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
        return a(eVar, this.gLB, this);
    }

    public final boa bjV() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (boa) this.gLB.hnR.hnY;
    }

    public final bnz bjW() {
        if (this.gLB == null || this.gLB.hnQ.hnY == null) {
            return null;
        }
        return (bnz) this.gLB.hnQ.hnY;
    }
}
