package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.mm.f.a.hm;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<hm> {
    public b() {
        this.xmG = hm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        hm hmVar = (hm) bVar;
        if (hmVar instanceof hm) {
            x.i("MicroMsg.GetSoterSupportEventListener", "hy: request is support soter");
            x.i("MicroMsg.GetSoterSupportEventListener", "alvinluo isSupportSoter: %b", Boolean.valueOf(h.bDD()));
            if (h.bDD()) {
                hmVar.fyI.fyJ = 1;
            } else {
                hmVar.fyI.fyJ = 0;
            }
        }
        return true;
    }
}
