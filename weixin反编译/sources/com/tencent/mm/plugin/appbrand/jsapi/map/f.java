package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.kernel.g;
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

public final class f extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapRegion";

    private static int j(JSONObject jSONObject) {
        int i = 0;
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiGetMapRegion", "get mapId error, exception : %s", e);
            return i;
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetMapRegion", "JsApiGetMapRegion data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        p b = e.b(jVar);
        if (b == null) {
            x.e("MicroMsg.JsApiGetMapRegion", "JsApiGetMapRegion pv is null");
            jVar.E(i, e("fail:pageView is null", null));
            return;
        }
        x.i("MicroMsg.JsApiGetMapRegion", "JsApiGetMapRegion data:%s", jSONObject.toString());
        try {
            View lG = b.aeW().lG(j(jSONObject));
            if (lG == null) {
                x.e("MicroMsg.JsApiGetMapRegion", "view is null");
                jVar.E(i, e("fail:view is null", null));
            } else if (lG instanceof CoverViewContainer) {
                b bE = ((c) g.h(c.class)).bE(((CoverViewContainer) lG).w(View.class));
                if (bE == null) {
                    x.e("MicroMsg.JsApiGetMapRegion", "get SoSoMapView by id failed");
                    jVar.E(i, e("fail:mapView is null", null));
                    return;
                }
                b.g abW = bE.abL().abV().abW();
                com.tencent.mm.plugin.appbrand.compat.a.b.f abQ = abW.abQ();
                com.tencent.mm.plugin.appbrand.compat.a.b.f abR = abW.abR();
                Map hashMap = new HashMap();
                hashMap.put("latitude", Double.valueOf(abQ.abS()));
                hashMap.put("longitude", Double.valueOf(abQ.abT()));
                Map hashMap2 = new HashMap();
                hashMap2.put("latitude", Double.valueOf(abR.abS()));
                hashMap2.put("longitude", Double.valueOf(abR.abT()));
                Map hashMap3 = new HashMap();
                hashMap3.put("southwest", hashMap);
                hashMap3.put("northeast", hashMap2);
                x.i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", hashMap3.toString());
                jVar.E(i, e("ok", hashMap3));
            } else {
                x.w("MicroMsg.JsApiGetMapRegion", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(r2));
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiGetMapRegion", "get SoSoMapView by id failed, exception : %s", e);
            jVar.E(i, e("fail", null));
        }
    }
}
