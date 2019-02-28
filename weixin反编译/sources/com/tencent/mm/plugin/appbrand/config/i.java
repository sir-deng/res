package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.x;

public enum i {
    ;

    public static int rd(String str) {
        int i;
        WxaAttributes g = e.Zs().g(str, "dynamicInfo");
        String str2 = "MicroMsg.AppServiceSettingMMManager";
        String str3 = "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (g == null) {
            i = -1;
        } else {
            i = g.acr().iSK.iSM;
        }
        objArr[1] = Integer.valueOf(i);
        x.i(str2, str3, objArr);
        if (g != null) {
            i = g.acr().iSK.iSM;
        } else {
            i = 5;
        }
        return i * 1048576;
    }
}
