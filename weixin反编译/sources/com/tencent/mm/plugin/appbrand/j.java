package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.e;
import com.tencent.mm.plugin.appbrand.g.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class j extends c {
    public volatile boolean Vx = true;
    public e iuk;
    public d iul = YW();
    public b ium = YV();
    public m iun = new m(this);
    protected LinkedList<a> iuo = new LinkedList();
    public boolean iup = false;
    private boolean iuq = false;
    private long iur = System.currentTimeMillis();
    public long ius;
    public String mAppId;

    private static class a {
        String data;
        String fpd;
        int src;

        a(String str, String str2, int i) {
            this.fpd = str;
            this.data = str2;
            this.src = i;
        }
    }

    public j() {
        this.ium.a(new com.tencent.xweb.d() {
            public final void aN(String str, String str2) {
            }
        });
        this.ius = System.currentTimeMillis() - this.iur;
    }

    public b YV() {
        return h.ca(ad.getContext());
    }

    public d YW() {
        d dVar = new d(this, this.ium);
        this.ium.addJavascriptInterface(dVar, "WeixinJSCore");
        return dVar;
    }

    public void f(e eVar) {
        x.i("MicroMsg.AppBrandService", "onRuntimeReady, mPreLoadWebView %b", Boolean.valueOf(this.iup));
        this.iuk = eVar;
        this.mAppId = eVar.mAppId;
        if (this.ium.v(e.class) != null) {
            ((e) this.ium.v(e.class)).tC(String.format("https://servicewechat.com/%s/js-engine", new Object[]{this.mAppId}));
        }
    }

    public void init() {
        Zb();
        YY();
        String a = ao.a(this.iuk, "app-service.js");
        g.pWK.a(370, 9, 1, false);
        com.tencent.mm.plugin.appbrand.r.h.a(this.ium, "app-service.js", a, new com.tencent.mm.plugin.appbrand.r.h.a() {
            public final void pH(String str) {
                g.pWK.a(370, 11, 1, false);
            }

            public final void fs(String str) {
                x.e("MicroMsg.AppBrandService", "Inject External Service Script Failed: %s", str);
                g.pWK.a(370, 10, 1, false);
                com.tencent.mm.plugin.appbrand.report.a.C(j.this.mAppId, 24, 0);
                com.tencent.mm.plugin.appbrand.report.a.a(j.this.mAppId, j.this.iuk.isS.iRU.iJb, j.this.iuk.isS.iRU.iJa, 370, 10);
            }
        });
        q.a(this.iuk, this.ium, "app-service.js");
        e eVar = this.iuk;
        b bVar = this.ium;
        if (eVar == null || bVar == null) {
            x.w("MicroMsg.SourceMapInjector", "runtime or jsRuntime is null.");
        } else if (com.tencent.mm.plugin.appbrand.appcache.d.a.jy(eVar.isS.iRU.iJa)) {
            x.i("MicroMsg.SourceMapInjector", "current running type is ReleaseType do not need to inject sourceMap.");
        } else {
            a = ab.pW("WASourceMap.js");
            if (a == null || a.length() == 0) {
                x.w("MicroMsg.SourceMapInjector", "WASourceMap.js is null or nil");
            } else {
                com.tencent.mm.plugin.appbrand.r.h.a(bVar, a, new com.tencent.mm.plugin.appbrand.r.h.a() {
                    public final void pH(String str) {
                        x.i("MicroMsg.SourceMapInjector", "Inject '%s' Script Success: %s", "WASourceMap.js", str);
                    }

                    public final void fs(String str) {
                        x.e("MicroMsg.SourceMapInjector", "Inject '%s' Script Failed: %s", "WASourceMap.js", str);
                    }
                });
            }
        }
        YX();
    }

    public void pG(final String str) {
        String str2 = str + (str.endsWith("/") ? "" : "/") + "app-service.js";
        String a = ao.a(this.iuk, str2);
        g.pWK.a(370, 30, 1, false);
        com.tencent.mm.plugin.appbrand.r.h.a(this.ium, str2, a, new com.tencent.mm.plugin.appbrand.r.h.a() {
            public final void pH(String str) {
                g.pWK.a(370, 31, 1, false);
            }

            public final void fs(String str) {
                x.e("MicroMsg.AppBrandService", "inject module(%s) script failed: %s", str, str);
                g.pWK.a(370, 32, 1, false);
            }
        });
        q.a(this.iuk, this.ium, str2);
    }

    public final synchronized void YX() {
        Iterator it = this.iuo.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            super.j(aVar.fpd, aVar.data, aVar.src);
        }
        this.iuo = null;
    }

    public void YY() {
        if (!this.iuq) {
            this.iuq = true;
            com.tencent.mm.plugin.appbrand.r.h.a(this.ium, com.tencent.mm.plugin.appbrand.q.c.ve("wxa_library/android.js"), new com.tencent.mm.plugin.appbrand.r.h.a() {
                public final void pH(String str) {
                    x.i("MicroMsg.AppBrandService", "Inject android.js Script Success");
                }

                public final void fs(String str) {
                    x.e("MicroMsg.AppBrandService", "Inject android.js Script Failed");
                }
            });
            com.tencent.mm.plugin.appbrand.r.h.a(this.ium, ab.pW("WAService.js"), new com.tencent.mm.plugin.appbrand.r.h.a() {
                public final void pH(String str) {
                    x.i("MicroMsg.AppBrandService", "Inject SDK Service Script Success");
                    g.pWK.a(370, 7, 1, false);
                }

                public final void fs(String str) {
                    int i = 0;
                    x.e("MicroMsg.AppBrandService", "Inject SDK Service Script Failed: %s", str);
                    g.pWK.a(370, 6, 1, false);
                    com.tencent.mm.plugin.appbrand.report.a.C(j.this.mAppId, 24, 0);
                    int i2 = -1;
                    if (j.this.iuk != null) {
                        i = j.this.iuk.isS.iRU.iJb;
                        i2 = j.this.iuk.isS.iRU.iJa;
                    }
                    com.tencent.mm.plugin.appbrand.report.a.a(j.this.mAppId, i, i2, 370, 6);
                }
            });
            g.pWK.a(370, 5, 1, false);
        }
        if (this.iuk != null) {
            String str = "";
            if (AppBrandPerformanceManager.uy(this.mAppId)) {
                str = ab.pW("WAPerf.js");
            }
            if (bi.oN(str)) {
                x.i("MicroMsg.AppBrandService", "execInternalInitScript, js null");
            } else {
                com.tencent.mm.plugin.appbrand.r.h.a(this.ium, str, new com.tencent.mm.plugin.appbrand.r.h.a() {
                    public final void pH(String str) {
                        x.i("MicroMsg.AppBrandService", "Inject performanceJs Script Success");
                    }

                    public final void fs(String str) {
                        x.e("MicroMsg.AppBrandService", "Inject performanceJs Script Failed");
                    }
                });
            }
        }
    }

    public void j(String str, String str2, int i) {
        synchronized (this) {
            if (this.iuo != null) {
                this.iuo.add(new a(str, str2, i));
                return;
            }
            super.j(str, str2, i);
        }
    }

    public final void a(String str, String str2, int[] iArr) {
        this.iuk.isX.c(str, str2, iArr);
    }

    public final boolean isRunning() {
        return this.Vx;
    }

    public final Activity getContext() {
        return this.iuk == null ? null : this.iuk.isO;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final e YZ() {
        return this.iuk;
    }

    public final b Za() {
        return this.ium;
    }

    public void cleanup() {
        super.cleanup();
        this.Vx = false;
        this.ium.destroy();
        this.iul.cleanup();
    }

    public void Zb() {
        JSONObject Zc = Zc();
        String str = this.iuk.isT.iPL;
        this.ium.evaluateJavascript(String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{Zc.toString(), str}), null);
        if (this.iup) {
            super.j("onWxConfigReady", "", 0);
        }
    }

    public final JSONObject Zc() {
        JSONObject jSONObject = new JSONObject();
        AppBrandSysConfig appBrandSysConfig = this.iuk.isS;
        com.tencent.mm.plugin.appbrand.config.a aVar = this.iuk.isT;
        if (appBrandSysConfig == null || aVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject2 = aVar.iPK;
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                jSONObject.putOpt(str, jSONObject2.opt(str));
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandService", e.getMessage());
            }
        }
        a(jSONObject, "appType", Integer.valueOf(this.iuk.isR.foo));
        a(jSONObject, "debug", Boolean.valueOf(this.iuk.isS.iRu));
        a(jSONObject, "downloadDomain", appBrandSysConfig.iRP);
        f(jSONObject);
        Object jSONObject3 = new JSONObject();
        a((JSONObject) jSONObject3, "scene", Integer.valueOf(this.iuk.YF()));
        String YG = this.iuk.YG();
        a((JSONObject) jSONObject3, "path", l.vh(YG));
        a((JSONObject) jSONObject3, "query", new JSONObject(l.vi(YG)));
        a((JSONObject) jSONObject3, "topBarStatus", Boolean.valueOf(this.iuk.isR.iRj));
        a((JSONObject) jSONObject3, "referrerInfo", this.iuk.isR.iRl.acn());
        a((JSONObject) jSONObject3, "shareInfo", this.iuk.isR.acl());
        a((JSONObject) jSONObject3, "isSticky", Boolean.valueOf(this.iuk.isR.iRj));
        Object jSONObject4 = new JSONObject();
        try {
            a((JSONObject) jSONObject4, "template", new JSONArray(appBrandSysConfig.iRt));
        } catch (Exception e2) {
        }
        a((JSONObject) jSONObject4, "maxRequestConcurrent", Integer.valueOf(appBrandSysConfig.iRC));
        a((JSONObject) jSONObject4, "maxUploadConcurrent", Integer.valueOf(appBrandSysConfig.iRD));
        a((JSONObject) jSONObject4, "maxDownloadConcurrent", Integer.valueOf(appBrandSysConfig.iRE));
        a((JSONObject) jSONObject4, "maxWebsocketConnect", Integer.valueOf(appBrandSysConfig.iRF));
        a((JSONObject) jSONObject4, "maxWorkerConcurrent", Integer.valueOf(appBrandSysConfig.iRG));
        a(jSONObject, "appLaunchInfo", jSONObject3);
        a(jSONObject, "wxAppInfo", jSONObject4);
        a(jSONObject, "isPluginMiniProgram", Boolean.valueOf(this.iuk.YH()));
        jSONObject3 = new JSONObject();
        a((JSONObject) jSONObject3, "USER_DATA_PATH", (Object) "wxfile://usr");
        a(jSONObject, "env", jSONObject3);
        a(jSONObject, "appContactInfo", bi.aD(this.iuk.isR.iRf, "{}"));
        return e(jSONObject);
    }

    public JSONObject e(JSONObject jSONObject) {
        return jSONObject;
    }

    public void f(JSONObject jSONObject) {
        a(jSONObject, "platform", (Object) "android");
        a(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.vHl));
        a(jSONObject, "nativeBufferEnabled", Boolean.valueOf(this.ium.v(com.tencent.mm.plugin.appbrand.g.d.class) != null));
        a(jSONObject, "system", "Android " + VERSION.RELEASE);
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandService", e.getMessage());
        }
    }
}
