package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ad.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.ajh;
import com.tencent.mm.protocal.c.aji;
import com.tencent.mm.protocal.c.ccn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.w.a;
import java.util.List;

public enum m {
    ;
    
    public static Integer iNa;

    static {
        iNa = null;
    }

    static void a(int i, int i2, int i3, b bVar) {
        if (bVar != null && (((ajh) bVar.hnQ.hnY).condition & 2) != 0) {
            aji aji = (aji) bVar.hnR.hnY;
            if (i2 == 0 && i3 == 0 && aji != null) {
                if (e.Zy() != null) {
                    l Zy = e.Zy();
                    List<ccn> list = aji.wxC;
                    long dA = Zy.iIR.dA(Thread.currentThread().getId());
                    Zy.iIR.delete("AppBrandStarApp", "", null);
                    a aVar = new a();
                    for (ccn ccn : list) {
                        if (!bi.oN(ccn.username)) {
                            aVar.field_username = ccn.username;
                            aVar.field_versionType = ccn.vVl;
                            aVar.field_updateTime = (long) ccn.wbg;
                            Zy.iIR.insert("AppBrandStarApp", null, aVar.vP());
                        }
                    }
                    Zy.iIR.fT(dA);
                    Zy.b("batch", 3, list);
                    n.a(i, null, aji.wxC);
                }
                g.Dq().Db().a(a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN, Boolean.valueOf((aji.status & 1) > 0));
            }
        }
    }
}
