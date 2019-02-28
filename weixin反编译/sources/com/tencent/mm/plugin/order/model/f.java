package com.tencent.mm.plugin.order.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.tg;
import com.tencent.mm.protocal.c.th;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class f extends l {
    private b gLB;
    private e gLE;

    public f(String str, String str2, int i) {
        a aVar = new a();
        aVar.hnT = new tg();
        aVar.hnU = new th();
        aVar.uri = "/cgi-bin/micromsg-bin/evaluateorder";
        this.gLB = aVar.Kf();
        tg tgVar = (tg) this.gLB.hnQ.hnY;
        tgVar.wir = str;
        tgVar.nlV = str2;
        tgVar.pWh = i;
        tgVar.vXW = i.bLR();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
