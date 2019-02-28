package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d implements e {
    public Map<Integer, Set<t>> hoJ = new HashMap();

    public d() {
        g.Dp().gRu.a(452, (e) this);
    }

    public final void a(int i, t tVar) {
        if (!this.hoJ.containsKey(Integer.valueOf(i))) {
            this.hoJ.put(Integer.valueOf(i), new HashSet());
        }
        if (!((Set) this.hoJ.get(Integer.valueOf(i))).contains(tVar)) {
            ((Set) this.hoJ.get(Integer.valueOf(i))).add(tVar);
        }
    }

    public final void b(int i, t tVar) {
        if (this.hoJ.get(Integer.valueOf(i)) != null) {
            ((Set) this.hoJ.get(Integer.valueOf(i))).remove(tVar);
        }
    }

    public static void a(int i, w wVar) {
        g.Dp().gRu.a(new x(i, wVar), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x xVar = (x) kVar;
        Set set = (Set) this.hoJ.get(Integer.valueOf(xVar.vlk));
        if (set != null && set.size() > 0) {
            Set<t> hashSet = new HashSet();
            hashSet.addAll(set);
            for (t tVar : hashSet) {
                if (tVar != null && set.contains(tVar)) {
                    tVar.a(i, i2, str, xVar.vll);
                }
            }
        }
    }
}
