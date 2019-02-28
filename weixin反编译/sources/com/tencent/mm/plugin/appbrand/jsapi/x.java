package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.r.a.a;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.u.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class x extends l {
    public static final int CTRL_INDEX = 425;
    public static final String NAME = "getBatteryInfo";

    public final String a(j jVar, JSONObject jSONObject) {
        c amt = a.jYg.amt();
        JSONObject hVar = new h();
        try {
            hVar.put("level", amt.jYq);
            hVar.put("isCharging", amt.jYp);
        } catch (JSONException e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiGetBatteryInfo", "JSON put failed. [%s]", e);
        }
        return hVar.toString();
    }
}
