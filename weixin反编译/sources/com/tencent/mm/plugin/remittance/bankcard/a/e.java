package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.protocal.c.rd;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    private b gLB;
    private com.tencent.mm.ad.e gLE;
    public String lnP;
    public rd pMP;

    public e(String str) {
        a aVar = new a();
        aVar.hnT = new rc();
        aVar.hnU = new rd();
        aVar.hnS = 1737;
        aVar.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((rc) this.gLB.hnQ.hnY).vWn = str;
        this.lnP = str;
    }

    public final int getType() {
        return 1737;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pMP = (rd) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", Integer.valueOf(this.pMP.lot), this.pMP.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        rd rdVar = (rd) ((b) qVar).hnR.hnY;
        this.zQy = rdVar.lot;
        this.zQz = rdVar.lou;
    }
}
