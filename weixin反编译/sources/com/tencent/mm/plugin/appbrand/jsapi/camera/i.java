package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class i extends b {
    private static final int CTRL_INDEX = 330;
    public static final String NAME = "removeCamera";

    protected final int j(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId", 0);
    }

    protected final boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        super.b(pVar, i, view, jSONObject);
        x.i("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            e eVar = (AppBrandCameraView) ((CoverViewContainer) view).w(AppBrandCameraView.class);
            if (eVar == null) {
                x.w("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", Integer.valueOf(i));
                return false;
            }
            pVar.b((f) eVar);
            pVar.b((d) eVar);
            pVar.b(eVar);
            eVar.release();
            return true;
        }
        x.w("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        return false;
    }
}
