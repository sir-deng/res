package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.Paint.Join;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class aa implements d {
    public final String getMethod() {
        return "setLineJoin";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        if ("miter".equalsIgnoreCase(optString)) {
            fVar.iNU.setStrokeJoin(Join.MITER);
            fVar.iNT.setStrokeJoin(Join.MITER);
        } else if ("round".equalsIgnoreCase(optString)) {
            fVar.iNU.setStrokeJoin(Join.ROUND);
            fVar.iNT.setStrokeJoin(Join.ROUND);
        } else if ("bevel".equalsIgnoreCase(optString)) {
            fVar.iNU.setStrokeJoin(Join.BEVEL);
            fVar.iNT.setStrokeJoin(Join.BEVEL);
        }
        return true;
    }
}
