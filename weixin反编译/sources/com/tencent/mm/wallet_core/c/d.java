package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.kh;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l {
    private b gLB;
    private e gLE;

    public d(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new kh();
        aVar.hnU = new ki();
        aVar.uri = "/cgi-bin/mmpay-bin/cancelqrpay";
        aVar.hnS = JsApiBatchGetContact.CTRL_INDEX;
        aVar.hnV = bc.CTRL_INDEX;
        this.gLB = aVar.Kf();
        kh khVar = (kh) this.gLB.hnQ.hnY;
        khVar.vXV = str;
        khVar.vPK = str2;
        khVar.vXW = i.bLR();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCancelQRPay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return JsApiBatchGetContact.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
