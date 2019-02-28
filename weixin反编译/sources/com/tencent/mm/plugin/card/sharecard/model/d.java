package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agi;
import com.tencent.mm.protocal.c.agj;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String kRA;
    public String kRy;
    public int kRz;

    public d(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new agi();
        aVar.hnU = new agj();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
        this.gLB = aVar.Kf();
        agi agi = (agi) this.gLB.hnQ.hnY;
        agi.fHP = str;
        agi.scene = 20;
        agi.kPy = str2;
        agi.code = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(910), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            agj agj = (agj) this.gLB.hnR.hnY;
            x.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + agj.kRy);
            this.kRy = agj.kRy;
            this.kRA = agj.kRA;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 910;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
