package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.a.a;
import java.util.HashMap;

public final class c extends a {
    private static String TAG = "MicroMsg.BackupItemFactory";
    private static c ksJ;
    private HashMap<Integer, l> ksK;

    public static c apX() {
        if (ksJ == null) {
            a cVar = new c();
            ksJ = cVar;
            a.a(cVar);
        }
        return ksJ;
    }

    public final void aoN() {
        ksJ = null;
    }

    public final l mZ(int i) {
        if (this.ksK == null) {
            this.ksK = new HashMap();
            this.ksK.put(Integer.valueOf(3), new d());
            this.ksK.put(Integer.valueOf(47), new b());
            this.ksK.put(Integer.valueOf(49), new a());
            this.ksK.put(Integer.valueOf(34), new g());
            f fVar = new f();
            this.ksK.put(Integer.valueOf(43), fVar);
            this.ksK.put(Integer.valueOf(44), fVar);
            this.ksK.put(Integer.valueOf(62), fVar);
            e eVar = new e();
            this.ksK.put(Integer.valueOf(48), eVar);
            this.ksK.put(Integer.valueOf(42), eVar);
            this.ksK.put(Integer.valueOf(66), eVar);
            this.ksK.put(Integer.valueOf(10000), eVar);
            this.ksK.put(Integer.valueOf(1), eVar);
            this.ksK.put(Integer.valueOf(37), eVar);
            this.ksK.put(Integer.valueOf(40), eVar);
            this.ksK.put(Integer.valueOf(50), eVar);
        }
        return (l) this.ksK.get(Integer.valueOf(i));
    }
}
