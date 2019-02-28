package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfo";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        final MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = jVar.mAppId;
        jsApiGetStorageInfoTask.jfW = new Runnable() {
            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put("keys", jsApiGetStorageInfoTask.juJ);
                hashMap.put("currentSize", Integer.valueOf(jsApiGetStorageInfoTask.size));
                hashMap.put("limitSize", Integer.valueOf(jsApiGetStorageInfoTask.asN));
                jVar.E(i, d.this.e("ok", hashMap));
            }
        };
        jsApiGetStorageInfoTask.afy();
        AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
    }
}
