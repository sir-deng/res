package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 354;
    public static final String NAME = "sendHCEMessage";

    public final void a(final j jVar, final JSONObject jSONObject, final int i) {
        super.a(jVar, jSONObject, i);
        a(new a() {
            public final void K(int i, String str) {
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    c cVar = c.this;
                    j jVar = jVar;
                    int i2 = i;
                    JSONObject jSONObject = jSONObject;
                    Map hashMap2 = new HashMap();
                    String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
                    if (bi.oN(optString)) {
                        hashMap2.put("errCode", Integer.valueOf(13005));
                        c.a(jVar, i2, cVar.e("fail", hashMap2));
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("key_apdu_command", optString);
                    HCEEventLogic.c(jVar.mAppId, 32, bundle);
                    hashMap2.put("errCode", Integer.valueOf(0));
                    jVar.E(i2, cVar.e("ok", hashMap2));
                    return;
                }
                c.a(jVar, i, c.this.e("fail: " + str, hashMap));
            }
        });
    }

    static void a(j jVar, int i, String str) {
        x.i("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", str);
        if (jVar != null) {
            jVar.E(i, str);
        }
    }
}
