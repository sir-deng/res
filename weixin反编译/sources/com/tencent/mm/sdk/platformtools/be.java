package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;

public final class be {
    private static final HashMap<String, String> xqD = new HashMap();

    public static String getProperty(String str) {
        return (String) xqD.get(str);
    }

    public static void setProperty(String str, String str2) {
        xqD.put(str, str2);
    }
}
