package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 245;
    private static final String NAME = "reportPageData";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
        AppBrandStatObject pl = com.tencent.mm.plugin.appbrand.a.pl(jVar.mAppId);
        MainProcessTask reportTask = new ReportTask();
        if (appBrandSysConfig != null) {
            reportTask.appId = appBrandSysConfig.appId;
            reportTask.username = appBrandSysConfig.foe;
            reportTask.iNi = appBrandSysConfig.iRU.iJa;
            reportTask.fJh = appBrandSysConfig.iRU.iJb;
            reportTask.jkI = ab.aaa().iJb;
        }
        if (pl != null) {
            reportTask.scene = pl.scene;
            reportTask.fJn = pl.fJn;
        }
        p b = e.b(jVar);
        if (b != null) {
            reportTask.foj = b.getURL();
        }
        reportTask.jsl = jSONObject.toString();
        AppBrandMainProcessService.a(reportTask);
        jVar.E(i, e("ok", null));
    }
}
