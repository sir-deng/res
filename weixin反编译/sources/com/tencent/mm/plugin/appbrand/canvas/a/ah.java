package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;

public final class ah implements d {
    public final String getMethod() {
        return "setTextBaseline";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        x.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", optString);
        if ("top".equalsIgnoreCase(optString)) {
            fVar.iNT.iOg = a.iOl;
            fVar.iNU.iOg = a.iOl;
        } else if ("middle".equalsIgnoreCase(optString)) {
            fVar.iNT.iOg = a.iOn;
            fVar.iNU.iOg = a.iOn;
        } else if ("bottom".equalsIgnoreCase(optString)) {
            fVar.iNT.iOg = a.iOm;
            fVar.iNU.iOg = a.iOm;
        } else if ("normal".equalsIgnoreCase(optString)) {
            fVar.iNT.iOg = a.iOk;
            fVar.iNU.iOg = a.iOk;
        }
        return true;
    }
}
