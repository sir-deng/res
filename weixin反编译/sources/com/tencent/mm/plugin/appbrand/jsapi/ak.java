package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.n.AnonymousClass11;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ak extends a {
    public static final int CTRL_INDEX = 14;
    public static final String NAME = "navigateTo";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        int i2 = jVar.iuk.isS.iRA;
        if (jVar.iuk.isX.getPageCount() >= i2) {
            jVar.E(i, e("fail:page limit exceeded: " + i2, null));
            x.e("MicroMsg.JsApiNavigateTo", "page limit exceeded: " + i2);
            return;
        }
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (jVar.iuk.isT.iPG.qV(optString)) {
            jVar.E(i, e("fail:can not navigate to a tab bar page", null));
            return;
        }
        n nVar = jVar.iuk.isX;
        nVar.runOnUiThread(new AnonymousClass11(optString));
        jVar.E(i, e("ok", null));
    }
}
