package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.n;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.b.d;
import com.tencent.mm.t.c.b;
import com.tencent.mm.t.c.f;
import com.tencent.mm.t.d.a;
import com.tencent.rtmp.TXLiveConstants;
import org.json.JSONObject;

public class e {
    private static volatile com.tencent.mm.t.c.e iXT;
    private static volatile DebuggerInfo iXU;
    private static volatile boolean iXV;

    public static com.tencent.mm.t.c.e a(Context context, WxaWidgetContext wxaWidgetContext, a aVar, Bundle bundle) {
        com.tencent.mm.t.c.e eVar;
        String convertStreamToString;
        synchronized (e.class) {
            eVar = iXT;
            iXT = null;
        }
        if (eVar == null) {
            eVar = a(wxaWidgetContext.adf());
        }
        int i = bundle.getInt("widget_type");
        b cVar = new c();
        if (i == 1) {
            cVar.iWQ = new com.tencent.mm.plugin.appbrand.dynamic.i.c(wxaWidgetContext.getAppId(), bundle.getString("search_id"));
        }
        com.tencent.mm.t.c.c cVar2 = new com.tencent.mm.t.c.c(context, eVar, aVar, cVar);
        cVar2.gQt = n.jY(i);
        eVar.gQB = cVar2;
        d dVar = eVar.gQD;
        eVar.gQC = new f(dVar, com.tencent.mm.plugin.appbrand.dynamic.f.a.jZ(i), aVar);
        eVar.gQF = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.adl();
        WidgetRuntimeConfig adh = wxaWidgetContext.adh();
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, "widgetType", Integer.valueOf(adh.iXt));
        b(jSONObject, "platform", "android");
        b(jSONObject, "debug", Boolean.valueOf(wxaWidgetContext.adf().iWf));
        b(jSONObject, "drawMinInterval", Integer.valueOf(wxaWidgetContext.adg().iQG));
        b(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.vHl));
        JSONObject jSONObject2 = new JSONObject();
        b(jSONObject2, "drawMinInterval", Integer.valueOf(adh.iXJ));
        b(jSONObject2, "timerEnabled", Boolean.valueOf(adh.iXK));
        b(jSONObject2, "drawLock", Boolean.valueOf(adh.iXL));
        dVar.evaluateJavascript(String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[]{jSONObject2.toString(), jSONObject.toString(), ""}), null);
        x.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", wxaWidgetContext.getId(), r1);
        String be = com.tencent.mm.plugin.appbrand.dynamic.j.c.be(wxaWidgetContext.getId(), "WAWidget.js");
        if (bi.oN(be)) {
            convertStreamToString = com.tencent.mm.plugin.appbrand.q.c.convertStreamToString(af.openRead("WAWidget.js"));
        } else {
            convertStreamToString = be;
        }
        if (bi.oN(convertStreamToString)) {
            x.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
        }
        g.pWK.a(636, 0, 1, false);
        com.tencent.mm.t.a.a(dVar, convertStreamToString, new com.tencent.mm.t.a.a() {
            public final void Cb() {
                g.pWK.a(636, 1, 1, false);
            }

            public final void fs(String str) {
                g.pWK.a(636, 2, 1, false);
                x.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", str);
            }
        });
        x.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", wxaWidgetContext.getId());
        convertStreamToString = com.tencent.mm.plugin.appbrand.dynamic.j.c.be(wxaWidgetContext.getId(), "widget.js");
        if (bi.oN(convertStreamToString)) {
            x.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.acX().av(wxaWidgetContext.getId(), TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
        }
        g.pWK.a(636, 3, 1, false);
        com.tencent.mm.t.a.a(dVar, convertStreamToString, new com.tencent.mm.t.a.a() {
            public final void Cb() {
                g.pWK.a(636, 4, 1, false);
            }

            public final void fs(String str) {
                g.pWK.a(636, 5, 1, false);
                x.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", str);
            }
        });
        x.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", wxaWidgetContext.getId());
        bS(context);
        return eVar;
    }

    public static void bS(final Context context) {
        if (iXV) {
            com.tencent.mm.by.a.Z(new Runnable() {
                public final void run() {
                    synchronized (e.class) {
                        if (e.iXT != null) {
                            return;
                        }
                        com.tencent.mm.t.c.e a = e.a(e.iXU);
                        synchronized (e.class) {
                            e.iXT = a;
                        }
                    }
                }
            });
        }
    }

    private static com.tencent.mm.t.c.e a(DebuggerInfo debuggerInfo) {
        d dVar;
        com.tencent.mm.t.c.e eVar = new com.tencent.mm.t.c.e();
        Object obj = null;
        if (debuggerInfo != null && debuggerInfo.iWg) {
            x.i("MicroMsg.PreloadOptimizer", "debug mode opened, use WebView  JavaScript Engine.");
            obj = 1;
        }
        Context context = ad.getContext();
        String str = "WeixinJSCore";
        String str2 = "https://servicewechat.com/app-widget";
        if (obj != null) {
            dVar = new com.tencent.mm.plugin.appbrand.dynamic.e.d(context, eVar, str, str2);
        } else {
            com.tencent.xweb.g a = com.tencent.xweb.g.a(com.tencent.xweb.g.a.RT_TYPE_AUTO, "support", context);
            dVar = a.isValid() ? new com.tencent.mm.plugin.appbrand.dynamic.e.a(eVar, str, a) : new com.tencent.mm.plugin.appbrand.dynamic.e.d(context, eVar, str, str2);
        }
        if (dVar.Ch()) {
            g.pWK.a(639, 1, 1, false);
            x.i("MicroMsg.PreloadOptimizer", "Using WebView Based Javascript Engine");
        } else {
            g.pWK.a(639, 2, 1, false);
            x.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
        }
        g.pWK.a(639, 0, 1, false);
        if (eVar.gQD != null) {
            x.e("MicroMsg.MiniJsBridge", "can not initialize again.");
        } else {
            eVar.gQD = dVar;
        }
        return eVar;
    }

    private static void b(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            x.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", e);
        }
    }
}
