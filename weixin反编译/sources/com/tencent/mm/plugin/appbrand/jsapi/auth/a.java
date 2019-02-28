package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class a extends e<a> implements a {
    private static final Map<String, a> jjf = new android.support.v4.e.a();
    private static final a jjg = new a() {
        protected final /* bridge */ /* synthetic */ boolean afU() {
            return true;
        }

        protected final /* synthetic */ void bd(Object obj) {
            super.a((a) obj);
        }

        protected final boolean afT() {
            return true;
        }
    };

    interface a {
        void afV();
    }

    /* synthetic */ a(com.tencent.mm.plugin.appbrand.e eVar, byte b) {
        this(null);
    }

    protected /* synthetic */ boolean afU() {
        return afT();
    }

    protected /* synthetic */ void bd(Object obj) {
        a((a) obj);
    }

    public static a o(com.tencent.mm.plugin.appbrand.e eVar) {
        if (eVar == null || eVar.mFinished) {
            return jjg;
        }
        a aVar;
        synchronized (jjf) {
            aVar = (a) jjf.get(eVar.mAppId);
            if (aVar == null) {
                aVar = new a(eVar);
                jjf.put(eVar.mAppId, aVar);
            }
        }
        return aVar;
    }

    private a(com.tencent.mm.plugin.appbrand.e eVar) {
        super("MicroMsg.AppBrandAuthJsApiQueue" + (eVar == null ? "|DUMMY" : "|" + eVar.mAppId), c.Dt().oFY.getLooper());
        if (eVar != null) {
            final String str = eVar.mAppId;
            com.tencent.mm.plugin.appbrand.c.a(str, new b() {
                public final void onDestroy() {
                    a.this.quit();
                    synchronized (a.jjf) {
                        a.jjf.remove(str);
                    }
                }
            });
        }
    }

    public final void afS() {
        DA(2);
    }

    protected boolean afT() {
        return false;
    }

    protected final void a(a aVar) {
        x.d(this.mName, "about to executeTask %s", aVar.toString());
        aVar.afV();
    }
}
