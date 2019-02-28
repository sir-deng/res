package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.protocal.c.ccu;
import com.tencent.mm.protocal.c.ccv;
import com.tencent.mm.protocal.c.cdg;
import com.tencent.mm.protocal.c.cdl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public class e extends a<Boolean, cdl> {
    final /* bridge */ /* synthetic */ cdg aY(Object obj) {
        return ((cdl) obj).xiG;
    }

    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        return a(str, str2, (cdl) obj);
    }

    private static Boolean a(String str, String str2, cdl cdl) {
        d dVar = null;
        String str3 = cdl.xiT;
        if (bi.oN(str3)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", str, str2);
            return Boolean.FALSE;
        }
        try {
            byte[] decode = Base64.decode(str3, 0);
            ccv ccv = new ccv();
            ccv.aH(decode);
            WxaAttributes f = com.tencent.mm.plugin.appbrand.app.e.Zs().f(str, "versionInfo");
            d acs = f == null ? null : f.acs();
            Iterator it = ccv.vTZ.iterator();
            while (it.hasNext()) {
                d rx;
                ccu ccu = (ccu) it.next();
                if ("WxaAppVersionInfo".equals(ccu.vUa)) {
                    rx = d.rx(ccu.pWq);
                } else {
                    rx = dVar;
                }
                dVar = rx;
            }
            int i;
            if (dVar == null) {
                i = a.iJQ;
                a.o((long) cdl.xiG.xiE, 87);
                return Boolean.FALSE;
            }
            boolean z;
            i = a.iJQ;
            a.o((long) cdl.xiG.xiE, 88);
            boolean z2 = acs == null || dVar == null || acs.fJh < dVar.fJh;
            if (z2) {
                boolean z3;
                com.tencent.mm.plugin.appbrand.app.e.Zs().a(str, ccv.vTY, ccv.vTZ);
                if (com.tencent.mm.plugin.appbrand.app.e.Zs().f(str, new String[0]) != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                int i2 = a.iJQ;
                a.o((long) cdl.xiG.xiE, z3 ? 85 : 86);
                z = z3;
            } else {
                i = a.iJQ;
                a.o((long) cdl.xiG.xiE, 84);
                z = false;
            }
            String str4 = "MicroMsg.AppBrand.Predownload.CmdIssueContact";
            String str5 = "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b";
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(acs == null ? -1 : acs.fJh);
            objArr[3] = Integer.valueOf(dVar == null ? -1 : dVar.fJh);
            objArr[4] = Boolean.valueOf(z2);
            objArr[5] = Boolean.valueOf(z);
            x.i(str4, str5, objArr);
            return Boolean.valueOf(z);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", e, "call[%s | %s], decode base64", str, str2);
            return Boolean.FALSE;
        }
    }

    final String aaC() {
        return "CmdIssueContact";
    }
}
