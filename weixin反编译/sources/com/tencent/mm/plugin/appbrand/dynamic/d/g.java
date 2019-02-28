package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class g extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    private static class a implements f {
        String fJv;
        String id;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void e(Parcel parcel) {
            parcel.writeString(this.id);
            parcel.writeString(this.fJv);
        }

        public final void readFromParcel(Parcel parcel) {
            this.id = parcel.readString();
            this.fJv = parcel.readString();
        }
    }

    private static class b implements h<a, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            a aVar = (a) obj;
            final Bundle bundle = new Bundle();
            View rJ = e.acW().rJ(aVar.id);
            if (rJ instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
                ((com.tencent.mm.plugin.appbrand.dynamic.h) rJ).b(aVar.fJv, new p() {
                    public final void b(boolean z, String str, Bundle bundle) {
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle(SlookAirButtonFrequentContactAdapter.DATA, bundle);
                        iVar.as(bundle);
                    }
                });
                return;
            }
            x.i("MicroMsg.IPCInvoke_RequestMakePhoneCall", "makePhoneCall failed, view is not a instance of DynamicPageAccessible.(%s)", aVar.id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            iVar.as(bundle);
        }
    }

    public g() {
        super(ai.NAME, 327);
    }

    protected final void a(com.tencent.mm.t.c.a aVar, JSONObject jSONObject, final com.tencent.mm.t.b.b.a<JSONObject> aVar2) {
        com.tencent.mm.y.u.b Ci = aVar.Ci();
        a aVar3 = new a();
        aVar3.id = Ci.getString("__page_view_id", "");
        aVar3.fJv = jSONObject.optString("phoneNumber", "");
        XIPCInvoker.a(Ci.getString("__process_name", ad.By()), aVar3, b.class, new i<Bundle>() {
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
                aVar2.aw(g.this.a(z, string, bundle));
            }
        });
    }
}
