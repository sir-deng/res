package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;

public final class f {
    public final IX5JsVirtualMachine AeI;
    public final HashSet<WeakReference<a>> AeJ;
    final Context mContext;

    private static class a implements IX5JsContext {
        public WebView AeA;

        public a(Context context) {
            this.AeA = new WebView(context);
            this.AeA.getSettings().setJavaScriptEnabled(true);
        }

        public final void addJavascriptInterface(Object obj, String str) {
            if (this.AeA != null) {
                this.AeA.addJavascriptInterface(obj, str);
                this.AeA.loadUrl("about:blank");
            }
        }

        public final void destroy() {
            if (this.AeA != null) {
                this.AeA.clearHistory();
                this.AeA.clearCache(true);
                this.AeA.loadUrl("about:blank");
                this.AeA.freeMemory();
                this.AeA.pauseTimers();
                this.AeA.destroy();
                this.AeA = null;
            }
        }

        public final void evaluateJavascript(String str, final ValueCallback<String> valueCallback, URL url) {
            if (this.AeA != null) {
                this.AeA.evaluateJavascript(str, valueCallback == null ? null : new ab<String>() {
                    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        valueCallback.onReceiveValue((String) obj);
                    }
                });
            }
        }

        public final IX5JsValue evaluateScript(String str, URL url) {
            if (this.AeA != null) {
                this.AeA.evaluateJavascript(str, null);
            }
            return null;
        }

        public final void evaluateScriptAsync(String str, final ValueCallback<IX5JsValue> valueCallback, URL url) {
            if (this.AeA != null) {
                this.AeA.evaluateJavascript(str, valueCallback == null ? null : new ab<String>() {
                    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        valueCallback.onReceiveValue(null);
                    }
                });
            }
        }

        public final void removeJavascriptInterface(String str) {
            if (this.AeA != null) {
                this.AeA.removeJavascriptInterface(str);
            }
        }

        public final void setExceptionHandler(ValueCallback<IX5JsError> valueCallback) {
        }

        public final void setName(String str) {
        }

        public final void setPerContextData(Object obj) {
        }

        public final void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
        }
    }

    public f(Context context) {
        this(context, (byte) 0);
    }

    private f(Context context, byte b) {
        this.AeJ = new HashSet();
        this.mContext = context;
        this.AeI = ah.a(context, null);
    }
}
