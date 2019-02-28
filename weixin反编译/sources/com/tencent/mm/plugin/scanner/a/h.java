package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ii;
import com.tencent.mm.protocal.c.ij;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public h(String str, String str2, int i, String str3, int i2, int i3) {
        a aVar = new a();
        aVar.hnT = new ii();
        aVar.hnU = new ij();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
        this.gLB = aVar.Kf();
        ii iiVar = (ii) this.gLB.hnQ.hnY;
        iiVar.vUW = d.vHf;
        iiVar.vUX = d.vHe;
        iiVar.vUY = d.vHh;
        iiVar.vUZ = d.vHi;
        iiVar.vVa = w.cfV();
        iiVar.pWp = 11294;
        iiVar.vVb = null;
        iiVar.pYv = str;
        iiVar.pYu = str2;
        iiVar.type = i;
        iiVar.value = str3;
        iiVar.count = i2;
        iiVar.pda = i3;
        x.v("MircoMsg.NetSceneScanProductReport", "statid:" + str2);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MircoMsg.NetSceneScanProductReport", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1064;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
