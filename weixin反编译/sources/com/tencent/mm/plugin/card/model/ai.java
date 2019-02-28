package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.sdk.platformtools.x;

public final class ai extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public ai(String str, byte[] bArr, float f, float f2, float f3, boolean z, boolean z2) {
        a aVar = new a();
        aVar.hnT = new bdq();
        aVar.hnU = new bdr();
        aVar.uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
        this.gLB = aVar.Kf();
        bdq bdq = (bdq) this.gLB.hnQ.hnY;
        bdq.fHP = str;
        bdq.wQg = com.tencent.mm.bp.b.be(bArr);
        bdq.fBX = f;
        bdq.fAo = f2;
        bdq.wQf = f3;
        bdq.wQh = z;
        bdq.wQi = z2;
    }

    public final int getType() {
        return 2574;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
