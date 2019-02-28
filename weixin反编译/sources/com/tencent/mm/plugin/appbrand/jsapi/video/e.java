package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e implements com.tencent.mm.plugin.appbrand.page.p.e {
    AppBrandVideoView jwG;
    private p jwH;
    al jwI;
    int jwJ;

    private static final class a extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 131;
        private static final String NAME = "onVideoClickDanmuBtn";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static final class b extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 138;
        private static final String NAME = "onVideoEnded";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static final class d extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 130;
        private static final String NAME = "onVideoFullScreenChange";

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private static final class e extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 128;
        private static final String NAME = "onVideoPause";

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    private static final class f extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoPlay";

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    private static final class g extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoTimeUpdate";

        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }
    }

    private static final class h extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 350;
        private static final String NAME = "onVideoWaiting";

        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }
    }

    private static final class c extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 349;
        private static final String NAME = "onVideoError";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public e(AppBrandVideoView appBrandVideoView, p pVar) {
        this.jwG = appBrandVideoView;
        this.jwH = pVar;
        this.jwH.a((com.tencent.mm.plugin.appbrand.page.p.e) this);
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.jwG.jvP = null;
    }

    public final void clean() {
        this.jwH.b((com.tencent.mm.plugin.appbrand.page.p.e) this);
        ahD();
    }

    final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject) {
        if (!(fVar instanceof g)) {
            x.i("MicroMsg.JsApiVideoCallback", "dispatchEvent event %s", fVar.getName());
        }
        com.tencent.mm.plugin.appbrand.jsapi.f aA = fVar.aA(this.jwH.mAppId, this.jwH.hashCode());
        aA.mData = jSONObject.toString();
        aA.afI();
    }

    final JSONObject ahC() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, this.jwG.jvM);
        return jSONObject;
    }

    final void ahD() {
        if (this.jwI != null) {
            this.jwI.TN();
        }
    }
}
