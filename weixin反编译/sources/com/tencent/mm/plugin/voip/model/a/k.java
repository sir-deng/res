package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bmw;
import com.tencent.mm.protocal.c.bwo;
import com.tencent.mm.protocal.c.bwp;

public final class k extends n<bwo, bwp> {
    public k(bmw bmw) {
        a aVar = new a();
        aVar.hnT = new bwo();
        aVar.hnU = new bwp();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedtest";
        this.gLB = aVar.Kf();
        bwo bwo = (bwo) this.gLB.hnQ.hnY;
        bwo.wil = bmw.wil;
        bwo.wWF = bmw.wWF;
        bwo.wdO = bmw.wdO;
        bwo.wWG = bmw.wWG;
        bwo.wWH = bmw.wWH;
        bwo.wWI = bmw.wWI;
        bwo.wWJ = bmw.wWJ;
        bwo.wWK = bmw.wWK;
        bwo.wWL = bmw.wWL;
        bwo.wWM = bmw.wWM;
        bwo.wWN = bmw.wWN;
        bwo.wWO = bmw.wWO;
        bwo.wWP = bmw.wWP;
    }

    public final int getType() {
        return 765;
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                try {
                    bwp bwp = (bwp) k.this.bIx();
                    if (bwp.xev == 0 || bwp.xew == 0) {
                        com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + bwp.xew);
                    } else if (k.this.sqC.spO != 1) {
                        com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + k.this.sqC.spO);
                    } else {
                        k.this.sqC.spO = 2;
                        k.this.sqC.spQ = bwp.xer;
                        v2protocal v2protocal = k.this.sqC.sqj;
                        if (v2protocal.svt != 0) {
                            com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
                            return;
                        }
                        v2protocal.svt = bwp.xer;
                        v2protocal.field_SpeedTestSvrParaArray = com.tencent.mm.plugin.voip.b.a.a(bwp);
                        v2protocal.StartSpeedTest(bwp.xer, bwp.xew);
                    }
                } catch (Exception e) {
                    k.this.sqC.spO = 0;
                }
            }
        };
    }
}
