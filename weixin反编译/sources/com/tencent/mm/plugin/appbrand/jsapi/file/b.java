package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.sdk.f.e;
import org.json.JSONObject;

abstract class b<T extends d> extends a {
    final T jmJ;

    public b(T t) {
        this.jmJ = t;
    }

    public final void a(final j jVar, final JSONObject jSONObject, final int i) {
        e.post(new Runnable() {
            public final void run() {
                f.a b = b.this.jmJ.b(jVar, jSONObject);
                l.a(jVar, b.values, b.this);
                jVar.E(i, b.this.e(b.foE, b.values));
            }
        }, "AppBrandFileApi#" + getName());
    }
}
