package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.Map;

public final class f {
    private static String tNL = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    private d jAm;
    private WebView tCV;
    public boolean tKB;
    private a tNI;
    private boolean tNJ;
    private final al tNK;
    private d tsa;

    public interface a {
        void bTX();
    }

    static /* synthetic */ void b(f fVar) {
        boolean z;
        if (fVar.tKB) {
            x.i("MicroMsg.JsLoader", "jsapi init done by preload");
            if (fVar.tsa != null) {
                fVar.tsa.bVa();
            }
            z = true;
        } else if (fVar.tCV == null || fVar.tsa == null) {
            x.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
            z = false;
        } else {
            Map bUH;
            fVar.tCV.evaluateJavascript(fVar.bVh(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    x.i("MicroMsg.JsLoader", "loadJavaScript, evaluateJavascript cb, ret = %s", (String) obj);
                }
            });
            d dVar = fVar.tsa;
            x.v("MicroMsg.JsApiHandler", "jsapi init");
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("sys:init", dVar.tNm, dVar.tNq, dVar.tNr) + ")", new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    x.i("MicroMsg.JsApiHandler", "sys:init back %s\t", (String) obj);
                }
            });
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("sys:bridged", null, dVar.tNq, dVar.tNr) + ")", new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    x.i("MicroMsg.JsApiHandler", "sys:bridged back %s\t", (String) obj);
                }
            });
            dVar.bVa();
            dVar.bVb();
            if (!(bi.oN(dVar.tNu) || dVar.tNi == null)) {
                dVar.tNi.evaluateJavascript(dVar.cL(dVar.tNu, dVar.tNv), null);
                dVar.tNu = null;
                dVar.tNv = 0;
            }
            if (dVar.tNi.getContext() instanceof MutableContextWrapper) {
                Context baseContext = ((MutableContextWrapper) dVar.tNi.getContext()).getBaseContext();
                if (baseContext instanceof PreLoadWebViewUI) {
                    bUH = ((PreLoadWebViewUI) baseContext).bUH();
                    dVar.al(bUH);
                    x.i("MicroMsg.JsLoader", "jsapi init done");
                    z = true;
                } else {
                    x.i("MicroMsg.JsApiHandler", "webview.context is not PreloadWebviewUI， %s", baseContext.toString());
                }
            }
            bUH = null;
            dVar.al(bUH);
            x.i("MicroMsg.JsLoader", "jsapi init done");
            z = true;
        }
        x.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", Boolean.valueOf(z));
        if (z && fVar.tNI != null) {
            fVar.tNI.bTX();
        }
        g.pWK.a(156, 1, 1, false);
        if (!z) {
            g.pWK.a(156, 0, 1, false);
        }
    }

    public f(WebView webView, d dVar, d dVar2, a aVar, boolean z) {
        this(webView, dVar, dVar2, aVar, false, false);
    }

    public f(WebView webView, d dVar, d dVar2, a aVar, boolean z, boolean z2) {
        this.tNJ = false;
        this.tNK = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                f.b(f.this);
                return false;
            }
        }, true);
        this.tCV = webView;
        this.jAm = dVar;
        this.tsa = dVar2;
        this.tNI = aVar;
        this.tNJ = z;
        this.tKB = z2;
        x.d("MicroMsg.JsLoader", "JsLoader <init>, withoutDelay = %b,isWebViewPreload %b", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public final void detach() {
        x.v("MicroMsg.JsLoader", "detach");
        this.tCV = null;
        this.tsa = null;
        this.tNI = null;
    }

    public final void bUT() {
        x.v("MicroMsg.JsLoader", "onPageStarted");
        if (!this.tNK.cgx()) {
            this.tNK.TN();
            x.i("MicroMsg.JsLoader", "tryStopTimer success");
        }
    }

    public final void bUU() {
        x.v("MicroMsg.JsLoader", "onPageFinished");
        if (this.tNK.cgx()) {
            al alVar = this.tNK;
            long j = this.tNJ ? 0 : 1000;
            alVar.K(j, j);
            x.i("MicroMsg.JsLoader", "tryStartTimer success");
            return;
        }
        x.i("MicroMsg.JsLoader", "timer running");
    }

    private String bVh() {
        int i;
        try {
            if (this.jAm.e(98, null) == null) {
                i = 0;
            } else {
                i = 1;
            }
        } catch (Exception e) {
            i = 0;
        }
        x.i("MicroMsg.JsLoader", "WXJS: %s", i != 0 ? "jsapi/wxjs.js" : "jsapi/wxjs_fallback.js");
        try {
            String convertStreamToString = bi.convertStreamToString(ad.getContext().getAssets().open(i != 0 ? "jsapi/wxjs.js" : "jsapi/wxjs_fallback.js"));
            if (TextUtils.isEmpty(this.tsa.tNr)) {
                return convertStreamToString;
            }
            return convertStreamToString.replace("__wx._getDgtVerifyRandomStr()", this.tsa.tNr).replace("__wx._isDgtVerifyEnabled()", "true");
        } catch (Exception e2) {
            x.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", e2);
            return "";
        }
    }
}
