package com.tencent.mm.t.c;

import android.webkit.JavascriptInterface;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.b.c;
import com.tencent.mm.t.b.d;

public final class e {
    public volatile boolean Vx;
    public String gQA;
    public c gQB;
    public f gQC;
    public d gQD;
    private volatile boolean gQE;
    public a gQF;

    public interface a {
        void B(String str, int i);
    }

    @JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        int i = 0;
        String str4 = "MicroMsg.MiniJsBridge";
        String str5 = "publishHandler, event: %s, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        x.d(str4, str5, objArr);
    }

    @JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        if (this.Vx) {
            return this.gQB.b(str, str2, i);
        }
        return this.gQB.gQu.G(str, "fail:JsApi core not started");
    }

    public final boolean a(c cVar) {
        f fVar = this.gQC;
        if (cVar == null) {
            x.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
            return false;
        }
        com.tencent.mm.t.b.e fu = fVar.gQG.fu(cVar.name);
        if (fu == null) {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", cVar);
            return false;
        } else if (fVar.gQs.go(fu.getIndex())) {
            String jSONObject = cVar.sO().toString();
            x.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", cVar.name, Integer.valueOf(jSONObject.length()), Integer.valueOf(0));
            fVar.gQD.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{cVar.name, jSONObject, "undefined", f.Cj()}), null);
            return true;
        } else {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", cVar);
            return false;
        }
    }

    public final void b(c cVar) {
        if (!this.gQE) {
            x.v("MicroMsg.MiniJsBridge", "onPause(%s)", this.gQA);
            this.gQE = true;
            if (this.gQD.Cg()) {
                this.gQD.pause();
            } else {
                a(cVar);
            }
            if (this.gQF != null) {
                this.gQF.B(this.gQA, 3);
            }
        }
    }

    public final void c(c cVar) {
        if (this.gQE) {
            x.v("MicroMsg.MiniJsBridge", "onResume(%s)", this.gQA);
            if (this.gQD.Cg()) {
                this.gQD.resume();
            } else {
                a(cVar);
            }
            this.gQE = false;
            if (this.gQF != null) {
                this.gQF.B(this.gQA, 2);
            }
        }
    }

    public final void onStart() {
        if (!this.Vx) {
            x.v("MicroMsg.MiniJsBridge", "onStart(%s)", this.gQA);
            this.Vx = true;
            if (this.gQF != null) {
                this.gQF.B(this.gQA, 1);
            }
        }
    }
}
