package com.tencent.mm.plugin.appbrand.dynamic.f;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.t.b.c;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends c {
    public d() {
        super("onNetworkStatusChange");
    }

    d(int i) {
        super("onNetworkStatusChange", i);
    }

    public final JSONObject sO() {
        HashMap hashMap = new HashMap();
        Context context = ad.getContext();
        boolean isConnected = ao.isConnected(context);
        hashMap.put("isConnected", Boolean.valueOf(isConnected));
        if (!isConnected) {
            hashMap.put("networkType", "none");
        } else if (ao.is2G(context)) {
            hashMap.put("networkType", "2g");
        } else if (ao.is3G(context)) {
            hashMap.put("networkType", "3g");
        } else if (ao.is4G(context)) {
            hashMap.put("networkType", "4g");
        } else if (ao.isWifi(context)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        return new JSONObject(hashMap);
    }
}
