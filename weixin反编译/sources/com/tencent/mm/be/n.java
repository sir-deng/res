package com.tencent.mm.be;

import com.tencent.mm.ac.h;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.f.a.it;
import com.tencent.mm.f.a.mf;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;

public final class n implements d {
    public final b b(a aVar) {
        int i = 0;
        bx bxVar = aVar.hoa;
        String a = com.tencent.mm.platformtools.n.a(bxVar.vNM);
        if ("fmessage".equals(a) || bxVar.nlX == 37) {
            String a2 = com.tencent.mm.platformtools.n.a(bxVar.vNO);
            final au.d Yb = au.d.Yb(a2);
            String FY = q.FY();
            if (Yb.sfb == null || !Yb.sfb.equals(FY)) {
                String str;
                h hVar = new h();
                hVar.username = Yb.sfb;
                hVar.fWZ = 3;
                hVar.bC(true);
                hVar.fEo = -1;
                hVar.hni = Yb.xHK;
                hVar.hnh = Yb.xHL;
                x.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", Yb.sfb, hVar.JM(), hVar.JN());
                com.tencent.mm.ac.n.JW().a(hVar);
                if (!bi.oN(Yb.sfb)) {
                    if (Yb.scene == 18) {
                        l.TF().a(bxVar, Yb);
                        as.Hm();
                        c.Db().set(73729, Integer.valueOf(1));
                        as.Hm();
                        ag Xv = c.Ff().Xv(Yb.xHX);
                        if (Xv == null || ((int) Xv.gKO) <= 0) {
                            ak.a.hhv.a(Yb.xHX, null, new ak.b.a() {
                                public final void v(String str, boolean z) {
                                    as.Hm();
                                    x.d("MicroMsg.VerifyMessageExtension", String.valueOf(c.Ff().Xv(Yb.xHX)));
                                    com.tencent.mm.sdk.b.b itVar = new it();
                                    itVar.fAc.fAd = Yb.xHX;
                                    itVar.fAc.type = 1;
                                    com.tencent.mm.sdk.b.a.xmy.m(itVar);
                                }
                            });
                        } else {
                            str = Xv.field_username;
                            if (!(str == null || s.gG(str))) {
                                Xv.setUsername(Yb.xHX);
                                Xv.di(null);
                                as.Hm();
                                c.Ff().a(str, Xv);
                            }
                            com.tencent.mm.sdk.b.b itVar = new it();
                            itVar.fAc.fAd = Yb.xHX;
                            itVar.fAc.type = 1;
                            com.tencent.mm.sdk.b.a.xmy.m(itVar);
                        }
                    } else if (bb.gV(Yb.scene)) {
                        l.TG().a(bxVar, Yb);
                        as.Hm();
                        c.Db().set(73730, Integer.valueOf(1));
                    } else if (Yb.scene == 48) {
                        com.tencent.mm.sdk.b.b mfVar = new mf();
                        mfVar.fEI.fEK = a2;
                        mfVar.fEI.talker = Yb.sfb;
                        com.tencent.mm.sdk.b.a.xmy.m(mfVar);
                    }
                }
                f fVar = new f();
                fVar.field_createTime = e.n(a, (long) bxVar.pgR);
                if (bxVar.kyY == 4) {
                    i = 2;
                }
                fVar.field_isSend = i + 0;
                fVar.field_msgContent = com.tencent.mm.platformtools.n.a(bxVar.vNO);
                fVar.field_svrId = bxVar.vNT;
                fVar.field_talker = Yb.sfb;
                as.Hm();
                com.tencent.mm.k.a Xv2 = c.Ff().Xv(Yb.chatroomName);
                if (!(Xv2 == null || ((int) Xv2.gKO) == -1)) {
                    fVar.field_chatroomName = Yb.chatroomName;
                }
                switch (Yb.fvG) {
                    case 2:
                        fVar.field_type = 1;
                        break;
                    case 5:
                        fVar.field_type = 2;
                        break;
                    case 6:
                        fVar.field_type = 3;
                        break;
                    default:
                        fVar.field_type = 1;
                        break;
                }
                if (bi.oN(Yb.xHX)) {
                    x.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
                    b mY = l.TE().mY(fVar.field_talker);
                    if (mY != null) {
                        fVar.field_encryptTalker = mY.field_talker;
                        fVar.field_talker = mY.field_talker;
                    }
                    l.TD().a(fVar);
                } else {
                    fVar.field_encryptTalker = Yb.xHX;
                    if (l.TE().mX(Yb.xHX) != null) {
                        g TD = l.TD();
                        str = fVar.field_encryptTalker;
                        TD.gLA.fD("fmessage_msginfo", "update fmessage_msginfo set talker = '" + bi.oL(fVar.field_talker) + "'  where talker = '" + bi.oL(str) + "'");
                        l.TE().d(0, fVar.field_encryptTalker);
                    }
                    l.TD().a(fVar);
                }
            } else {
                x.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", Integer.valueOf(Yb.scene), a2);
                x.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
