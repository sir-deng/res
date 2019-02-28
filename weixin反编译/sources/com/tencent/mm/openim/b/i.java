package com.tencent.mm.openim.b;

import com.tencent.mm.ac.d;
import com.tencent.mm.ac.n;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.avg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;

public final class i {
    public static x a(avg avg) {
        ag Xv = ((h) g.h(h.class)).Ff().Xv(avg.idC);
        if (Xv == null) {
            Xv = new x();
        }
        Xv.setUsername(avg.idC);
        Xv.dc(avg.fqG);
        Xv.setType(avg.type);
        Xv.da(avg.iLo);
        Xv.setSource(avg.cPf);
        Xv.dd(avg.wJV);
        Xv.de(avg.wJW);
        Xv.dh(avg.wJX);
        Xv.dg(avg.wJY);
        Xv.dF(avg.wJZ.nlZ);
        Xv.eN(avg.wJZ.wKb);
        Xv.dD(avg.vNZ);
        Xv.dE(avg.kPE);
        Xv.eD(avg.fXa);
        Xv.field_descWordingId = avg.wKa;
        Xv.fWI = true;
        Xv.eK((int) bi.Wx());
        return Xv;
    }

    public static void b(avg avg) {
        boolean z;
        boolean z2 = true;
        Object obj = "";
        Object obj2 = "";
        com.tencent.mm.ac.h jp = n.JW().jp(avg.idC);
        if (jp != null) {
            obj = jp.JM();
            obj2 = jp.JN();
        }
        jp = new com.tencent.mm.ac.h();
        jp.fEo = -1;
        jp.username = avg.idC;
        jp.hnh = avg.wJU;
        jp.hni = avg.wJT;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", jp.getUsername(), jp.JM(), jp.JN());
        if (jp.JM().equals(obj)) {
            z = false;
        } else {
            n.JF();
            d.y(avg.idC, true);
            z = true;
        }
        if (jp.JN().equals(obj2)) {
            z2 = z;
        } else {
            n.JF();
            d.y(avg.idC, false);
        }
        if (z2) {
            n.JY().jb(avg.idC);
            n.JW().a(jp);
        }
    }
}
