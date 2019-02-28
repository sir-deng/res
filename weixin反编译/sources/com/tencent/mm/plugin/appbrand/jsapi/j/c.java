package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends a {
    public static final int CTRL_INDEX = 63;
    public static final String NAME = "reportKeyValue";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        if (jVar.iuk.isS == null) {
            x.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            jVar.E(i, e("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(Columns.VALUE);
                if (optInt > 0 && !bi.oN(optString)) {
                    g.pWK.h(optInt, jVar.mAppId, Integer.valueOf(r4.iRU.iJb), Integer.valueOf(r4.iRU.iJa + 1), optString);
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiReportKeyValue", "AppBrandService parse report value failed : %s", e.getMessage());
            }
        }
        jVar.E(i, e("ok", null));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            pVar.E(i, e("fail", null));
            return;
        }
        if (pVar.iuk.isS == null) {
            x.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            pVar.E(i, e("fail", null));
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString(Columns.VALUE);
                if (optInt > 0 && !bi.oN(optString)) {
                    g.pWK.h(optInt, pVar.mAppId, Integer.valueOf(r4.iRU.iJb), Integer.valueOf(r4.iRU.iJa + 1), optString);
                }
            } catch (Exception e) {
                x.e("MicroMsg.JsApiReportKeyValue", "AppBrandPageView parse report value failed : %s", e.getMessage());
            }
        }
        pVar.E(i, e("ok", null));
    }
}
