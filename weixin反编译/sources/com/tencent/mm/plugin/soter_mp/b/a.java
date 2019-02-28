package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.mm.f.a.hk;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<hk> {
    public a() {
        this.xmG = hk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 1;
        hk hkVar = (hk) bVar;
        x.i("MicroMsg.GetIsEnrolledListener", "hy: check mode: %d", Integer.valueOf(hkVar.fyz.fyB));
        if (hkVar.fyz.fyB == 1 && h.bDD()) {
            x.i("MicroMsg.GetIsEnrolledListener", "hy: has enrolled fingerprint: %b", Boolean.valueOf(com.tencent.d.a.a.if(ad.getContext())));
            hk.b bVar2 = hkVar.fyA;
            if (!com.tencent.d.a.a.if(ad.getContext())) {
                i = 0;
            }
            bVar2.fyC = i;
        } else {
            x.w("MicroMsg.GetIsEnrolledListener", "hy: not support");
            hkVar.fyA.fyC = -1;
        }
        return false;
    }
}
