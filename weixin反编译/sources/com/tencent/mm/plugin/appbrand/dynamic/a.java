package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.protocal.c.bzf;
import com.tencent.mm.protocal.c.bzg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    public String gQA;
    public String iUJ;
    h iUK;

    private static class f implements j<Bundle, IPCBoolean> {
        private f() {
        }

        public final /* synthetic */ Object at(Object obj) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            String string2 = bundle.getString("event");
            String string3 = bundle.getString(SlookAirButtonFrequentContactAdapter.DATA);
            c rI = d.acV().rI(string);
            if (rI != null) {
                return new IPCBoolean(rI.bb(string2, string3));
            }
            x.e("MicroMsg.IPCInvoke_PublishJsEvent", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
            return new IPCBoolean(false);
        }
    }

    private static class d implements com.tencent.mm.ipcinvoker.a {
        private d() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            final c rI = d.acV().rI(bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
            if (rI == null) {
                x.e("MicroMsg.IPCInvoke_OnPause", "get DynamicPageViewIPCProxy(id : %s) return null.", r0);
                return;
            }
            b.n(new Runnable() {
                public final void run() {
                    rI.onPause();
                }
            });
        }
    }

    private static class e implements com.tencent.mm.ipcinvoker.a {
        private e() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            final c rI = d.acV().rI(bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
            if (rI == null) {
                x.e("MicroMsg.IPCInvoke_OnResume", "get DynamicPageViewIPCProxy(id : %s) return null.", r0);
                return;
            }
            b.n(new Runnable() {
                public final void run() {
                    rI.onResume();
                }
            });
        }
    }

    private static class g implements com.tencent.mm.ipcinvoker.a {
        private g() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            Bundle bundle2 = bundle.getBundle("__env_args");
            if (bundle2 == null) {
                x.i("MicroMsg.IPCInvoke_UpdateEnvArgs", "envArgs is null.");
                return;
            }
            c rI = d.acV().rI(string);
            if (rI == null) {
                x.e("MicroMsg.IPCInvoke_UpdateEnvArgs", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                return;
            }
            rI.o(bundle2);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$2 */
    class AnonymousClass2 implements com.tencent.mm.ipcinvoker.c {
        final /* synthetic */ String uR;

        public AnonymousClass2(String str) {
            this.uR = str;
        }

        public final void i(Bundle bundle) {
            i.rL(this.uR);
        }
    }

    private static class b implements com.tencent.mm.ipcinvoker.a {
        private b() {
        }

        public final void a(Bundle bundle, final com.tencent.mm.ipcinvoker.c cVar) {
            c cVar2 = null;
            final String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            d acV = d.acV();
            if (bi.oN(string)) {
                x.w("MicroMsg.DynamicPageViewIPCProxyManager", "remove IPCProxy from manager failed, key is null or nil.");
            } else {
                c cVar3 = (c) acV.iVk.remove(string);
                String str = "MicroMsg.DynamicPageViewIPCProxyManager";
                String str2 = "remove IPCProxy success.(key : %s, ref : %s)";
                Object[] objArr = new Object[2];
                objArr[0] = string;
                objArr[1] = cVar3 != null ? Integer.valueOf(cVar3.hashCode()) : null;
                x.d(str, str2, objArr);
                if (cVar3 != null) {
                    cVar2 = cVar3;
                }
            }
            if (cVar2 == null) {
                x.e("MicroMsg.IPCInvoke_Detach", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
            } else {
                b.n(new Runnable() {
                    public final void run() {
                        c cVar = cVar2;
                        x.i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", cVar.gQA);
                        cVar.Vx = false;
                        cVar.cleanup();
                        cVar.gQx = null;
                        cVar.iUZ = null;
                        cVar.gQA = null;
                        cVar.iNG = null;
                        i.rL(string);
                        cVar.i(null);
                        f acX = f.acX();
                        String str = string;
                        if (acX.iVo.containsKey(str)) {
                            com.tencent.mm.plugin.appbrand.dynamic.f.b bVar = (com.tencent.mm.plugin.appbrand.dynamic.f.b) acX.iVo.get(str);
                            x.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", bVar.iVs.toString());
                            if (bVar.iVs.size() > 0) {
                                com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                                aVar.hnS = 2653;
                                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
                                com.tencent.mm.bp.a bzf = new bzf();
                                bzf.fGh = bVar.appId;
                                bzf.id = bVar.hqv;
                                bzf.xgl = bVar.iVs;
                                aVar.hnT = bzf;
                                aVar.hnU = new bzg();
                                com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.Kf(), acX.iVp);
                                return;
                            }
                            return;
                        }
                        x.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", str);
                    }
                });
            }
        }
    }

    private static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            final String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            final String string2 = bundle.getString("appId");
            final Bundle bundle2 = bundle.getBundle("extData");
            final c rI = d.acV().rI(string);
            if (rI == null) {
                x.e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                return;
            }
            b.n(new Runnable() {
                public final void run() {
                    long j;
                    c cVar = rI;
                    String str = string;
                    String str2 = string2;
                    Bundle bundle = bundle2;
                    Assert.assertNotNull(str);
                    if (!(str.equals(cVar.gQA) || cVar.gQx == null)) {
                        cVar.cleanup();
                        cVar.Vx = false;
                        cVar.gQx = null;
                    }
                    cVar.gQA = str;
                    cVar.appId = str2;
                    String str3 = "";
                    long j2 = 0;
                    if (bundle != null) {
                        String string = bundle.getString("cache_key", "");
                        cVar.iUY = bundle.getString("query");
                        cVar.mUrl = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        cVar.iUX = bundle.getInt("widget_type");
                        cVar.iVa = bundle.getString("search_id");
                        cVar.iNG = bundle.getString("__session_id");
                        j = bundle.getLong("__on_bind_nano_time");
                        if (!bi.oN(cVar.iNG)) {
                            com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
                        }
                        long j3 = j;
                        str3 = string;
                        j2 = j3;
                    }
                    x.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s, %s)", str, str2, str3);
                    Object obj = 1;
                    cVar.iUZ = com.tencent.mm.plugin.appbrand.dynamic.j.b.rY(str);
                    if (cVar.iUZ == null) {
                        cVar.iUZ = new com.tencent.mm.plugin.appbrand.widget.g();
                        obj = null;
                    }
                    Object obj2 = cVar.iUX == 1 ? null : obj;
                    cVar.iUZ.field_id = str;
                    cVar.iUZ.field_cacheKey = str3;
                    cVar.iUZ.field_appId = str2;
                    if (cVar.gQx == null) {
                        com.tencent.mm.t.c.e eVar;
                        com.tencent.mm.plugin.appbrand.collector.c.aU(cVar.iNG, "before_init_js_engine");
                        Context context = cVar.mContext;
                        String str4 = cVar.gQA;
                        WxaWidgetContext rK = i.rK(str4);
                        if (rK == null || bundle == null) {
                            x.w("MicroMsg.WxaWidgetInitializer", "FwContext is null(id : %s)", str4);
                            eVar = null;
                        } else {
                            x.i("MicroMsg.WxaWidgetInitializer", "initJsBridge(%s)", str4);
                            eVar = com.tencent.mm.plugin.appbrand.dynamic.h.e.a(context, rK, new com.tencent.mm.plugin.appbrand.dynamic.d.b.a(str4, rK.adc()), bundle);
                        }
                        cVar.gQx = eVar;
                        com.tencent.mm.plugin.appbrand.collector.c.aU(cVar.iNG, "after_init_js_engine");
                        cVar.gQx.gQA = cVar.gQA;
                        if (bundle != null) {
                            cVar.o(bundle.getBundle("__env_args"));
                        }
                        cVar.gQx.onStart();
                        if (cVar.iVb) {
                            cVar.gQx.b(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
                        } else {
                            cVar.gQx.c(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
                        }
                        com.tencent.mm.t.c.e eVar2 = cVar.gQx;
                        str4 = "";
                        str3 = "";
                        String str5 = "";
                        Map map = null;
                        int i = 0;
                        int i2 = 0;
                        if (bundle != null) {
                            i = bundle.getInt("view_init_width");
                            i2 = bundle.getInt("view_init_height");
                            str4 = bundle.getString("cache_key", "");
                            str3 = bundle.getString("msg_title", "");
                            String string2 = bundle.getString("msg_path", "");
                            str5 = l.vh(string2);
                            map = l.vi(string2);
                        }
                        com.tencent.mm.t.b.c bVar = new com.tencent.mm.plugin.appbrand.dynamic.f.b();
                        bVar.iXq = str4;
                        bVar.title = str3;
                        bVar.path = str5;
                        bVar.iXp = map;
                        bVar.iXr = i;
                        bVar.iXs = i2;
                        eVar2.a(bVar);
                        if (j2 > 0) {
                            j = (System.nanoTime() - j2) / 1000000;
                            int i3 = 7;
                            if (j <= 50) {
                                i3 = 0;
                            } else if (j <= 100) {
                                i3 = 1;
                            } else if (j <= 200) {
                                i3 = 2;
                            } else if (j <= 300) {
                                i3 = 3;
                            } else if (j <= 400) {
                                i3 = 4;
                            } else if (j <= 500) {
                                i3 = 5;
                            } else if (j <= 600) {
                                i3 = 6;
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.a(677, (long) i3, 1, false);
                        }
                        com.tencent.mm.plugin.appbrand.collector.c.aU(cVar.iNG, "init_finish");
                        com.tencent.mm.plugin.appbrand.collector.c.print(cVar.iNG);
                    } else {
                        com.tencent.mm.plugin.appbrand.collector.c.qI(cVar.iNG);
                        if (bundle != null) {
                            cVar.o(bundle.getBundle("__env_args"));
                        }
                        cVar.gQx.onStart();
                        if (cVar.iVb) {
                            cVar.gQx.b(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
                        } else {
                            cVar.gQx.c(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
                        }
                    }
                    cVar.Vx = true;
                    if (obj2 != null) {
                        c.a(cVar.gQx, cVar.iUZ);
                    }
                    cVar.acU();
                }
            });
        }
    }

    private static class c implements com.tencent.mm.ipcinvoker.a {
        private c() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            String string2 = bundle.getString("appId");
            int i = bundle.getInt("wxaPkgType");
            int i2 = bundle.getInt("pkgVersion");
            int i3 = bundle.getInt("scene");
            String string3 = bundle.getString("searchId");
            int i4 = bundle.getInt("widgetType");
            int i5 = bundle.getInt("serviceType");
            String string4 = bundle.getString("preloadLaunchData", "");
            if (d.acV().rI(string) == null) {
                c cVar2 = new c(ad.getContext());
                d acV = d.acV();
                if (bi.oN(string)) {
                    x.w("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy into manager failed, key is null or nil.");
                } else {
                    if (((c) acV.iVk.put(string, cVar2)) != null) {
                        x.i("MicroMsg.DynamicPageViewIPCProxyManager", "add a new IPCProxy and remove old one with key : %s.", string);
                    }
                    x.d("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy success.(%s)", string);
                }
            }
            f acX = f.acX();
            if (acX.iVo.containsKey(string)) {
                x.w("MicroMsg.DynamicPageViewStateMonitor", "OnAttach with same widgetId[%s]", string);
                acX.iVo.remove(string);
            }
            acX.iVo.put(string, new com.tencent.mm.plugin.appbrand.dynamic.f.b(string, string2, i5));
            final com.tencent.mm.ipcinvoker.c cVar3 = cVar;
            b.m(new com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.AnonymousClass1(string, com.tencent.mm.plugin.appbrand.dynamic.k.a.bD(i4, i), i2, string2, i4, i3, string4, new com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.a() {
                public final void ba(String str, String str2) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("op", 0);
                    bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
                    bundle.putString("appId", str2);
                    cVar3.i(bundle);
                }

                public final void a(String str, String str2, boolean z, WxaWidgetContext wxaWidgetContext) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("op", 1);
                    bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
                    bundle.putString("appId", str2);
                    bundle.putBoolean("success", z);
                    if (wxaWidgetContext != null) {
                        bundle.putParcelable("fwContext", wxaWidgetContext);
                        i.a(str, wxaWidgetContext);
                    }
                    cVar3.i(bundle);
                }
            }, string3));
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$1 */
    class AnonymousClass1 implements com.tencent.mm.ipcinvoker.c {
        final /* synthetic */ String fhk;
        final /* synthetic */ String iUL;
        final /* synthetic */ Bundle iUM;
        final /* synthetic */ String uR;

        public AnonymousClass1(String str, String str2, String str3, Bundle bundle) {
            this.iUL = str;
            this.uR = str2;
            this.fhk = str3;
            this.iUM = bundle;
        }

        public final void i(Bundle bundle) {
            if (this.iUL.equals(a.this.iUJ)) {
                int i = bundle.getInt("op");
                if (i == 0) {
                    a.this.iUK.cleanup();
                } else if (i == 1) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(635, 0, 1, false);
                    WxaWidgetContext wxaWidgetContext = (WxaWidgetContext) bundle.getParcelable("fwContext");
                    if (!bundle.getBoolean("success", false) || wxaWidgetContext == null) {
                        x.i("MicroMsg.DynamicIPCJsBridge", "init widget running context(%s) failed", this.uR);
                        a.this.iUK.jW(1);
                        com.tencent.mm.plugin.report.service.g.pWK.a(635, 2, 1, false);
                    } else if (wxaWidgetContext.ade() != 1) {
                        x.i("MicroMsg.DynamicIPCJsBridge", "abort init widget running context(%s), server banned", this.uR);
                        a.this.iUK.jW(2);
                        com.tencent.mm.plugin.report.service.g.pWK.a(635, 2, 1, false);
                    } else {
                        i.a(this.uR, wxaWidgetContext);
                        a.this.iUK.d(this.uR, this.fhk, this.iUM);
                        com.tencent.mm.plugin.report.service.g.pWK.a(635, 1, 1, false);
                    }
                }
            }
        }
    }

    public a(h hVar) {
        this.iUK = hVar;
    }
}
