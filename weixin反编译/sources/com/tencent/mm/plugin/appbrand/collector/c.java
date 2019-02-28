package com.tencent.mm.plugin.appbrand.collector;

import java.util.HashSet;
import java.util.Set;

public final class c {
    private static b iOP = new h();
    private static boolean iOQ;
    private static final Set<String> iOR = new HashSet();

    public static void qK(String str) {
        if (str.length() != 0) {
            iOR.add(str);
        }
    }

    public static void qL(String str) {
        if (str.length() != 0) {
            iOR.remove(str);
        }
    }

    public static boolean qM(String str) {
        if (str.length() == 0) {
            return false;
        }
        return iOR.contains(str);
    }

    public static void cu(boolean z) {
        iOQ = z;
    }

    public static boolean abG() {
        return iOQ;
    }

    private static boolean qN(String str) {
        return iOQ && iOR.contains(str);
    }

    private static boolean qO(String str) {
        if (!iOQ) {
            return false;
        }
        CollectSession qH = iOP.qH(str);
        if (qH == null || !iOR.contains(qH.groupId)) {
            return false;
        }
        return true;
    }

    public static void clear() {
        if (iOQ) {
            iOP.clear();
        }
    }

    public static void c(String str, String str2, String str3, boolean z) {
        if (qN(str)) {
            iOP.c(str, str2, str3, z);
        }
    }

    public static void aV(String str, String str2) {
        if (qO(str)) {
            iOP.aV(str, str2);
        }
    }

    public static void a(CollectSession collectSession) {
        if (collectSession != null && qN(collectSession.groupId)) {
            iOP.a(collectSession);
        }
    }

    public static CollectSession aU(String str, String str2) {
        if (qO(str)) {
            return iOP.aU(str, str2);
        }
        return null;
    }

    public static void f(String str, String str2, boolean z) {
        if (qO(str)) {
            iOP.f(str, str2, z);
        }
    }

    public static CollectSession qH(String str) {
        if (qO(str)) {
            return iOP.qH(str);
        }
        return null;
    }

    public static CollectSession qI(String str) {
        if (iOQ) {
            return iOP.qI(str);
        }
        return null;
    }

    public static void print(String str) {
        if (qO(str)) {
            iOP.print(str);
        }
    }

    public static int aW(String str, String str2) {
        if (qN(str)) {
            return iOP.aW(str, str2);
        }
        return 0;
    }

    public static StringBuilder qJ(String str) {
        if (qN(str)) {
            return iOP.qJ(str);
        }
        return new StringBuilder();
    }
}
