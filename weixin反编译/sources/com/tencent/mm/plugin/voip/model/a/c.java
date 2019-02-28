package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.protocal.c.bvq;
import com.tencent.mm.protocal.c.bwq;

public final class c extends n<bvp, bvq> {
    public c(int i, long j, String str, String str2, int i2) {
        a aVar = new a();
        aVar.hnT = new bvp();
        aVar.hnU = new bvq();
        aVar.uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
        this.gLB = aVar.Kf();
        bvp bvp = (bvp) this.gLB.hnQ.hnY;
        bvp.wil = i;
        bvp.wim = j;
        bvp.npV = str;
        bvp.wMS = i2;
        bwq bwq = new bwq();
        bet bet = new bet();
        bet.Vf(str2);
        bwq.wYa = bet;
        bvp.xdg = bwq;
        bvp.xcm = System.currentTimeMillis();
    }

    public final int bIu() {
        bvp bvp = (bvp) bIy();
        if (bvp.wil == 0 && bvp.wMS == 0) {
            return -1;
        }
        return 0;
    }

    public final int getType() {
        return 171;
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            }
        };
    }
}
