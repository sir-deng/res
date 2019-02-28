package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.f.a.ri;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<ri> {
    public n() {
        this.xmG = ri.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ri riVar = (ri) bVar;
        switch (riVar.fJS.opType) {
            case 0:
                a JT = com.tencent.mm.plugin.shake.e.c.JT(riVar.fJS.fJU);
                if (JT != null) {
                    riVar.fJT.fEl = com.tencent.mm.plugin.shake.e.c.a(riVar.fJS.context, JT);
                    riVar.fJT.fwx = m.dZ(JT.field_thumburl, "@B");
                    riVar.fJT.fqR = true;
                    break;
                }
                x.w("MicroMsg.TVOperationListener", "error, xml[%s] can not parse", riVar.fJS.fJU);
                riVar.fJT.fqR = false;
                break;
        }
        return false;
    }
}
