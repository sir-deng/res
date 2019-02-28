package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abp;
import com.tencent.mm.protocal.c.abq;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    public String country;
    public String fXk;
    public String fXl;
    private b gLB;
    private e gLE;

    public n(double d, double d2) {
        a aVar = new a();
        aVar.hnT = new abp();
        aVar.hnU = new abq();
        aVar.uri = "/cgi-bin/micromsg-bin/getcurlocation";
        this.gLB = aVar.Kf();
        abp abp = (abp) this.gLB.hnQ.hnY;
        abp.vUG = d;
        abp.vUF = d2;
        x.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + d + ", longitude:" + d2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 665;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            abq abq = (abq) this.gLB.hnR.hnY;
            this.fXl = abq.hxg;
            this.country = abq.hxn;
            this.fXk = abq.hxf;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
