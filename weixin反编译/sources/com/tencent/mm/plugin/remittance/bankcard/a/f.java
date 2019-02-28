package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.re;
import com.tencent.mm.protocal.c.rf;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    private b gLB;
    private e gLE;
    public String pMM;
    public rf pMQ;

    public f(String str) {
        a aVar = new a();
        aVar.hnT = new re();
        aVar.hnU = new rf();
        aVar.hnS = 1395;
        aVar.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((re) this.gLB.hnQ.hnY).pNt = str;
        this.pMM = str;
    }

    public final int getType() {
        return 1395;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pMQ = (rf) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", Integer.valueOf(this.pMQ.lot), this.pMQ.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        rf rfVar = (rf) ((b) qVar).hnR.hnY;
        this.zQy = rfVar.lot;
        this.zQz = rfVar.lou;
    }
}
