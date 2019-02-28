package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class f implements e {
    b iiC;
    boolean iiQ = false;

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.iiQ = false;
        if (i == 0 && i2 == 0) {
            o oVar = ((i) kVar).ijw;
            x.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", Integer.valueOf(oVar.lot), oVar.lou);
            if (oVar.lot == 0) {
                g.a(this.iiC, oVar);
                com.tencent.mm.plugin.report.service.g.pWK.a(407, 9, 1, false);
                return;
            }
            if (this.iiC != null) {
                if (oVar.vKc != null && oVar.vKc.fEo == 1 && !bi.oN(oVar.vKc.loA) && !bi.oN(oVar.vKc.ojb) && !bi.oN(oVar.vKc.ojc) && !bi.oN(oVar.vKc.fzT)) {
                    this.iiC.cm(oVar.vKc);
                } else if (oVar.lot <= 0 || bi.oN(oVar.lou)) {
                    this.iiC.cm(Boolean.valueOf(false));
                } else {
                    this.iiC.cm(oVar.lou);
                }
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(407, 11, 1, false);
            return;
        }
        if (this.iiC != null) {
            this.iiC.cm(Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(407, 10, 1, false);
    }
}
