package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

final class s {

    public enum a {
        SYNC_GET_ATTRS(20),
        SYNC_LAUNCH(21),
        GET_DOWNLOAD_URL(22);
        
        final int jcn;

        private a(int i) {
            this.jcn = i;
        }
    }

    static void a(a aVar, String str, int i, int i2, int i3, long j) {
        int uD = com.tencent.mm.plugin.appbrand.report.a.uD(str);
        x.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %s", aVar.name(), str, Long.valueOf(j), Integer.valueOf(uD));
        g.pWK.h(13886, str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(aVar.jcn), "", "", Long.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(uD));
    }
}
