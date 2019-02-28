package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.sdk.platformtools.bi;

public final class h {
    public static boolean rc(String str) {
        if (bi.oN(str)) {
            return false;
        }
        AppBrandSysConfig pk = a.pk(str);
        if (pk == null || pk.iRh || pk.iRU.iJa == 0) {
            return false;
        }
        return true;
    }
}
