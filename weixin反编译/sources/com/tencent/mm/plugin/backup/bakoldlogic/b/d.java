package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.a.a;
import java.util.HashMap;

public final class d extends a {
    private static String TAG = "MicroMsg.BakOldItemFactory";
    private static d kvX;
    private HashMap<Integer, k> ksK;

    public static d aqR() {
        if (kvX == null) {
            a dVar = new d();
            kvX = dVar;
            a.a(dVar);
        }
        return kvX;
    }

    public final void aoN() {
        kvX = null;
    }

    public final k ni(int i) {
        if (this.ksK == null) {
            this.ksK = new HashMap();
            this.ksK.put(Integer.valueOf(3), new e());
            this.ksK.put(Integer.valueOf(47), new c());
            this.ksK.put(Integer.valueOf(49), new b());
            this.ksK.put(Integer.valueOf(34), new h());
            g gVar = new g();
            this.ksK.put(Integer.valueOf(43), gVar);
            this.ksK.put(Integer.valueOf(44), gVar);
            this.ksK.put(Integer.valueOf(62), gVar);
            f fVar = new f();
            this.ksK.put(Integer.valueOf(48), fVar);
            this.ksK.put(Integer.valueOf(42), fVar);
            this.ksK.put(Integer.valueOf(66), fVar);
            this.ksK.put(Integer.valueOf(10000), fVar);
            this.ksK.put(Integer.valueOf(1), fVar);
            this.ksK.put(Integer.valueOf(37), fVar);
            this.ksK.put(Integer.valueOf(40), fVar);
            this.ksK.put(Integer.valueOf(50), fVar);
        }
        return (k) this.ksK.get(Integer.valueOf(i));
    }
}
