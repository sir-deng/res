package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.canvas.h;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;

public final class a implements d {
    public final String getMethod() {
        return "clearRect";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float d = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 0);
        float d2 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 1);
        float d3 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 2);
        float d4 = com.tencent.mm.plugin.appbrand.q.f.d(jSONArray, 3);
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof h) {
                ((h) canvas).c(d, d2, d + d3, d2 + d4);
                x.v("MicroMsg.ClearRectAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", Float.valueOf(d), Float.valueOf(d2), Float.valueOf(d3), Float.valueOf(d4));
                return true;
            } else if (fVar.iNY != null) {
                canvas.drawRect(d, d2, d + d3, d2 + d4, fVar.iNY);
                x.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(d), Float.valueOf(d2), Float.valueOf(d3), Float.valueOf(d4));
                return true;
            } else {
                x.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", Float.valueOf(d), Float.valueOf(d2), Float.valueOf(d3), Float.valueOf(d4));
                return false;
            }
        } else if (fVar.iNY != null) {
            canvas.drawRect(d, d2, d + d3, d2 + d4, fVar.iNY);
            x.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(d), Float.valueOf(d2), Float.valueOf(d3), Float.valueOf(d4));
            return true;
        } else {
            canvas.drawRect(d, d2, d + d3, d2 + d4, fVar.iNX);
            x.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", Float.valueOf(d), Float.valueOf(d2), Float.valueOf(d3), Float.valueOf(d4));
            return true;
        }
    }
}
