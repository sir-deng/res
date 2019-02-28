package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u.b;
import org.json.JSONObject;

public final class l extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    private static class a implements h<com.tencent.mm.plugin.appbrand.dynamic.widget.a.a, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            com.tencent.mm.plugin.appbrand.dynamic.widget.a.a aVar = (com.tencent.mm.plugin.appbrand.dynamic.widget.a.a) obj;
            final Bundle bundle = new Bundle();
            View rJ = e.acW().rJ(aVar.id);
            if (rJ instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
                ((com.tencent.mm.plugin.appbrand.dynamic.h) rJ).b(aVar.height, new p() {
                    public final void b(boolean z, String str, Bundle bundle) {
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle(SlookAirButtonFrequentContactAdapter.DATA, bundle);
                        iVar.as(bundle);
                    }
                });
                return;
            }
            x.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "drawCanvas failed, view is not a instance of DynamicPageAccessible.(%s)", aVar.id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            iVar.as(bundle);
        }
    }

    public l(int i) {
        super("setWidgetSize", i);
    }

    protected final void a(com.tencent.mm.t.c.a aVar, JSONObject jSONObject, final com.tencent.mm.t.b.b.a<JSONObject> aVar2) {
        b Ci = aVar.Ci();
        com.tencent.mm.plugin.appbrand.dynamic.widget.a.a aVar3 = new com.tencent.mm.plugin.appbrand.dynamic.widget.a.a();
        aVar3.id = Ci.getString("__page_view_id", "");
        aVar3.width = jSONObject.optInt("width", Ci.getInt("__page_view_width", 0));
        aVar3.height = jSONObject.optInt("height", Ci.getInt("__page_view_height", 0));
        XIPCInvoker.a(Ci.getString("__process_name", ad.By()), aVar3, a.class, new i<Bundle>() {
            public final /* synthetic */ void as(Object obj) {
                boolean z;
                String string;
                Bundle bundle = null;
                Bundle bundle2 = (Bundle) obj;
                if (bundle2 != null) {
                    z = bundle2.getBoolean("ret");
                    string = bundle2.getString("reason");
                    bundle = bundle2.getBundle(SlookAirButtonFrequentContactAdapter.DATA);
                } else {
                    z = false;
                    string = null;
                }
                aVar2.aw(l.this.a(z, string, bundle));
            }
        });
    }
}
