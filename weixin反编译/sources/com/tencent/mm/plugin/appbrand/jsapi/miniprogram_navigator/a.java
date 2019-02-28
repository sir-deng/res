package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.sdk.platformtools.bi;

public enum a {
    RELEASE(0),
    DEVELOP(1),
    TRIAL(2);
    
    public final int iNi;

    private a(int i) {
        this.iNi = i;
    }

    public static a a(String str, a aVar) {
        if (bi.oN(str)) {
            return aVar;
        }
        for (a aVar2 : values()) {
            if (aVar2.name().toLowerCase().equals(str)) {
                return aVar2;
            }
        }
        return aVar;
    }
}
