package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapScale";

    private static int j(JSONObject jSONObject) {
        int i = 0;
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiGetMapScale", "get mapId error, exception : %s", e);
            return i;
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetMapScale", "JsApiGetMapScale data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        p b = e.b(jVar);
        if (b == null) {
            x.e("MicroMsg.JsApiGetMapScale", "JsApiGetMapScale pv is null");
            jVar.E(i, e("fail:pageView is null", null));
            return;
        }
        x.i("MicroMsg.JsApiGetMapScale", "JsApiGetMapScale data:%s", jSONObject.toString());
        try {
            View lG = b.aeW().lG(j(jSONObject));
            if (lG == null) {
                x.e("MicroMsg.JsApiGetMapScale", "view is null");
                jVar.E(i, e("fail:view is null", null));
            } else if (lG instanceof CoverViewContainer) {
                b bE = ((c) com.tencent.mm.kernel.g.h(c.class)).bE(((CoverViewContainer) lG).w(View.class));
                Map hashMap = new HashMap();
                if (bE != null) {
                    hashMap.put("scale", Integer.valueOf(bE.getZoomLevel()));
                    x.i("MicroMsg.JsApiGetMapScale", "getMapScale ok, values:%s", hashMap.toString());
                    jVar.E(i, e("ok", hashMap));
                    return;
                }
                x.e("MicroMsg.JsApiGetMapScale", "get SoSoMapView by id failed");
                jVar.E(i, e("fail:mapView is null", null));
            } else {
                x.w("MicroMsg.JsApiGetMapScale", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(r2));
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiGetMapScale", "get SoSoMapView by id failed, exception : %s", e);
            jVar.E(i, e("fail", null));
        }
    }
}
