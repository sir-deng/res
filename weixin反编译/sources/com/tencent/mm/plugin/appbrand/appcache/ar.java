package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class ar extends a {
    private static String c(String str, String str2, int i, int i2) {
        return String.format(Locale.US, "WxaPage_%s_%d_%d_%d", new Object[]{str2, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(str.hashCode())});
    }

    ar(String str, String str2, int i, int i2) {
        super(c(str, str2, i, i2), ai.qb(c(str, str2, i, i2)), str, str2, i, i2);
    }
}
