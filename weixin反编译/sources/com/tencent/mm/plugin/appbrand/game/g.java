package com.tencent.mm.plugin.appbrand.game;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import java.net.URL;

public final class g implements b {
    private h jaz;
    private boolean qG = false;

    public g(h hVar) {
        j jVar = j.jaE;
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.initJsVmContext ThreadName = [%s]", Thread.currentThread().getName());
        if (jVar.jaF != null) {
            throw new IllegalStateException("Init JsVm Context second time");
        }
        int addAndGet = jVar.jaG.addAndGet(1);
        jVar.jaF = new f(true, new com.tencent.magicbrush.engine.b(), addAndGet);
        jVar.jaH.put(Integer.valueOf(addAndGet), jVar.jaF);
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.initJsVmContext finished");
        this.jaz = hVar;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        a aVar = j.jaE.jaF;
        if (aVar == null) {
            throw new IllegalStateException("JsVmContext Not Initialized, main");
        } else if (str == null || str.isEmpty()) {
            x.e("WAGameJsEngine", "js script is null");
            throw new IllegalArgumentException("js script is null");
        } else if (aVar == null) {
            x.w("WAGameJsEngine", "WAGameJsEngine.evaluateJavaScriptImpl jsVmContext == null");
        } else {
            synchronized (this) {
                if (this.qG) {
                    x.w("WAGameJsEngine", "evaluateSubJavascript is mDestroyed. script : " + str);
                    return;
                }
                aVar.evaluateJavascript(str, valueCallback);
            }
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        a aVar = j.jaE.jaF;
        if (aVar == null) {
            throw new IllegalStateException("JsVmContext Not Initialized, main");
        } else if (str == null || str.isEmpty()) {
            x.e("WAGameJsEngine", "js script is null");
            throw new IllegalArgumentException("js script is null");
        } else {
            synchronized (this) {
                if (this.qG) {
                    x.w("WAGameJsEngine", "evaluateSubJavascript is mDestroyed. script : " + str);
                    return;
                }
                aVar.a(url, str, valueCallback);
            }
        }
    }

    public final void a(d dVar) {
    }

    public final void addJavascriptInterface(Object obj, String str) {
        a aVar = j.jaE.jaF;
        if (obj == null || str == null || str.isEmpty()) {
            x.w("WAGameJsEngine", "addJavaScriptInterface empty! : " + str);
        } else if (aVar == null) {
            x.w("WAGameJsEngine", "");
        } else {
            synchronized (this) {
                if (this.qG) {
                    x.w("WAGameJsEngine", "addJavaScriptInterface mDestroyed. name : " + str);
                    return;
                }
                x.i("WAGameJsEngine", "addJavaScriptInterface name : " + str);
                aVar.addJavascriptInterface(obj, str);
            }
        }
    }

    public final void destroy() {
        synchronized (this) {
            this.qG = true;
        }
    }

    public final <T extends c> T v(Class<T> cls) {
        if (cls.equals(f.class) || cls.equals(com.tencent.mm.plugin.appbrand.g.d.class)) {
            return j.jaE;
        }
        return !cls.isInstance(this) ? null : this;
    }
}
