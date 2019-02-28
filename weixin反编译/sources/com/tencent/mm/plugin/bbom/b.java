package com.tencent.mm.plugin.bbom;

import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.ap.o;
import com.tencent.mm.be.h;
import com.tencent.mm.be.l;
import com.tencent.mm.f.a.it;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public final class b implements a {
    public final void a(d.a aVar, au auVar, final String str, String str2, boolean z) {
        int i = 1;
        final bx bxVar = aVar.hoa;
        final com.tencent.mm.y.bb.b hW = bb.hW(bxVar.vNR);
        if (hW != null) {
            auVar.eb(hW.hir);
            auVar.dY(hW.hiq);
            x.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", hW.hiq);
            if (!(hW.his == null || hW.scene != 1 || bxVar.nlX == 10000)) {
                as.Hm();
                com.tencent.mm.k.a Xv = c.Ff().Xv(str);
                if (Xv == null || ((int) Xv.gKO) <= 0) {
                    ak.a.hhv.a(str, null, new com.tencent.mm.y.ak.b.a() {
                        public final void v(String str, boolean z) {
                            as.Hm();
                            b.a(bxVar, hW, c.Ff().Xv(str));
                        }
                    });
                } else {
                    a(bxVar, hW, Xv);
                }
            }
        }
        int i2;
        if (s.gH(str) && s.hv(str)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!s.eX(str) || s.hu(str)) {
            i = 0;
        }
        if (!z && auVar.cjT() && i2 == 0 && i == 0) {
            com.tencent.mm.modelcontrol.c.MX();
            if (com.tencent.mm.modelcontrol.c.l(auVar)) {
                com.tencent.mm.ap.b PE = o.PE();
                long j = auVar.field_msgId;
                com.tencent.mm.modelcontrol.c.MX();
                if (com.tencent.mm.modelcontrol.c.MY()) {
                    synchronized (PE.hAW) {
                        if (PE.hAW.size() >= 100) {
                            PE.hAW.remove(0);
                        }
                        PE.hAW.push(Long.valueOf(j));
                    }
                    PE.hBa = System.currentTimeMillis();
                    PE.start();
                }
            }
        }
    }

    static void a(bx bxVar, com.tencent.mm.y.bb.b bVar, com.tencent.mm.storage.x xVar) {
        int i;
        String a = n.a(bxVar.vNM);
        as.Hm();
        c.Db().set(73729, Integer.valueOf(1));
        String str = xVar.field_nickname;
        h hVar = new h();
        hVar.field_content = n.a(bxVar.vNO);
        hVar.field_createtime = bi.Wx();
        hVar.field_imgpath = "";
        hVar.field_sayhicontent = bxVar.nlX == 3 ? ad.getContext().getString(R.l.exL) : n.a(bxVar.vNO);
        hVar.field_sayhiuser = a;
        hVar.field_scene = 18;
        if (bxVar.kyY > 3) {
            i = bxVar.kyY;
        } else {
            i = 3;
        }
        hVar.field_status = i;
        hVar.field_svrid = bxVar.vNT;
        hVar.field_talker = str;
        hVar.field_type = bxVar.nlX;
        hVar.field_isSend = 0;
        hVar.field_sayhiencryptuser = a;
        hVar.field_ticket = bVar.his;
        l.TF().a(hVar);
        com.tencent.mm.sdk.b.b itVar = new it();
        itVar.fAc.fAd = a;
        com.tencent.mm.sdk.b.a.xmy.m(itVar);
    }
}
