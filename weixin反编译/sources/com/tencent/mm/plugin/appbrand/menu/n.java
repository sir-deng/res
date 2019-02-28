package com.tencent.mm.plugin.appbrand.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n {
    public Map<Integer, com.tencent.mm.plugin.appbrand.menu.a.a> jGx;

    private static class a {
        public static n jGy = new n();
    }

    /* synthetic */ n(byte b) {
        this();
    }

    private n() {
        this.jGx = new HashMap();
        a(new b());
        a(new a());
        a(new d());
        a(new g());
        a(new MenuDelegate_SendToDesktop());
        a(new h());
        a(new j());
        a(new k());
        a(new MenuDelegate_EnableDebug());
        a(new i());
        a(new f());
        a(new e());
        a(new c());
    }

    public static l d(List<l> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (l lVar : list) {
            if (lVar != null && lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public static void a(List<l> list, int i, boolean z) {
        l lVar = new l(i);
        lVar.jGh = z;
        list.add(lVar);
    }

    private void a(com.tencent.mm.plugin.appbrand.menu.a.a aVar) {
        this.jGx.put(Integer.valueOf(aVar.jGz), aVar);
    }
}
