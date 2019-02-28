package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.soter.c.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.c;

public final class b {
    public static void a(boolean z, boolean z2, final e eVar) {
        x.v("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            g.t(Boolean.valueOf(z), Boolean.valueOf(z2)).c(new a()).c(new c()).c(new d()).a(new a<c<Integer, String>>() {
                public final /* synthetic */ void aW(Object obj) {
                    c cVar = (c) obj;
                    String str = (String) cVar.get(1);
                    x.e("MicroMsg.SoterInitManager", "alvinluo onInterrupt errCode: %d, errMsg: %s", Integer.valueOf(((Integer) cVar.get(0)).intValue()), str);
                    if (eVar != null) {
                        eVar.yu(r1);
                    }
                }
            }).a(new com.tencent.mm.vending.g.d.b<Boolean>() {
                public final /* synthetic */ void aB(Object obj) {
                    x.i("MicroMsg.SoterInitManager", "alvinluo onTerminate");
                    x.i("MicroMsg.SoterInitManager", "alvinluo init takes %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (eVar != null) {
                        eVar.yu(0);
                    }
                }
            });
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SoterInitManager", e, "alvinluo exception when init soter: %s", e.getMessage());
            com.tencent.mm.plugin.soter.c.a.dQ(4, 1001);
            if (eVar != null) {
                eVar.yu(-1);
            }
        }
    }
}
