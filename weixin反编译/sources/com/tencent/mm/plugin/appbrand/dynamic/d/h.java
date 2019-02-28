package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class h extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    public static class b implements f {
        String fJM;
        boolean iWH;
        boolean iWI;
        String id;

        public final void e(Parcel parcel) {
            int i;
            int i2 = 1;
            parcel.writeString(this.id);
            if (this.iWH) {
                i = 1;
            } else {
                i = 0;
            }
            parcel.writeInt(i);
            parcel.writeString(this.fJM);
            if (!this.iWI) {
                i2 = 0;
            }
            parcel.writeInt(i2);
        }

        public final void readFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.id = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.iWH = z;
            this.fJM = parcel.readString();
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.iWI = z2;
        }
    }

    private static class a implements com.tencent.mm.ipcinvoker.h<b, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            b bVar = (b) obj;
            final Bundle bundle = new Bundle();
            View rJ = e.acW().rJ(bVar.id);
            if (rJ instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
                ((com.tencent.mm.plugin.appbrand.dynamic.h) rJ).a(bVar.iWH, bVar.fJM, bVar.iWI, new p() {
                    public final void b(boolean z, String str, Bundle bundle) {
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle(SlookAirButtonFrequentContactAdapter.DATA, bundle);
                        iVar.as(bundle);
                    }
                });
                return;
            }
            x.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "onTapCallback failed, view is not a instance of DynamicPageAccessible.(%s)", bVar.id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            iVar.as(bundle);
        }
    }

    public h() {
        super("onTapCallback", 327);
    }

    protected final void a(com.tencent.mm.t.c.a aVar, JSONObject jSONObject, final com.tencent.mm.t.b.b.a<JSONObject> aVar2) {
        com.tencent.mm.y.u.b Ci = aVar.Ci();
        b bVar = new b();
        bVar.id = Ci.getString("__page_view_id", "");
        bVar.fJM = jSONObject.optString("eventId", "");
        bVar.iWH = jSONObject.optBoolean("hasHandler");
        bVar.iWI = jSONObject.optBoolean("res");
        XIPCInvoker.a(Ci.getString("__process_name", ad.By()), bVar, a.class, new i<Bundle>() {
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
                aVar2.aw(h.this.a(z, string, bundle));
            }
        });
    }
}
