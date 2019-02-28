package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.view.View;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.y.u;
import com.tencent.mm.y.u.b;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 106;
    private static final String NAME = "hideToast";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        ah.y(new Runnable() {
            public final void run() {
                e eVar = a.this;
                j jVar = jVar;
                int i = i;
                b hB = u.GQ().hB(jVar.hashCode() + "toast_name");
                if (hB != null) {
                    View view = (View) hB.get("toast_view", null);
                    if (view != null) {
                        view.setVisibility(8);
                        jVar.E(i, eVar.e("ok", null));
                        return;
                    }
                }
                jVar.E(i, eVar.e("fail", null));
            }
        });
    }
}
