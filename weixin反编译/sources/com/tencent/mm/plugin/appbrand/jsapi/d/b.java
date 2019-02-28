package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 223;
    private static final String NAME = "getBeacons";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiGetBeacons", "getBeacons!");
        a.a sK = a.sK(jVar.mAppId);
        JSONArray jSONArray = new JSONArray();
        Map hashMap;
        if (sK == null || sK.jnb == null) {
            x.e("MicroMsg.JsApiGetBeacons", "not found device");
            hashMap = new HashMap();
            hashMap.put("beacons", jSONArray);
            jVar.E(i, e("ok", hashMap));
            return;
        }
        for (Entry value : sK.jnb.entrySet()) {
            jSONArray.put((JSONObject) value.getValue());
        }
        hashMap = new HashMap();
        hashMap.put("beacons", jSONArray);
        jVar.E(i, e("ok", hashMap));
    }
}
