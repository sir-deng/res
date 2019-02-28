package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asz;
import com.tencent.mm.protocal.c.ata;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    private b gLB;
    private e gLE;
    public String iLo;
    public String pMM;
    public ata pMU;

    public j(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new asz();
        aVar.hnU = new ata();
        aVar.hnS = 1590;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        asz asz = (asz) this.gLB.hnQ.hnY;
        asz.pNt = str;
        asz.pNw = str2;
        this.pMM = str;
        this.iLo = str2;
    }

    public final int getType() {
        return 1590;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pMU = (ata) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", Integer.valueOf(this.pMU.lot), this.pMU.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        ata ata = (ata) ((b) qVar).hnR.hnY;
        this.zQy = ata.lot;
        this.zQz = ata.lou;
    }
}
