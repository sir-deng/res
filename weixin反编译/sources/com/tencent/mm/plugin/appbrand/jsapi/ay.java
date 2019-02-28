package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ay extends a {
    public static final int CTRL_INDEX = 66;
    public static final String NAME = "reportSubmitForm";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(pVar.mAppId);
        reportSubmitFormTask.type = 1;
        reportSubmitFormTask.jkD = System.currentTimeMillis();
        reportSubmitFormTask.fDk = pVar.afe();
        AppBrandMainProcessService.a(reportSubmitFormTask);
        Map hashMap = new HashMap();
        hashMap.put("formId", reportSubmitFormTask.jkD);
        i pF = i.pF(pVar.mAppId);
        if (pF != null) {
            pF.iud = reportSubmitFormTask.jkD;
        }
        pVar.E(i, e("ok", hashMap));
    }
}
