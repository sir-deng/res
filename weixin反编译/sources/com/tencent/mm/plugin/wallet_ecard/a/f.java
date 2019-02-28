package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bak;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public bal tge;

    public f(String str, int i) {
        a aVar = new a();
        aVar.hnT = new bak();
        aVar.hnU = new bal();
        aVar.uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bak bak = (bak) this.gLB.hnQ.hnY;
        bak.vSz = str;
        bak.fDt = i;
        x.i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", str, Integer.valueOf(i));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tge = (bal) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.tge.kRz), this.tge.kRA);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1988;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
