package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.aq.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.x;

abstract class o implements a {
    final int iNi;

    abstract String aiC();

    abstract void c(WxaPkgWrappingInfo wxaPkgWrappingInfo);

    public final /* synthetic */ void a(String str, b.a.a aVar, Object obj) {
        aq.b bVar = (aq.b) obj;
        x.i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, appId = %s, return = %s", aiC(), str, aVar.name());
        if (b.a.a.OK.equals(aVar)) {
            WxaPkgWrappingInfo qh = WxaPkgWrappingInfo.qh(bVar.filePath);
            if (qh == null) {
                x.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, ret=OK but obtain null appPkgInfo");
            } else {
                qh.iJb = bVar.version;
                qh.iJc = c.amp();
                qh.iJa = bVar.iIZ;
            }
            c(qh);
            return;
        }
        if (b.a.a.SEVER_FILE_NOT_FOUND.equals(aVar)) {
            y.lh(j.iDu);
            com.tencent.mm.plugin.appbrand.report.a.C(str, 23, this.iNi + 1);
        } else {
            y.tF(c.getMMString(j.iDr, Integer.valueOf(2), Integer.valueOf(aVar.code)));
        }
        c(null);
    }

    o(int i) {
        this.iNi = i;
    }
}
