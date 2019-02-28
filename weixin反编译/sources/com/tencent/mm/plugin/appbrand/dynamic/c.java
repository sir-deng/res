package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.canvas.widget.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.c.e;
import com.tencent.mm.y.u;

public final class c implements b {
    boolean Vx;
    String appId;
    String gQA;
    volatile e gQx;
    String iNG;
    int iUX;
    String iUY;
    g iUZ;
    String iVa;
    volatile boolean iVb;
    private volatile boolean iVc;
    boolean iVd = false;
    boolean iVe = false;
    private com.tencent.mm.ipcinvoker.wx_extension.b.a iVf;
    Runnable iVg;
    Context mContext;
    String mUrl;

    private static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            String string = bundle.getString("widgetId");
            String string2 = bundle.getString("respData");
            if (!bi.oN(string)) {
                IPCDynamicPageView rR = com.tencent.mm.plugin.appbrand.dynamic.h.a.adv().rR(string);
                if (rR != null) {
                    p anonymousClass1 = new p() {
                        public final void b(boolean z, String str, Bundle bundle) {
                        }
                    };
                    if (rR.iYB == null) {
                        anonymousClass1.b(false, "listener is null", null);
                        return;
                    }
                    t tVar = (t) rR.iYB.iB("OnDataPush");
                    if (tVar == null) {
                        anonymousClass1.b(false, "listener is null", null);
                    } else {
                        tVar.Y(string, string2);
                    }
                }
            }
        }
    }

    public c(Context context) {
        this.mContext = context;
        this.iVf = new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                x.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                g gVar = c.this.iUZ;
                if (i == 0 && i2 == 0) {
                    if (c.this.iUX == 1 && !c.this.iVd) {
                        c.this.iVd = true;
                        com.tencent.mm.plugin.report.service.g.pWK.h(14452, c.this.iVa + "-" + c.this.appId, Integer.valueOf(9), Long.valueOf(System.currentTimeMillis()));
                    }
                    sa saVar = (sa) bVar.hnR.hnY;
                    String cec = saVar.wgG != null ? saVar.wgG.cec() : "";
                    if (gVar != null) {
                        if (!bi.oN(cec)) {
                            gVar.field_data = cec;
                        }
                        gVar.field_interval = saVar.hZI;
                        gVar.field_updateTime = System.currentTimeMillis();
                        Bundle bundle = (Bundle) f.a("com.tencent.mm", gVar.vP(), b.class);
                        if (bundle != null) {
                            bundle.getBoolean("result", false);
                        }
                        if (c.this.Vx) {
                            c.a(c.this.gQx, gVar);
                            if (c.this.iUX == 1 && !c.this.iVe) {
                                c.this.iVe = true;
                                com.tencent.mm.plugin.report.service.g.pWK.h(14452, c.this.iVa + "-" + c.this.appId, Integer.valueOf(11), Long.valueOf(System.currentTimeMillis()));
                            }
                            if (gVar.field_interval > 0) {
                                c.this.acU();
                                return;
                            }
                            return;
                        }
                        x.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
                        return;
                    }
                    return;
                }
                com.tencent.mm.plugin.report.service.g.pWK.a(638, 0, 1, false);
                if (c.this.iUX == 1 && !c.this.iVd) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14452, c.this.iVa + "-" + c.this.appId, Integer.valueOf(10), Long.valueOf(System.currentTimeMillis()));
                }
                b.d(c.this.iVg, (gVar != null ? (long) gVar.field_interval : 10) * 1000);
            }
        };
        this.iVg = new Runnable() {
            public final void run() {
                c.this.acU();
            }
        };
    }

    public final boolean bb(String str, String str2) {
        if (this.gQx == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        com.tencent.mm.t.c.f fVar = this.gQx.gQC;
        com.tencent.mm.t.b.e fu = fVar.gQG.fu(str);
        if (fu == null) {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", str);
            return false;
        } else if (fVar.gQs.go(fu.getIndex())) {
            if (bi.oN(str2)) {
                str2 = "{}";
            }
            x.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(0));
            fVar.gQD.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{str, str2, "undefined", com.tencent.mm.t.c.f.Cj()}), null);
            return true;
        } else {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", str);
            return false;
        }
    }

    void cleanup() {
        if (this.iUZ != null) {
            x.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s, %s)", this.iUZ.field_id, this.iUZ.field_appId, this.iUZ.field_cacheKey);
        } else {
            x.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
        }
        if (this.gQx != null) {
            e eVar = this.gQx;
            x.v("MicroMsg.MiniJsBridge", "onStop(%s)", eVar.gQA);
            eVar.Vx = false;
            eVar.gQD.cleanup();
            com.tencent.mm.t.c.c cVar = eVar.gQB;
            cVar.gQu.quit();
            cVar.gQr.gQy.recycle();
            if (eVar.gQF != null) {
                eVar.gQF.B(eVar.gQA, 4);
                eVar.gQF = null;
            }
        }
    }

    final void acU() {
        g gVar = this.iUZ;
        if (gVar != null && this.Vx) {
            if (this.iVb) {
                this.iVc = true;
            } else if (bi.oN(gVar.field_appId)) {
                x.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", this.gQA);
            } else {
                this.iVc = false;
                long currentTimeMillis = (gVar.field_updateTime + (((long) gVar.field_interval) * 1000)) - System.currentTimeMillis();
                if (currentTimeMillis > 0) {
                    x.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", Long.valueOf(currentTimeMillis));
                    b.d(this.iVg, currentTimeMillis);
                    return;
                }
                x.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s, %s)", this.iUZ.field_id, this.iUZ.field_appId, this.iUZ.field_cacheKey);
                com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                aVar.hnS = 1193;
                aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
                com.tencent.mm.bp.a rzVar = new rz();
                rzVar.fGh = gVar.field_appId;
                rzVar.aAM = gVar.field_cacheKey;
                rzVar.scene = this.iUX;
                rzVar.fEe = this.iUY;
                rzVar.url = this.mUrl;
                aVar.hnT = rzVar;
                aVar.hnU = new sa();
                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.Kf(), this.iVf);
            }
        }
    }

    static void a(e eVar, g gVar) {
        boolean z = false;
        if (eVar == null || gVar == null || bi.oN(gVar.field_data)) {
            boolean z2;
            String str = "MicroMsg.DynamicPageViewIPCProxy";
            String str2 = "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null";
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (gVar == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            return;
        }
        com.tencent.mm.t.b.c cVar = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
        cVar.data = gVar.field_data;
        eVar.a(cVar);
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", gVar.field_id);
        bundle.putString("respData", gVar.field_data);
        f.a("com.tencent.mm:tools", bundle, a.class, null);
    }

    public final void o(Bundle bundle) {
        if (bundle != null) {
            u.b bVar = this.gQx.gQB.gQr.gQy;
            for (String str : bundle.keySet()) {
                bVar.o(str, bundle.get(str));
            }
        }
    }

    public final void onPause() {
        x.i("MicroMsg.DynamicPageViewIPCProxy", "onPause(%s)", this.gQA);
        this.iVb = true;
        if (this.gQx != null) {
            this.gQx.b(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
        }
    }

    public final void onResume() {
        x.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", this.gQA);
        boolean z = this.iVb;
        if (this.gQx != null) {
            this.gQx.c(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
        }
        this.iVb = false;
        if (z && this.iVc) {
            acU();
        }
    }

    public final boolean isPaused() {
        return this.iVb;
    }
}
