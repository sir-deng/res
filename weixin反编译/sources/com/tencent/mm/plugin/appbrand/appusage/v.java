package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bi;

public enum v {
    ;

    public static void k(final String str, final String str2, final int i) {
        if (!bi.oN(str2)) {
            d.aL(str2, i);
            c.Dt().F(new Runnable() {
                public final void run() {
                    v.l(str, str2, i);
                }
            });
        }
    }
}
