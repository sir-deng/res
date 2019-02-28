package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static Map<String, a> isu = new HashMap();
    private static Map<String, c> isv = new HashMap();
    private static Map<String, Set<b>> isw = new ConcurrentHashMap();

    public enum a {
        INIT,
        ON_CREATE,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY
    }

    public static class b {
        public void onCreate() {
        }

        public void onDestroy() {
        }

        public void a(c cVar) {
        }

        public void onResume() {
        }
    }

    public enum c {
        CLOSE,
        BACK,
        HIDE,
        HANG,
        HOME_PRESSED,
        LAUNCH_NATIVE_PAGE,
        LAUNCH_MINI_PROGRAM
    }

    public static void a(String str, b bVar) {
        if (str != null && bVar != null) {
            if (!isw.containsKey(str)) {
                isw.put(str, Collections.newSetFromMap(new ConcurrentHashMap()));
            }
            ((Set) isw.get(str)).add(bVar);
        }
    }

    private static Iterator<b> po(String str) {
        Object str2;
        Map map = isw;
        if (str2 == null) {
            str2 = "";
        }
        Set set = (Set) map.get(str2);
        if (set == null) {
            set = new HashSet();
        }
        return set.iterator();
    }

    public static void pp(String str) {
        Iterator po = po(str);
        while (po.hasNext()) {
            ((b) po.next()).onCreate();
        }
    }

    public static void pq(String str) {
        Iterator po = po(str);
        while (po.hasNext()) {
            ((b) po.next()).onDestroy();
        }
    }

    public static void pr(String str) {
        Iterator po = po(str);
        while (po.hasNext()) {
            ((b) po.next()).a(px(str));
        }
    }

    public static void pt(String str) {
        Iterator po = po(str);
        while (po.hasNext()) {
            ((b) po.next()).onResume();
        }
    }

    public static void pu(String str) {
        Iterator po = po(str);
        while (po.hasNext()) {
            po.next();
        }
    }

    public static void b(String str, b bVar) {
        if (bVar != null) {
            Set set = (Set) isw.get(str);
            if (set != null && !set.isEmpty()) {
                set.remove(bVar);
            }
        }
    }

    public static void pv(String str) {
        isw.remove(str);
    }

    public static void pw(String str) {
        a(str, c.HIDE);
    }

    public static c px(String str) {
        c cVar = (c) isv.get(str);
        if (cVar == null) {
            return c.HIDE;
        }
        return cVar;
    }

    public static void a(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            isv.put(str, cVar);
        }
    }

    public static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            isu.put(str, aVar);
        }
    }

    public static a py(String str) {
        a aVar = (a) isu.get(str);
        if (aVar == null) {
            return a.INIT;
        }
        return aVar;
    }
}
