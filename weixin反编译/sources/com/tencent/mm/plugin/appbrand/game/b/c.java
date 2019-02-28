package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.a.b.a;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.game.e.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class c {
    public static void abp() {
        b.a(new a() {
            public final void loadLibrary(String str) {
                try {
                    k.b(str, c.class.getClassLoader());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MBLoadDelegateRegistery", e, "hy: link %s error!!", str);
                    d.bT(ad.getContext());
                }
            }
        });
    }
}
