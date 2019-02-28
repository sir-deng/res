package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class m implements d {
    public final String getMethod() {
        return "restore";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.restore();
        if (!fVar.iNV.isEmpty()) {
            fVar.iNT = (a) fVar.iNV.pop();
            fVar.iNU = (a) fVar.iNW.pop();
        }
        return true;
    }
}
