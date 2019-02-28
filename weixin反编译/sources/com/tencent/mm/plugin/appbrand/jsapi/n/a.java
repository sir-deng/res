package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.n.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.n.c.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.n;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.o;
import org.json.JSONObject;

public final class a extends FrameLayout implements c {
    public MMWebView jAa;
    private MMFalseProgressBar jAb;
    private final b jAc;
    private String jAd = "";
    private boolean jAe = true;
    boolean jAf = false;
    private o jAg = new o() {
        public final boolean z(MotionEvent motionEvent) {
            return a.this.jAa.O(motionEvent);
        }

        public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return a.this.jAa.b(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void aik() {
            a.this.jAa.czP();
        }

        @TargetApi(9)
        public final void b(int i, int i2, boolean z, boolean z2) {
            a.this.jAa.c(i, i2, z, z2);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            a.this.jAa.y(i, i2, i3, i4);
        }

        public final boolean A(MotionEvent motionEvent) {
            return a.this.jAa.P(motionEvent);
        }

        public final boolean B(MotionEvent motionEvent) {
            return a.this.jAa.Q(motionEvent);
        }
    };
    private com.tencent.xweb.x5.a.a.a.a.b jAh = new com.tencent.xweb.x5.a.a.a.a.b() {
        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return a.this.jAg.z(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return a.this.jAg.B(motionEvent);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return a.this.jAg.A(motionEvent);
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            return a.this.jAg.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            a.this.jAg.onScrollChanged(i, i2, i3, i4, view);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            a.this.jAg.b(i, i2, z, z2);
        }

        public final void computeScroll(View view) {
            a.this.jAg.aik();
        }
    };
    p jfF;
    private b jzZ;
    private String mAppId;

    public a(Context context, e eVar, p pVar) {
        super(context);
        this.mAppId = eVar.mAppId;
        this.jzZ = new b();
        this.jzZ.a(pVar);
        this.jfF = pVar;
        this.jAa = com.tencent.mm.plugin.webview.ui.tools.widget.c.a.tQy.co(context);
        this.jAa.getSettings().cJp();
        this.jAa.getSettings().setJavaScriptEnabled(true);
        this.jAa.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.jAa.getSettings().cJr();
        this.jAa.getSettings().setUserAgentString(s.aL(getContext(), this.jAa.getSettings().getUserAgentString()) + " miniProgram");
        this.jAa.getView().setHorizontalScrollBarEnabled(false);
        this.jAa.getView().setVerticalScrollBarEnabled(false);
        this.jAa.getSettings().setBuiltInZoomControls(true);
        this.jAa.getSettings().setUseWideViewPort(true);
        this.jAa.getSettings().setLoadWithOverviewMode(true);
        this.jAa.getSettings().cJk();
        this.jAa.getSettings().cJj();
        this.jAa.getSettings().setGeolocationEnabled(true);
        this.jAa.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.jAa.getSettings().cJn();
        this.jAa.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        this.jAa.getSettings().cJm();
        this.jAa.getSettings().cJo();
        this.jAa.getSettings().setDatabasePath(com.tencent.mm.loader.stub.a.hbu + "databases/");
        this.jAa.zEL = pVar.jJx;
        this.jAa.czO();
        this.jAa.setWebViewCallbackClient(this.jAg);
        if (this.jAa.isX5Kernel) {
            this.jAa.setWebViewClientExtension(this.jAh);
        }
        addView(this.jAa, new LayoutParams(-1, -1));
        this.jAb = new MMFalseProgressBar(context);
        this.jAb.setProgressDrawable(com.tencent.mm.bu.a.b(context, f.ivG));
        addView(this.jAb, new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(context, 3)));
        this.jAc = ((com.tencent.mm.plugin.appbrand.jsapi.n.c.a) g.h(com.tencent.mm.plugin.appbrand.jsapi.n.c.a.class)).a(this);
        this.jfF.a(new p.e() {
            public final void onDestroy() {
                a.this.jAc.cleanup();
            }
        });
        aii().jOI = true;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final MMWebView aie() {
        return this.jAa;
    }

    public final void runOnUiThread(Runnable runnable) {
        post(runnable);
    }

    public final void u(JSONObject jSONObject) {
        this.jzZ.mData = jSONObject.toString();
        this.jzZ.afI();
    }

    public final void tv(String str) {
        this.jfF.sn(str);
    }

    public final void aif() {
        aih();
        this.jAb.start();
    }

    public final void tw(String str) {
        aih();
        this.jAb.finish();
        if (!(this.jAe || this.jAf)) {
            n aii = aii();
            p pVar = this.jfF;
            String str2 = this.jAd;
            aii.jNN = (String) aii.jOG.peekFirst();
            aii.jNO = 2;
            aii.jNP = str;
            aii.jOG.push(str2);
            aii.k(pVar);
        }
        this.jAe = false;
        this.jAf = false;
        this.jAd = str;
        if (!bi.oN(str)) {
            if (!bi.oN(Uri.parse(str).getHost())) {
                this.jfF.uo(getContext().getString(j.eXn, new Object[]{r0}));
                return;
            }
        }
        this.jfF.uo("");
    }

    public final void aig() {
        this.jfF.iuk.isX.ajx();
    }

    private void aih() {
        this.jAa.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    }

    final n aii() {
        return this.jfF.iuk.isX.jIP.jNb;
    }

    public final String[] aij() {
        p pVar = this.jfF;
        e eVar = pVar.iuk;
        AppBrandStatObject appBrandStatObject = eVar.itc;
        h e = h.e(eVar);
        a ajG = pVar.ajG();
        String[] strArr = new String[19];
        strArr[0] = appBrandStatObject.scene;
        strArr[1] = appBrandStatObject.foi;
        strArr[2] = eVar.mAppId;
        strArr[3] = eVar.isS.iRU.iJb;
        strArr[4] = e.iub;
        strArr[5] = (eVar.isS.iRU.iJa + 1);
        strArr[6] = appBrandStatObject.jMN;
        strArr[7] = pVar.getURL();
        strArr[8] = ajG == null ? "" : ajG.jAa.getUrl();
        strArr[9] = com.tencent.mm.plugin.appbrand.report.a.cf(pVar.mContext);
        strArr[10] = "";
        strArr[11] = "";
        strArr[12] = "";
        strArr[13] = "";
        strArr[14] = "";
        strArr[15] = "";
        strArr[16] = appBrandStatObject.fJn;
        strArr[17] = appBrandStatObject.fJo;
        strArr[18] = (eVar.isR.foo + 1000);
        return strArr;
    }
}
