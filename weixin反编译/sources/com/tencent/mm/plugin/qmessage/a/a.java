package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ax.n;
import com.tencent.mm.f.a.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;

final class a extends c<af> {
    a() {
        this.xmG = af.class.getName().hashCode();
    }

    private static boolean a(af afVar) {
        if (!(afVar instanceof af)) {
            x.f("MicroMsg.QMsg.EventListener", "not bind qq event");
        } else if (afVar.foR.foT == 0) {
            try {
                int Gj = q.Gj() | 32;
                as.Hm();
                com.tencent.mm.y.c.Db().set(34, Integer.valueOf(Gj));
                as.Hm();
                com.tencent.mm.y.c.Fe().b(new n("", "", "", "", "", "", "", "", Gj, "", ""));
                g.bkH();
                x.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.QMsg.EventListener", e, "", new Object[0]);
            }
        }
        return false;
    }
}
