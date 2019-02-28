package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 152;
    public static final String NAME = "getContactMessageCount";

    public static class a extends f {
        private static final int CTRL_INDEX = 152;
        private static final String NAME = "onContactMessageCountChange";
    }

    public final void a(final p pVar, JSONObject jSONObject, final int i) {
        String str = "";
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        if (appBrandSysConfig != null) {
            str = appBrandSysConfig.foe;
        }
        if (bi.oN(str)) {
            x.e("MicroMsg.JsApiGetAppConfig", "getContactMessageCount username is empty!!!");
        }
        final MainProcessTask jsApiGetContactMessageCountTask = new JsApiGetContactMessageCountTask();
        jsApiGetContactMessageCountTask.username = str;
        jsApiGetContactMessageCountTask.jfW = new Runnable() {
            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put("count", jsApiGetContactMessageCountTask.fof);
                x.i("MicroMsg.JsApiGetAppConfig", "JsApiGetContactMessageCountTask unreadCount:%d", Integer.valueOf(jsApiGetContactMessageCountTask.fof));
                if (jsApiGetContactMessageCountTask.fof == -1) {
                    pVar.E(i, d.this.e("fail", null));
                } else {
                    pVar.E(i, d.this.e("ok", hashMap));
                }
                jsApiGetContactMessageCountTask.afz();
            }
        };
        jsApiGetContactMessageCountTask.afy();
        AppBrandMainProcessService.a(jsApiGetContactMessageCountTask);
    }
}
