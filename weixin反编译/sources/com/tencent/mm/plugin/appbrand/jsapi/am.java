package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public final class am extends a {
    public static final int CTRL_INDEX = 59;
    public static final String NAME = "openCard";
    int jfG;

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenCard", "mmActivity is null, invoke fail!");
            return;
        }
        String optString = jSONObject.optString("cardList");
        if (bi.oN(optString)) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenCard", "cardList is null, invoke fail!");
            return;
        }
        this.jfG = i;
        a.jCj = new a() {
            public final void b(int i, int i2, Intent intent) {
                if (i != 1) {
                    return;
                }
                if (i2 == -1) {
                    jVar.E(am.this.jfG, am.this.e("ok", null));
                    x.i("MicroMsg.JsApiOpenCard", "view card result is cancel!");
                } else if (i2 == 0) {
                    jVar.E(am.this.jfG, am.this.e("cancel", null));
                    x.e("MicroMsg.JsApiOpenCard", "view card result is cancel!");
                } else {
                    jVar.E(am.this.jfG, am.this.e("fail", null));
                    x.e("MicroMsg.JsApiOpenCard", "view card result is fail!");
                }
            }
        };
        intent.putExtra("card_list", optString);
        intent.putExtra("key_from_scene", 26);
        AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
        if (!(appBrandSysConfig == null || appBrandSysConfig.iRU == null)) {
            intent.putExtra("key_from_appbrand_type", appBrandSysConfig.iRU.iJa);
        }
        d.b(a, "card", ".ui.CardViewEntranceUI", intent, 1);
    }
}
