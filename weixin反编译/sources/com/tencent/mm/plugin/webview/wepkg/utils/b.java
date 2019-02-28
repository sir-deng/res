package com.tencent.mm.plugin.webview.wepkg.utils;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.webview.wepkg.model.f;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public static final String OBJECT_ROOT_DIR_PATH;
    public static final Set<Integer> tUs = new HashSet();
    public static a tUt = new a();
    public static boolean tUu = false;

    public static class a {
        public final Map<String, f> tUv = new ConcurrentHashMap();

        public final f QS(String str) {
            if (bi.oN(str)) {
                return null;
            }
            return (f) this.tUv.get(str);
        }

        public final f QT(String str) {
            return (f) this.tUv.remove(str);
        }
    }

    static {
        String str = e.bnF;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        OBJECT_ROOT_DIR_PATH = str + "wepkg/pkgfiles/";
    }
}
