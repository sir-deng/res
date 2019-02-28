package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.report.d;

public final class m {

    public enum a {
        GUIDE_EXPOSE(1),
        GUIDE_CLOSE(2),
        TO_APP_LAUNCHER(3),
        GUIDE_CLOSE_BY_BACK(4);
        
        final int value;

        private a(int i) {
            this.value = i;
        }
    }

    public static void a(a aVar, String str) {
        d.pVE.h(14750, Integer.valueOf(aVar.value), str);
    }
}
