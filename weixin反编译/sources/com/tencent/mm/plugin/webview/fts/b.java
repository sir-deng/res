package com.tencent.mm.plugin.webview.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bb.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass31;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass39;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass40;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass43;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static l tsd = new l();
    private Context context;
    private MMWebView pzt;
    public HashMap<String, Object> trV = new HashMap();
    private HashMap<String, Object> trW = new HashMap();
    private HashMap<String, Object> trX = new HashMap();
    private int trY = -1;
    public e trZ;
    public d tsa;
    private Map<String, c> tsb = new HashMap();
    private Map<String, b> tsc = new HashMap();

    private class c {
        int tso;
        int tsp;

        private c() {
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        public final String toString() {
            return String.format("minH %d, maxH %d", new Object[]{Integer.valueOf(this.tso), Integer.valueOf(this.tsp)});
        }
    }

    private static class a implements com.tencent.mm.ipcinvoker.l {
        private a() {
        }

        public final Bundle j(Bundle bundle) {
            int i;
            com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100266");
            if (fp.isValid()) {
                i = t.getInt((String) fp.civ().get("search_wa_widget_init_out_time"), 8000);
            } else {
                i = 8000;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("search_wa_widget_init_out_time", i);
            return bundle2;
        }
    }

    private class b {
        String fGh;
        int fwH;
        int iJb;
        String iVr;

        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final String toString() {
            return String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[]{this.fGh, this.iVr, Integer.valueOf(this.fwH), Integer.valueOf(this.iJb)});
        }
    }

    static /* synthetic */ void a(b bVar, String str, int i, p pVar) {
        x.i("FTSSearchWidgetMgr", "onSetWidgetSize widgetId %s, height %d", str, Integer.valueOf(i));
        c cVar = (c) bVar.tsb.get(str);
        Bundle bundle = new Bundle();
        if (cVar != null && (i > cVar.tsp || i < cVar.tso)) {
            x.w("FTSSearchWidgetMgr", "invalid widget size, should in range %s", cVar.toString());
            if (pVar != null) {
                bundle.putInt("errCode", -2);
                pVar.b(false, "invalid widget size, should in range " + cVar.toString(), bundle);
            }
        } else if (bVar.tsa != null) {
            d dVar = bVar.tsa;
            if (dVar.tNo) {
                x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
                Map hashMap = new HashMap();
                hashMap.put("widgetId", str);
                hashMap.put("height", Integer.valueOf(i));
                ah.y(new AnonymousClass31(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchWAWidgetAttrChanged", hashMap, dVar.tNq, dVar.tNr)));
            } else {
                x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
            }
            if (pVar != null) {
                bundle.putInt("errCode", 0);
                pVar.b(true, "", bundle);
            }
        } else if (pVar != null) {
            bundle.putInt("errCode", -1);
            pVar.b(false, "jsapi is null", bundle);
        }
    }

    public static l bPS() {
        return tsd;
    }

    public b(Context context, MMWebView mMWebView) {
        this.context = context;
        this.pzt = mMWebView;
        this.trZ = (e) g.h(e.class);
    }

    public final void L(Bundle bundle) {
        b bVar = (b) this.tsc.get((String) bundle.get("widgetId"));
        if (bVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("app_id", bVar.fGh);
            bundle2.putString("msg_id", bVar.iVr);
            bundle2.putInt("pkg_type", bVar.fwH);
            bundle2.putInt("pkg_version", bVar.iJb);
            ((e) g.h(e.class)).Jd().b(this.context, bundle2);
        }
    }

    public final void a(Bundle bundle, int i) {
        String string = bundle.getString("fts_key_json_data");
        final String string2 = bundle.getString("fts_key_widget_view_cache_key");
        final String bj = k.bj(this);
        x.i("FTSSearchWidgetMgr", "inserting widget: widgetId %s, sessionId %s, jsonData %s ", string2, bj, string);
        if (string == null || string.length() == 0) {
            x.i("FTSSearchWidgetMgr", "insert args invalid");
            return;
        }
        try {
            b bVar;
            b bVar2;
            final String optString;
            String optString2;
            String optString3;
            String optString4;
            int i2;
            int i3;
            final View be;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            final View view;
            LayoutParams layoutParams;
            FrameLayout frameLayout;
            final ThreeDotsLoadingView threeDotsLoadingView;
            final ImageView imageView;
            String optString5;
            String str;
            Bundle bundle2;
            int optInt;
            Bundle bundle3;
            q rVar;
            final ThreeDotsLoadingView threeDotsLoadingView2;
            final String str2;
            ViewGroup topView;
            b bVar3 = (b) this.tsc.get(string2);
            if (bVar3 == null) {
                bVar = this;
                bVar3 = new b();
                this.tsc.put(string2, bVar3);
                bVar2 = bVar3;
            } else {
                bVar2 = bVar3;
            }
            final JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("maxHeight")) {
                if (jSONObject.has("minHeight")) {
                    c cVar = (c) this.tsb.get(string2);
                    if (cVar == null) {
                        bVar = this;
                        cVar = new c();
                        this.tsb.put(string2, cVar);
                    }
                    cVar.tso = jSONObject.optInt("minHeight");
                    cVar.tsp = jSONObject.optInt("maxHeight");
                    x.i("FTSSearchWidgetMgr", "update widgetSize %s", cVar.toString());
                    optString = jSONObject.optString("appid");
                    optString2 = jSONObject.optString("pagePath");
                    optString3 = jSONObject.optString("searchId");
                    l.ma(optString);
                    if (optString2.contains("widgetData")) {
                        l.Rn();
                    }
                    optString4 = jSONObject.optString("nickName");
                    i2 = jSONObject.getInt("version");
                    if (jSONObject.has("debugMode")) {
                        i3 = 0;
                    } else {
                        i3 = jSONObject.optInt("debugMode");
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.h(14452, jSONObject.optString("searchId") + "-" + optString, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()));
                    be = this.trZ.be(this.context);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr = new Object[3];
                    objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(System.currentTimeMillis());
                    gVar.h(14452, objArr);
                    view = (AbsoluteLayout) v.fw(this.context).inflate(R.i.dju, null);
                    view.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("offsetX")), com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("offsetY"))));
                    layoutParams = new AbsoluteLayout.LayoutParams(com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("width")), com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("height")), 0, 0);
                    be.setLayoutParams(layoutParams);
                    view.addView(be);
                    frameLayout = (FrameLayout) view.findViewById(R.h.ctJ);
                    frameLayout.setLayoutParams(layoutParams);
                    view.removeView(frameLayout);
                    view.addView(frameLayout);
                    try {
                        be.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                    } catch (Exception e) {
                        x.e("FTSSearchWidgetMgr", "the color is error : ");
                    }
                    be.setTag(bj);
                    this.trV.put(string2, be);
                    this.trW.put(string2, view);
                    this.trX.put(string2, frameLayout);
                    threeDotsLoadingView = (ThreeDotsLoadingView) view.findViewById(R.h.ctI);
                    imageView = (ImageView) view.findViewById(R.h.bZu);
                    optString5 = jSONObject.optString("wxaData");
                    str = optString + "_" + optString5.hashCode();
                    bundle2 = new Bundle();
                    bundle2.putString("app_id", optString);
                    bundle2.putString("msg_id", str);
                    bundle2.putString("search_id", optString3);
                    bundle2.putString("cache_key", optString5);
                    bundle2.putString("msg_title", optString4);
                    bundle2.putString("msg_path", optString2);
                    bundle2.putInt("pkg_version", i2);
                    bundle2.putInt("msg_pkg_type", i3);
                    optString2 = jSONObject.optString("inputData");
                    bundle2.putString("init_data", optString2);
                    bundle2.putInt("widget_type", 1);
                    optInt = jSONObject.optInt("serviceType");
                    bundle2.putInt("service_type", optInt);
                    bundle2.putInt("scene", com.tencent.mm.bb.b.io(i));
                    jSONObject = jSONObject;
                    bundle3 = bundle2;
                    bundle3.putInt("view_init_width", com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                    jSONObject = jSONObject;
                    bundle3 = bundle2;
                    bundle3.putInt("view_init_height", com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                    optString2 = jSONObject.optString("wxaData");
                    bundle2.putString("query", optString2);
                    optString2 = jSONObject.optString("launchwxawidget");
                    bundle2.putString("preload_launch_data", optString2);
                    threeDotsLoadingView.setVisibility(0);
                    imageView.setVisibility(4);
                    threeDotsLoadingView.czW();
                    bVar2.fGh = optString;
                    bVar2.fwH = i3;
                    bVar2.iJb = i2;
                    bVar2.iVr = str;
                    x.i("FTSSearchWidgetMgr", "inserting widget %s", bVar2.toString());
                    rVar = new r(new f() {
                        public final void q(View view, int i) {
                            x.i("FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", bj, Integer.valueOf(i));
                            b.this.trY = i;
                            switch (i) {
                                case 0:
                                    threeDotsLoadingView.setVisibility(0);
                                    imageView.setVisibility(4);
                                    b.this.tsa.cM(string2, 1);
                                    return;
                                case 1:
                                    threeDotsLoadingView.ajR();
                                    threeDotsLoadingView.setVisibility(4);
                                    b.this.tsa.cM(string2, 3);
                                    b.bPS();
                                    l.E(optString, false);
                                    return;
                                case 4:
                                    threeDotsLoadingView.setVisibility(4);
                                    imageView.setVisibility(4);
                                    threeDotsLoadingView.ajR();
                                    b.bPS();
                                    l.E(optString, true);
                                    b.this.tsa.cM(string2, 2);
                                    return;
                                default:
                                    b.bPS();
                                    l.E(optString, false);
                                    threeDotsLoadingView.ajR();
                                    threeDotsLoadingView.setVisibility(4);
                                    if (i == 2) {
                                        b.this.tsa.cM(string2, 4);
                                        return;
                                    } else {
                                        b.this.tsa.cM(string2, 3);
                                        return;
                                    }
                            }
                        }
                    });
                    rVar.a(new com.tencent.mm.modelappbrand.x() {
                        public final void a(int i, p pVar) {
                            b.a(b.this, string2, i, pVar);
                        }
                    });
                    rVar.a(new u() {
                        public final void b(boolean z, String str, boolean z2) {
                            x.v("FTSSearchWidgetMgr", "on widget call %s ", "onSearchWAWidgetOnTapCallback");
                            x.i("FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", "onSearchWAWidgetOnTapCallback", Boolean.valueOf(z), str, Boolean.valueOf(z2));
                            d a = b.this.tsa;
                            if (!z) {
                                z2 = false;
                            }
                            a.a(str, z2, "", string2);
                        }
                    });
                    rVar.a(new com.tencent.mm.modelappbrand.v() {
                        public final void iD(String str) {
                            x.v("FTSSearchWidgetMgr", "on widget call %s ", "onOpenApp");
                            d a = b.this.tsa;
                            String str2 = string2;
                            if (a.tNo) {
                                x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("widgetId", str2);
                                hashMap.put("path", str);
                                ah.y(new AnonymousClass39(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchWAWidgetOpenApp", hashMap, a.tNq, a.tNr)));
                                return;
                            }
                            x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, not ready");
                        }
                    });
                    rVar.a(new s() {
                        public final void iC(String str) {
                            x.v("FTSSearchWidgetMgr", "on widget call %s ", "onMakePhoneCall");
                            if (TextUtils.isEmpty(str)) {
                                x.e("FTSSearchWidgetMgr", "onMakePhone null number");
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            if (bi.k(b.this.context, intent)) {
                                b.this.context.startActivity(intent);
                            }
                        }
                    });
                    rVar.a(new w() {
                        public final void iE(String str) {
                            String str2;
                            x.v("FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", str);
                            String str3 = "";
                            for (Entry entry : b.this.trV.entrySet()) {
                                b bVar = (b) b.this.tsc.get(entry.getKey());
                                if ((bVar.fGh + "#" + bVar.iVr).equals(str)) {
                                    str2 = (String) entry.getKey();
                                    break;
                                }
                            }
                            str2 = str3;
                            if (bi.oN(str2)) {
                                x.e("FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                                return;
                            }
                            d a = b.this.tsa;
                            if (a.tNo) {
                                x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("widgetId", str2);
                                ah.y(new AnonymousClass40(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchWAWidgetReloadData", hashMap, a.tNq, a.tNr)));
                                return;
                            }
                            x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
                        }
                    });
                    rVar.a(new com.tencent.mm.modelappbrand.t() {
                        public final void Y(String str, String str2) {
                            String str3;
                            x.v("FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", str, str2);
                            String str4 = "";
                            for (Entry entry : b.this.trV.entrySet()) {
                                b bVar = (b) b.this.tsc.get(entry.getKey());
                                if ((bVar.fGh + "#" + bVar.iVr).equals(str)) {
                                    str3 = (String) entry.getKey();
                                    break;
                                }
                            }
                            str3 = str4;
                            if (bi.oN(str3)) {
                                x.e("FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                                return;
                            }
                            d a = b.this.tsa;
                            if (a.tNo) {
                                x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("widgetId", str3);
                                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str2);
                                ah.y(new AnonymousClass43(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchWAWidgetDataPush", hashMap, a.tNq, a.tNr)));
                                return;
                            }
                            x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
                        }
                    });
                    this.trZ.a(bj, be, bundle2, rVar);
                    optString3 = optString;
                    threeDotsLoadingView2 = threeDotsLoadingView;
                    str2 = string2;
                    str = bj;
                    com.tencent.mm.by.a.post(new Runnable() {
                        public final void run() {
                            int i;
                            Bundle a = com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", new Bundle(), a.class);
                            if (a != null) {
                                i = a.getInt("search_wa_widget_init_out_time");
                            } else {
                                i = 0;
                            }
                            if (i == 0) {
                                i = 8000;
                            }
                            x.i("FTSSearchWidgetMgr", "widget loading timeout is %d ms", Integer.valueOf(i));
                            if (i > 0) {
                                ah.h(new Runnable() {
                                    public final void run() {
                                        if (b.this.trY != 4 && b.this.trY != 2 && b.this.trY != 3) {
                                            x.e("FTSSearchWidgetMgr", "widget load timeout, unbind now");
                                            b.bPS();
                                            l.E(optString3, false);
                                            threeDotsLoadingView2.ajR();
                                            threeDotsLoadingView2.setVisibility(4);
                                            b.this.tsa.cM(str2, 3);
                                            b.this.trZ.bA(be);
                                            b.this.trZ.a(str, be);
                                            view.removeView(be);
                                            com.tencent.mm.plugin.report.service.g.pWK.h(14452, jSONObject.optString("searchId") + "-" + optString3, Integer.valueOf(12), Long.valueOf(System.currentTimeMillis()));
                                            com.tencent.mm.plugin.report.service.g.pWK.a(646, 0, 1, false);
                                        }
                                    }
                                }, (long) i);
                            }
                        }
                    });
                    topView = this.pzt.getTopView();
                    if (topView == null && (topView instanceof AbsoluteLayout)) {
                        topView.addView(view);
                        return;
                    } else {
                        x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
                    }
                }
            }
            try {
                x.i("FTSSearchWidgetMgr", "removew widgetSize " + ((c) this.tsb.remove(string2)));
                optString = jSONObject.optString("appid");
                optString2 = jSONObject.optString("pagePath");
                optString3 = jSONObject.optString("searchId");
                l.ma(optString);
                if (optString2.contains("widgetData")) {
                    l.Rn();
                }
                optString4 = jSONObject.optString("nickName");
                i2 = jSONObject.getInt("version");
                if (jSONObject.has("debugMode")) {
                    i3 = jSONObject.optInt("debugMode");
                } else {
                    i3 = 0;
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(14452, jSONObject.optString("searchId") + "-" + optString, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()));
                be = this.trZ.be(this.context);
                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                objArr = new Object[3];
                objArr[0] = jSONObject.optString("searchId") + "-" + optString;
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(System.currentTimeMillis());
                gVar.h(14452, objArr);
                view = (AbsoluteLayout) v.fw(this.context).inflate(R.i.dju, null);
                view.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("offsetX")), com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("offsetY"))));
                layoutParams = new AbsoluteLayout.LayoutParams(com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("width")), com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("height")), 0, 0);
                be.setLayoutParams(layoutParams);
                view.addView(be);
                frameLayout = (FrameLayout) view.findViewById(R.h.ctJ);
                frameLayout.setLayoutParams(layoutParams);
                view.removeView(frameLayout);
                view.addView(frameLayout);
                be.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                be.setTag(bj);
                this.trV.put(string2, be);
                this.trW.put(string2, view);
                this.trX.put(string2, frameLayout);
                threeDotsLoadingView = (ThreeDotsLoadingView) view.findViewById(R.h.ctI);
                imageView = (ImageView) view.findViewById(R.h.bZu);
                optString5 = jSONObject.optString("wxaData");
                str = optString + "_" + optString5.hashCode();
                bundle2 = new Bundle();
                bundle2.putString("app_id", optString);
                bundle2.putString("msg_id", str);
                bundle2.putString("search_id", optString3);
                bundle2.putString("cache_key", optString5);
                bundle2.putString("msg_title", optString4);
                bundle2.putString("msg_path", optString2);
                bundle2.putInt("pkg_version", i2);
                bundle2.putInt("msg_pkg_type", i3);
                optString2 = jSONObject.optString("inputData");
                bundle2.putString("init_data", optString2);
                bundle2.putInt("widget_type", 1);
                optInt = jSONObject.optInt("serviceType");
                bundle2.putInt("service_type", optInt);
                bundle2.putInt("scene", com.tencent.mm.bb.b.io(i));
                jSONObject = jSONObject;
                bundle3 = bundle2;
                bundle3.putInt("view_init_width", com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("width")));
                jSONObject = jSONObject;
                bundle3 = bundle2;
                bundle3.putInt("view_init_height", com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.getInt("height")));
                optString2 = jSONObject.optString("wxaData");
                bundle2.putString("query", optString2);
                optString2 = jSONObject.optString("launchwxawidget");
                bundle2.putString("preload_launch_data", optString2);
                threeDotsLoadingView.setVisibility(0);
                imageView.setVisibility(4);
                threeDotsLoadingView.czW();
                bVar2.fGh = optString;
                bVar2.fwH = i3;
                bVar2.iJb = i2;
                bVar2.iVr = str;
                x.i("FTSSearchWidgetMgr", "inserting widget %s", bVar2.toString());
                rVar = new r(/* anonymous class already generated */);
                rVar.a(/* anonymous class already generated */);
                rVar.a(/* anonymous class already generated */);
                rVar.a(/* anonymous class already generated */);
                rVar.a(/* anonymous class already generated */);
                rVar.a(/* anonymous class already generated */);
                rVar.a(/* anonymous class already generated */);
                this.trZ.a(bj, be, bundle2, rVar);
                optString3 = optString;
                threeDotsLoadingView2 = threeDotsLoadingView;
                str2 = string2;
                str = bj;
                com.tencent.mm.by.a.post(/* anonymous class already generated */);
                topView = this.pzt.getTopView();
                if (topView == null) {
                }
                x.e("FTSSearchWidgetMgr", "webview invalid viewgroup " + topView);
            } catch (Exception e2) {
                x.e("FTSSearchWidgetMgr", "this is has a error" + e2.toString());
            }
        } catch (JSONException e3) {
            x.e("FTSSearchWidgetMgr", "parse json and init dynamicPageService is error!");
        }
    }

    public final void M(Bundle bundle) {
        OC(bundle.getString("fts_key_widget_view_cache_key"));
    }

    private void OC(String str) {
        if (str != null && str.length() > 0) {
            View view = (View) this.trV.get(str);
            if (view == null) {
                x.i("FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", str);
                return;
            }
            x.i("FTSSearchWidgetMgr", "removing widget sessionId %s", view.getTag().toString());
            if (this.trZ != null) {
                this.trZ.a((String) view.getTag(), view);
            }
            this.trV.remove(str);
            this.trX.remove(str);
            view = (View) this.trW.get(str);
            if (view != null) {
                ViewGroup topView = this.pzt.getTopView();
                if (topView != null && (topView instanceof AbsoluteLayout)) {
                    topView.removeView(view);
                }
                this.trW.remove(str);
            }
        }
    }

    public final void N(Bundle bundle) {
        String string = bundle.getString("fts_key_json_data");
        String string2 = bundle.getString("fts_key_widget_view_cache_key");
        x.i("FTSSearchWidgetMgr", "updating widget: widgetId %s, jsonData %s", string2, string);
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (string2 != null && string2.length() > 0) {
                final View view = (View) this.trV.get(string2);
                View view2 = (View) this.trW.get(string2);
                if (view != null) {
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams();
                    LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) view2.getLayoutParams();
                    if (jSONObject.has("width") || jSONObject.has("height")) {
                        final View view3 = (View) this.trX.get(string2);
                        x.i("FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", Integer.valueOf(layoutParams.height), Integer.valueOf(com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.optInt("height"))), Integer.valueOf(layoutParams.width), Integer.valueOf(com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.optInt("width"))));
                        if (!(layoutParams.height == com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.optInt("height")) && r2 == r6)) {
                            final LayoutParams layoutParams3 = view.getLayoutParams();
                            final LayoutParams layoutParams4 = view3.getLayoutParams();
                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{r3, r11});
                            ofInt.setDuration(300);
                            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
                            ofInt.addUpdateListener(new AnimatorUpdateListener() {
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    layoutParams3.height = intValue;
                                    view.setLayoutParams(layoutParams3);
                                    layoutParams4.height = intValue;
                                    view3.setLayoutParams(layoutParams4);
                                }
                            });
                            ofInt.start();
                        }
                    }
                    if (jSONObject.has("offsetX")) {
                        layoutParams2.x = com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.optInt("offsetX"));
                    }
                    if (jSONObject.has("offsetY")) {
                        layoutParams2.y = com.tencent.mm.bu.a.fromDPToPix(this.context, jSONObject.optInt("offsetY"));
                    }
                    view2.setLayoutParams(layoutParams2);
                    if (jSONObject.has("backgroundColor")) {
                        try {
                            view.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                        } catch (Throwable e) {
                            x.e("FTSSearchWidgetMgr", bi.i(e));
                        }
                    }
                    if (jSONObject.has("show")) {
                        if (jSONObject.has("show") ? jSONObject.optBoolean("show") : false) {
                            view.setVisibility(0);
                            view2.setVisibility(0);
                            return;
                        }
                        view.setVisibility(8);
                        view2.setVisibility(8);
                    }
                }
            }
        } catch (Exception e2) {
            x.e("FTSSearchWidgetMgr", "the error is e");
        }
    }

    public final void onResume() {
        if (this.trZ != null) {
            for (String str : this.trV.keySet()) {
                if (str != null && str.length() > 0) {
                    ((e) g.h(e.class)).Jc().iz((String) ((View) this.trV.get(str)).getTag());
                }
            }
        }
    }

    public final void onPause() {
        if (this.trZ != null) {
            for (String str : this.trV.keySet()) {
                if (str != null && str.length() > 0) {
                    ((e) g.h(e.class)).Jc().iy((String) ((View) this.trV.get(str)).getTag());
                }
            }
        }
    }

    public final void onDestroy() {
        try {
            if (this.trZ != null) {
                x.i("FTSSearchWidgetMgr", "remove all widget count %d", Integer.valueOf(this.trV.size()));
                for (String str : new HashMap(this.trV).keySet()) {
                    if (str != null && str.length() > 0) {
                        this.trZ.iA((String) ((View) this.trV.get(str)).getTag());
                        if (((View) this.trW.get(str)) != null) {
                            OC(str);
                            this.trW.remove(str);
                        }
                    }
                }
                this.trV.clear();
                this.trX.clear();
            }
        } catch (Throwable e) {
            x.e("FTSSearchWidgetMgr", bi.i(e));
        }
    }
}
