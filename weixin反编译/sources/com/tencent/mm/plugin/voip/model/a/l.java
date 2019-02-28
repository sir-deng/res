package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bwq;
import com.tencent.mm.protocal.c.bwr;
import com.tencent.mm.protocal.c.bws;

public final class l extends n<bwr, bws> {
    public l(String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.hnT = new bwr();
        aVar.hnU = new bws();
        aVar.uri = "/cgi-bin/micromsg-bin/voipstatreport";
        this.gLB = aVar.Kf();
        bwr bwr = (bwr) this.gLB.hnQ.hnY;
        bwq bwq = new bwq();
        bet bet = new bet();
        bet.Vf(str);
        bwq.wYa = bet;
        bwq bwq2 = new bwq();
        bet bet2 = new bet();
        bet2.Vf(str2);
        bwq2.wYa = bet2;
        bwq bwq3 = new bwq();
        bet bet3 = new bet();
        bet3.Vf(str3);
        bwq3.wYa = bet3;
        bwq bwq4 = new bwq();
        bet bet4 = new bet();
        bet4.Vf(str4);
        bwq4.wYa = bet4;
        bwq bwq5 = new bwq();
        bet bet5 = new bet();
        bet5.Vf(str5);
        bwq5.wYa = bet5;
        bwr.xdg = bwq;
        bwr.xez = bwq2;
        bwr.xey = bwq3;
        bwr.xeA = bwq4;
        bwr.xeB = bwq5;
    }

    public final int getType() {
        return 320;
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            }
        };
    }
}
