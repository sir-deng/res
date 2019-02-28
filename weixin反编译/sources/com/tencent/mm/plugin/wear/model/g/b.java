package com.tencent.mm.plugin.wear.model.g;

import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.f.a.tp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class b implements d {
    public final com.tencent.mm.ad.d.b b(a aVar) {
        bx bxVar = aVar.hoa;
        as.Hm();
        if (!bi.oN((String) c.Db().get(2, (Object) ""))) {
            String a = n.a(bxVar.vNM);
            String a2 = n.a(bxVar.vNN);
            if (bi.oN(a) || bi.oN(a2)) {
                x.e("MicroMsg.YoExtension", "neither from-user nor to-user can be empty");
            } else {
                String a3 = n.a(bxVar.vNO);
                x.i("MicroMsg.YoExtension", "from  " + a + "content " + a3);
                a aVar2 = com.tencent.mm.plugin.wear.model.a.bPh().tos;
                synchronized (aVar2.tpH) {
                    tp Ot = a.Ot(a);
                    if (aVar2.tpH.containsKey(a) || Ot.fMY.fMZ == 1) {
                        x.i("MicroMsg.wear.WearYoLogic", "Can not add Yo Message %s", a);
                        com.tencent.mm.sdk.b.b tpVar = new tp();
                        tpVar.fMX.fql = 2;
                        tpVar.fMX.username = a;
                        com.tencent.mm.sdk.b.a.xmy.m(tpVar);
                    } else {
                        x.i("MicroMsg.wear.WearYoLogic", "Can add Yo Message %s", a);
                        aVar2.tpH.put(a, new a(a, a3));
                    }
                }
                com.tencent.mm.plugin.wear.model.a.bPh().tos.bPx();
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
