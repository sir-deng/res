package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.sdk.platformtools.x;

public enum j {
    ;

    public static long re(String str) {
        long j;
        AppBrandSysConfig pk = a.pk(str);
        String str2 = "MicroMsg.AppServiceSettingRemoteManager";
        String str3 = "getMaxFileStorageSize, (null == config) = %b, MaxFileStorageSize = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(pk == null);
        objArr[1] = Long.valueOf(pk == null ? -1 : pk.iRI);
        x.i(str2, str3, objArr);
        if (pk == null || pk.iRI <= 0) {
            j = 10;
        } else {
            j = pk.iRI;
        }
        return j * 1048576;
    }
}
