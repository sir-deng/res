package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.d.e;
import com.tencent.mm.protocal.c.aon;
import com.tencent.mm.protocal.c.cdg;
import com.tencent.mm.protocal.c.cdn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class g extends a<Boolean, cdn> {
    final /* bridge */ /* synthetic */ cdg aY(Object obj) {
        return ((cdn) obj).xiG;
    }

    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        return a(str, str2, (cdn) obj);
    }

    private static Boolean a(String str, String str2, cdn cdn) {
        String str3 = cdn.xiV;
        if (bi.oN(str3)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", str, str2);
            return Boolean.FALSE;
        } else if (bi.cC(cdn.xbK)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", str, str2);
            return Boolean.FALSE;
        } else {
            try {
                byte[] decode = Base64.decode(str3, 0);
                aon aon = new aon();
                aon.aH(decode);
                int i;
                if (aon.wCh.wcZ.oz.length == 0) {
                    x.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", str, str2);
                    i = a.iJQ;
                    a.o((long) cdn.xiG.xiE, 105);
                    return Boolean.FALSE;
                }
                i = a.iJQ;
                a.o((long) cdn.xiG.xiE, 104);
                List<Object> list = cdn.xbK;
                long j = ((long) cdn.xiW) & 4294967295L;
                long j2 = ((long) cdn.xiX) & 4294967295L;
                String str4 = "MicroMsg.AppBrand.Predownload.CmdIssueLaunch";
                String str5 = "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                if (list == null) {
                    str3 = "null";
                } else if (bi.cC(list)) {
                    str3 = "{}";
                } else {
                    StringBuilder stringBuilder = new StringBuilder("{");
                    for (Object obj : list) {
                        stringBuilder.append(obj.toString()).append(',');
                    }
                    stringBuilder.append("}");
                    str3 = stringBuilder.toString();
                }
                objArr[2] = str3;
                objArr[3] = Long.valueOf(j);
                objArr[4] = Long.valueOf(j2);
                x.i(str4, str5, objArr);
                boolean a = ((e) com.tencent.mm.plugin.appbrand.app.e.u(e.class)).a(decode, str2, list, j, j2);
                i = a.iJQ;
                a.o((long) cdn.xiG.xiE, a ? 107 : 108);
                return Boolean.valueOf(a);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", e, "call[%s | %s], decode base64", str, str2);
                return Boolean.FALSE;
            }
        }
    }

    final String aaC() {
        return "CmdIssueLaunch";
    }
}
