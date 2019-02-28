package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.report.service.g;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 340;
    private static final String NAME = "enableLocationUpdate";
    private volatile f jnC;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        g.pWK.h(840, 9);
        synchronized (this) {
            if (this.jnC == null) {
                this.jnC = new f(jVar);
                this.jnC.start();
            }
        }
        boolean optBoolean = jSONObject.optBoolean("enable");
        if (optBoolean || a.i(jVar)) {
            if (!optBoolean) {
                this.jnC.DA(2);
            } else if (a.i(jVar)) {
                this.jnC.DA(1);
            } else {
                g.pWK.h(840, 11);
                jVar.E(i, e("fail:system permission denied", null));
            }
            g.pWK.h(840, 10);
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("ok", null));
    }
}
