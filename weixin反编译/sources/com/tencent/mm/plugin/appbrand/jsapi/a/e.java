package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 402;
    public static final String NAME = "openRealnameAuth";

    public final void a(final p pVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo data is null");
            pVar.E(i, e("fail:data is null", null));
            return;
        }
        MMActivity mMActivity = (MMActivity) pVar.mContext;
        if (mMActivity == null) {
            pVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenRealnameAuth", "mmActivity is null, invoke fail!");
            return;
        }
        String optString = jSONObject.optString("categoryId", "");
        if (bi.oN(optString)) {
            x.e("MicroMsg.JsApiOpenRealnameAuth", "category_id is null");
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(40003));
            pVar.E(i, e("fail:category_id is empty", hashMap));
            return;
        }
        x.i("MicroMsg.JsApiOpenRealnameAuth", "getIDCardInfo category_id:%s, appId:%s", optString, pVar.mAppId);
        Intent intent = new Intent(mMActivity, AppBrandIDCardUI.class);
        intent.putExtra("intent_appid", r2);
        intent.putExtra("intent_category_id", optString);
        mMActivity.jCj = new MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                x.i("MicroMsg.JsApiOpenRealnameAuth", "mmOnActivityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (i == 1) {
                    Map hashMap = new HashMap();
                    if (i2 == -1) {
                        x.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth ok");
                        String stringExtra = intent.getStringExtra("intent_auth_token");
                        if (bi.oN(stringExtra)) {
                            pVar.E(i, e.this.e("fail", hashMap));
                            return;
                        }
                        hashMap.put("errCode", Integer.valueOf(0));
                        hashMap.put("auth_token", stringExtra);
                        pVar.E(i, e.this.e("ok", hashMap));
                        x.d("MicroMsg.JsApiOpenRealnameAuth", "authToken:%s", stringExtra);
                    } else if (i2 == 0) {
                        x.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth cancel");
                        pVar.E(i, e.this.e("cancel", null));
                    } else if (i2 == 1) {
                        x.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth fail");
                        if (intent != null) {
                            int intExtra = intent.getIntExtra("intent_err_code", -1);
                            String stringExtra2 = intent.getStringExtra("intent_err_msg");
                            hashMap.put("errCode", Integer.valueOf(intExtra));
                            pVar.E(i, e.this.e("fail:" + bi.oM(stringExtra2), hashMap));
                            x.i("MicroMsg.JsApiOpenRealnameAuth", "openRealnameAuth errCode:%d, errMsg:%s", Integer.valueOf(intExtra), stringExtra2);
                            return;
                        }
                        pVar.E(i, e.this.e("fail", hashMap));
                    }
                }
            }
        };
        mMActivity.startActivityForResult(intent, 1);
        g.pWK.h(14943, r2, Integer.valueOf(1), "");
    }
}
