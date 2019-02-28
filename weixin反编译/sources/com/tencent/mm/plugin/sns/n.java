package com.tencent.mm.plugin.sns;

import com.tencent.mm.f.a.qp;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<qp> {
    public n() {
        this.xmG = qp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qp qpVar = (qp) bVar;
        if (qpVar instanceof qp) {
            qpVar.fIY.fqR = a.a(qpVar.fIX.fJb, qpVar.fIX.url, qpVar.fIX.fJa);
            return true;
        }
        x.f("MicroMsg.SnsfillEventInfoListener", "mismatched event");
        return false;
    }
}
