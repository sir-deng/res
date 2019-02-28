package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorage";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        final long currentTimeMillis = System.currentTimeMillis();
        String optString = jSONObject.optString("key");
        if (bi.oN(optString)) {
            jVar.E(i, e("fail", null));
            return;
        }
        final MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
        jsApiGetStorageTask.appId = jVar.mAppId;
        jsApiGetStorageTask.aAM = optString;
        final j jVar2 = jVar;
        final int i2 = i;
        jsApiGetStorageTask.jfW = new Runnable() {
            public final void run() {
                String str = jsApiGetStorageTask.value == null ? "fail" : "ok";
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, jsApiGetStorageTask.value == null ? "" : jsApiGetStorageTask.value);
                hashMap.put("dataType", jsApiGetStorageTask.type == null ? "" : jsApiGetStorageTask.type);
                jVar2.E(i2, c.this.e(str, hashMap));
                jsApiGetStorageTask.afz();
                x.i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", jsApiGetStorageTask.aAM, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        };
        jsApiGetStorageTask.afy();
        AppBrandMainProcessService.a(jsApiGetStorageTask);
    }
}
