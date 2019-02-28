package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbe;
import com.tencent.mm.protocal.c.bbf;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    private b gLB;
    private e gLE;
    public bbf pMX;

    public m() {
        a aVar = new a();
        aVar.hnT = new bbe();
        aVar.hnU = new bbf();
        aVar.hnS = 1378;
        aVar.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int getType() {
        return 1378;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pMX = (bbf) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", Integer.valueOf(this.pMX.lot), this.pMX.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bbf bbf = (bbf) ((b) qVar).hnR.hnY;
        this.zQy = bbf.lot;
        this.zQz = bbf.lou;
    }
}
