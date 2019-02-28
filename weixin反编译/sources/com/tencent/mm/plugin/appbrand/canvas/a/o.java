package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class o implements d {
    public final String getMethod() {
        return "save";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.save();
        a aVar = fVar.iNT;
        fVar.iNV.push(fVar.iNT);
        fVar.iNT = fVar.iNT.abE();
        if (fVar.iNT == null) {
            fVar.iNT = aVar;
        }
        aVar = fVar.iNU;
        fVar.iNW.push(fVar.iNU);
        fVar.iNU = fVar.iNU.abE();
        if (fVar.iNU == null) {
            fVar.iNU = aVar;
        }
        return true;
    }
}
