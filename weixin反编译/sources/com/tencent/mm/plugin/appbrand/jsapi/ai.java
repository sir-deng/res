package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class ai extends a {
    public static final int CTRL_INDEX = 102;
    public static final String NAME = "makePhoneCall";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        String optString = jSONObject.optString("phoneNumber");
        if (bi.oN(optString)) {
            jVar.E(i, e("fail", null));
            return;
        }
        MMActivity a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        a.jCj = new a() {
            public final void b(int i, int i2, Intent intent) {
                if (i == (ai.this.hashCode() & 65535)) {
                    jVar.E(i, ai.this.e("ok", null));
                }
            }
        };
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(Uri.encode(optString)).toString()));
        try {
            a.startActivityForResult(intent, hashCode() & 65535);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiMakePhoneCall", "startActivity failed");
            jVar.E(i, e("fail", null));
        }
    }
}
