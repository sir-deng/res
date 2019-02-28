package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.f.a.rc;
import com.tencent.mm.f.a.rc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<rc> {
    public n() {
        this.xmG = rc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rc rcVar = (rc) bVar;
        if (!g.Do().CF()) {
            x.e("MicroMsg.SupportFingerPrintEventListener", "SupportFingerPrintEventListener account is not ready");
        } else if (rcVar instanceof rc) {
            x.i("MicroMsg.SupportFingerPrintEventListener", "handle SupportFingerPrintEvent");
            boolean aKG = c.aKG();
            x.i("MicroMsg.SupportFingerPrintEventListener", "isSupportFP is " + aKG);
            a aVar = new a();
            aVar.fJK = aKG;
            rcVar.fJJ = aVar;
            if (rcVar.frD != null) {
                rcVar.frD.run();
            }
            return true;
        }
        return false;
    }
}
