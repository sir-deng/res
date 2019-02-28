package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class a {
    static String a(e eVar, String str, boolean z) {
        String ve;
        x.i("MicroMsg.GameFileUtils", "Ready to getJsString js! filePath: %s,isAsset:%s", str, Boolean.valueOf(z));
        if (z) {
            ve = c.ve(str);
        } else {
            ve = ao.a(eVar, str);
        }
        if (bi.oN(ve)) {
            x.e("MicroMsg.GameFileUtils", "js code is null, filePath : " + str);
        }
        return ve;
    }
}
