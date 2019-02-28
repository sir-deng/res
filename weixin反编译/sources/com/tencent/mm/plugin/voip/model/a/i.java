package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bwk;
import com.tencent.mm.protocal.c.bwl;
import com.tencent.mm.protocal.c.bwq;

public final class i extends n<bwk, bwl> {
    String TAG = "MicroMsg.NetSceneVoipShutDown";

    public i(int i, long j, String str) {
        a aVar = new a();
        aVar.hnT = new bwk();
        aVar.hnU = new bwl();
        aVar.uri = "/cgi-bin/micromsg-bin/voipshutdown";
        aVar.hnS = af.CTRL_BYTE;
        aVar.hnV = 66;
        aVar.hnW = 1000000066;
        this.gLB = aVar.Kf();
        bwk bwk = (bwk) this.gLB.hnQ.hnY;
        bwk.wil = i;
        bwk.wim = j;
        bwq bwq = new bwq();
        bet bet = new bet();
        bet.Vf(str);
        bwq.wYa = bet;
        bwk.xdg = bwq;
        bwk.xcm = System.currentTimeMillis();
    }

    public final int getType() {
        return af.CTRL_BYTE;
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.eB(i.this.TAG, "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            }
        };
    }
}
