package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i {
    private static final Map<String, WxaWidgetContext> iVu = new ConcurrentHashMap();

    public static boolean a(String str, WxaWidgetContext wxaWidgetContext) {
        if (bi.oN(str) || wxaWidgetContext == null) {
            return false;
        }
        iVu.put(str, wxaWidgetContext);
        return true;
    }

    public static WxaWidgetContext rK(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return (WxaWidgetContext) iVu.get(str);
    }

    public static WxaWidgetContext rL(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return (WxaWidgetContext) iVu.remove(str);
    }
}
