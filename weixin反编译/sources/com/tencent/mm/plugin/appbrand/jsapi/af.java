package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.l;
import org.json.JSONObject;

public final class af extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "hideTabBar";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        l ajy = jVar.iuk.isX.ajy();
        if (ajy instanceof e) {
            ((e) ajy).jIy.dq(jSONObject.optBoolean("animation", true));
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("fail:not TabBar page", null));
    }
}
