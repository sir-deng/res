package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.b.d;
import com.tencent.mm.plugin.appbrand.dynamic.h.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.AnonymousClass1;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class c implements OnAttachStateChangeListener, e, a, com.tencent.mm.sdk.platformtools.ak.c {
    private String hAU;
    private volatile com.tencent.mm.modelappbrand.c iVK;
    private volatile b iVR;
    private volatile d iVS;

    public final void initialize() {
        if (!(this.hAU == null || this.hAU.length() == 0)) {
            shutdown();
        }
        this.hAU = "Token#" + System.nanoTime();
        ak.a((com.tencent.mm.sdk.platformtools.ak.c) this);
        r.a(new d());
    }

    public final void shutdown() {
        Map Jb = adi().Jb();
        if (Jb != null && !Jb.isEmpty()) {
            for (Object next : new LinkedHashSet(Jb.keySet())) {
                if (next != null && (next instanceof String)) {
                    iA((String) next);
                }
            }
        }
    }

    public final View be(Context context) {
        return new IPCDynamicPageView(context);
    }

    public final boolean a(String str, View view, Bundle bundle, q qVar) {
        f fVar = null;
        if (!(view instanceof IPCDynamicPageView)) {
            return false;
        }
        String string;
        String string2;
        String bH = k.bH(System.nanoTime());
        com.tencent.mm.plugin.appbrand.collector.c.c("widget_launch", bH, "on_bind_view", true);
        com.tencent.mm.plugin.appbrand.collector.c.aV(bH, "init_finish");
        IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
        if (bundle != null) {
            string = bundle.getString("app_id");
            string2 = bundle.getString("msg_id");
            bundle.putString("__session_id", str);
            bundle.putLong("__on_bind_nano_time", System.nanoTime());
            bundle.putString("__session_id", bH);
            bundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.collector.c.qH(bH));
        } else {
            string2 = null;
            string = null;
        }
        bH = WxaWidgetInitializer.bc(string, string2);
        iPCDynamicPageView.removeOnAttachStateChangeListener(this);
        iPCDynamicPageView.addOnAttachStateChangeListener(this);
        Assert.assertNotNull(bH);
        iPCDynamicPageView.iYD = System.currentTimeMillis();
        if (qVar != null) {
            fVar = qVar.Jm();
        }
        if (!(iPCDynamicPageView.gQA == null || bH.equals(iPCDynamicPageView.gQA))) {
            iPCDynamicPageView.cleanup();
        }
        if (!(fVar == null || (bH.equals(iPCDynamicPageView.gQA) && iPCDynamicPageView.iYC))) {
            fVar.q(iPCDynamicPageView, 0);
        }
        iPCDynamicPageView.iYC = false;
        IPCDynamicPageView.iUU.post(new AnonymousClass3(bH, bundle, qVar, string));
        x.v("MicroMsg.DynamicPageService", "onBindView(%s)", bH);
        com.tencent.mm.plugin.appbrand.dynamic.h.a adv = com.tencent.mm.plugin.appbrand.dynamic.h.a.adv();
        if (!(this == null || str == null || str.length() == 0)) {
            adv.iXQ.put(str, this);
        }
        com.tencent.mm.plugin.appbrand.dynamic.h.a.adv().c(str, iPCDynamicPageView);
        adi().g(str, iPCDynamicPageView);
        return true;
    }

    public final void a(String str, View view) {
        if (view instanceof IPCDynamicPageView) {
            IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
            x.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", iPCDynamicPageView.gQA);
            iPCDynamicPageView.removeOnAttachStateChangeListener(this);
            adi().h(str, iPCDynamicPageView);
            com.tencent.mm.plugin.appbrand.dynamic.h.a.adv().b(str, iPCDynamicPageView);
            iPCDynamicPageView.detach();
        }
    }

    public final void bA(View view) {
        if (view instanceof IPCDynamicPageView) {
            ((IPCDynamicPageView) view).kc(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG);
        }
    }

    public final void iA(String str) {
        com.tencent.mm.plugin.appbrand.dynamic.h.a.adv().iXP.remove(str);
        com.tencent.mm.plugin.appbrand.dynamic.h.a adv = com.tencent.mm.plugin.appbrand.dynamic.h.a.adv();
        if (!(str == null || str.length() == 0)) {
            adv.iXQ.remove(str);
        }
        Set<View> aT = adi().aT(str);
        if (aT != null && !aT.isEmpty()) {
            for (View view : aT) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
                    x.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", iPCDynamicPageView.gQA);
                    iPCDynamicPageView.removeOnAttachStateChangeListener(this);
                    iPCDynamicPageView.detach();
                }
            }
            if (!adi().Jb().isEmpty()) {
                return;
            }
            if (g.fm("com.tencent.mm:support")) {
                com.tencent.mm.by.a.post(new AnonymousClass1());
            } else {
                x.i("MicroMsg.DynamicPkgUpdater", "has not Connected RemoteService, abort clearCache");
            }
        }
    }

    public final j bB(View view) {
        if (view instanceof IPCDynamicPageView) {
            return (j) view;
        }
        return null;
    }

    private com.tencent.mm.modelappbrand.c adi() {
        if (this.iVK == null) {
            synchronized (this) {
                if (this.iVK == null) {
                    this.iVK = new a();
                }
            }
        }
        return this.iVK;
    }

    public final com.tencent.mm.modelappbrand.d Jc() {
        if (this.iVR == null) {
            synchronized (this) {
                if (this.iVR == null) {
                    this.iVR = new b(adi());
                }
            }
        }
        return this.iVR;
    }

    public final h Jd() {
        if (this.iVS == null) {
            synchronized (this) {
                if (this.iVS == null) {
                    this.iVS = new d();
                }
            }
        }
        return this.iVS;
    }

    public final void a(String str, Throwable th) {
        x.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", Log.getStackTraceString(th));
        shutdown();
    }

    public final void onViewAttachedToWindow(View view) {
        if (view != null && (view instanceof IPCDynamicPageView)) {
            x.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", ((IPCDynamicPageView) view).gQA);
            r6.onResume();
        }
    }

    public final void onViewDetachedFromWindow(View view) {
        if (view != null && (view instanceof IPCDynamicPageView)) {
            x.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", ((IPCDynamicPageView) view).gQA);
            r6.onPause();
        }
    }

    public final void a(String str, IPCDynamicPageView iPCDynamicPageView) {
        x.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", str, iPCDynamicPageView.gQA);
        a(str, (View) iPCDynamicPageView);
    }
}
