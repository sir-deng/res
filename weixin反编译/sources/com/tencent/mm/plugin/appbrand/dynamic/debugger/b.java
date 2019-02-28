package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import com.tencent.mm.modelappbrand.h.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final Map<String, List<a>> gOD = new ConcurrentHashMap();
    private static final Map<String, DebuggerInfo> iWj = new ConcurrentHashMap();

    public static DebuggerInfo rN(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (DebuggerInfo) iWj.get(str);
    }

    public static void a(String str, DebuggerInfo debuggerInfo) {
        if (str != null && str.length() != 0) {
            iWj.put(str, debuggerInfo);
        }
    }

    public static boolean c(String str, a aVar) {
        if (bi.oN(str) || aVar == null) {
            return false;
        }
        List list = (List) gOD.get(str);
        if (list == null) {
            list = new LinkedList();
            gOD.put(str, list);
        } else if (list.contains(aVar)) {
            return true;
        }
        return list.add(aVar);
    }

    public static boolean d(String str, a aVar) {
        if (bi.oN(str) || aVar == null) {
            return false;
        }
        List list = (List) gOD.get(str);
        if (list == null) {
            return false;
        }
        boolean remove = list.remove(aVar);
        if (list.isEmpty()) {
            gOD.remove(str);
        }
        return remove;
    }

    public static void B(String str, int i) {
        if (!bi.oN(str)) {
            List list = (List) gOD.get(str);
            if (list != null) {
                for (a hj : new LinkedList(list)) {
                    hj.hj(i);
                }
            }
        }
    }
}
