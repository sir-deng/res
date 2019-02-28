package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ji;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    private b gLB;
    private e gLE;
    public jj pMN;

    public c(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new ji();
        aVar.hnU = new jj();
        aVar.hnS = 1340;
        aVar.uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ji jiVar = (ji) this.gLB.hnQ.hnY;
        jiVar.vWn = str;
        jiVar.pRd = str2;
    }

    public final int getType() {
        return 1340;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pMN = (jj) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", Integer.valueOf(this.pMN.lot), this.pMN.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        jj jjVar = (jj) ((b) qVar).hnR.hnY;
        this.zQy = jjVar.lot;
        this.zQz = jjVar.lou;
    }
}
