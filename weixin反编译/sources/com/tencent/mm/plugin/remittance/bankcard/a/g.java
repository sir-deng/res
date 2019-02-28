package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.protocal.c.zb;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
    public String frM;
    private b gLB;
    private e gLE;
    public zb pMR;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new za();
        aVar.hnU = new zb();
        aVar.hnS = 1542;
        aVar.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((za) this.gLB.hnQ.hnY).wcd = str;
        this.frM = str2;
    }

    public final int getType() {
        return 1542;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pMR = (zb) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", Integer.valueOf(this.pMR.lot), this.pMR.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        zb zbVar = (zb) ((b) qVar).hnR.hnY;
        this.zQy = zbVar.lot;
        this.zQz = zbVar.lou;
    }
}
