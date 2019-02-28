package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.d.d;
import com.tencent.mm.plugin.appbrand.launching.f;
import com.tencent.mm.protocal.c.cdg;
import com.tencent.mm.protocal.c.cdj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class c extends a<Boolean, cdj> {
    final /* bridge */ /* synthetic */ cdg aY(Object obj) {
        return ((cdj) obj).xiG;
    }

    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z = true;
        cdj cdj = (cdj) obj;
        if (bi.oN(str2)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode nil appId");
            return Boolean.FALSE;
        } else if (bi.oN(cdj.wgP)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode(%s | %s), nil md5", str, str2);
            return Boolean.FALSE;
        } else {
            WxaPkgWrappingInfo aF = f.aF(str2, 0);
            int i;
            if (aF != null && aF.iJb >= cdj.vTR) {
                x.i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call, localUsage(%d) ok, cmd_appId(%s), cmd_version(%d)", Integer.valueOf(aF.iJb), str2, Integer.valueOf(cdj.vTR));
                i = a.iJQ;
                a.o((long) cdj.xiG.xiE, 44);
                return Boolean.FALSE;
            } else if (!cdj.xiS || ((com.tencent.mm.plugin.appbrand.appcache.x) e.u(com.tencent.mm.plugin.appbrand.appcache.x.class)).o(str2, 1, cdj.vTR) == null) {
                com.tencent.mm.sdk.e.c cVar;
                d dVar = (d) e.u(d.class);
                if (bi.oN(str2) || cdj == null) {
                    cVar = null;
                } else {
                    com.tencent.mm.sdk.e.c cVar2 = new com.tencent.mm.plugin.appbrand.appcache.b.d.c();
                    cVar2.field_appId = str2;
                    cVar2.field_version = cdj.vTR;
                    cVar2.field_type = cdj.xiS ? 1 : 0;
                    boolean b = dVar.b(cVar2, new String[0]);
                    cVar2.field_firstTimeTried = false;
                    cVar2.field_lastRetryTime = 0;
                    cVar2.field_retriedCount = 0;
                    cVar2.field_retryTimes = cdj.wQO;
                    cVar2.field_retryInterval = (long) cdj.wQQ;
                    cVar2.field_networkType = cdj.xiR;
                    cVar2.field_pkgMd5 = cdj.wgP;
                    cVar2.field_reportId = cdj.xiG.xiE;
                    cVar = b ? dVar.c(cVar2, new String[0]) : dVar.b(cVar2) ? cVar2 : null;
                }
                String str3 = "MicroMsg.AppBrand.Predownload.CmdGetCode";
                String str4 = "getCode, writeCmd %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(cVar != null);
                x.i(str3, str4, objArr);
                if (cVar == null) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else {
                x.i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call IsEncrypt=true, encryptPkg ok, cmd_appId(%s), cmd_version(%d)", str2, Integer.valueOf(cdj.vTR));
                i = a.iJQ;
                a.o((long) cdj.xiG.xiE, 45);
                return Boolean.FALSE;
            }
        }
    }

    final String aaC() {
        return "CmdGetCode";
    }
}
