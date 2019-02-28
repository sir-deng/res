package com.tencent.mm.plugin.address.b.a;

import com.tencent.mm.plugin.o.a.b;
import java.util.Iterator;

public final class a {
    public com.tencent.mm.plugin.o.a.a iok = new com.tencent.mm.plugin.o.a.a();

    public final b jj(int i) {
        Iterator it = this.iok.nHo.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.nHp == i) {
                return bVar;
            }
        }
        return null;
    }
}
