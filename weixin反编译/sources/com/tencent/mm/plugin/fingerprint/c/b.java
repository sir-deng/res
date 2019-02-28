package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bmr;
import com.tencent.mm.protocal.c.bms;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;

public final class b extends d implements k {
    public final com.tencent.mm.ad.b gLB;
    private e gLE;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new bmr();
        aVar.hnU = new bms();
        aVar.uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
        this.gLB = aVar.Kf();
        bmr bmr = (bmr) this.gLB.hnQ.hnY;
        bmr.wKi = str;
        bmr.signature = str2;
        bmr.wWp = str3;
        bmr.fzi = TenpayUtil.signWith3Des("passwd=" + bmr.wWp);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
            com.tencent.mm.plugin.fingerprint.b.e.fn(true);
        } else {
            x.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
        }
        this.gLE.a(i, i2, "", this);
    }

    public final void aLm() {
        x.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
        if (this.gLE != null) {
            this.gLE.a(4, -1, "", this);
        }
    }

    public final void cC(int i, int i2) {
        x.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i2));
        if (this.gLE != null) {
            this.gLE.a(4, -1, "", this);
        }
    }

    public final int getType() {
        return 1638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
