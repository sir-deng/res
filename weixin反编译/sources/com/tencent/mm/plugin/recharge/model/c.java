package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public String fBa;
    public b gLB;
    private e gLE;
    public String lKx;

    public c(String str, String str2, String str3, String str4, String str5) {
        this.fBa = str2;
        this.lKx = str3;
        a aVar = new a();
        aVar.hnT = new wi();
        aVar.hnU = new wj();
        aVar.uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
        this.gLB = aVar.Kf();
        wi wiVar = (wi) this.gLB.hnQ.hnY;
        wiVar.wnw = str;
        wiVar.vSS = str2;
        wiVar.phw = str3;
        wiVar.wnx = str4;
        wiVar.wny = str5;
        wiVar.wgO = com.tencent.mm.plugin.wallet_core.model.mall.c.bMQ().NF(str);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + i3 + ", errMsg " + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
