package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.ccq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 108;
    public static final String NAME = "reportRealtimeAction";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        try {
            a(jVar.iuk, null, jSONObject);
            jVar.E(i, e("ok", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiReportRealtimeAction", "report by service(%s), e = %s", jVar.mAppId, e);
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        try {
            a(pVar.iuk, pVar, jSONObject);
            pVar.E(i, e("ok", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiReportRealtimeAction", "report by page(%s), e = %s", pVar.mAppId, e);
        }
    }

    private static void a(e eVar, p pVar, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.report.a.e.a h;
        int i;
        String optString = jSONObject.optString("actionData");
        ccq ccq = new ccq();
        ccq.kzz = 2;
        ccq.nlV = eVar.mAppId;
        ccq.pWg = 0;
        ccq.lUo = (int) bi.Wx();
        ccq.pWh = 0;
        ccq.xig = optString;
        ccq.xih = eVar.isS.iRU.iJa + 1;
        ccq.xij = com.tencent.mm.plugin.appbrand.report.a.cf(ad.getContext());
        ccq.xii = h.e(eVar).iub;
        AppBrandStatObject appBrandStatObject = eVar.itc;
        ccq.tsq = appBrandStatObject.scene;
        ccq.xil = appBrandStatObject.foi;
        ccq.fJn = appBrandStatObject.fJn;
        ccq.fJo = appBrandStatObject.fJo;
        ccq.xik = appBrandStatObject.jMN;
        com.tencent.mm.plugin.appbrand.report.a.e eVar2 = eVar.isX.jIP.jNc;
        if (pVar != null) {
            h = eVar2.h(pVar);
        } else {
            h = eVar2.akB();
        }
        ccq.xif = h.path;
        ccq.jNN = h.jNw == null ? null : h.jNw.path;
        if (eVar2.uH(h.path)) {
            i = 1;
        } else {
            i = 0;
        }
        ccq.jNS = i;
        x.i("MicroMsg.JsApiReportRealtimeAction", "report(%s), path %s, appState %d, sessionId %s, scene %d, sceneNote %s, preScene %d, preSceneNote %s, usedState %d, referPath %s, isEntrance %d", eVar.mAppId, ccq.xif, Integer.valueOf(ccq.xih), ccq.xii, Integer.valueOf(ccq.tsq), ccq.xil, Integer.valueOf(ccq.fJn), ccq.fJo, Integer.valueOf(ccq.xik), ccq.jNN, Integer.valueOf(ccq.jNS));
        AppBrandIDKeyBatchReport.a(ccq);
    }
}
