package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    private b gLB;
    private e gLE;
    public baw pMW;

    public l(String str) {
        a aVar = new a();
        aVar.hnT = new bav();
        aVar.hnU = new baw();
        aVar.hnS = 1579;
        aVar.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((bav) this.gLB.hnQ.hnY).vWn = str;
        x.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", str);
    }

    public final int getType() {
        return 1579;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pMW = (baw) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        baw baw = (baw) ((b) qVar).hnR.hnY;
        this.zQy = baw.lot;
        this.zQz = baw.lou;
    }
}
