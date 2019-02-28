package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private String fHP = "";
    private final b gLB;
    private e gLE;
    public int kRz;

    public a(String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new qs();
        aVar.hnU = new qt();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
        aVar.hnS = 1163;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((qs) this.gLB.hnQ.hnY).fHP = str;
        this.fHP = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(1163), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            qt qtVar = (qt) this.gLB.hnR.hnY;
            x.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + qtVar.kRz);
            this.kRz = qtVar.kRz;
            if (this.kRz == 0) {
                am.avp().xa(this.fHP);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1163;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
