package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgz;
import com.tencent.mm.protocal.c.bha;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public n(String str, String str2) {
        this(str, str2, 0);
    }

    public n(String str, String str2, int i) {
        a aVar = new a();
        aVar.hnT = new bgz();
        aVar.hnU = new bha();
        aVar.uri = "/cgi-bin/micromsg-bin/sendfeedback";
        aVar.hnS = 153;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bgz bgz = (bgz) this.gLB.hnQ.hnY;
        bgz.wSs = str;
        bgz.noL = str2;
        bgz.wBO = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 153;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + i2 + " code:" + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
