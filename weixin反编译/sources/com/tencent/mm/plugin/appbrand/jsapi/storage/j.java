package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class j extends l {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorageSync";

    public final String a(com.tencent.mm.plugin.appbrand.j jVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        String optString3 = jSONObject.optString("dataType");
        if (bi.oN(optString)) {
            return e("fail", null);
        }
        if ((optString2 == null ? 0 : optString2.length()) + optString.length() > jVar.iuk.isS.iRV.iQy) {
            return e("fail:entry size limit reached", null);
        }
        String str = "fail";
        MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
        jsApiSetStorageTask.appId = jVar.mAppId;
        jsApiSetStorageTask.B(optString, optString2, optString3);
        if (AppBrandMainProcessService.b(jsApiSetStorageTask)) {
            str = jsApiSetStorageTask.result;
        }
        return e(str, null);
    }
}
