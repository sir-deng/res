package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.kd;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public class a extends l {
    private b gLB;
    private e gLE;

    public a(String str, int i, int i2) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a kdVar = new kd();
        kdVar.vPK = str;
        kdVar.vXP = i;
        kdVar.vXQ = i2;
        aVar.hnT = kdVar;
        aVar.hnU = new ke();
        aVar.uri = getUri();
        aVar.hnS = Hx();
        this.gLB = aVar.Kf();
        x.i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", getUri(), str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCancelPay", "response uri: %s, errType: %d, errCode: %d, errMsg: %s", getUri(), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            try {
                ke keVar = (ke) ((b) qVar).hnR.hnY;
                x.i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", Integer.valueOf(keVar.wRa.vQL), keVar.wRa.vRT);
            } catch (Exception e) {
                x.i("MicroMsg.NetSceneCancelPay", e.getMessage());
            }
        }
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    public final int getType() {
        return Hx();
    }

    public int Hx() {
        return 2823;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_cancelpay";
    }
}
