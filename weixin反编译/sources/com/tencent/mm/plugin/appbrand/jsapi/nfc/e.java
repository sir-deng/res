package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 353;
    public static final String NAME = "stopHCE";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        a(new a() {
            public final void K(int i, String str) {
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    e eVar = e.this;
                    j jVar = jVar;
                    int i2 = i;
                    HCEEventLogic.ta(jVar.mAppId);
                    HCEEventLogic.a(null);
                    HCEEventLogic.c(jVar.mAppId, 13, null);
                    Map hashMap2 = new HashMap(2);
                    hashMap2.put("errCode", Integer.valueOf(0));
                    e.a(jVar, i2, eVar.e("ok", hashMap2));
                    return;
                }
                e.a(jVar, i, e.this.e("fail: " + str, hashMap));
            }
        });
    }

    static void a(j jVar, int i, String str) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", str);
        if (jVar != null) {
            jVar.E(i, str);
        }
    }
}
