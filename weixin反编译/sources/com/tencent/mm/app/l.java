package com.tencent.mm.app;

import java.util.HashSet;
import java.util.Set;

public final class l {
    private static final Set<String> ffV;

    static {
        Set hashSet = new HashSet();
        ffV = hashSet;
        hashSet.add(":nospace");
        ffV.add(":cuploader");
        ffV.add(":dexopt");
        ffV.add(":recovery");
        ffV.add(":fallback");
    }

    public static boolean ct(String str) {
        int indexOf = str.indexOf(58);
        return ffV.contains(indexOf != -1 ? str.substring(indexOf) : "");
    }

    public static boolean tZ() {
        return false;
    }
}
