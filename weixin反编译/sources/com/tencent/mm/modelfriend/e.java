package com.tencent.mm.modelfriend;

import com.tencent.mm.ac.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;

public final class e extends com.tencent.mm.y.e {
    protected final au a(bx bxVar, String str, String str2, String str3) {
        String a = n.a(bxVar.vNO);
        if (a == null || a.length() <= 0) {
            x.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
            return null;
        }
        a XY = a.XY(a);
        if (bxVar.nlX == 66) {
            ((b) g.h(b.class)).ox(XY.xHO);
        }
        if (bi.oM(XY.sfb).length() > 0) {
            h hVar = new h();
            hVar.username = XY.sfb;
            hVar.fWZ = 3;
            hVar.bC(true);
            hVar.hni = XY.xHK;
            hVar.hnh = XY.xHL;
            hVar.fEo = -1;
            x.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", XY.sfb, hVar.JM(), hVar.JN());
            com.tencent.mm.ac.n.JW().a(hVar);
        }
        return super.a(bxVar, str, str2, str3);
    }
}
