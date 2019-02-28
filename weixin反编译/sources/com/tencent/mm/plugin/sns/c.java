package com.tencent.mm.plugin.sns;

import com.tencent.mm.f.a.fe;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sdk.b.c<fe> {
    public c() {
        this.xmG = fe.class.getName().hashCode();
    }

    private boolean a(final fe feVar) {
        if (feVar instanceof fe) {
            a bvV = ae.bvV();
            bvV.a(feVar.fuY.type, feVar.fuY.username, new h.a() {
                public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
                    if (feVar.fuY != null) {
                        feVar.fuY.fvc.a(null);
                    }
                }

                public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
                }
            });
            bvV.a(1, feVar.fuY.username, feVar.fuY.fva, feVar.fuY.fvb);
            return true;
        }
        x.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
        return false;
    }
}
