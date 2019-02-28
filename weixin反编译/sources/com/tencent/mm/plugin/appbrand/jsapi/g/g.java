package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 285;
    public static final String NAME = "requestVirtualPayment";
    boolean jsw = false;

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
        } else if (this.jsw) {
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(2));
            x.e("MicroMsg.JsApiRequestVirtualPayment", "errCode: %d, errMsg: an order is being paid", Integer.valueOf(2));
            jVar.E(i, e("fail an order is being paid", hashMap));
        } else {
            this.jsw = true;
            MMActivity.a anonymousClass1 = new MMActivity.a() {
                public final void b(int i, int i2, Intent intent) {
                    if (i == (g.this.hashCode() & 65535)) {
                        g.this.jsw = false;
                        if (i2 == -1) {
                            int intExtra = intent.getIntExtra("key_err_code", 1);
                            if (intExtra == 0) {
                                x.e("MicroMsg.JsApiRequestVirtualPayment", "requestIAP ok");
                                jVar.E(i, g.this.e("ok", null));
                                return;
                            }
                            Map hashMap = new HashMap();
                            String oM = bi.oM(intent.getStringExtra("key_err_msg"));
                            hashMap.put("errCode", Integer.valueOf(intExtra));
                            x.e("MicroMsg.JsApiRequestVirtualPayment", "requestVirtualPayment errCode: %d, errMsg: %s", Integer.valueOf(intExtra), oM);
                            jVar.E(i, g.this.e("fail " + oM, hashMap));
                            return;
                        }
                        jVar.E(i, g.this.e("cancel", null));
                    }
                }
            };
            Bundle bundle = new Bundle();
            bundle.putInt("scene", 0);
            p b = e.b(jVar);
            if (b != null) {
                b.a(2, bundle, new Object[0]);
            } else {
                x.e("MicroMsg.JsApiRequestVirtualPayment", "hy: associated page view is null!!");
            }
            Intent intent = new Intent();
            x.i("MicroMsg.JsApiRequestVirtualPayment", "iap payment start ... data : " + jSONObject);
            intent.putExtra("key_appid", jVar.mAppId);
            intent.putExtra("key_product_id", jSONObject.optString("priceLevel"));
            intent.putExtra("key_price", jSONObject.optString("priceLevel"));
            intent.putExtra("key_currency_type", jSONObject.optString("currencyType", "CNY"));
            intent.putExtra("key_desc", jSONObject.optString("desc"));
            intent.putExtra("key_count", jSONObject.optInt("count", 1));
            intent.putExtra("key_is_mini_program", true);
            intent.putExtra("key_busiid", jSONObject.optString("outTradeNo"));
            intent.putExtra("key_virtual_pay_sign", jSONObject.optString("virtualPaySign"));
            intent.putExtra("key_attach", jSONObject.optString("attach"));
            a.jCj = anonymousClass1;
            d.b(a, "wallet_index", ".ui.WalletIapUI", intent, hashCode() & 65535);
        }
    }
}
