package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

@SuppressLint({"DefaultLocale"})
public class ai extends a {
    public static String ag(String str, int i) {
        return ah.aak() + String.format("_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i)});
    }

    static String qb(String str) {
        return ah.aak() + String.format("_%s.wxapkg", new Object[]{str});
    }

    ai(String str, int i, int i2, String str2) {
        this(String.format("WxaPkg_%s_%d", new Object[]{str, Integer.valueOf(i2)}), ag(str, i2), str2, str, i2, i);
    }

    private ai(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, str3, str4, i, i2);
    }
}
