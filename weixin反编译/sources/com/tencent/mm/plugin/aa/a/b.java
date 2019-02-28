package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;

public final class b implements e {
    com.tencent.mm.vending.g.b iiC;

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            v vVar = ((j) kVar).ijy;
            x.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", Integer.valueOf(vVar.lot));
            if (vVar.lot == 0) {
                g.a(this.iiC, vVar);
                com.tencent.mm.plugin.report.service.g.pWK.a(407, 6, 1, false);
                c oV = com.tencent.mm.plugin.aa.b.WJ().oV(vVar.vJI);
                if (oV != null) {
                    oV.field_status = vVar.state;
                    com.tencent.mm.plugin.aa.b.WJ().b(oV);
                    return;
                }
                return;
            }
            if (vVar.lot <= 0 || bi.oN(vVar.lou)) {
                this.iiC.cm(Boolean.valueOf(false));
            } else {
                this.iiC.cm(vVar.lou);
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(407, 8, 1, false);
            return;
        }
        if (this.iiC != null) {
            this.iiC.cm(Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(407, 7, 1, false);
    }
}
