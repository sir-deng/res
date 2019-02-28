package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    private ls pQl;

    public m(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.hnT = new ls();
        aVar.hnU = new lt();
        aVar.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.pQl = (ls) this.hPx.hnQ.hnY;
        this.pQl.vOg = str;
        this.pQl.vOh = str2;
        this.pQl.wbo = str3;
        this.pQl.wbp = str4;
        this.pQl.oeK = i;
        x.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", str, str2, str3, Integer.valueOf(i));
    }

    public final int getType() {
        return 1273;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
