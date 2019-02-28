package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONArray;
import org.json.JSONObject;

final class bo extends a {
    public static final int CTRL_INDEX = 283;
    public static final String NAME = "traceEvent";

    bo() {
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("events");
        if (!AppBrandPerformanceManager.uy(cVar.getAppId()) || optJSONArray == null) {
            cVar.E(i, e("fail", null));
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("category");
                    String optString2 = optJSONObject.optString("name");
                    long optLong = optJSONObject.optLong("start");
                    long optLong2 = optJSONObject.optLong("end");
                    String optString3 = optJSONObject.optString("phase");
                    String optString4 = optJSONObject.optString("args");
                    if (!bi.oN(optString2)) {
                        a.a(cVar.getAppId(), optString, optString2, optString3, optLong, optLong2, optString4);
                    }
                }
                i2 = i3 + 1;
            } else {
                cVar.E(i, e("ok", null));
                return;
            }
        }
    }
}
