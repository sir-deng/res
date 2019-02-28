package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ue;
import com.tencent.mm.protocal.c.uf;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    private ue oeD;
    private uf oeE;

    public a(String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new ue();
        aVar.hnU = new uf();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
        this.hPx = aVar.Kf();
        this.oeD = (ue) this.hPx.hnQ.hnY;
        this.oeD.oeH = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.oeE = (uf) ((b) qVar).hnR.hnY;
        x.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(this.oeE.lot), this.oeE.lou);
        if (this.gLE != null) {
            this.gLE.a(i2, this.oeE.lot, this.oeE.lou, this);
        }
    }

    public final int getType() {
        return 1987;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }
}
