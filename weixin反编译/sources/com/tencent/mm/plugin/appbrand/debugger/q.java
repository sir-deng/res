package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.r.h;
import com.tencent.mm.sdk.platformtools.x;

public final class q {
    public static void a(e eVar, b bVar, final String str) {
        if (eVar == null || bVar == null || str == null || str.length() == 0) {
            x.w("MicroMsg.SourceMapInjector", "runtime or jsRuntime or filePath is null.");
        } else if (a.jy(eVar.isS.iRU.iJa)) {
            x.i("MicroMsg.SourceMapInjector", "current running type is ReleaseType do not need to inject sourceMap.");
        } else {
            String a = ao.a(eVar, str + ".map");
            if (a == null || a.length() == 0) {
                x.i("MicroMsg.SourceMapInjector", "sourceMap of the script(%s) is null or nil.", str);
                return;
            }
            h.a(bVar, String.format("var __wxSourceMap ={ '%s': %s };", new Object[]{str, a}), new h.a() {
                public final void pH(String str) {
                    x.i("MicroMsg.SourceMapInjector", "Inject '%s' Script Success: %s", str, str);
                }

                public final void fs(String str) {
                    x.e("MicroMsg.SourceMapInjector", "Inject '%s' Script Failed: %s", str, str);
                }
            });
        }
    }

    public static String rH(String str) {
        return "https://servicewechat.qq.com/" + str;
    }
}
