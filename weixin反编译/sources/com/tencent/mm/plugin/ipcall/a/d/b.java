package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.azj;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.b gLB = null;
    private e gLE;
    private azi nKX = null;
    public azj nKY = null;

    public b(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.hnT = new azi();
        aVar.hnU = new azj();
        aVar.hnS = 807;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nKX = (azi) this.gLB.hnQ.hnY;
        this.nKX.wMV = str;
        this.nKX.wMX = str2;
        this.nKX.wMZ = str3;
        this.nKX.wMY = str4;
        this.nKX.wNa = i;
        x.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", str, str2, str3, str4, Integer.valueOf(i));
    }

    public final int getType() {
        return 807;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nKY = (azj) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
