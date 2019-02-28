package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class c extends b {
    private e jfE;
    private int jfG;
    WeakReference<p> mPageRef;

    abstract void s(JSONObject jSONObject);

    c() {
    }

    final void a(e eVar, p pVar, JSONObject jSONObject, int i) {
        this.jfE = eVar;
        this.mPageRef = new WeakReference(pVar);
        this.jfG = i;
        s(jSONObject);
    }

    protected final View agW() {
        return this.mPageRef == null ? null : ((p) this.mPageRef.get()).getContentView();
    }

    final void f(String str, Map<String, Object> map) {
        if (this.mPageRef != null && this.mPageRef.get() != null && this.jfE != null) {
            ((p) this.mPageRef.get()).E(this.jfG, this.jfE.e(str, map));
        }
    }
}
