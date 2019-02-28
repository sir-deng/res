package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import org.json.JSONObject;

public final class e extends a {
    private static final int CTRL_INDEX = 241;
    private static final String NAME = "setTopBarText";

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        AppBrandStickyBannerLogic.a.bK(jVar.mAppId, jSONObject.optString("text"));
        jVar.E(i, e("ok", null));
        c.a(jVar.mAppId, new b() {
            public final void onDestroy() {
                AppBrandStickyBannerLogic.a.bK(jVar.mAppId, "");
            }
        });
    }
}
