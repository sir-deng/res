package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.buu;
import com.tencent.mm.protocal.c.bwd;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.y.as;

public final class a extends n<but, buu> {
    String TAG = "MicroMsg.NetSceneVoipAck";

    public a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new but();
        aVar.hnU = new buu();
        aVar.uri = "/cgi-bin/micromsg-bin/voipack";
        aVar.hnS = 305;
        aVar.hnV = 123;
        aVar.hnW = 1000000123;
        this.gLB = aVar.Kf();
        but but = (but) this.gLB.hnQ.hnY;
        but.wil = i;
        but.wim = j;
        but.xcl = i2;
        if (i2 != 1) {
            but.xch = 0;
            return;
        }
        but.xck = str;
        bwi bwi = new bwi();
        bwi.kzz = 2;
        bes bes = new bes();
        bes.bl(bArr);
        bwi.vQW = bes;
        but.xci = bwi;
        bwi = new bwi();
        bwi.kzz = 3;
        bes = new bes();
        bes.bl(bArr2);
        bwi.vQW = bes;
        but.xcj = bwi;
        but.xcm = System.currentTimeMillis();
        but.xch = 1;
    }

    public final int getType() {
        return 305;
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.eA(a.this.TAG, "ack response:" + i + " errCode:" + i2 + " status:" + a.this.sqC.mStatus);
                if (a.this.sqC.mStatus == 1) {
                    com.tencent.mm.plugin.voip.b.a.eA(a.this.TAG, "reject ok!");
                } else if (a.this.sqC.mStatus != 3) {
                    com.tencent.mm.plugin.voip.b.a.ez(a.this.TAG, "ack response not within WAITCONNECT, ignored.");
                } else if (i == 0) {
                    buu buu = (buu) a.this.bIx();
                    if (buu.xch != 1) {
                        com.tencent.mm.plugin.voip.b.a.eA(a.this.TAG, "onVoipAckResp: do not use preconnect");
                        return;
                    }
                    a.this.sqC.spL = true;
                    a.this.sqC.sqj.suL = 1;
                    a.this.sqC.sqj.nJe = buu.wil;
                    a.this.sqC.sqj.nJf = buu.wim;
                    a.this.sqC.sqj.nJm = buu.xcn;
                    a.this.sqC.sqj.sus = buu.xcr;
                    a.this.sqC.sqj.sut = buu.xcs;
                    a.this.sqC.yR(buu.xcp);
                    com.tencent.mm.plugin.voip.b.a.eA(a.this.TAG, "ack ok, roomid =" + a.this.sqC.sqj.nJe + ",memberid = " + a.this.sqC.sqj.nJm);
                    final bwd bwd = buu.xco;
                    if (bwd.nJA > 0) {
                        bwd.nJA--;
                        com.tencent.mm.plugin.voip.b.a.eA(a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + bwd.nJA + "] from ackresp relaydata");
                    } else {
                        bwd.nJA = 1;
                        com.tencent.mm.plugin.voip.b.a.eA(a.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
                    }
                    com.tencent.mm.plugin.voip.b.a.eA(a.this.TAG, "ack with switchtcpcnt  =" + a.this.sqC.sqj.sur + " RedirectReqThreshold =" + bwd.xdT + " BothSideSwitchFlag =" + bwd.xdU + " WifiScanInterval =" + buu.xcs);
                    a.this.sqC.sqj.svj = bwd.xdU;
                    a.this.sqC.yQ(bwd.xdy);
                    a.this.sqC.aN(bwd.xci.vQW.wRm.toByteArray());
                    if (!(bwd.xdF == null || bwd.xdF.wRm == null || bwd.xdR == null || bwd.xdR.wRm == null)) {
                        a.this.sqC.a(bwd.xdF.wRm.toByteArray(), bwd.xdE, bwd.nJA, bwd.xdR.wRm.toByteArray());
                    }
                    a.this.sqC.i(bwd.xdI, bwd.xdJ, bwd.xdK, bwd.xdL, bwd.xdM);
                    a.this.sqC.aO(bwd.xcj.vQW.wRm.toByteArray());
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            a.this.sqC.a(bwd.xdz, bwd.xdA, bwd.xdH);
                            a.this.sqC.yP(bwd.xdQ);
                            a.this.sqC.yO(bwd.xdT);
                            if (!(bwd.xdO == null || bwd.xdP == null)) {
                                a.this.sqC.b(bwd.xdN, bwd.xdO.wRm.toByteArray(), bwd.xdP.wRm.toByteArray());
                            }
                            d.bGT().bIi();
                            com.tencent.mm.plugin.voip.b.a.eA(a.this.TAG, "ack success, try connect channel");
                            a.this.sqC.bHj();
                        }
                    });
                } else if (i == 4) {
                    a.this.sqC.sqj.svN.sqW = 12;
                    a.this.sqC.sqj.svN.sqX = i2;
                    a.this.sqC.p(1, i2, "");
                } else {
                    a.this.sqC.sqj.svN.sqW = 12;
                    a.this.sqC.sqj.svN.sqX = i2;
                    a.this.sqC.p(1, -9004, "");
                }
            }
        };
    }
}
