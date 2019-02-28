package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import org.json.JSONObject;

abstract class c<T extends d> extends l {
    private final T jmJ;

    public c(T t) {
        this.jmJ = t;
    }

    public final String a(j jVar, JSONObject jSONObject) {
        a b = this.jmJ.b(jVar, jSONObject);
        com.tencent.mm.plugin.appbrand.r.l.a(jVar, b.values, (b) this);
        return e(b.foE, b.values);
    }
}
