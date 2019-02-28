package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    private b gLB;
    private e gLE;
    public dq pML;
    public String pMM;

    public a(String str, String str2, String str3) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new dp();
        aVar.hnU = new dq();
        aVar.hnS = 1348;
        aVar.uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        dp dpVar = (dp) this.gLB.hnQ.hnY;
        dpVar.pNt = str;
        dpVar.vPz = str2;
        dpVar.pff = str3;
        this.pMM = str;
        x.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", str, str2, str3);
    }

    public final int getType() {
        return 1348;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pML = (dq) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", Integer.valueOf(this.pML.lot), this.pML.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        dq dqVar = (dq) ((b) qVar).hnR.hnY;
        this.zQy = dqVar.lot;
        this.zQz = dqVar.lou;
    }
}
