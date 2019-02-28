package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o extends a {
    public static final int CTRL_BYTE = 28;
    public static final String NAME = "getBrandWCPayRequest";

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiGetBrandWCPayRequest", "invoke");
        MMActivity aPO = dVar.aPO();
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiGetBrandWCPayRequest", "data is null");
            dVar.E(i, a.e("get_brand_wcpay_request:fail_invalid_data", null));
            return;
        }
        h.a(aPO, new g(jSONObject), hashCode() & 65535, new MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                if (i == (o.this.hashCode() & 65535)) {
                    d dVar;
                    int i3;
                    o oVar;
                    if (i2 == -1) {
                        dVar = dVar;
                        i3 = i;
                        oVar = o.this;
                        dVar.E(i3, a.e("ok", null));
                    } else if (i2 == 5) {
                        Map hashMap = new HashMap();
                        i3 = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                        String oM = bi.oM(intent.getStringExtra("key_jsapi_pay_err_msg"));
                        hashMap.put("err_code", Integer.valueOf(i3));
                        hashMap.put("err_desc", oM);
                        x.e("MicroMsg.GameJsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", Integer.valueOf(i3), oM);
                        dVar.E(i, a.e("get_brand_wcpay_request:fail", hashMap));
                    } else {
                        dVar = dVar;
                        i3 = i;
                        oVar = o.this;
                        dVar.E(i3, a.e("get_brand_wcpay_request:cancel", null));
                    }
                }
            }
        });
    }
}
