package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import java.util.HashMap;

public final class a {
    private static HashMap<Integer, d> ndr = new HashMap();

    public static void a(d dVar) {
        ndr.put(Integer.valueOf(dVar.hashCode()), dVar);
    }

    public static void b(d dVar) {
        ndr.remove(Integer.valueOf(dVar.hashCode()));
    }

    public static d qX(int i) {
        return (d) ndr.get(Integer.valueOf(i));
    }

    public static void cleanup() {
        ndr.clear();
    }
}
