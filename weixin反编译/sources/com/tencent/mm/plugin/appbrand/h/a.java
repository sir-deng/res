package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a implements com.tencent.mm.plugin.messenger.a.e.a {
    public final String g(Map<String, String> map, String str) {
        if (map != null && !map.isEmpty()) {
            return bi.oM((String) map.get(str + ".title"));
        }
        x.w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
        return "";
    }
}
