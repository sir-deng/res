package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.f.a.ly;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<ly> {
    public j() {
        this.xmG = ly.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ly lyVar = (ly) bVar;
        switch (lyVar.fEi.opType) {
            case 0:
                a bZ = i.bZ(lyVar.fEi.fEk, 0);
                if (bZ != null) {
                    lyVar.fEj.fEl = i.a(lyVar.fEi.context, bZ);
                    lyVar.fEj.fwx = com.tencent.mm.plugin.scanner.c.bpi().dZ(bZ.field_thumburl, "@S");
                    lyVar.fEj.fqR = true;
                    break;
                }
                x.w("MicroMsg.ProductOperationListener", "error, xml[%s] can not parse", lyVar.fEi.fEk);
                lyVar.fEj.fqR = false;
                break;
        }
        return false;
    }
}
