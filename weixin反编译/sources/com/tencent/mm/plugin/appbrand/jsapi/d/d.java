package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 222;
    private static final String NAME = "stopBeaconDiscovery";

    private static class a extends f {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
        com.tencent.mm.plugin.appbrand.jsapi.d.a.a sK = a.sK(jVar.mAppId);
        Map hashMap;
        if (sK == null) {
            x.e("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            jVar.E(i, e("fail", hashMap));
            return;
        }
        if (sK.vp()) {
            a.remove(jVar.mAppId);
            new HashMap().put("errCode", Integer.valueOf(0));
            jVar.E(i, e("ok", null));
        } else {
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            jVar.E(i, e("fail", hashMap));
        }
        a aVar = new a();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("available", a.jmZ);
            jSONObject2.put("discovering", false);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", e);
        }
        x.i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject2.toString());
        f aA = aVar.aA(jVar.mAppId, jVar.hashCode());
        aA.mData = jSONObject2.toString();
        aA.afI();
    }
}
