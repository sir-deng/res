package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 70;
    public static final String NAME = "hideKeyboard";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        b(pVar, jSONObject, i);
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        b(jVar, jSONObject, i);
    }

    private void b(final c cVar, JSONObject jSONObject, final int i) {
        Integer num = null;
        try {
            num = Integer.valueOf(jSONObject.getInt("inputId"));
        } catch (JSONException e) {
        }
        com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new Runnable() {
            public final void run() {
                if (cVar.isRunning()) {
                    b bVar = b.this;
                    c cVar = cVar;
                    cVar.E(i, b.this.e(m.a(cVar instanceof p ? (p) cVar : e.b((j) cVar), num) ? "ok" : "fail:input not exists", null));
                }
            }
        });
    }
}
