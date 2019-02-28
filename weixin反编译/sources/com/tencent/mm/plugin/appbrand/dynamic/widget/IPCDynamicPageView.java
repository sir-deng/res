package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.appbrand.dynamic.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

public class IPCDynamicPageView extends LinearLayout implements j, a, h {
    public static ag iUU;
    private static LayoutParams iYH = new LayoutParams(-1, -1);
    public String gQA;
    private long iNN;
    private g iUZ;
    private com.tencent.mm.plugin.appbrand.dynamic.a iYA;
    public q iYB;
    public volatile boolean iYC;
    public long iYD;
    private a iYE;
    private Runnable iYF = new Runnable() {
        public final void run() {
            int i = 1;
            if (!IPCDynamicPageView.this.iYC) {
                IPCDynamicPageView.this.iYC = true;
                IPCDynamicPageView.this.kb(4);
                long currentTimeMillis = System.currentTimeMillis() - IPCDynamicPageView.this.iYD;
                if (currentTimeMillis <= 1000) {
                    i = 0;
                } else if (currentTimeMillis > 2000) {
                    i = currentTimeMillis <= 3000 ? 2 : currentTimeMillis <= 4000 ? 3 : currentTimeMillis <= 5000 ? 4 : currentTimeMillis <= 6000 ? 5 : currentTimeMillis <= 7000 ? 6 : currentTimeMillis <= 8000 ? 7 : currentTimeMillis <= 9000 ? 8 : currentTimeMillis <= 10000 ? 9 : 10;
                }
                com.tencent.mm.plugin.report.service.g.pWK.a(645, (long) i, 1, false);
                IPCDynamicPageView.this.kc(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
            }
            IPCDynamicPageView.this.iNN = System.currentTimeMillis();
            IPCDynamicPageView.this.iYE.abx();
        }
    };
    private Runnable iYG = new Runnable() {
        public final void run() {
            String e = IPCDynamicPageView.this.gQA;
            if (bi.oN(e)) {
                x.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
                return;
            }
            IPCDynamicPageView.this.mDetached = true;
            com.tencent.mm.plugin.appbrand.dynamic.a f = IPCDynamicPageView.this.iYA;
            if (e == null || e.length() == 0) {
                x.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", Integer.valueOf(f.hashCode()));
            } else {
                x.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", Integer.valueOf(f.hashCode()), e);
                Bundle bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.ID, e);
                f.a("com.tencent.mm:support", bundle, b.class, new com.tencent.mm.plugin.appbrand.dynamic.a.AnonymousClass2(e));
            }
            e acW = e.acW();
            if (bi.oN(e)) {
                x.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
            } else {
                WeakReference weakReference = (WeakReference) acW.iVm.remove(e);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
            IPCDynamicPageView.this.cleanup();
            IPCDynamicPageView.this.iUZ = null;
            IPCDynamicPageView.this.gQA = null;
            IPCDynamicPageView.this.iYB = null;
            IPCDynamicPageView.this.iYC = false;
            IPCDynamicPageView.this.iYE.abB();
        }
    };
    private Bundle iYz;
    private volatile boolean mDetached;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String fhk;
        final /* synthetic */ Bundle iUM;
        final /* synthetic */ q iYJ;
        final /* synthetic */ String uR;

        public AnonymousClass3(String str, Bundle bundle, q qVar, String str2) {
            this.uR = str;
            this.iUM = bundle;
            this.iYJ = qVar;
            this.fhk = str2;
        }

        public final void run() {
            if (!(IPCDynamicPageView.this.gQA == null || this.uR.equals(IPCDynamicPageView.this.gQA))) {
                IPCDynamicPageView.this.detach();
            }
            IPCDynamicPageView.this.gQA = this.uR;
            IPCDynamicPageView.this.iYz = this.iUM;
            IPCDynamicPageView.this.iYB = new r(this.iYJ);
            com.tencent.mm.plugin.appbrand.dynamic.a f = IPCDynamicPageView.this.iYA;
            String str = this.uR;
            String str2 = this.fhk;
            Bundle bundle = this.iUM;
            f.gQA = str;
            String str3 = "Token#" + System.nanoTime();
            f.iUJ = str3;
            Bundle bundle2 = new Bundle();
            bundle2.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle2.putString("appId", str2);
            if (bundle != null) {
                bundle2.putInt("scene", bundle.getInt("scene"));
                bundle2.putInt("widgetType", bundle.getInt("widget_type"));
                bundle2.putInt("serviceType", bundle.getInt("service_type"));
                bundle2.putInt("wxaPkgType", bundle.getInt("msg_pkg_type"));
                bundle2.putString("searchId", bundle.getString("search_id", ""));
                bundle2.putInt("pkgVersion", bundle.getInt("pkg_version"));
                bundle2.putString("preloadLaunchData", bundle.getString("preload_launch_data", ""));
            }
            f.a("com.tencent.mm:support", bundle2, c.class, new com.tencent.mm.plugin.appbrand.dynamic.a.AnonymousClass1(str3, str, str2, bundle));
            IPCDynamicPageView.this.mDetached = false;
        }
    }

