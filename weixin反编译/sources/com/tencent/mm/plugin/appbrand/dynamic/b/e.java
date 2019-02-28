package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e iWc;
    private Map<String, SoftReference<WxaPkgWrappingInfo>> gOF = new ConcurrentHashMap();

    private static e adk() {
        if (iWc == null) {
            synchronized (e.class) {
                if (iWc == null) {
                    iWc = new e();
                }
            }
        }
        return iWc;
    }

    private e() {
    }

    public static boolean a(String str, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (str == null || str.length() == 0 || wxaPkgWrappingInfo == null) {
            return false;
        }
        adk().gOF.put(str, new SoftReference(wxaPkgWrappingInfo));
        return true;
    }

    public static WxaPkgWrappingInfo rM(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        SoftReference softReference = (SoftReference) adk().gOF.get(str);
        return softReference != null ? (WxaPkgWrappingInfo) softReference.get() : null;
    }

    public static void removeAll() {
        adk().gOF.clear();
    }
}
