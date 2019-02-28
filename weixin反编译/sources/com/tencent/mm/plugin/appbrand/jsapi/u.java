package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u extends a {
    public static final int CTRL_INDEX = 286;
    public static final String NAME = "chooseInvoiceTitle";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_appbrand", true);
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        a.jCj = new a() {
            public final void b(int i, int i2, Intent intent) {
                if (i == (u.this.hashCode() & 65535)) {
                    if (i2 == -1 && intent != null) {
                        Map hashMap = new HashMap();
                        String aD = bi.aD(intent.getStringExtra("choose_invoice_title_info"), "");
                        x.i("MicroMsg.JsApiChooseInvoiceTitle", "choose_invoice_title_info is : " + aD);
                        hashMap.put("invoiceTitleInfo", aD);
                        jVar.E(i, u.this.e("ok", hashMap));
                    } else if (i2 == 0) {
                        jVar.E(i, u.this.e("cancel", null));
                    } else {
                        jVar.E(i, u.this.e("fail", null));
                    }
                }
            }
        };
        d.a(a, "address", ".ui.InvoiceListUI", intent, hashCode() & 65535, false);
    }
}
