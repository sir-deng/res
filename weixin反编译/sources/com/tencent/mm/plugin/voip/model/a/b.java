package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bux;
import com.tencent.mm.protocal.c.buy;
import com.tencent.mm.protocal.c.bwd;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class b extends n<bux, buy> {
    String TAG = "MicroMsg.NetSceneVoipAnswer";

    public b(int i, int i2, int i3, byte[] bArr, byte[] bArr2, long j, boolean z, boolean z2) {
        a aVar = new a();
        aVar.hnT = new bux();
        aVar.hnU = new buy();
        aVar.uri = "/cgi-bin/micromsg-bin/voipanswer";
        aVar.hnS = 172;
        aVar.hnV = 65;
        aVar.hnW = 1000000065;
        this.gLB = aVar.Kf();
        bux bux = (bux) this.gLB.hnQ.hnY;
        bux.xcv = i;
        bux.wil = i3;
        bux.wdO = i2;
        bwi bwi = new bwi();
        bwi.kzz = 2;
        bes bes = new bes();
        bes.bl(bArr);
        bwi.vQW = bes;
        bux.xci = bwi;
        bwi = new bwi();
        bwi.kzz = 3;
        bes = new bes();
        bes.bl(bArr2);
        bwi.vQW = bes;
        bux.xcj = bwi;
        bux.wim = j;
        if (z2) {
            bux.xcw = z ? 1 : 0;
        }
        bux.xcm = System.currentTimeMillis();
    }

    public final int getType() {
        return 172;
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "Anwser response:" + i + " errCode:" + i2 + " status:" + b.this.sqC.mStatus);
                if (b.this.sqC.mStatus == 1) {
                    com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "reject ok!");
                } else if (b.this.sqC.mStatus != 4) {
                    com.tencent.mm.plugin.voip.b.a.ez(b.this.TAG, "Anwser response not within WAITCONNECT, ignored.");
                } else if (i == 0) {
                    buy buy = (buy) b.this.bIx();
                    b.this.sqC.sqj.nJe = buy.wil;
                    b.this.sqC.sqj.nJf = buy.wim;
                    b.this.sqC.sqj.nJm = buy.xcn;
                    b.this.sqC.sqj.suN = buy.xcz;
                    b.this.sqC.sqj.suO = buy.xcA;
                    b.this.sqC.sqj.suP = buy.xcB;
                    b.this.sqC.sqj.suQ = buy.xcC;
                    b.this.sqC.sqj.suS = buy.xcE;
                    b.this.sqC.sqj.suR = buy.xcJ;
                    b.this.sqC.sqj.sus = buy.xcr;
                    b.this.sqC.sqj.suT = buy.xcL;
                    b.this.sqC.yR(buy.xcp);
                    b.this.sqC.sqj.sut = buy.xcs;
                    com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "onAnwserResp: audioTsdfBeyond3G = " + b.this.sqC.sqj.suN + ",audioTsdEdge = " + b.this.sqC.sqj.suO + ",passthroughQosAlgorithm = " + b.this.sqC.sqj.suP + ",fastPlayRepair = " + b.this.sqC.sqj.suQ + ", audioDtx = " + b.this.sqC.sqj.suS + ", switchtcppktCnt=" + b.this.sqC.sqj.sur + ", SvrCfgListV=" + b.this.sqC.sqj.suR + ", setMaxBRForRelay=" + b.this.sqC.sqj.suT + ", RedirectreqThreshold=" + buy.xco.xdT + ", BothSideSwitchFlag=" + buy.xco.xdU + ", WifiScanInterval=" + buy.xcs);
                    b.this.sqC.sqj.suU = buy.xcI;
                    b.this.sqC.sqj.suV = buy.xcM;
                    com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "answerResp AudioAecMode5 = " + b.this.sqC.sqj.suU);
                    b.this.sqC.spJ = true;
                    com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "answer ok, roomid =" + b.this.sqC.sqj.nJe + ",memberid = " + b.this.sqC.sqj.nJm);
                    final bwd bwd = buy.xco;
                    if (bwd.nJA > 0) {
                        bwd.nJA--;
                        com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + bwd.nJA + "] from answerresp relaydata");
                    } else {
                        bwd.nJA = 1;
                        com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
                    }
                    com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "answer with relayData peerid.length =" + bwd.xci.vQW.wRk);
                    com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "answer with relayData capinfo.length =" + bwd.xcj.vQW.wRk);
                    b.this.sqC.yQ(bwd.xdy);
                    try {
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                b.this.sqC.a(bwd.xdz, bwd.xdA, bwd.xdH);
                                if (bwd.xci.vQW.wRm != null) {
                                    b.this.sqC.aN(bwd.xci.vQW.wRm.toByteArray());
                                } else {
                                    x.e(b.this.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                                }
                                if (!(bwd.xdF == null || bwd.xdF.wRm == null || bwd.xdR == null || bwd.xdR.wRm == null)) {
                                    b.this.sqC.a(bwd.xdF.wRm.toByteArray(), bwd.xdE, bwd.nJA, bwd.xdR.wRm.toByteArray());
                                }
                                b.this.sqC.i(bwd.xdI, bwd.xdJ, bwd.xdK, bwd.xdL, bwd.xdM);
                                b.this.sqC.yP(bwd.xdQ);
                                if (!(bwd.xdO == null || bwd.xdP == null || bwd.xdO.wRm == null || bwd.xdP.wRm == null)) {
                                    b.this.sqC.b(bwd.xdN, bwd.xdO.wRm.toByteArray(), bwd.xdP.wRm.toByteArray());
                                }
                                if (bwd.xcj.vQW.wRm != null) {
                                    b.this.sqC.aO(bwd.xcj.vQW.wRm.toByteArray());
                                } else {
                                    x.e(b.this.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                                }
                                b.this.sqC.yO(bwd.xdT);
                                b.this.sqC.sqj.svj = bwd.xdU;
                                if (b.this.sqC.spL) {
                                    b.this.sqC.spL = false;
                                    if (b.this.sqC.spH) {
                                        com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "channel pre-connect already success, start talk");
                                        b.this.sqC.bHe();
                                    } else if (b.this.sqC.spK) {
                                        com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "channel pre-connect already failed");
                                        b.this.sqC.p(1, -9000, "");
                                        return;
                                    } else {
                                        com.tencent.mm.plugin.voip.b.a.eA(b.this.TAG, "channel pre-connect still connecting...");
                                    }
                                } else {
                                    x.i(b.this.TAG, "isPreConnect is false");
                                }
                                b.this.sqC.bHl();
                                b.this.sqC.bHj();
                            }
                        });
                    } catch (Exception e) {
                        x.e(b.this.TAG, "get proxy ip fail..");
                    }
                } else if (i == 4) {
                    b.this.sqC.sqj.svN.sqW = 12;
                    b.this.sqC.sqj.svN.sqX = i2;
                    b.this.sqC.p(1, i2, "");
                } else {
                    b.this.sqC.sqj.svN.sqW = 12;
                    b.this.sqC.sqj.svN.sqX = i2;
                    b.this.sqC.p(1, -9004, "");
                }
            }
        };
    }
}
