package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ar extends a {
    public static final int CTRL_INDEX = 192;
    public static final String NAME = "openSetting";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        x.d("MicroMsg.JsApiOpenSetting", "jumpToSettingView!");
        AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
        if (appBrandSysConfig == null) {
            x.e("MicroMsg.JsApiOpenSetting", "config is null!");
            jVar.E(i, e("fail", null));
            return;
        }
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenSetting", "mmActivity is null, invoke fail!");
            return;
        }
        a.jCj = new a() {
            public final void b(int i, int i2, Intent intent) {
                if (i == 1) {
                    String stringExtra;
                    Object jSONArray;
                    String str = "";
                    if (intent != null) {
                        stringExtra = intent.getStringExtra("key_app_authorize_state");
                    } else {
                        stringExtra = str;
                    }
                    try {
                        jSONArray = new JSONArray(stringExtra);
                    } catch (JSONException e) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errMsg", ar.this.getName() + ":ok");
                        jSONObject.put("authSetting", jSONArray);
                    } catch (Throwable e2) {
                        x.e("MicroMsg.JsApiOpenSetting", "set json error!");
                        x.printErrStackTrace("MicroMsg.JsApiOpenSetting", e2, "", new Object[0]);
                    }
                    jVar.E(i, jSONObject.toString());
                }
            }
        };
        Intent putExtra = new Intent(jVar.getContext(), AppBrandAuthorizeUI.class).putExtra("key_username", appBrandSysConfig.foe);
        putExtra.putExtra("key_app_authorize_jsapi", true);
        d.b(a, "appbrand", ".ui.AppBrandAuthorizeUI", putExtra, 1);
    }
}
