package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.c.ank;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bvr;
import com.tencent.mm.protocal.c.bvs;
import com.tencent.mm.protocal.c.bwd;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.protocal.c.bwt;
import com.tencent.mm.protocal.c.bwv;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.util.LinkedList;

public final class o {
    e soQ = null;
    bwd stG = new bwd();
    private bvs stH = null;
    private int stI = 0;

    public o(e eVar) {
        this.soQ = eVar;
    }

    private void a(bvs bvs) {
        if (bvs == null) {
            a.ez("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
            this.stI++;
            return;
        }
        if (this.stH == null) {
            this.stH = new bvs();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bvs.kyA) {
                this.stH.kyB.add((bvr) bvs.kyB.get(i2));
                i = i2 + 1;
            } else {
                this.stH.kyA = this.stH.kyB.size();
                return;
            }
        }
    }

    private void b(bvs bvs) {
        if (this.stH != null && this.stH.kyA > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.stH.kyA) {
                    bvs.kyB.add((bvr) this.stH.kyB.get(i2));
                    i = i2 + 1;
                } else {
                    bvs.kyA = bvs.kyB.size();
                    bIs();
                    return;
                }
            }
        }
    }

    public final void bIs() {
        if (this.stH != null) {
            this.stH.kyB.clear();
            this.stH.kyA = 0;
            this.stH = null;
            this.stI = 0;
        }
    }

    public final int a(bvs bvs, boolean z, int i) {
        if (this.soQ.sqj.nJe == 0) {
            a.ez("MicroMsg.Voip.VoipSyncHandle", g.zo() + "failed to do voip sync , roomid = 0");
        } else if (this.soQ.sqp) {
            a.ez("MicroMsg.Voip.VoipSyncHandle", g.zo() + "voip syncing, push to cache...");
            a(bvs);
        } else {
            bvs bvs2;
            this.soQ.sqp = true;
            if (bvs == null) {
                bvs2 = new bvs();
                bvs2.kyA = 0;
                bvs2.kyB = new LinkedList();
            } else {
                bvs2 = bvs;
            }
            b(bvs2);
            this.stI = 0;
            if (this.soQ.sqn == null) {
                this.soQ.sqn = "".getBytes();
            }
            a.eA("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + z + ",cmdList:" + bvs2.kyA + ",syncKey.length:" + this.soQ.sqn.length + ",selector:" + i);
            new m(this.soQ.sqj.nJe, bvs2, this.soQ.sqn, this.soQ.sqj.nJf, i).bIw();
        }
        return 0;
    }

    public final void a(bwt bwt, int i) {
        a.eA("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + bwt.kyY);
        if (bwt.kyY == 1) {
            h hVar;
            this.soQ.spI = true;
            if (1 == i) {
                hVar = this.soQ.sqj.svN;
                if (0 == hVar.srz) {
                    hVar.srz = System.currentTimeMillis();
                    a.eA("MicroMsg.VoipDailReport", "accept received timestamp:" + hVar.srz);
                }
            }
            if (3 == i) {
                hVar = this.soQ.sqj.svN;
                if (0 == hVar.srA) {
                    hVar.srA = System.currentTimeMillis();
                    a.eA("MicroMsg.VoipDailReport", "sync accept received timestamp:" + hVar.srA);
                }
            }
            a.eA("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: " + i);
            this.soQ.sqk.aTy();
            d.bGT().ssY.bIr();
            this.soQ.spJ = true;
            if (this.soQ.spL) {
                this.soQ.spL = false;
                if (this.soQ.spH) {
                    a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
                    this.soQ.bHe();
                } else if (this.soQ.spK) {
                    a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
                    this.soQ.p(1, -9000, "");
                } else {
                    a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
                }
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(11519, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(2));
            this.soQ.bHj();
            this.soQ.bHl();
        } else if (bwt.kyY == 6) {
            a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
            a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
            this.soQ.spL = true;
            this.soQ.sqj.suL = 1;
            this.soQ.bHj();
        } else if (bwt.kyY == 8) {
            a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
            this.soQ.sqj.svN.sqX = h.CTRL_INDEX;
            this.soQ.sqj.svN.sqW = 11;
            this.soQ.sqj.svN.srj = 12;
            com.tencent.mm.plugin.report.service.g.pWK.h(11519, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(3));
            this.soQ.p(1, h.CTRL_INDEX, "");
            this.soQ.bHl();
        } else if (bwt.kyY == 2) {
            a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
            this.soQ.sqj.svN.sqW = 103;
            this.soQ.sqj.svN.srj = 4;
            this.soQ.sqj.svN.srq = (int) (System.currentTimeMillis() - this.soQ.sqj.svN.beginTime);
            com.tencent.mm.plugin.report.service.g.pWK.h(11519, Integer.valueOf(d.bGT().bHZ()), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(1));
            this.soQ.bHl();
            this.soQ.p(4, 0, "");
        } else if (bwt.kyY == 3) {
            this.soQ.sqj.svN.srj = 5;
        } else if (bwt.kyY == 4) {
            a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
            if (this.soQ.mStatus < 6) {
                this.soQ.sqj.svN.srk = 1;
            }
            this.soQ.sqj.svN.sqW = 110;
            this.soQ.p(6, 0, "");
            this.soQ.bHl();
        } else {
            a.eA("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + bwt.kyY);
        }
    }

    public final void a(final bwi bwi) {
        as.Dt().F(new Runnable() {
            public final void run() {
                a.eA("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
                try {
                    bwd bwd = (bwd) new bwd().aH(bwi.vQW.wRm.toByteArray());
                    if (!(bwd.xci == null || bwd.xci.vQW == null || bwd.xci.vQW.wRm == null)) {
                        o.this.stG.xci = bwd.xci;
                    }
                    if (!(bwd.xcj.vQW == null || bwd.xcj.vQW.wRm == null)) {
                        o.this.stG.xcj = bwd.xcj;
                    }
                    if (bwd.xdy != 0) {
                        o.this.stG.xdy = bwd.xdy;
                    }
                    if (!(bwd.xdz == null || bwd.xdz.xct == 0)) {
                        o.this.stG.xdz = bwd.xdz;
                    }
                    if (!(bwd.xdA == null || bwd.xdA.xct == 0)) {
                        o.this.stG.xdA = bwd.xdA;
                    }
                    if (bwd.xdC != 0) {
                        o.this.stG.xdC = bwd.xdC;
                    }
                    if (bwd.xdD != 0) {
                        o.this.stG.xdD = bwd.xdD;
                    }
                    if (bwd.xdH.xct != 0) {
                        o.this.stG.xdH = bwd.xdH;
                    }
                    if (bwd.xdI > 0) {
                        o.this.stG.xdI = bwd.xdI;
                    } else {
                        o.this.stG.xdI = 0;
                        a.eA("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
                    }
                    if (bwd.nJA > 0) {
                        o.this.stG.nJA = bwd.nJA - 1;
                        a.eA("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + o.this.stG.nJA + "] from relaydata");
                    } else {
                        o.this.stG.nJA = 1;
                        a.eA("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
                    }
                    if (bwd.xdJ > 0) {
                        o.this.stG.xdJ = bwd.xdJ;
                        o.this.stG.xdK = bwd.xdK;
                        o.this.stG.xdL = bwd.xdL;
                        o.this.stG.xdM = bwd.xdM;
                        a.eA("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + bwd.xdJ + ", ARQRttThreshold: " + bwd.xdK + ", ARQUsedRateThreshold: " + bwd.xdL + ", ARQRespRateThreshold: " + bwd.xdM);
                    } else {
                        a.eA("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
                    }
                    if (bwd.xdQ > 0) {
                        o.this.stG.xdQ = bwd.xdQ;
                    } else {
                        o.this.stG.xdQ = 0;
                        a.eA("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
                    }
                    o.this.stG.xdT = bwd.xdT;
                    if (bwd.xdV != null) {
                        o.this.stG.xdV = bwd.xdV;
                    }
                    int i = (o.this.stG.xci == null || o.this.stG.xci.vQW == null || o.this.stG.xci.vQW.wRm == null || o.this.stG.xdy == 0 || o.this.stG.xcj == null || o.this.stG.xcj.vQW == null || o.this.stG.xcj.vQW.wRm == null || o.this.stG.xdz == null || o.this.stG.xdz.xct == 0 || o.this.stG.xdA == null || o.this.stG.xdA.xct == 0 || o.this.stG.xdH == null || o.this.stG.xdH.xct == 0) ? 0 : 1;
                    if (i == 0) {
                        a.eA("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                        return;
                    }
                    a.eA("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + o.this.stG.xdT + " BothSideSwitchFlag = " + bwd.xdU);
                    o.this.soQ.yQ(o.this.stG.xdy);
                    o.this.soQ.aN(o.this.stG.xci.vQW.wRm.toByteArray());
                    if (!(bwd.xdF == null || bwd.xdF.wRm == null || bwd.xdR == null || bwd.xdR.wRm == null)) {
                        o.this.soQ.a(bwd.xdF.wRm.toByteArray(), bwd.xdE, o.this.stG.nJA, bwd.xdR.wRm.toByteArray());
                    }
                    if (d.bGT().bHZ() != 0) {
                        o.this.soQ.aO(o.this.stG.xcj.vQW.wRm.toByteArray());
                    }
                    o.this.soQ.a(o.this.stG.xdz, o.this.stG.xdA, o.this.stG.xdH);
                    o.this.soQ.i(o.this.stG.xdI, o.this.stG.xdJ, o.this.stG.xdK, o.this.stG.xdL, o.this.stG.xdM);
                    o.this.soQ.yP(o.this.stG.xdQ);
                    e eVar = o.this.soQ;
                    int i2 = o.this.stG.xdC;
                    int i3 = o.this.stG.xdD;
                    eVar.sqj.sup = i2;
                    eVar.sqj.suq = i3;
                    o.this.soQ.yO(o.this.stG.xdT);
                    o.this.soQ.sqj.svj = bwd.xdU;
                    if (!(bwd.xdO == null || bwd.xdO.wRm == null || bwd.xdP == null || bwd.xdP.wRm == null)) {
                        o.this.soQ.b(bwd.xdN, bwd.xdO.wRm.toByteArray(), bwd.xdP.wRm.toByteArray());
                    }
                    eVar = o.this.soQ;
                    ank ank = o.this.stG.xdV;
                    v2protocal v2protocal = eVar.sqj;
                    a.eB("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + ank.wAD + " Bitrate: " + ank.wAE);
                    v2protocal.field_jbmParamArraySize = 27;
                    v2protocal.field_jbmBitratRsSvrParamArray = new int[v2protocal.field_jbmParamArraySize];
                    v2protocal.field_jbmBitratRsSvrParamArray[0] = ank.wAC;
                    v2protocal.field_jbmBitratRsSvrParamArray[1] = ank.wAD;
                    v2protocal.field_jbmBitratRsSvrParamArray[2] = ank.wAE;
                    v2protocal.field_jbmBitratRsSvrParamArray[3] = ank.wAF;
                    v2protocal.field_jbmBitratRsSvrParamArray[4] = ank.wAG;
                    v2protocal.field_jbmBitratRsSvrParamArray[5] = ank.wAH;
                    v2protocal.field_jbmBitratRsSvrParamArray[6] = ank.wAI;
                    v2protocal.field_jbmBitratRsSvrParamArray[7] = ank.wAL;
                    v2protocal.field_jbmBitratRsSvrParamArray[8] = ank.wAM;
                    v2protocal.field_jbmBitratRsSvrParamArray[9] = ank.wAP;
                    v2protocal.field_jbmBitratRsSvrParamArray[10] = ank.wAQ;
                    v2protocal.field_jbmBitratRsSvrParamArray[11] = ank.wAT;
                    v2protocal.field_jbmBitratRsSvrParamArray[12] = ank.wAU;
                    v2protocal.field_jbmBitratRsSvrParamArray[13] = ank.wAX;
                    v2protocal.field_jbmBitratRsSvrParamArray[14] = ank.wAY;
                    v2protocal.field_jbmBitratRsSvrParamArray[15] = ank.wBb;
                    v2protocal.field_jbmBitratRsSvrParamArray[16] = ank.wBc;
                    v2protocal.field_jbmBitratRsSvrParamArray[17] = ank.wBf;
                    v2protocal.field_jbmBitratRsSvrParamArray[18] = ank.wBg;
                    v2protocal.field_jbmBitratRsSvrParamArray[19] = ank.wBj;
                    v2protocal.field_jbmBitratRsSvrParamArray[20] = ank.wBk;
                    v2protocal.field_jbmBitratRsSvrParamArray[21] = ank.wBn;
                    v2protocal.field_jbmBitratRsSvrParamArray[22] = ank.wBo;
                    v2protocal.field_jbmBitratRsSvrParamArray[23] = ank.wBr;
                    v2protocal.field_jbmBitratRsSvrParamArray[24] = ank.wBs;
                    v2protocal.field_jbmBitratRsSvrParamArray[25] = ank.wBv;
                    v2protocal.field_jbmBitratRsSvrParamArray[26] = ank.wBw;
                    v2protocal.field_jbmParamDoubleArraySize = 20;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray = new double[v2protocal.field_jbmParamDoubleArraySize];
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[0] = ank.wAJ;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[1] = ank.wAK;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[2] = ank.wAN;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[3] = ank.wAO;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[4] = ank.wAR;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[5] = ank.wAS;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[6] = ank.wAV;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[7] = ank.wAW;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[8] = ank.wAZ;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[9] = ank.wBa;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[10] = ank.wBd;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[11] = ank.wBe;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[12] = ank.wBh;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[13] = ank.wBi;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[14] = ank.wBl;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[15] = ank.wBm;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[16] = ank.wBp;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[17] = ank.wBq;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[18] = ank.wBt;
                    v2protocal.field_jbmBitratRsSvrParamDoubleArray[19] = ank.wBu;
                    o.this.soQ.bHj();
                    a.eA("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                }
            }
        });
    }

    public final void b(bwi bwi) {
        e eVar = this.soQ;
        eVar.sqj.sum = bwi.vQW.wRm.toByteArray();
        eVar.bHk();
    }

    public final void c(bes bes) {
        int aS = a.aS(bes.wRm.toByteArray());
        a.eA("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = " + aS);
        e eVar = this.soQ;
        aS &= 255;
        if (8 == aS || 9 == aS) {
            eVar.sqb = aS;
        } else {
            eVar.spZ = aS;
            eVar.spX = aS;
        }
        if (1 == aS || 3 == aS) {
            eVar.yN(2);
        }
        eVar.sqk.yV(aS);
    }

    public final void o(k kVar) {
        x.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
        this.soQ.sqp = false;
        bwv bwv = (bwv) ((m) kVar).bIx();
        this.soQ.sqj.parseSyncKeyBuff(this.soQ.sqn, this.soQ.sqn.length);
        int i = this.soQ.sqj.field_statusSyncKey;
        int i2 = this.soQ.sqj.field_relayDataSyncKey;
        int i3 = this.soQ.sqj.field_connectingStatusKey;
        this.soQ.sqj.parseSyncKeyBuff(bwv.vYE.wRm.toByteArray(), bwv.vYE.wRk);
        int i4 = this.soQ.sqj.field_statusSyncKey;
        int i5 = this.soQ.sqj.field_relayDataSyncKey;
        int i6 = this.soQ.sqj.field_connectingStatusKey;
        x.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + i + " oldRelayDataSyncKey:" + i2 + " oldConnectingStatusSyncKey:" + i3);
        x.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + i4 + " newRelayDataSyncKey:" + i5 + " newConnectingStatusSyncKey:" + i6);
        this.soQ.sqn = bwv.vYE.wRm.toByteArray();
        x.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + bwv.vWu);
        LinkedList linkedList = bwv.xeD.kyB;
        if (linkedList != null && linkedList.size() != 0) {
            x.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + linkedList.size());
            x.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + linkedList.size() + ",selector = " + ((m) kVar).bIv());
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= linkedList.size()) {
                    break;
                }
                bvr bvr = (bvr) linkedList.get(i8);
                int i9 = bvr.wet;
                x.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:" + i9);
                if (i9 == 1) {
                    if (i4 > i) {
                        if (this.soQ.sqj.nJe == 0) {
                            a.ez("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
                        } else {
                            try {
                                bwt bwt = (bwt) new bwt().aH(bvr.weu.wRm.toByteArray());
                                a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + bvr.npW + ",itemStatus =  " + bwt.kyY);
                                a(bwt, 3);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 2) {
                    if (i5 > i2) {
                        if (this.soQ.sqj.nJe == 0) {
                            a.ez("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
                        } else {
                            try {
                                bwi bwi = (bwi) new bwi().aH(bvr.weu.wRm.toByteArray());
                                a.eA("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + bwi.kzz + ",from user = " + bvr.npW);
                                if (bwi.kzz == 5) {
                                    a(bwi);
                                } else if (bwi.kzz == 3) {
                                    this.soQ.aO(bwi.vQW.wRm.toByteArray());
                                    if (!(bwi.vQW == null || bwi.vQW.wRm == null)) {
                                        this.stG.xcj = bwi;
                                    }
                                } else if (bwi.kzz == 2) {
                                    this.soQ.aN(bwi.vQW.wRm.toByteArray());
                                    if (!(bwi.vQW == null || bwi.vQW.wRm == null)) {
                                        this.stG.xci = bwi;
                                    }
                                } else if (bwi.kzz == 1) {
                                    b(bwi);
                                }
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 3 && i6 > i3) {
                    if (this.soQ.sqj.nJe == 0) {
                        x.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
                    } else {
                        try {
                            bes bm = new bes().bm(bvr.weu.wRm.toByteArray());
                            if (bvr.npW.equals(q.FY())) {
                                a.ez("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
                            } else {
                                c(bm);
                            }
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e22, "", new Object[0]);
                        }
                    }
                }
                i7 = i8 + 1;
            }
        }
        x.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
        if ((this.stH != null && this.stH.kyA > 0) || this.stI > 0) {
            a(null, false, 7);
        }
    }
}
