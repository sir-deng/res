package com.tencent.xweb;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.h;
import com.tencent.xweb.xwalk.b;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class g {
    public static a Aza;
    private static String Azc = "";
    public f Azb;
    public volatile boolean iXb = false;

    public enum a {
        RT_TYPE_AUTO,
        RT_TYPE_SYS,
        RT_TYPE_XWALK,
        RT_TYPE_WEB_X5,
        RT_TYPE_DUMMY,
        RT_TYPE_X5,
        RT_TYPE_J2V8,
        RT_TYPE_NATIVE_SCRIPT,
        RT_TYPE_MMV8
    }

    public static a cJf() {
        return Aza;
    }

    public final boolean isValid() {
        return (this.Azb == null || Aza == a.RT_TYPE_AUTO || Aza == a.RT_TYPE_DUMMY) ? false : true;
    }

    public static String cJg() {
        return Azc;
    }

    public static g a(a aVar, String str, Context context) {
        return new g(aVar, str, context);
    }

    public static a b(a aVar, String str, Context context) {
        k.iS(context);
        if (str == null) {
            str = "";
        }
        if (k.cJh().Azw != a.RT_TYPE_AUTO) {
            aVar = k.cJh().Azw;
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = " + aVar);
        } else if (a.acU(str) != a.RT_TYPE_AUTO) {
            aVar = a.acU(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + str + "use cmd jscore type = " + aVar);
        }
        if (WebView.getCurWebType() == c.WV_KIND_X5) {
            if (a.RT_TYPE_SYS == aVar || a.RT_TYPE_MMV8 == aVar) {
                return aVar;
            }
            return a.RT_TYPE_X5;
        } else if (WebView.getCurWebType() == c.WV_KIND_CW) {
            if (a.RT_TYPE_NATIVE_SCRIPT == aVar || a.RT_TYPE_J2V8 == aVar || a.RT_TYPE_SYS == aVar) {
                return aVar;
            }
            return a.RT_TYPE_MMV8;
        } else if (WebView.getCurWebType() != c.WV_KIND_SYS || a.RT_TYPE_SYS == aVar) {
            return aVar;
        } else {
            return a.RT_TYPE_MMV8;
        }
    }

    private g(a aVar, String str, Context context) {
        a aVar2;
        Log.i("JsRuntime", String.format("init JsRuntime (%s)", new Object[]{android.util.Log.getStackTraceString(new Throwable())}));
        a b = b(aVar, str, context);
        switch (b) {
            case RT_TYPE_X5:
                this.Azb = h.a(c.WV_KIND_X5).getJsCore(b, context);
                if (this.Azb != null) {
                    Azc = "x5";
                    break;
                }
                break;
            case RT_TYPE_J2V8:
            case RT_TYPE_NATIVE_SCRIPT:
                this.Azb = h.a(c.WV_KIND_CW).getJsCore(b, context);
                if (this.Azb != null) {
                    Azc = b == a.RT_TYPE_J2V8 ? "j2v8" : "nativeScript";
                    break;
                }
                break;
            case RT_TYPE_MMV8:
                this.Azb = new b();
                this.Azb.init(0);
                Azc = "mmv8";
                break;
        }
        if (this.Azb != null) {
            aVar2 = b;
        } else if (a.RT_TYPE_SYS == b || a.RT_TYPE_X5 == b) {
            aVar2 = a.RT_TYPE_DUMMY;
            this.Azb = new com.tencent.xweb.c.c();
        } else {
            aVar2 = a.RT_TYPE_MMV8;
            this.Azb = new b();
            this.Azb.init(0);
            Azc = "mmv8";
        }
        Aza = aVar2;
        Log.d("JsRuntime", "xxx IJsRuntime  request=" + aVar2.toString() + ", create=" + Azc);
    }

    public final void cleanup() {
        if (!this.iXb) {
            this.Azb.cleanup();
        }
        this.iXb = true;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.iXb) {
            this.Azb.evaluateJavascript(str, valueCallback);
        }
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.Azb.addJavascriptInterface(obj, str);
    }

    public final void pause() {
        this.Azb.pause();
    }

    public final void resume() {
        this.Azb.resume();
    }

    public final boolean Cg() {
        return this.Azb.Cg();
    }
}
