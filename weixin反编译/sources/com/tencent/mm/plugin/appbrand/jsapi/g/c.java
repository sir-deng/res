package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.AnonymousClass3;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 86;
    public static final String NAME = "bindPaymentCard";

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
            a aVar = a.jsn;
            MMActivity.a anonymousClass3 = new AnonymousClass3(new b.a() {
                public final void a(int i, String str, Map<String, Object> map) {
                    switch (i) {
                        case 1:
                            jVar.E(i, c.this.e("ok", null));
                            return;
                        default:
                            jVar.E(i, c.this.e("fail", null));
                            return;
                    }
                }
            });
            g gVar = new g(jSONObject);
            gVar.fDR = 4;
            h.b(a, gVar, aVar.hashCode() & 65535, anonymousClass3);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiBindPaymentCard", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
