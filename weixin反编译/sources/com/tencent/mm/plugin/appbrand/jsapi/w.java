package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w extends a {
    public static final int CTRL_INDEX = 101;
    public static final String NAME = "getAppConfig";

    public static class a extends f {
        private static final int CTRL_INDEX = 109;
        private static final String NAME = "onAppConfig";
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiGetAppConfig", "data is null");
            return;
        }
        String str = jVar.mAppId;
        final int optInt = jSONObject.optInt(Columns.TYPE, 0);
        x.i("MicroMsg.JsApiGetAppConfig", "getAppConfig app_id:%s,type:%d", str, Integer.valueOf(optInt));
        if (optInt <= 0) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiGetAppConfig", "type %d is invalid", Integer.valueOf(optInt));
            return;
        }
        final MainProcessTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask();
        jsApiGetAppConfigTask.appId = str;
        jsApiGetAppConfigTask.type = optInt;
        jsApiGetAppConfigTask.scene = jVar.iuk.YF();
        final j jVar2 = jVar;
        final int i2 = i;
        jsApiGetAppConfigTask.jfW = new Runnable() {
            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put(Columns.TYPE, optInt);
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, jsApiGetAppConfigTask.value);
                x.i("MicroMsg.JsApiGetAppConfig", "getAppConfig type:%d,data:\n%s", Integer.valueOf(optInt), jsApiGetAppConfigTask.value);
                if (bi.oN(jsApiGetAppConfigTask.value)) {
                    jVar2.E(i2, w.this.e("fail", null));
                } else {
                    jVar2.E(i2, w.this.e("ok", hashMap));
                }
                jsApiGetAppConfigTask.afz();
            }
        };
        jsApiGetAppConfigTask.afy();
        AppBrandMainProcessService.a(jsApiGetAppConfigTask);
    }
}
