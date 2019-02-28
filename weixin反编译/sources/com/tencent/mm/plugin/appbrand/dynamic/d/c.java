package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.t.b.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public c(int i) {
        super("getNetworkType", i);
    }

    protected final void a(com.tencent.mm.t.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        Context context = aVar.getContext();
        Map hashMap = new HashMap();
        if (!ao.isConnected(context)) {
            hashMap.put("networkType", "none");
        } else if (ao.is2G(context)) {
            hashMap.put("networkType", "2g");
        } else if (ao.is3G(context)) {
            hashMap.put("networkType", "3g");
        } else if (ao.is4G(context)) {
            hashMap.put("networkType", "4g");
        } else if (ao.isWifi(context)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        aVar2.aw(a(true, "", hashMap));
    }
}
