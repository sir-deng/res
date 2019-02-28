package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;
import java.util.List;
import org.json.JSONObject;

public final class k extends b {
    public static final int CTRL_INDEX = 3;
    public static final String NAME = "removeMap";

    protected final int j(JSONObject jSONObject) {
        int i = 0;
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRemoveMap", "get mapId error, exception : %s", e);
            return i;
        }
    }

    protected final boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        super.b(pVar, i, view, jSONObject);
        u.b lH = pVar.aeW().lH(i);
        if (lH == null) {
            x.i("MicroMsg.JsApiRemoveMap", "KeyValueSet(%s) is null.", Integer.valueOf(i));
            return false;
        } else if (view instanceof CoverViewContainer) {
            try {
                final com.tencent.mm.plugin.appbrand.compat.a.b bE = ((c) g.h(c.class)).bE(((CoverViewContainer) view).w(View.class));
                List list = (List) lH.get("markers", null);
                List list2 = (List) lH.get("converters", null);
                if (list != null && list.size() > 0) {
                    list.clear();
                }
                if (list2 != null && list2.size() > 0) {
                    list2.clear();
                }
                ah.y(new Runnable() {
                    public final void run() {
                        if (bE != null) {
                            bE.getView().setVisibility(8);
                            bE.clean();
                        }
                    }
                });
                lH.recycle();
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.JsApiRemoveMap", "get SoSoMapView(%s) by id failed, exception : %s", Integer.valueOf(i), e);
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiRemoveMap", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
            return false;
        }
    }
}
