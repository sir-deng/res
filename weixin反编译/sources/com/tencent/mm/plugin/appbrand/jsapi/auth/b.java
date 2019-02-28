package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

abstract class b extends com.tencent.mm.plugin.appbrand.jsapi.a {

    interface a {
        void afS();
    }

    protected abstract void a(j jVar, JSONObject jSONObject, int i, a aVar);

    b() {
    }

    public void a(j jVar, JSONObject jSONObject, int i) {
        final e o = a.o(jVar.iuk);
        final j jVar2 = jVar;
        final JSONObject jSONObject2 = jSONObject;
        final int i2 = i;
        AnonymousClass1 anonymousClass1 = new a() {
            public final void afV() {
                x.i("MicroMsg.AppBrand.BaseAuthJsApi", "about to call AuthInvoke, api[%s]", b.this.getName());
                b.this.a(jVar2, jSONObject2, i2, o);
            }

            public final String toString() {
                return hashCode() + "|" + b.this.getName();
            }
        };
        if (!o.afU()) {
            synchronized (o.jXF) {
                o.jXF.offer(anonymousClass1);
            }
            o.DA(1);
        }
    }

    final void a(j jVar, int i, String str) {
        jVar.E(i, e(str, null));
    }

    protected final MMActivity a(j jVar) {
        return super.a(jVar);
    }
}
