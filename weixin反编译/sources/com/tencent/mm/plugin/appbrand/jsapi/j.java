package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class j extends f {
    private static final int CTRL_INDEX = 153;
    private static final String NAME = "onNetworkStatusChange";
    private static j jfv;
    private static HashSet<String> jfw = new HashSet();

    public static synchronized void sA(String str) {
        synchronized (j.class) {
            jfw.add(str);
        }
    }

    public static synchronized void sB(String str) {
        synchronized (j.class) {
            jfw.remove(str);
        }
    }

    public static synchronized void onNetworkChange() {
        synchronized (j.class) {
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
            Iterator it = jfw.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (jfv == null) {
                    jfv = new j();
                }
                jfv.aA(str, 0).v(hashMap).afI();
            }
        }
    }
}
