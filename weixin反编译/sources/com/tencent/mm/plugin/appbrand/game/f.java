package com.tencent.mm.plugin.appbrand.game;

import android.webkit.ValueCallback;
import com.tencent.magicbrush.engine.b;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import java.net.URL;

public final class f implements a {
    private int jaw;
    b jax;
    private boolean jay;

    public f(boolean z, b bVar, int i) {
        this.jax = bVar;
        this.jaw = i;
        this.jay = z;
    }

    public final void addJavascriptInterface(Object obj, String str) {
        if (this.jax != null) {
            this.jax.c(obj, str);
        }
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.jax == null || bi.oN(str)) {
            x.e("MicroMsg.WAGameJsContextImpl", "evaluate Error : [%s], [%s]", this.jax, str);
            if (valueCallback != null) {
                valueCallback.onReceiveValue("");
                return;
            }
            return;
        }
        String by = this.jax.by(str);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(bi.oM(by));
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        if (url == null) {
            evaluateJavascript(str, valueCallback);
        } else if (this.jax == null || bi.oN(str)) {
            x.e("MicroMsg.WAGameJsContextImpl", "evaluate Error : [%s], [%s]", this.jax, str);
            if (valueCallback != null) {
                valueCallback.onReceiveValue("");
            }
        } else {
            String q = this.jax.q(str, url.toString());
            if (valueCallback != null) {
                valueCallback.onReceiveValue(bi.oM(q));
            }
        }
    }

    public final void a(d dVar) {
    }

    public final void destroy() {
        if (this.jax != null) {
            this.jax.dispose();
        }
    }

    public final <T extends c> T v(Class<T> cls) {
        return null;
    }

    public final boolean adY() {
        return this.jay;
    }

    public final int adZ() {
        return this.jaw;
    }

    public final void a(a aVar, String str) {
        if (aVar == null || bi.oN(str)) {
            x.e("MicroMsg.WAGameJsContextImpl", "shareObject object name is null [%s], [%s]", aVar, str);
        } else if (aVar instanceof f) {
            this.jax.a(((f) aVar).jax, str);
        } else {
            x.e("MicroMsg.WAGameJsContextImpl", "share Object with different JSContext type , [%s]", aVar);
        }
    }
}
