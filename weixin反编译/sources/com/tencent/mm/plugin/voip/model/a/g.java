package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bwb;
import com.tencent.mm.protocal.c.bwc;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.LinkedList;
import java.util.List;

public final class g extends n<bwb, bwc> {
    public g(List<String> list, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        a aVar = new a();
        aVar.hnT = new bwb();
        aVar.hnU = new bwc();
        aVar.uri = "/cgi-bin/micromsg-bin/voipinvite";
        this.gLB = aVar.Kf();
        bwb bwb = (bwb) this.gLB.hnQ.hnY;
        LinkedList linkedList = new LinkedList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            linkedList.add(new bet().Vf((String) list.get(i5)));
        }
        bwb.wNo = q.FY();
        bwb.xdt = linkedList;
        bwb.xds = linkedList.size();
        bwb.wdO = i;
        bwb.wWF = 0;
        bwb.xdh = i3;
        bwb.wMS = i4;
        bwi bwi = new bwi();
        bwi.kzz = 2;
        bes bes = new bes();
        bes.bl(bArr);
        bwi.vQW = bes;
        bwb.xci = bwi;
        bwi = new bwi();
        bwi.kzz = 3;
        bes = new bes();
        bes.bl(bArr2);
        bwi.vQW = bes;
        bwb.xcj = bwi;
        bwb.xcm = System.currentTimeMillis();
    }

    public final int getType() {
        return 170;
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.NetSceneVoipInvite", "Invite response:" + i + " errCode:" + i2 + " status:" + g.this.sqC.mStatus);
                if (g.this.sqC.mStatus != 2) {
                    com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.sqC.mStatus + " should:2");
                    return;
                }
                bwc bwc = (bwc) g.this.bIx();
                g.this.sqC.sqj.suN = bwc.xcz;
                g.this.sqC.sqj.suO = bwc.xcA;
                g.this.sqC.sqj.suP = bwc.xcB;
                g.this.sqC.sqj.suQ = bwc.xcC;
                g.this.sqC.sqj.suS = bwc.xcE;
                g.this.sqC.sqj.suR = bwc.xcJ;
                g.this.sqC.sqj.svs = bwc.xdw;
                g.this.sqC.sqj.sus = bwc.xcr;
                g.this.sqC.sqj.suT = bwc.xcL;
                g.this.sqC.yR(bwc.xcp);
                g.this.sqC.sqj.sut = bwc.xcs;
                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.sqC.sqj.suN + ",audioTsdEdge = " + g.this.sqC.sqj.suO + ",passthroughQosAlgorithm = " + g.this.sqC.sqj.suP + ",fastPlayRepair = " + g.this.sqC.sqj.suQ + ", audioDtx = " + g.this.sqC.sqj.suS + ",switchtcpPktCnt = " + g.this.sqC.sqj.sur + ",SvrCfgListV = " + g.this.sqC.sqj.suR + ", setMaxBRForRelay=" + g.this.sqC.sqj.suT + ",EnableDataAccept = " + g.this.sqC.sqj.svs + ",WifiScanInterval = " + g.this.sqC.sqj.sut);
                g.this.sqC.sqj.suU = bwc.xcI;
                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.sqC.sqj.suU);
                g.this.sqC.sqj.suV = bwc.xcM;
                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.sqC.sqj.suV);
                int netType = com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext());
                if (i == 0) {
                    g.this.sqC.eR(4);
                    g.this.sqC.sqj.nJe = bwc.wil;
                    g.this.sqC.sqj.nJf = bwc.wim;
                    g.this.sqC.sqj.nJm = bwc.wNd;
                    com.tencent.mm.plugin.report.service.g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(1), Integer.valueOf(netType));
                    if (bwc.xdv > 0) {
                        long j = (long) (bwc.xdv * 1000);
                        g.this.sqC.sqv.K(j, j);
                    }
                    d.bGT().bIi();
                    com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.sqC.sqj.nJe + ",memberid = " + g.this.sqC.sqj.nJm + "VoipSyncInterval = " + bwc.xdv);
                    g.this.sqC.sqk.bHE();
                } else if (i == 4) {
                    com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + bwc.wil + "," + bwc.wim);
                    switch (i2) {
                        case h.CTRL_INDEX /*211*/:
                            g.this.sqC.sqj.svN.sqW = 12;
                            g.this.sqC.sqj.svN.srj = 12;
                            com.tencent.mm.plugin.report.service.g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(8), Integer.valueOf(netType));
                            break;
                        case 233:
                            g.this.sqC.sqj.svN.sqW = 12;
                            g.this.sqC.sqj.svN.srj = 1;
                            com.tencent.mm.plugin.report.service.g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(3), Integer.valueOf(netType));
                            break;
                        case 234:
                            g.this.sqC.sqj.svN.sqW = 13;
                            g.this.sqC.sqj.svN.srj = 11;
                            com.tencent.mm.plugin.report.service.g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(4), Integer.valueOf(netType));
                            break;
                        case 235:
                            g.this.sqC.sqj.svN.sqW = 13;
                            g.this.sqC.sqj.svN.srj = 2;
                            com.tencent.mm.plugin.report.service.g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(2), Integer.valueOf(netType));
                            break;
                        case JsApiGetSetting.CTRL_INDEX /*236*/:
                            g.this.sqC.sqj.svN.sqW = 12;
                            g.this.sqC.sqj.svN.srj = 10;
                            com.tencent.mm.plugin.report.service.g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(7), Integer.valueOf(netType));
                            break;
                        case bd.CTRL_BYTE /*237*/:
                            g.this.sqC.sqj.svN.sqW = 13;
                            g.this.sqC.sqj.svN.srj = 9;
                            com.tencent.mm.plugin.report.service.g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(2), Integer.valueOf(netType));
                            break;
                        case bc.CTRL_BYTE /*238*/:
                            g.this.sqC.spJ = true;
                            g.this.sqC.spL = false;
                            g.this.sqC.spK = false;
                            g.this.sqC.sqj.suM = 0;
                            g.this.sqC.sqj.suL = 0;
                            g.this.sqC.eR(3);
                            g.this.sqC.sqj.nJe = bwc.wil;
                            g.this.sqC.sqj.nJf = bwc.wim;
                            g.this.sqC.sqj.nJm = bwc.wNd;
                            g.this.sqC.sqk.yW(((bwb) ((g) kVar).bIy()).wWF);
                            return;
                        case GameJsApiGetGameCommInfo.CTRL_BYTE /*241*/:
                            x.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + bwc.xdx + " seconds!");
                            d.bGT().stf = System.currentTimeMillis();
                            if (bwc.xdx == 0) {
                                d.bGT().stg = 30000;
                                break;
                            }
                            d.bGT().stg = (long) (bwc.xdx * 1000);
                            break;
                        default:
                            g.this.sqC.sqj.svN.sqW = 12;
                            g.this.sqC.sqj.svN.srj = 99;
                            com.tencent.mm.plugin.report.service.g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(5), Integer.valueOf(netType));
                            break;
                    }
                    g.this.sqC.sqj.svN.sqX = i2;
                    g.this.sqC.p(1, i2, str);
                } else {
                    g.this.sqC.sqj.svN.sqW = 12;
                    g.this.sqC.sqj.svN.sqX = i2;
                    g.this.sqC.sqj.svN.srj = 99;
                    com.tencent.mm.plugin.report.service.g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(9), Integer.valueOf(netType));
                    g.this.sqC.p(1, -9004, "");
                }
            }
        };
    }
}
