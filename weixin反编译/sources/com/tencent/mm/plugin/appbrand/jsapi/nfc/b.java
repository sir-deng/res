package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 358;
    public static final String NAME = "getHCEState";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        super.a(jVar, jSONObject, i);
        a(new a() {
            public final void K(int i, String str) {
                x.i("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    jVar.E(i, b.this.e("ok", hashMap));
                } else {
                    jVar.E(i, b.this.e("fail " + str, hashMap));
                }
            }
        });
    }
}
