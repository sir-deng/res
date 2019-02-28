package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.mm.pluginsdk.i.a.d.k;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class a extends k {
    public final String appId;
    public final int fwH;
    public volatile boolean iJg = true;
    public final int version;

    public a(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, String.valueOf(i), "AppBrandWxaPkgDownloader", str3, "GET", 1, 2, 0);
        this.appId = str4;
        this.version = i;
        this.fwH = i2;
        setConnectTimeout((int) TimeUnit.SECONDS.toMillis(15));
        setReadTimeout((int) TimeUnit.SECONDS.toMillis(30));
    }

    public String toShortString() {
        return getClass().getSimpleName() + String.format(Locale.US, "[%s|%d|%d]", new Object[]{this.appId, Integer.valueOf(this.version), Integer.valueOf(this.fwH)});
    }
}
