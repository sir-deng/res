package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends l {
    public abstract void a(j jVar, JSONObject jSONObject, String str);

    protected abstract String agR();

    protected abstract String agS();

    public final String a(final j jVar, final JSONObject jSONObject) {
        final String agR = agR();
        Map hashMap = new HashMap();
        hashMap.put(agS(), agR);
        jVar.iul.iWP.post(new Runnable() {
            public final void run() {
                a.this.a(jVar, jSONObject, agR);
            }
        });
        return e("ok", hashMap);
    }
}
