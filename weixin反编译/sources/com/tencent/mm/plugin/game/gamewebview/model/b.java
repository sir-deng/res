package com.tencent.mm.plugin.game.gamewebview.model;

import java.util.HashMap;

public final class b {
    private static HashMap<String, String> nds = new HashMap();

    public static void cN(String str, String str2) {
        nds.put(str, str2);
    }

    public static String Cl(String str) {
        return (String) nds.get(str);
    }

    public static void Cm(String str) {
        nds.remove(str);
    }
}
