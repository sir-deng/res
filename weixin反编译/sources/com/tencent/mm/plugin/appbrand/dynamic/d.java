package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    private static volatile d iVj;
    Map<String, c> iVk = new ConcurrentHashMap();

    private d() {
    }

    public static d acV() {
        if (iVj == null) {
            synchronized (d.class) {
                if (iVj == null) {
                    iVj = new d();
                }
            }
        }
        return iVj;
    }

    public final c rI(String str) {
        if (!bi.oN(str)) {
            return (c) this.iVk.get(str);
        }
        x.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
        return null;
    }
}
