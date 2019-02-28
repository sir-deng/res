package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.f.a.nc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<nc> {
    public j() {
        this.xmG = nc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nc ncVar = (nc) bVar;
        if (!g.Do().CF()) {
            x.e("MicroMsg.ReleaseFingerPrintAuthEventListener", "ReleaseFingerPrintAuthEventListener account is not ready");
        } else if (ncVar instanceof nc) {
            x.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "handle ReleaseFingerPrintAuthEventListener");
            a.aKz();
            if (a.aKA() != null) {
                a.aKz();
                a.aKA();
                c.aKH();
                x.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "systemRelease FPManger");
            }
            return true;
        }
        return false;
    }
}
