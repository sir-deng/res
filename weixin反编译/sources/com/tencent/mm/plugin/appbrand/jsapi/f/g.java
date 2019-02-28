package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.c;
import com.tencent.mm.plugin.appbrand.j.d;
import com.tencent.mm.plugin.appbrand.j.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 243;
    public static final String NAME = "operateRequestTask";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiOperateRequestTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("requestTaskId");
        if (bi.oN(optString)) {
            x.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
            jVar.E(i, e("fail:requestTaskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bi.oN(optString2)) {
            x.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
            jVar.E(i, e("fail:operationType is null or nil", null));
        } else if (optString2.equals("abort")) {
            c tY = e.ajg().tY(jVar.mAppId);
            if (tY == null) {
                jVar.E(i, e("fail:no task", null));
                x.w("MicroMsg.JsApiOperateRequestTask", "request is null");
                return;
            }
            d tX = tY.tX(optString);
            if (tX == null) {
                jVar.E(i, e("fail:no task", null));
                x.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null %s", optString);
                return;
            }
            tY.b(tX);
            jVar.E(i, e("ok", null));
            Map hashMap = new HashMap();
            hashMap.put("requestTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            optString2 = new JSONObject(hashMap).toString();
            f a = new c.a().a(jVar);
            a.mData = optString2;
            a.afI();
            x.d("MicroMsg.JsApiOperateRequestTask", "abortTask finish %s", optString);
        } else {
            jVar.E(i, e("fail:unknown operationType", null));
        }
    }
}
