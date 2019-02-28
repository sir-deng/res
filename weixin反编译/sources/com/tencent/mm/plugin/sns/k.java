package com.tencent.mm.plugin.sns;

import com.tencent.mm.f.a.ne;
import com.tencent.mm.plugin.sns.model.aa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends c<ne> {
    public k() {
        this.xmG = ne.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ne neVar = (ne) bVar;
        if (neVar instanceof ne) {
            if (neVar.fFX.state == 0) {
                x.d("MicroMsg.RemoveSnsTaskEventListener", "start clean");
                aa.nYp = true;
                aa aaVar = new aa();
                aaVar.raY = System.currentTimeMillis();
                if (!aaVar.raX) {
                    new a().m("");
                }
            } else {
                x.d("MicroMsg.RemoveSnsTaskEventListener", "stop clean");
                aa.nYp = false;
            }
            return true;
        }
        x.f("MicroMsg.RemoveSnsTaskEventListener", "mismatched event");
        return false;
    }
}
