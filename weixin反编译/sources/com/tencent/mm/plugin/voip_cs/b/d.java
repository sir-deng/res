package com.tencent.mm.plugin.voip_cs.b;

import android.os.Looper;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.g;
import com.tencent.mm.plugin.brandservice.a.j;
import com.tencent.mm.plugin.voip_cs.b.c.b;
import com.tencent.mm.plugin.voip_cs.b.c.c;
import com.tencent.mm.plugin.voip_cs.b.c.f;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.protocal.c.buv;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.protocal.c.bva;
import com.tencent.mm.protocal.c.bvc;
import com.tencent.mm.protocal.c.bvg;
import com.tencent.mm.protocal.c.bvj;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bwf;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Arrays;
import java.util.List;

public final class d implements e {
    public int nJo = 0;
    public a sCT;
    public int sCU = 0;
    public int sCV = 0;
    public int sCW = 0;
    public byte[] sCX = null;
    public int sCY = 0;
    public int sCZ = 0;
    public int sCq = 0;
    public int sDa = 0;
    public String sDb = "";
    public int sDc = 0;
    public int sDd = 999;
    public al sDe = new al(Looper.getMainLooper(), new a() {
        public final boolean uG() {
            x.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
            d.this.bJI();
            return true;
        }
    }, true);
    public al sDf = new al(Looper.getMainLooper(), new a() {
        public final boolean uG() {
            x.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
            as.CN().a(795, d.this);
            as.CN().a(new b(b.bJC().nKn.suj, b.bJC().nKn.nJf), 0);
            return true;
        }
    }, true);
    public int sqt = 0;

    public final void bJI() {
        as.CN().a(818, (e) this);
        as.CN().a(new f(b.bJC().nKn.suj, b.bJC().nKn.nJf, this.sCU), 0);
    }

