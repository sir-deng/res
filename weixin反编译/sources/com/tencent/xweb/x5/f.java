package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ah;
import com.tencent.xweb.x5.a.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.Log;

public final class f implements com.tencent.xweb.c.f {
    private ah AAX;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
        Log.i("MicroMsg.X5JsRuntime", "create X5V8JsRuntime");
    }

    public final void init(int i) {
        this.AAX = new ah(this.mContext);
    }

    public final void pause() {
        if (this.AAX.wD != null) {
            ah.a("pause", new Class[]{Object.class}, this.AAX.wD);
        }
    }

    public final void resume() {
        if (this.AAX.wD != null) {
            ah.a("resume", new Class[]{Object.class}, this.AAX.wD);
        }
    }

    public final boolean Cg() {
        return ah.hH(this.mContext) && QbSdk.getTbsVersion(this.mContext) >= 43600;
    }

    public final void cleanup() {
        ah ahVar = this.AAX;
        if (ahVar.wD != null) {
            ah.a("destroyX5JsCore", new Class[]{Object.class}, ahVar.wD);
            ahVar.wD = null;
        } else if (ahVar.AeA != null) {
            ahVar.AeA.clearHistory();
            ahVar.AeA.clearCache(true);
            ahVar.AeA.loadUrl("about:blank");
            ahVar.AeA.freeMemory();
            ahVar.AeA.pauseTimers();
            ahVar.AeA.destroy();
            ahVar.AeA = null;
        }
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.AAX.evaluateJavascript(str, new d(valueCallback));
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        this.AAX.evaluateJavascript(str, new d(valueCallback));
    }

    public final void addJavascriptInterface(Object obj, String str) {
        ah ahVar = this.AAX;
        if (ahVar.wD != null) {
            ah.a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, ahVar.wD);
        } else if (ahVar.AeA != null) {
            ahVar.AeA.addJavascriptInterface(obj, str);
            ahVar.AeA.loadUrl("about:blank");
        }
    }

    public final int getNativeBufferId() {
        return this.AAX.getNativeBufferId();
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        this.AAX.setNativeBuffer(i, byteBuffer);
    }

    public final ByteBuffer ef(int i) {
        return this.AAX.ef(i);
    }

    public final boolean cJu() {
        return ah.hI(this.mContext);
    }

    public final void a(com.tencent.xweb.d dVar) {
    }
}
