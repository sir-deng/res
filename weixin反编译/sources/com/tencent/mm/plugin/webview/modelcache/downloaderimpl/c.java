package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.i.a.d.j;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.m.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;

public final class c extends a<e> {
    private static final ConcurrentHashMap<String, Boolean> tAI = new ConcurrentHashMap();

    public c(e eVar) {
        super(eVar);
    }

    public final boolean aan() {
        return true;
    }

    public final boolean aao() {
        return false;
    }

    public final boolean aap() {
        return true;
    }

    public final boolean aar() {
        return false;
    }

    public final String aam() {
        return "WebViewCache";
    }

    public final boolean bE(long j) {
        if (super.bE(j) && j < 5242880) {
            return true;
        }
        return false;
    }

    protected final l a(j jVar) {
        if (tAI.putIfAbsent(((e) aat()).getFilePath(), Boolean.TRUE) != null) {
            x.i("MicroMsg.ResDownloader.WebViewCacheDownloadNetworkRequestHandler", "request urlKey = %s, already downloading this file", ((e) aat()).vmK);
            return null;
        }
        l a = super.a(jVar);
        tAI.remove(((e) aat()).getFilePath());
        return a;
    }

    public static void clearCache() {
        tAI.clear();
    }
}
