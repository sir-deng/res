package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class j implements d {
    public final String getMethod() {
        return "fillPath";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.drawPath(a.iOq.d(jSONArray), fVar.iNU);
        return true;
    }
}
