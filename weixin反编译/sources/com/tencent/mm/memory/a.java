package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.x;
import java.util.NavigableMap;

public abstract class a<T> extends e<T, Integer> {
    public synchronized T a(Integer num) {
        T t;
        NavigableMap subMap = this.hbE.subMap(num, true, Integer.valueOf(Integer.MAX_VALUE), true);
        if (!(subMap == null || subMap.isEmpty())) {
            for (Integer intValue : subMap.keySet()) {
                d dVar = (d) subMap.get(Integer.valueOf(intValue.intValue()));
                if (dVar.size() > 0) {
                    T pop = dVar.pop();
                    this.hbE.put(dVar.EA(), dVar);
                    t = pop;
                    break;
                }
            }
            t = null;
            if (t != null) {
                aJ(aN(t));
            }
        }
        t = null;
        return t;
    }

    public synchronized T b(Integer num) {
        T t;
        d dVar = (d) this.hbE.get(num);
        if (dVar == null || dVar.size() <= 0) {
            String str = "MicroMsg.BiggerThanPool";
            String str2 = "BiggerThanPool getExactSize cannot get %s size count %d";
            Object[] objArr = new Object[2];
            objArr[0] = num;
            int size = dVar == null ? -1 : dVar.hbC == null ? -1 : dVar.hbC.size();
            objArr[1] = Integer.valueOf(size);
            x.d(str, str2, objArr);
            t = null;
        } else {
            T pop = dVar.pop();
            this.hbE.put(dVar.EA(), dVar);
            aJ(aN(pop));
            t = pop;
        }
        return t;
    }
}
