package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.launching.ae.a;
import com.tencent.mm.sdk.platformtools.bi;

final class ad {

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ad$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] jDS = new int[a.values().length];

        static {
            try {
                jDS[a.Ok.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jDS[a.Timeout.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static String aH(String str, int i) {
        al a = e.Zz().a(str, i, "versionMd5", "pkgPath");
        if (a == null || bi.oN(a.field_pkgPath) || !com.tencent.mm.a.e.bO(a.field_pkgPath) || bi.oN(a.field_versionMd5) || !a.field_pkgPath.equals(g.bV(a.field_pkgPath))) {
            return null;
        }
        return a.field_versionMd5;
    }
}
