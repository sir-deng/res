package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

final class ae extends a {
    final int iHA;
    final int iHB;
    final aq.a iHC;

    static String p(String str, int i, int i2) {
        return String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    ae(String str, int i, int i2, String str2, aq.a aVar) {
        boolean z = false;
        super(p(str, i, i2), ah.aak() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)}), str2, str, 0, i2);
        this.iHA = i;
        this.iHB = i2;
        this.iHC = aVar;
        if (!"@LibraryAppId".equals(str)) {
            z = true;
        }
        this.iJg = z;
    }

    public final String aad() {
        return ai.ag(this.appId, this.iHB);
    }
}
