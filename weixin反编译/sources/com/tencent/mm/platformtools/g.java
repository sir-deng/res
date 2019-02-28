package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.mm.bx.h;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.b;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g {
    private static ConcurrentHashMap<Integer, a> iev = new ConcurrentHashMap();

    public static final class a extends h {
        public final boolean iew;
        SparseBooleanArray iex = new SparseBooleanArray();
        private final String path;

        public a(String str, boolean z) {
            x.d("MicroMsg.GeneralDBHelper", "create db %s", str);
            this.iew = z;
            this.path = str;
        }

        public final void iY(int i) {
            x.d("MicroMsg.GeneralDBHelper", "try close db %d", Integer.valueOf(i));
            this.iex.delete(i);
            if (this.iex.size() <= 0) {
                x.d("MicroMsg.GeneralDBHelper", "close db %d succ", Integer.valueOf(i));
                super.EZ();
                g.iev.remove(Integer.valueOf(this.path.hashCode()));
            }
        }

        @Deprecated
        public final void EZ() {
            x.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", bi.chl());
            if (this.iex.size() <= 1) {
                super.EZ();
            }
        }

        @Deprecated
        public final void ed(String str) {
            x.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
            if (this.iex.size() <= 1) {
                super.ed(str);
            }
        }
    }

    public static final a a(int i, String str, HashMap<Integer, d> hashMap, boolean z) {
        boolean z2 = (bi.oN(str) || hashMap == null) ? false : true;
        Assert.assertTrue(z2);
        int hashCode = str.hashCode();
        a aVar = (a) iev.get(Integer.valueOf(hashCode));
        if (aVar == null) {
            aVar = new a(str, z);
            if (z) {
                com.tencent.mm.kernel.g.Do();
                if (!aVar.a("", str, "", (long) com.tencent.mm.kernel.a.Cn(), q.yL(), hashMap, true)) {
                    throw new b((byte) 0);
                }
            } else if (!aVar.b(str, hashMap, true, false)) {
                throw new b((byte) 0);
            }
            iev.put(Integer.valueOf(hashCode), aVar);
        } else {
            Assert.assertTrue(z == aVar.iew);
            long dA = aVar.dA(-1);
            for (d wn : hashMap.values()) {
                for (String str2 : wn.wn()) {
                    x.d("MicroMsg.GeneralDBHelper", "init sql:" + str2);
                    try {
                        aVar.fD(null, str2);
                    } catch (Exception e) {
                        Assert.assertTrue("CreateTable failed:[" + str2 + "][" + e.getMessage() + "]", false);
                    }
                }
            }
            aVar.fT(dA);
        }
        x.d("MicroMsg.GeneralDBHelper", "addRef %d", Integer.valueOf(i));
        aVar.iex.put(i, true);
        return aVar;
    }
}