    private static void b(int i, int i2, k kVar) {
        x.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + i + " errCode:" + i2);
        if (i2 != 0) {
            x.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:" + i2);
            return;
        }
        bvj bvj = (bvj) ((com.tencent.mm.plugin.voip_cs.b.c.d) kVar).gLB.hnR.hnY;
        x.i("MicroMsg.voipcs.VoipCSService", "roomid " + bvj.xcP + " key " + bvj.wim + "relay addr cnt " + bvj.vQG.size());
        List<bva> list = bvj.vQG;
        buw buw = new buw();
        for (bva bva : list) {
            buv buv = new buv();
            b.bJC();
            buv.wXY = com.tencent.mm.plugin.voip_cs.b.b.a.Nq(bva.wDa);
            buv.wMQ = bva.wMQ;
            buw.xcu.add(buv);
        }
        buw.xct = list.size();
        b.bJC().nKn.a(buw, buw, null, 0, 0);
    }

    public final void a(bvo bvo) {
        if (bvo.xcZ > this.sCU && b.bJD().sDa != 3) {
            x.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + bvo.xcZ + ",calleeMemberId:" + bvo.xda + ",calleeStatus:" + bvo.xdb + ",calleeSubStatus:" + bvo.xdc + ",recv roomId:" + bvo.xcP + ",recv roomKey:" + bvo.wim);
            if (b.bJC().nKn.suj == 0 || b.bJC().nKn.suj == bvo.xcP) {
                this.sCU = bvo.xcZ;
                this.sCq = bvo.xda;
                this.sCV = bvo.xdb;
                this.sCW = bvo.xdc;
                b.bJE().sCq = this.sCq;
                if (this.sCV == 2) {
                    x.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
                    this.sDe.TN();
                    bJI();
                    b.bJC().nKn.nJf = bvo.wim;
                    x.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + bvo.xcP + ",roomkey:" + bvo.wim);
                    this.sCX = bvo.xdd != null ? bvo.xdd.toByteArray() : null;
                    if (b.bJC().nKn.field_capInfo != null && this.sCX != null) {
                        int i;
                        c bJE = b.bJE();
                        x.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
                        if (bJE.sCD == 0) {
                            bJE.sCP = (int) (System.currentTimeMillis() / 1000);
                            bJE.sCD = (long) (bJE.sCP - bJE.sCN);
                        }
                        b.bJC().nKn.sul = this.sCX;
                        x.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(b.bJC().nKn.sul));
                        x.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.sCX.length);
                        if (b.bJC().nKn.sul != null && b.bJC().nKn.exchangeCabInfo(b.bJC().nKn.sul, b.bJC().nKn.sul.length) < 0) {
                            x.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
                        }
                        if (b.bJC().nKn.suo == null) {
                            i = 0;
                        } else {
                            i = b.bJC().nKn.suo.length;
                        }
                        if (b.bJC().nKn.setConfigInfo(b.bJC().nKn.sui, b.bJC().nKn.suj, b.bJC().nKn.nJm, b.bJC().nKn.nJf, b.bJC().nKn.field_peerId, 1, b.bJC().nKn.sup, b.bJC().nKn.suq, b.bJC().nKn.sun, i, b.bJC().nKn.suo, this.sDd, 1, b.bJC().nKn.netType, b.bJC().nKn.svg, b.bJC().nKn.svh, 255, 0) != 0) {
                            x.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", Integer.valueOf(b.bJC().nKn.setConfigInfo(b.bJC().nKn.sui, b.bJC().nKn.suj, b.bJC().nKn.nJm, b.bJC().nKn.nJf, b.bJC().nKn.field_peerId, 1, b.bJC().nKn.sup, b.bJC().nKn.suq, b.bJC().nKn.sun, i, b.bJC().nKn.suo, this.sDd, 1, b.bJC().nKn.netType, b.bJC().nKn.svg, b.bJC().nKn.svh, 255, 0)));
                        }
                        if (b.bJC().nKn.connectToPeer() != 0) {
                            x.e("MicroMsg.voipcs.VoipCSService", "connectToPeer fail, ret:%d", Integer.valueOf(b.bJC().nKn.connectToPeer()));
                        }
                        if (this.sDf.cgx()) {
                            this.sDf.K(50000, 50000);
                        }
                        b.bJE().sCw = 1;
                        return;
                    }
                    return;
                } else if (this.sCV != 0 && this.sCV != 1 && this.sCV == 3) {
                    x.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
                    b.bJE().bjS = 5;
                    b.bJE().bJF();
                    b.bJE().sCA = 2;
                    if (this.sCW == 1) {
                        b.bJE().sCs = 12;
                    } else if (this.sCW == 3) {
                        b.bJE().sCs = 99;
                    }
                    if (this.sCT != null) {
                        this.sCT.zo(1);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            x.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + b.bJC().nKn.suj + ",recv roomId:" + bvo.xcP + ",current and recv not equal!!");
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        String str2;
        if (i != 0 || i2 != 0) {
            x.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 && i != 4) {
                this.sDc = -1;
                this.sCT.onError(10);
            } else if (kVar.getType() == 823) {
                if (i2 == 406) {
                    x.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
                    return;
                }
                b.bJE().bjS = 1;
                this.sDc = 823;
                this.sCT.onError(i2);
            } else if (kVar.getType() != 880 && kVar.getType() != 818 && kVar.getType() == 455) {
                this.sCT.eD("", "");
            }
        } else if (kVar.getType() == 823) {
            buv buv;
            bvg bvg = (bvg) ((c) kVar).gLB.hnR.hnY;
            long j = bvg.xcP;
            long j2 = bvg.wim;
            List<bva> list = bvg.vQG;
            List<bva> list2 = bvg.xcY;
            this.nJo = bvg.xcU;
            this.sDd = bvg.xcX;
            x.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.sDd);
            b.bJC().nKn.suq = bvg.nJv;
            this.sCY = bvg.nJp;
            b.bJC().nKn.svg = bvg.nJA;
            b.bJC().nKn.svh = bvg.wNh.toByteArray();
            b.bJC().nKn.sup = bvg.nJw;
            buw buw = new buw();
            for (bva bva : list) {
                buv = new buv();
                b.bJC();
                buv.wXY = com.tencent.mm.plugin.voip_cs.b.b.a.Nq(bva.wDa);
                buv.wMQ = bva.wMQ;
                buw.xcu.add(buv);
            }
            buw.xct = list.size();
            buw buw2 = new buw();
            for (bva bva2 : list2) {
                buv = new buv();
                b.bJC();
                buv.wXY = com.tencent.mm.plugin.voip_cs.b.b.a.Nq(bva2.wDa);
                buv.wMQ = bva2.wMQ;
                buw2.xcu.add(buv);
            }
            buw2.xct = list2.size();
            b.bJC().nKn.suj = j;
            b.bJC().nKn.nJf = j2;
            x.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + j + ",roomKey:" + j2);
            b.bJC().nKn.svq = bvg.xcV;
            b.bJC().nKn.svr = bvg.xcW;
            bwf bwf = new bwf();
            bwf.xdY = 0;
            bwf.xdZ = 0;
            bwf.xea = 0;
            bwf.userName = "";
            bwf.mHK = "";
            if (b.bJC().nKn.a(buw, buw, buw, bwf) != 0) {
                x.i("MicroMsg.voipcs.VoipCSService", "setIp fail!");
            }
            c bJE = b.bJE();
            str2 = this.sDb;
            x.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
            bJE.sCo = j;
            bJE.nJf = j2;
            bJE.sCp = str2;
            if (this.sDe.cgx()) {
                if (this.nJo > 0) {
                    j = (long) (this.nJo * 1000);
                    this.sDe.K(j, j);
                } else {
                    this.sDe.K(4000, 4000);
                }
            }
            bJE = b.bJE();
            x.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (bJE.sCN != 0) {
                bJE.sCO = (int) (System.currentTimeMillis() / 1000);
            }
        } else if (kVar.getType() == 818) {
            bvo bvo = (bvo) ((f) kVar).gLB.hnR.hnY;
            x.i("MicroMsg.voipcs.VoipCSService", "sync status = " + bvo.xdb + ",notifySeq = " + bvo.xcZ);
            a(bvo);
        } else if (kVar.getType() == 880) {
            bvc bvc = (bvc) ((com.tencent.mm.plugin.voip_cs.b.c.a) kVar).gLB.hnR.hnY;
            if (b.bJC().nKn.suj == bvc.xcP && b.bJC().nKn.nJf == bvc.wim) {
                x.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
            }
            as.CN().b(880, (e) this);
            b.bJE().zp(com.tencent.mm.plugin.voip_cs.b.a.a.bJK().str.bJr());
        } else if (kVar.getType() == 455) {
            j jVar = (j) kVar;
            str2 = "";
            String str3 = "";
            if (jVar.kKD == null || jVar.kKD.size() <= 0) {
                x.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
            } else {
                bgl bgl = (bgl) jVar.kKD.get(0);
                str2 = bgl.wbY;
                str3 = bgl.wzM.wRo;
            }
            this.sCT.eD(str2, str3);
        } else if (kVar.getType() == g.CTRL_INDEX) {
            b(i, i2, kVar);
        } else if (kVar.getType() == 312) {
            bvm bvm = (bvm) ((com.tencent.mm.plugin.voip_cs.b.c.e) kVar).gLB.hnR.hnY;
            if (bvm.xcP == b.bJC().nKn.suj && bvm.wim == b.bJC().nKn.nJf) {
                x.i("MicroMsg.voipcs.VoipCSService", "report data success!");
            }
        }
    }
}
