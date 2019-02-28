package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.adq;
import com.tencent.mm.protocal.c.adr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ad.b gLB;
    private e gLE;
    public e qun;

    public b(float f, float f2) {
        a aVar = new a();
        aVar.hnT = new adq();
        aVar.hnU = new adr();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getlbscard";
        this.gLB = aVar.Kf();
        adq adq = (adq) this.gLB.hnQ.hnY;
        adq.fAo = f2;
        adq.fBX = f;
    }

    public final int getType() {
        return 1251;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = 1251" + " errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            adr adr = (adr) this.gLB.hnR.hnY;
            if (adr != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!adr.wsL) {
                    x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
                } else if (adr.wsP <= currentTimeMillis) {
                    x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + adr.wsP + " is <= currentTime:" + currentTimeMillis + " , don't handle");
                } else if (TextUtils.isEmpty(adr.kPy)) {
                    x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
                } else {
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
                    if (adr.wsM) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
                    } else {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
                    }
                    this.qun = new e();
                    this.qun.kRj = 1;
                    this.qun.kPy = adr.kPy;
                    this.qun.fHQ = adr.fHQ;
                    this.qun.title = adr.title;
                    this.qun.kPB = adr.kPB;
                    this.qun.kPC = adr.kPC;
                    this.qun.kQL = adr.kQL;
                    this.qun.kPA = adr.kPA;
                    this.qun.hdx = adr.hdx;
                    this.qun.quo = 0;
                    this.qun.qur = adr.qur;
                    this.qun.qus = adr.qus;
                    this.qun.qut = adr.qut;
                    this.qun.quu = adr.quu;
                    this.qun.quv = "";
                    this.qun.ceA = adr.ceA;
                    this.qun.quw = adr.quw;
                    this.qun.qux = adr.qux;
                    m.bss().quq = this.qun.quv;
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + adr.wsP + " is <= currentTime:" + currentTimeMillis);
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + adr.wsR);
                    as.Hm();
                    c.Db().a(w.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(currentTimeMillis));
                    as.Hm();
                    c.Db().a(w.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(adr.wsP));
                    as.Hm();
                    c.Db().a(w.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, adr.wsS);
                    as.Hm();
                    c.Db().a(w.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, adr.wsQ);
                    as.Hm();
                    c.Db().a(w.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(adr.wsR));
                    String bsJ = com.tencent.mm.plugin.shake.c.c.a.bsJ();
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + adr.wsN);
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is " + bsJ);
                    if (TextUtils.isEmpty(adr.wsN)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
                    }
                    if (TextUtils.isEmpty(bsJ)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
                        com.tencent.mm.r.c.Bx().p(262155, true);
                        as.Hm();
                        c.Db().a(w.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, adr.wsN);
                        as.Hm();
                        c.Db().a(w.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, adr.wsO);
                    } else if (!bsJ.equals(adr.wsN)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
                        com.tencent.mm.r.c.Bx().p(262155, true);
                        as.Hm();
                        c.Db().a(w.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, adr.wsN);
                        as.Hm();
                        c.Db().a(w.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, adr.wsO);
                    } else if (bsJ.equals(adr.wsN)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
                    }
                    g.pWK.k(11721, adr.kPy);
                }
            } else {
                x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
