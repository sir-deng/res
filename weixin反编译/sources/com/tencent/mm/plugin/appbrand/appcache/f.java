package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class f extends a {
    final int iGm;

    public f(String str, int i, int i2, String str2) {
        this(String.format(Locale.US, "EncWxaPkg_%s_%d_%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}), ai.qb(String.format(Locale.US, "%d_%d_%d.encwxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)})), str2, str, i, i2);
    }

    private f(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, str3, str4, i2, 0);
        this.iGm = i;
    }

    public final String toShortString() {
        return String.format(Locale.US, "EncryptPkgDownloadRequest[%s %d %d]", new Object[]{this.appId, Integer.valueOf(this.iGm), Integer.valueOf(this.version)});
    }
}
