package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 280;
    private static final String NAME = "getRegionData";
    private static final AtomicReference<String> jsM = new AtomicReference();

    private static final class a implements j<IPCVoid, IPCString> {
        private a() {
        }

        public final /* synthetic */ Object at(Object obj) {
            String str = g.Dq().gRT + "address";
            return e.bO(str) ? new IPCString(str) : new IPCString("");
        }
    }

    public final void a(p pVar, JSONObject jSONObject, final int i) {
        final WeakReference weakReference = new WeakReference(pVar);
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                Object bT;
                String bT2 = null;
                String str = (String) b.jsM.get();
                if (bi.oN(str)) {
                    String str2;
                    if (ad.cgn()) {
                        try {
                            str2 = ((IPCString) XIPCInvoker.a("com.tencent.mm", IPCVoid.gOQ, a.class)).value;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e, "query updated address path", new Object[0]);
                            str2 = bT2;
                        }
                    } else {
                        str2 = "";
                    }
                    if (bi.oN(str2)) {
                        bT2 = str;
                    } else {
                        try {
                            bT2 = e.bT(str2);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e2, "read address from file %s", str2);
                        }
                    }
                    if (bi.oN(bT2)) {
                        try {
                            bT2 = bi.convertStreamToString(ad.getContext().getAssets().open("address"));
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e22, "read address from assets", new Object[0]);
                        }
                    }
                    if (!bi.oN(bT2)) {
                        b.jsM.set(bT2);
                    }
                } else {
                    bT2 = str;
                }
                p pVar = (p) weakReference.get();
                if (pVar != null && pVar.isRunning()) {
                    Map hashMap = new HashMap(1);
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, bT2);
                    pVar.E(i, b.this.e("ok", hashMap));
                }
            }
        }, "AppBrandJsApiGetRegionData");
    }
}
