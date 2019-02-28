package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.beb;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    private b gLB;
    private e gLE;
    public bec pMY;

    public n(String str, String str2, String str3, int i, int i2, String str4, int i3, int i4, String str5) {
        a aVar = new a();
        aVar.hnT = new beb();
        aVar.hnU = new bec();
        aVar.hnS = 1380;
        aVar.uri = "/cgi-bin/mmpay-bin/request_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        beb beb = (beb) this.gLB.hnQ.hnY;
        beb.pNt = str;
        beb.pNu = str2;
        beb.pff = str3;
        beb.pNg = i;
        beb.wQF = i2;
        beb.wQG = str4;
        beb.wQH = i3;
        beb.wQI = i4;
        beb.vPB = str5;
    }

    public final int getType() {
        return 1380;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pMY = (bec) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.pMY.lot), this.pMY.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bec bec = (bec) ((b) qVar).hnR.hnY;
        this.zQy = bec.lot;
        this.zQz = bec.lou;
    }

    public final boolean azz() {
        if (this.pMY.wQJ == null || this.pMY.wQJ.fEo != 1) {
            return true;
        }
        return false;
    }
}
