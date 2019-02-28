package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class b {
    private static HashMap<String, Integer> jMM = new HashMap();

    public static void aJ(String str, int i) {
        x.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: %s,serviceType:%d", str, Integer.valueOf(i));
        jMM.put(str, Integer.valueOf(i));
    }

    public static int uE(String str) {
        if (jMM.containsKey(str)) {
            x.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: %s");
            return ((Integer) jMM.get(str)).intValue();
        }
        x.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap default appId: %s");
        return 0;
    }
}
