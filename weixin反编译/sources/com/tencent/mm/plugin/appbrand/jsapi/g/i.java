package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 85;
    public static final String NAME = "verifyPaymentPassword";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        MMActivity a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", jVar.mAppId);
            a.jsn.a(a, jSONObject, new b() {
                public final void d(boolean z, String str) {
                    if (z) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("token", str);
                        jVar.E(i, i.this.e("ok", hashMap));
                        return;
                    }
                    jVar.E(i, i.this.e("fail", null));
                }
            });
        } catch (Exception e) {
            x.e("MicroMsg.JsApiVerifyPaymentPassword", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