    static /* synthetic */ Bundle b(IPCDynamicPageView iPCDynamicPageView, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("__page_view_id", iPCDynamicPageView.gQA);
        bundle2.putString("__process_name", ad.By());
        int measuredWidth = iPCDynamicPageView.getMeasuredWidth();
        int measuredHeight = iPCDynamicPageView.getMeasuredHeight();
        if ((measuredWidth == 0 || measuredHeight == 0) && bundle != null) {
            measuredWidth = bundle.getInt("view_init_width");
            measuredHeight = bundle.getInt("view_init_height");
        }
        bundle2.putInt("__page_view_width", measuredWidth);
        bundle2.putInt("__page_view_height", measuredHeight);
        if (!(iPCDynamicPageView.iUZ == null || iPCDynamicPageView.iUZ.field_appId == null)) {
            bundle2.putString("__page_app_id", iPCDynamicPageView.iUZ.field_appId);
        }
        return bundle2;
    }

    static {
        HandlerThread WL = com.tencent.mm.sdk.f.e.WL("WxaWidget#UIActionThread");
        WL.start();
        iUU = new ag(WL.getLooper());
    }

    public IPCDynamicPageView(Context context) {
        super(context);
        init(context);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.iYA = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
        View be = c.be(context);
        addView(be, iYH);
        this.iYE = (a) be;
    }

    public final void d(final String str, final String str2, final Bundle bundle) {
        iUU.post(new Runnable() {
            public final void run() {
                String str = "";
                if (bundle != null) {
                    str = bundle.getString("cache_key", "");
                }
                x.i("MicroMsg.IPCDynamicPageView", "attach(%s, %s, %s)", str, str2, str);
                IPCDynamicPageView.this.iUZ = b.rY(str);
                if (IPCDynamicPageView.this.iUZ == null) {
                    IPCDynamicPageView.this.iUZ = new g();
                }
                IPCDynamicPageView.this.iUZ.field_id = str;
                IPCDynamicPageView.this.iUZ.field_cacheKey = str;
                IPCDynamicPageView.this.iUZ.field_appId = str2;
                IPCDynamicPageView.this.qz(str);
                e acW = e.acW();
                String str2 = str;
                IPCDynamicPageView iPCDynamicPageView = IPCDynamicPageView.this;
                if (bi.oN(str2)) {
                    x.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
                } else if (iPCDynamicPageView == null) {
                    x.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
                } else {
                    WeakReference weakReference = (WeakReference) acW.iVm.put(str2, new WeakReference(iPCDynamicPageView));
                    if (!(weakReference == null || weakReference.get() == null)) {
                        x.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", str2);
                    }
                }
                if (bundle != null) {
                    bundle.putBundle("__env_args", IPCDynamicPageView.b(IPCDynamicPageView.this, bundle));
                }
                IPCDynamicPageView.this.iYA;
                str = str;
                str2 = str2;
                Bundle bundle = bundle;
                Bundle bundle2 = new Bundle();
                bundle2.putString(SlookAirButtonFrequentContactAdapter.ID, str);
                bundle2.putString("appId", str2);
                bundle2.putBundle("extData", bundle);
                f.a("com.tencent.mm:support", bundle2, a.class, null);
            }
        });
    }

    public final void detach() {
        if (Looper.myLooper() == iUU.getLooper()) {
            this.iYG.run();
        } else {
            iUU.post(this.iYG);
        }
    }

    public final void cleanup() {
        if (this.iUZ != null) {
            x.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", this.gQA, this.iUZ.field_id, this.iUZ.field_appId, this.iUZ.field_cacheKey);
        } else {
            x.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", this.gQA);
        }
        aby();
    }

    public final void jW(int i) {
        kb(i);
        detach();
    }

