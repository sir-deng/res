package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

final class bp extends a {
    public static final int CTRL_INDEX = 215;
    public static final String NAME = "updatePerfData";
    private static final SparseArray<Integer> jhD = new SparseArray();

    bp() {
        jhD.put("firstRenderTime".hashCode(), Integer.valueOf(301));
        jhD.put("reRenderTime".hashCode(), Integer.valueOf(HardCoderJNI.SCENE_QUIT_CHATTING));
        jhD.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(e.CTRL_INDEX));
        jhD.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(ap.CTRL_INDEX));
        jhD.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(TencentLocation.ERROR_UNKNOWN));
        jhD.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
        jhD.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(au.CTRL_INDEX));
        jhD.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(JsApiPrivateAddContact.CTRL_INDEX));
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (!AppBrandPerformanceManager.uy(cVar.getAppId()) || optJSONArray == null) {
            cVar.E(i, e("fail", null));
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("key");
                    String optString2 = optJSONObject.optString(Columns.VALUE);
                    if (!bi.oN(optString)) {
                        Integer num = (Integer) jhD.get(optString.hashCode());
                        if (num != null) {
                            AppBrandPerformanceManager.o(cVar.getAppId(), num.intValue(), optString2);
                        } else {
                            AppBrandPerformanceManager.E(cVar.getAppId(), optString, optString2);
                        }
                    }
                }
                i2 = i3 + 1;
            } else {
                cVar.E(i, e("ok", null));
                return;
            }
        }
    }
}
