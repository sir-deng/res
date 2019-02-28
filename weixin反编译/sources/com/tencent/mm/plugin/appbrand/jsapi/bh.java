package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.l;
import org.json.JSONObject;

public final class bh extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setTabBarStyle";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        e eVar = jVar.iuk.isT.iPG;
        String optString = jSONObject.optString("color", eVar.hdx);
        String optString2 = jSONObject.optString("selectedColor", eVar.iPS);
        String optString3 = jSONObject.optString("backgroundColor", eVar.iPT);
        String optString4 = jSONObject.optString("borderStyle", eVar.iPU);
        l ajy = jVar.iuk.isX.ajy();
        if (ajy instanceof com.tencent.mm.plugin.appbrand.page.e) {
            ((com.tencent.mm.plugin.appbrand.page.e) ajy).jIy.g(optString, optString2, optString3, optString4);
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("fail:not TabBar page", null));
    }
}
