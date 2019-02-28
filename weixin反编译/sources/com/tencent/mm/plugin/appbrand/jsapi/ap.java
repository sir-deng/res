package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public final class ap extends a {
    public static final int CTRL_INDEX = 403;
    public static final String NAME = "openOfflinePayView";
    private int jfG;

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenOfflinePayView", "mmActivity is null, invoke fail!");
            return;
        }
        a.jCj = new a() {
            public final void b(int i, int i2, Intent intent) {
                if (i == (ap.this.hashCode() & 65535)) {
                    if (intent != null) {
                        x.i("MicroMsg.JsApiOpenOfflinePayView", "callback: %s", intent.getStringExtra("key_callback"));
                        jVar.E(i, ap.this.e(r0, null));
                        g.pWK.h(14954, f.cdH(), "openOfflinePayView:ok");
                    } else {
                        jVar.E(i, ap.this.e("fail", null));
                        if (!f.cdG()) {
                            g.pWK.h(14954, f.cdH(), "openOfflinePayView:fail");
                        }
                    }
                    if (!f.cdG()) {
                        f.cdI();
                    }
                }
            }
        };
        this.jfG = i;
        x.d("MicroMsg.JsApiOpenOfflinePayView", "json: %s", jSONObject.toString());
        AppBrandSysConfig pk = com.tencent.mm.plugin.appbrand.a.pk(jVar.mAppId);
        if (pk == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenOfflinePayView", "sysConfig is null, invoke fail!");
            return;
        }
        e pi = com.tencent.mm.plugin.appbrand.a.pi(jVar.mAppId);
        if (pi == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenOfflinePayView", "runtime is null, invoke fail!");
            return;
        }
        String aeH = pi.isX.aeH();
        Intent intent = new Intent();
        intent.putExtra("appId", jVar.mAppId);
        intent.putExtra("timeStamp", jSONObject.optString("timeStamp"));
        intent.putExtra("nonceStr", jSONObject.optString("nonceStr"));
        intent.putExtra("packageExt", jSONObject.optString("package"));
        intent.putExtra("signtype", jSONObject.optString("signType"));
        intent.putExtra("paySignature", jSONObject.optString("paySign"));
        intent.putExtra("wxapp_username", pk.fsi);
        intent.putExtra("wxapp_path", aeH);
        int hashCode = hashCode() & 65535;
        intent.putExtra("key_from_scene", 7);
        d.b(a, "offline", ".ui.WalletOfflineEntranceUI", intent, hashCode);
    }
}
