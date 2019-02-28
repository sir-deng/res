package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.protocal.c.zd;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    private b gLB;
    private e gLE;
    public zd pMS;

    public h() {
        a aVar = new a();
        aVar.hnT = new zc();
        aVar.hnU = new zd();
        aVar.hnS = 1399;
        aVar.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int getType() {
        return 1399;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pMS = (zd) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", Integer.valueOf(this.pMS.lot), this.pMS.lou);
        if (!(this.lpb || this.pMS.lot == 0)) {
            this.lpc = true;
        }
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        zd zdVar = (zd) ((b) qVar).hnR.hnY;
        this.zQy = zdVar.lot;
        this.zQz = zdVar.lou;
    }
}
