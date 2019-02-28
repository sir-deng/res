package com.tencent.mm.plugin.d;

import com.tencent.mm.bx.h;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.storage.g;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.a, e, c {
    private static final HashMap<Integer, d> gyG;
    private static a iqN;
    private g iqO;

    private a() {
    }

    public static synchronized a Yf() {
        a aVar;
        synchronized (a.class) {
            if (iqN == null) {
                iqN = new a();
            }
            aVar = iqN;
        }
        return aVar;
    }

    public final g FP() {
        com.tencent.mm.kernel.g.Do().CA();
        return this.iqO;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        this.iqO = new g(hVar);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        return gyG;
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new d() {
            public final String[] wn() {
                return g.gLy;
            }
        });
    }
}
