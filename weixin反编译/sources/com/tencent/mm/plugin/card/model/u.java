package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bdp;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public u(float f, float f2, String str, String str2, int i) {
        a aVar = new a();
        aVar.hnT = new bdo();
        aVar.hnU = new bdp();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
        this.gLB = aVar.Kf();
        bdo bdo = (bdo) this.gLB.hnQ.hnY;
        bdo.latitude = (double) f;
        bdo.longitude = (double) f2;
        bdo.fHP = str;
        bdo.kPy = str2;
        bdo.wQe = i;
    }

    public final int getType() {
        return 1253;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