    public final void b(String str, p pVar) {
        if (this.iYB == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        s sVar = (s) this.iYB.iB(ai.NAME);
        if (sVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            sVar.iC(str);
        }
    }

    public final void c(String str, p pVar) {
        if (this.iYB == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        w wVar = (w) this.iYB.iB("onSearchWAWidgetReloadData");
        if (wVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            wVar.iE(str);
        }
    }

    public final void a(String str, p pVar) {
        if (this.iYB == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        v vVar = (v) this.iYB.iB("openApp");
        if (vVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            vVar.iD(str);
        }
    }

    public final void a(boolean z, String str, boolean z2, p pVar) {
        if (this.iYB == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        u uVar = (u) this.iYB.iB("OnTapCallback");
        if (uVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            uVar.b(z, str, z2);
        }
    }

    public final void b(int i, p pVar) {
        if (this.iYB == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        com.tencent.mm.modelappbrand.x xVar = (com.tencent.mm.modelappbrand.x) this.iYB.iB("setWidgetSize");
        if (xVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            xVar.a(i, pVar);
        }
    }

    public final boolean d(Canvas canvas) {
        return this.iYE.d(canvas);
    }

    public final void abx() {
        long currentTimeMillis = System.currentTimeMillis() - this.iNN;
        iUU.removeCallbacks(this.iYF);
        if (currentTimeMillis < 12) {
            iUU.postDelayed(this.iYF, currentTimeMillis);
        } else {
            this.iYF.run();
        }
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        this.iYE.a(jSONArray, aVar);
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        this.iYE.b(jSONArray, aVar);
    }

    public final void aby() {
        this.iYE.aby();
    }

    public final void qz(String str) {
        this.iYE.qz(str);
    }

    public final int getType() {
        return this.iYE.getType();
    }

    public final void l(Runnable runnable) {
        this.iYE.l(runnable);
    }

    public final void onPause() {
        x.v("MicroMsg.IPCDynamicPageView", "onPause(%s)", this.gQA);
        this.iYE.onPause();
        iUU.post(new Runnable() {
            public final void run() {
                IPCDynamicPageView.this.iYA;
                String e = IPCDynamicPageView.this.gQA;
                Bundle bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.ID, e);
                f.a("com.tencent.mm:support", bundle, d.class, null);
            }
        });
    }

    public final void onResume() {
        x.v("MicroMsg.IPCDynamicPageView", "onResume(%s)", this.gQA);
        this.iYE.onResume();
        iUU.post(new Runnable() {
            public final void run() {
                IPCDynamicPageView.this.iYA;
                String e = IPCDynamicPageView.this.gQA;
                Bundle bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.ID, e);
                f.a("com.tencent.mm:support", bundle, e.class, null);
            }
        });
    }

    public final boolean isPaused() {
        return this.iYE.isPaused();
    }

    public final void qA(String str) {
        this.iYE.qA(str);
    }

    public final int abz() {
        return this.iYE.abz();
    }

    public final int abA() {
        return this.iYE.abA();
    }

    public final void setStartTime(long j) {
        this.iYE.setStartTime(j);
    }

    public final void abB() {
        this.iYE.abB();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        x.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        Bundle bundle = new Bundle();
        bundle.putInt("__page_view_width", i);
        bundle.putInt("__page_view_height", i2);
        String str = this.gQA;
        Bundle bundle2 = new Bundle();
        bundle2.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle2.putBundle("__env_args", bundle);
        f.a("com.tencent.mm:support", bundle2, g.class, null);
    }

    private void kb(final int i) {
        if (this.iYB == null) {
            x.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", this.gQA, Integer.valueOf(i));
            return;
        }
        final com.tencent.mm.modelappbrand.f Jm = this.iYB.Jm();
        if (Jm == null) {
            x.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", this.gQA, Integer.valueOf(i));
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            Jm.q(this, i);
        } else {
            com.tencent.mm.plugin.appbrand.dynamic.b.n(new Runnable() {
                public final void run() {
                    Jm.q(IPCDynamicPageView.this, i);
                }
            });
        }
    }

    public final boolean X(String str, String str2) {
        com.tencent.mm.plugin.appbrand.dynamic.a aVar = this.iYA;
        String str3 = this.gQA;
        if (aVar.gQA == null || aVar.gQA.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        Parcelable bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str3);
        bundle.putString("event", str);
        bundle.putString(SlookAirButtonFrequentContactAdapter.DATA, str2);
        IPCBoolean iPCBoolean = (IPCBoolean) f.a("com.tencent.mm:support", bundle, f.class);
        return iPCBoolean != null ? iPCBoolean.value : false;
    }

    public final void kc(int i) {
        com.tencent.mm.plugin.appbrand.dynamic.a aVar = this.iYA;
        String str = this.gQA;
        if (aVar.gQA != null && aVar.gQA.length() != 0) {
            Bundle bundle = new Bundle();
            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle.putInt("widgetState", i);
            f.a("com.tencent.mm:support", bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
        }
    }
}
