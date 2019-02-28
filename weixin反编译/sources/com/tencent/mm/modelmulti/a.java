package com.tencent.mm.modelmulti;

import com.tencent.mm.ac.d;
import com.tencent.mm.ac.e;
import com.tencent.mm.ac.h;
import com.tencent.mm.af.f;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.jy;
import com.tencent.mm.f.a.mb;
import com.tencent.mm.f.a.od;
import com.tencent.mm.f.a.rh;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.alz;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.asm;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.bol;
import com.tencent.mm.protocal.c.bsz;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.Map;
import junit.framework.Assert;
import org.xwalk.core.R;

public final class a implements p {
    public final void a(ot otVar, byte[] bArr, boolean z, r rVar) {
        String a;
        ag Xv;
        b mbVar;
        h hVar;
        String FY;
        int i;
        switch (otVar.wet) {
            case 13:
                asm asm = (asm) new asm().aH(bArr);
                if (1 == asm.wGS) {
                    as.Hm();
                    c.Fn().c(n.a(asm.wfM), asm.wGC == 1, asm.wGT == 1);
                    return;
                }
                x.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + asm.wGS);
                return;
            case 15:
                arx arx = (arx) new arx().aH(bArr);
                if (arx != null) {
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + arx.wfM + " nickname:" + arx.wzM);
                    a = n.a(arx.wfM);
                    as.Hm();
                    ag Xv2 = c.Ff().Xv(a);
                    Xv2.setUsername(a);
                    Xv2.dc(n.a(arx.wzM));
                    Xv2.dd(n.a(arx.wfA));
                    Xv2.de(n.a(arx.wfB));
                    Xv2.eD(arx.hxe);
                    Xv2.da(n.a(arx.wFS));
                    Xv2.dg(n.a(arx.wFU));
                    Xv2.dh(n.a(arx.wFT));
                    Xv2.eG(arx.weW);
                    h hVar2 = new h();
                    hVar2.fEo = -1;
                    hVar2.username = Xv2.field_username;
                    hVar2.hnh = arx.wbZ;
                    hVar2.hni = arx.wbY;
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", hVar2.getUsername(), hVar2.JM(), hVar2.JN());
                    hVar2.bC(true);
                    if (arx.wGj == 3 || arx.wGj == 4) {
                        Xv2.eC(arx.wGj);
                        hVar2.fWZ = arx.wGj;
                    } else if (arx.wGj == 2) {
                        Xv2.eC(3);
                        hVar2.fWZ = 3;
                        Xv2.eC(3);
                        if (!q.FY().equals(Xv2.field_username)) {
                            com.tencent.mm.ac.n.JF();
                            d.y(Xv2.field_username, false);
                            com.tencent.mm.ac.n.JF();
                            d.y(Xv2.field_username, true);
                            com.tencent.mm.ac.n.JY().jb(Xv2.field_username);
                        }
                    }
                    com.tencent.mm.ac.n.JW().a(hVar2);
                    as.Hm();
                    c.Ff().R(Xv2);
                    com.tencent.mm.af.d jN = y.Ml().jN(Xv2.field_username);
                    jN.field_username = Xv2.field_username;
                    jN.field_brandList = arx.hxo;
                    py pyVar = arx.wCx;
                    if (pyVar != null) {
                        jN.field_brandFlag = pyVar.hxs;
                        jN.field_brandInfo = pyVar.hxu;
                        jN.field_brandIconURL = pyVar.hxv;
                        jN.field_extInfo = pyVar.hxt;
                    }
                    if (!y.Ml().e(jN)) {
                        y.Ml().d(jN);
                        return;
                    }
                    return;
                }
                return;
            case 22:
                alz alz = (alz) new alz().aH(bArr);
                com.tencent.mm.modelfriend.q qVar = new com.tencent.mm.modelfriend.q();
                qVar.username = alz.kyG;
                qVar.hxY = alz.wzN;
                qVar.hqN = (int) bi.Wx();
                af.ON().a(qVar);
                return;
            case 23:
                wu wuVar = (wu) new wu().aH(bArr);
                switch (wuVar.wnP) {
                    case 1:
                        as.Hm();
                        c.Db().set(17, Integer.valueOf(wuVar.wnQ));
                        return;
                    case 4:
                        return;
                    default:
                        x.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + wuVar.wnP);
                        return;
                }
            case 24:
                bad bad = (bad) new bad().aH(bArr);
                Assert.assertTrue(bad != null);
                Assert.assertTrue(bi.oM(bad.kyG).length() > 0);
                if (com.tencent.mm.storage.x.Xf(bad.kyG)) {
                    as.Hm();
                    Xv = c.Ff().Xv(bad.kyG);
                    if (Xv == null || ((int) Xv.gKO) == 0) {
                        Xv = new com.tencent.mm.storage.x(bad.kyG);
                        Xv.At();
                        Xv.dc(bad.wbX);
                        Xv.da(bad.wbX);
                        Xv.eG(4);
                        as.Hm();
                        if (c.Ff().T(Xv) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
                            return;
                        }
                        com.tencent.mm.ac.b.iX(Xv.field_username);
                    } else if (!bi.oM(bad.wbX).equals(bi.oM(Xv.field_username))) {
                        Xv.dc(bad.wbX);
                        Xv.da(bad.wbX);
                        as.Hm();
                        if (c.Ff().a(Xv.field_username, Xv) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
                        }
                    }
                    mbVar = new mb();
                    mbVar.fEt.opType = 1;
                    mbVar.fEt.fEx = bad.kyG;
                    mbVar.fEt.fEy = bad.wNC;
                    mbVar.fEt.fEz = bad.wfd;
                    com.tencent.mm.sdk.b.a.xmy.m(mbVar);
                    return;
                }
                x.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
                return;
            case 25:
                bol bol = (bol) new bol().aH(bArr);
                Assert.assertTrue(bol != null);
                Assert.assertTrue(bi.oM(bol.kyG).length() > 0);
                if (com.tencent.mm.storage.x.Xd(bol.kyG)) {
                    as.Hm();
                    Xv = c.Ff().Xv(bol.kyG);
                    if (Xv == null || ((int) Xv.gKO) == 0) {
                        Xv = new com.tencent.mm.storage.x(bol.kyG);
                        Xv.da(bol.wbX);
                        Xv.eG(1);
                        Xv.At();
                        as.Hm();
                        if (c.Ff().T(Xv) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
                            return;
                        }
                        a = Xv.field_username;
                        if (a == null) {
                            x.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        } else if (a.endsWith("@t.qq.com")) {
                            hVar = new h();
                            hVar.username = a;
                            hVar.fWZ = 3;
                            hVar.fEo = 3;
                            com.tencent.mm.ac.n.JW().a(hVar);
                        } else {
                            x.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        }
                    } else if (!bi.oM(bol.wbX).equals(bi.oM(Xv.field_username))) {
                        Xv.da(bol.wbX);
                        as.Hm();
                        if (c.Ff().a(Xv.field_username, Xv) == -1) {
                            x.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
                        }
                    }
                    mbVar = new rh();
                    mbVar.fJQ.opType = 1;
                    mbVar.fJQ.fEx = bol.kyG;
                    mbVar.fJQ.fEy = bol.wNC;
                    mbVar.fJQ.fEz = bol.wfd;
                    com.tencent.mm.sdk.b.a.xmy.m(mbVar);
                    return;
                }
                x.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
                return;
            case 33:
                aru aru = (aru) new aru().aH(bArr);
                Assert.assertTrue(aru != null);
                Assert.assertTrue(bi.oM(aru.kyG).length() > 0);
                com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
                xVar.setUsername(aru.kyG);
                xVar.setType(aru.kzz);
                xVar.eD(aru.hxe);
                xVar.dv(RegionCodeDecoder.ai(aru.hxn, aru.hxf, aru.hxg));
                xVar.dp(aru.hxh);
                h hVar3 = new h();
                hVar3.fEo = -1;
                hVar3.username = aru.kyG;
                hVar3.hnh = aru.wbZ;
                hVar3.hni = aru.wbY;
                x.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", hVar3.getUsername(), hVar3.JM(), hVar3.JN());
                x.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + aru.wGj + " hd:" + aru.wGk);
                hVar3.bC(aru.wGk != 0);
                if (aru.wGj == 3 || aru.wGj == 4) {
                    xVar.eC(aru.wGj);
                    hVar3.fWZ = aru.wGj;
                } else if (aru.wGj == 2) {
                    xVar.eC(3);
                    hVar3.fWZ = 3;
                    com.tencent.mm.ac.n.JF();
                    d.y(aru.kyG, false);
                    com.tencent.mm.ac.n.JF();
                    d.y(aru.kyG, true);
                    com.tencent.mm.ac.n.JY().jb(aru.kyG);
                } else {
                    xVar.eC(3);
                    hVar3.fWZ = 3;
                }
                com.tencent.mm.ac.n.JW().a(hVar3);
                as.Hm();
                c.Ff().Q(xVar);
                return;
            case 35:
                String str;
                asv asv = (asv) new asv().aH(bArr);
                Assert.assertTrue(asv != null);
                FY = q.FY();
                i = asv.vUT;
                if (i == 2) {
                    FY = com.tencent.mm.storage.x.Xk(FY);
                    as.Hm();
                    str = FY;
                    FY = (String) c.Db().get(12553, null);
                } else {
                    as.Hm();
                    str = FY;
                    FY = (String) c.Db().get(12297, null);
                }
                boolean z2 = false;
                if (FY == null || !FY.equals(asv.wHc)) {
                    com.tencent.mm.ac.n.JF();
                    d.y(str, true);
                    as.Hm();
                    c.Db().set(i == 2 ? 12553 : 12297, asv.wHc);
                    z2 = true;
                }
                x.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", Boolean.valueOf(z2), Integer.valueOf(i), asv.wHc, asv.wbY, asv.wbZ);
                hVar = new h();
                hVar.username = str;
                hVar.hni = asv.wbY;
                hVar.hnh = asv.wbZ;
                if (!bi.oN(hVar.JN())) {
                    if (i == 1) {
                        as.Hm();
                        c.Db().set(59, Boolean.valueOf(true));
                    } else {
                        as.Hm();
                        c.Db().set(60, Boolean.valueOf(true));
                    }
                }
                hVar.bC(false);
                hVar.fEo = 56;
                if (!bi.oN(asv.wHc)) {
                    hVar.bC(true);
                }
                com.tencent.mm.ac.n.JW().a(hVar);
                if (z2) {
                    new e().a(str, new e.b() {
                        public final int ba(int i, int i2) {
                            return 0;
                        }
                    });
                    return;
                }
                return;
            case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                bsz bsz = (bsz) new bsz().aH(bArr);
                x.d("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag " + bsz.wCw.hxp);
                as.Hm();
                a = (String) c.Db().get(2, null);
                if (a != null && a.length() > 0) {
                    if (com.tencent.mm.plugin.sns.b.n.qWC != null) {
                        com.tencent.mm.plugin.sns.b.n.qWC.a(a, bsz.wCw);
                    }
                    com.tencent.mm.af.d jV = f.jV(q.FY());
                    if (jV == null) {
                        jV = new com.tencent.mm.af.d();
                    }
                    jV.field_username = a;
                    jV.field_brandList = bsz.hxo;
                    if (!(!jV.Ll() || jV.bK(false) == null || jV.bK(false).LM() == null || bi.oN(jV.Ls()))) {
                        jV.field_enterpriseFather = jV.Ls();
                        x.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", a, jV.field_enterpriseFather);
                    }
                    if (!y.Ml().e(jV)) {
                        y.Ml().d(jV);
                    }
                    int i2 = bsz.xaQ;
                    int i3 = bsz.xaR;
                    i = bsz.xaS;
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i2 + " rommquota: " + i3 + " invite: " + i);
                    as.Hm();
                    c.Db().set(135175, Integer.valueOf(i2));
                    as.Hm();
                    c.Db().set(135176, Integer.valueOf(i3));
                    as.Hm();
                    c.Db().set(135177, Integer.valueOf(i));
                    as.Hm();
                    c.Db().set(144385, Integer.valueOf(bsz.xaW));
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(bsz.woN));
                    as.Hm();
                    c.Db().set(339975, Integer.valueOf(bsz.xbe));
                    x.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", Integer.valueOf(bsz.xbe), Integer.valueOf(bsz.woN));
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_PROFILE_WEIDIANINFO_STRING, bi.aD(bsz.fXy, ""));
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", bsz.fXy);
                    as.Hm();
                    c.Db().set(147457, Long.valueOf(bsz.xbf));
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_F2F_RING_TONE_STRING, bsz.xbg);
                    hVar = new h();
                    hVar.fEo = -1;
                    hVar.username = a;
                    hVar.hni = bsz.wbY;
                    hVar.hnh = bsz.wbZ;
                    hVar.bC(true);
                    hVar.fWZ = 3;
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", hVar.getUsername(), hVar.JM(), hVar.JN());
                    com.tencent.mm.ac.n.JW().a(hVar);
                    a = bsz.wGu;
                    FY = bsz.wGv;
                    as.Hm();
                    c.Db().set(274433, FY);
                    as.Hm();
                    c.Db().set(274434, a);
                    if (bsz.vOb != null) {
                        as.Hm();
                        c.Db().set(286721, bsz.vOb.vSL);
                        as.Hm();
                        c.Db().set(286722, bsz.vOb.vSM);
                        as.Hm();
                        c.Db().set(286723, bsz.vOb.vSN);
                    }
                    if (bsz.xbc != null && bsz.xbc.wKF != null && bsz.xbc.wKF.wRk > 0) {
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", Integer.valueOf(bsz.xbc.wKF.wRk));
                        mbVar = new rz();
                        mbVar.fKB.fKC = bsz.xbc;
                        com.tencent.mm.sdk.b.a.xmy.m(mbVar);
                        return;
                    }
                    return;
                }
                return;
            case 53:
                atm atm = (atm) new atm().aH(bArr);
                x.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", Integer.valueOf(atm.nlX), Long.valueOf(atm.vNT));
                if (s.gY(atm.npW)) {
                    mbVar = new od();
                    mbVar.fGS.frh = atm.vNT;
                    com.tencent.mm.sdk.b.a.xmy.m(mbVar);
                    return;
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX /*204*/:
                a((by) new by().aH(bArr), rVar);
                return;
            case 999999:
                try {
                    int p = com.tencent.mm.a.n.p(bArr, 0);
                    x.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", Integer.valueOf(p));
                    if (p > 0) {
                        Thread.sleep((long) p);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
                    return;
                }
            default:
                x.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + otVar.wet);
                return;
        }
    }

    public static boolean a(com.tencent.mm.storage.x xVar) {
        String str;
        String str2;
        Object[] objArr;
        if (xVar == null || bi.oN(xVar.field_username)) {
            String str3;
            str = "MicroMsg.BigBallOfMudSyncExtension";
            str2 = "dealModContactExtInfo username:%s ";
            objArr = new Object[1];
            if (xVar == null) {
                str3 = "-1";
            } else {
                str3 = xVar.field_username;
            }
            objArr[0] = str3;
            x.w(str, str2, objArr);
            return false;
        }
        as.Hm();
        byte[] Xz = c.Ff().Xz(xVar.field_username);
        if (bi.by(Xz)) {
            str = "MicroMsg.BigBallOfMudSyncExtension";
            str2 = "dealModContactExtInfo username:%s  buf:%d";
            objArr = new Object[2];
            objArr[0] = xVar.field_username;
            objArr[1] = Integer.valueOf(Xz == null ? -1 : Xz.length);
            x.w(str, str2, objArr);
            return false;
        }
        asc asc;
        try {
            asc = (asc) new asc().aH(Xz);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", e, "", new Object[0]);
            asc = null;
        }
        as.Hm();
        c.Ff().XA(xVar.field_username);
        if (asc != null) {
            return com.tencent.mm.plugin.bbom.c.a(xVar, asc, false);
        }
        x.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        return false;
    }

    public final void a(by byVar, r rVar) {
        long EX;
        ae aeVar;
        Object obj;
        int i;
        String str;
        final String a = n.a(byVar.vNV);
        long j = byVar.vNT;
        int i2 = byVar.pgR;
        int i3 = byVar.vNY;
        int i4 = byVar.vNU;
        int i5 = byVar.nlX;
        int i6 = byVar.vNW;
        String a2 = n.a(byVar.vNX);
        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", a, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), bi.Wz(a2));
        if (bi.oN(a)) {
            x.e("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId is null and ret");
        }
        if (i6 == 0) {
            com.tencent.mm.plugin.report.d.pVE.a(403, 24, 1, false);
            if (bi.aD(bb.hS(a2), "").equals(q.FY())) {
                as.Hm();
                au G = c.Fh().G(a, j);
                if (G.field_msgId > 0 && G.field_isSend == 1) {
                    x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList self send msg[%d] createtime[%d, %d] svrid[%d, %d] seq[%d, %d]", Long.valueOf(G.field_msgId), Long.valueOf(G.field_createTime), Integer.valueOf(i2), Long.valueOf(G.field_msgSvrId), Long.valueOf(j), Long.valueOf(G.field_msgSeq), Integer.valueOf(i4));
                    if (G.field_msgSeq == 0) {
                        com.tencent.mm.plugin.report.d.pVE.a(403, 25, 1, false);
                        G.as((long) i4);
                        as.Hm();
                        c.Fh().a(G.field_msgId, G);
                        return;
                    }
                    return;
                }
            }
        }
        as.Hm();
        ak XF = c.Fk().XF(a);
        ak aeVar2;
        if (XF == null) {
            com.tencent.mm.plugin.report.d.pVE.a(403, 22, 1, false);
            ak aeVar3 = new ae(a);
            aeVar3.aj(((long) i2) * 1000);
            aeVar3.al((long) i4);
            aeVar3.eP(i6);
            aeVar3.eX(i6);
            as.Hm();
            EX = c.FQ().EX(a);
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", Long.valueOf(EX), Integer.valueOf(i4));
            if (EX > 0) {
                aeVar3.am(EX);
                aeVar2 = aeVar3;
                obj = 1;
            } else {
                aeVar3.am((long) i4);
                aeVar2 = aeVar3;
                int obj2 = 1;
            }
        } else {
            i = (int) XF.field_lastSeq;
            com.tencent.mm.plugin.report.d.pVE.a(403, 23, 1, false);
            if (i6 < XF.field_UnDeliverCount) {
                com.tencent.mm.plugin.report.d.pVE.a(403, 26, (long) XF.field_UnDeliverCount, false);
            }
            if (i4 > i) {
                XF.al((long) i4);
                XF.eX(i6);
                XF.aj(bb.n(a, (long) i2));
                if (i6 > XF.field_unReadCount) {
                    XF.eP(i6);
                }
                x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList  msgSeq[%d], firstSeq[%d], lastseq[%d]", Integer.valueOf(i4), Long.valueOf(XF.field_firstUnDeliverSeq), Integer.valueOf(i));
                if (XF.field_firstUnDeliverSeq > 0) {
                    as.Hm();
                    cg H = c.Fh().H(a, (long) i);
                    if (H.field_msgId > 0) {
                        XF.am(H.field_msgSeq);
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d reset firstSeq:%d to last exist: %d", Integer.valueOf(i6), Long.valueOf(EX), Long.valueOf(XF.field_firstUnDeliverSeq));
                        com.tencent.mm.plugin.report.d.pVE.a(403, 28, 1, false);
                        aeVar2 = XF;
                        obj2 = null;
                    } else {
                        com.tencent.mm.plugin.report.d.pVE.a(403, 29, 1, false);
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d lastSeq:%d not existed", Integer.valueOf(i6), Integer.valueOf(i));
                        aeVar2 = XF;
                        obj2 = null;
                    }
                } else {
                    long EX2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).FQ().EX(a);
                    x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList lastDeleteSeq[%s]", Long.valueOf(EX2));
                    if (EX2 > 0) {
                        com.tencent.mm.plugin.report.d.pVE.a(403, 30, 1, false);
                        XF.am(EX2);
                        aeVar2 = XF;
                        obj2 = null;
                    } else {
                        as.Hm();
                        long Fz = c.Fh().Fz(a);
                        x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList lastMsgSeq[%s]", Long.valueOf(Fz));
                        if (Fz > 0) {
                            XF.am(Fz);
                            com.tencent.mm.plugin.report.d.pVE.a(403, 31, 1, false);
                            aeVar2 = XF;
                            obj2 = null;
                        } else {
                            com.tencent.mm.plugin.report.d.pVE.a(403, 32, 1, false);
                            aeVar2 = XF;
                            obj2 = null;
                        }
                    }
                }
            } else {
                if (i4 == i && i6 == 0 && XF.field_unReadCount > 0) {
                    com.tencent.mm.plugin.report.d.pVE.a(403, 33, 1, false);
                    XF.eP(0);
                }
                x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList msgSeq <= lastSeq, do nothing [%d, %d]", Integer.valueOf(i4), Integer.valueOf(i));
                return;
            }
        }
        if (i3 > 0) {
            aeVar2.eV(aeVar2.field_atCount + i3);
        }
        au auVar = new au();
        auVar.eS(0);
        auVar.dU(a);
        auVar.setType(i5);
        auVar.setContent(a2);
        if (i5 == 49) {
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(j.fk(a, a2));
            auVar.setType(l.d(fV));
            auVar.setContent(auVar.cjK() ? fV.content : a2);
        } else if (i5 == 10002) {
            as.getSysCmdMsgExtension();
            if (auVar.getType() == 10002 && !bi.oN(a2)) {
                if (bi.oN(a2)) {
                    x.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                } else {
                    Map map;
                    if (a2.startsWith("~SEMI_XML~")) {
                        Map VU = ay.VU(a2);
                        if (VU == null) {
                            x.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                        } else {
                            Map map2 = VU;
                            str = "brand_service";
                            map = map2;
                        }
                    } else {
                        i = a2.indexOf("<sysmsg");
                        if (i == -1) {
                            x.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                        } else {
                            map = bj.y(a2.substring(i), "sysmsg");
                            if (map == null) {
                                x.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                            } else {
                                str = (String) map.get(".sysmsg.$type");
                            }
                        }
                    }
                    if (str != null && str.equals("revokemsg")) {
                        x.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                        map.get(".sysmsg.revokemsg.session");
                        str = (String) map.get(".sysmsg.revokemsg.newmsgid");
                        x.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", str, (String) map.get(".sysmsg.revokemsg.replacemsg"));
                        auVar.setContent(r4);
                        auVar.setType(10000);
                    }
                }
            }
        }
        aeVar2.eS(0);
        aeVar2.setContent(auVar.field_content);
        aeVar2.dG(Integer.toString(auVar.getType()));
        as.Hm();
        com.tencent.mm.storage.as.b ux = c.Fk().ux();
        if (ux != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            ux.a(auVar, pString, pString2, pInt, false);
            aeVar2.dH(pString.value);
            aeVar2.dI(pString2.value);
            aeVar2.eT(pInt.value);
            if (auVar.getType() == 49) {
                str = (String) bj.y(aeVar2.field_content, "msg").get(".msg.appmsg.title");
                aeVar2.dH(bi.oM(aeVar2.field_digest).concat(bi.oN(str) ? "" : " " + bi.oM(str)));
            }
        } else {
            aeVar2.dH(aeVar2.field_content);
        }
        if (obj2 != null) {
            as.Hm();
            EX = c.Fk().d(aeVar2);
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", a, Long.valueOf(EX), Long.valueOf(aeVar2.field_firstUnDeliverSeq), Long.valueOf(aeVar2.field_lastSeq), Integer.valueOf(aeVar2.field_UnDeliverCount));
        } else {
            aeVar2.eU(aeVar2.field_attrflag & -1048577);
            as.Hm();
            EX = (long) c.Fk().a(aeVar2, a, true);
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", a, Long.valueOf(EX), Long.valueOf(aeVar2.field_firstUnDeliverSeq), Long.valueOf(aeVar2.field_lastSeq), Integer.valueOf(aeVar2.field_UnDeliverCount));
        }
        as.Hm();
        final com.tencent.mm.storage.q hH = c.Fo().hH(a);
        as.Hm();
        com.tencent.mm.k.a Xv = c.Ff().Xv(a);
        if (Xv == null || ((int) Xv.gKO) <= 0) {
            x.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], contact is null need get", a);
            com.tencent.mm.y.ak.a.hhv.a(a, null, new com.tencent.mm.y.ak.b.a() {
                public final void v(String str, boolean z) {
                    if (hH != null && hH.ciE()) {
                        b jyVar = new jy();
                        jyVar.fBT.chatroomName = a;
                        jyVar.fBT.fBU = hH.ciD();
                        com.tencent.mm.sdk.b.a.xmy.m(jyVar);
                    }
                }
            });
        }
        if (com.tencent.mm.sdk.a.b.foreground && i5 != 10002 && i6 > 0) {
            bx bxVar = new bx();
            bxVar.vNM = byVar.vNV;
            bxVar.vNN = n.oK(q.FY());
            bxVar.pgR = byVar.pgR;
            bxVar.vNO = byVar.vNX;
            bxVar.nlX = byVar.nlX;
            bxVar.vNT = byVar.vNT;
            bxVar.vNU = byVar.vNU;
            if (rVar != null) {
                rVar.a(auVar, bxVar);
            }
        }
    }
}
