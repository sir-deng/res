package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class g extends b {
    private static final int CTRL_INDEX = 255;
    public static final String NAME = "removeTextView";

    protected final int j(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        pVar.aeW().lH(i);
        return super.b(pVar, i, view, jSONObject);
    }
}
