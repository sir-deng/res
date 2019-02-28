package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;

public final class o extends i<Integer> {
    private a Aqq = null;
    private e Aqr = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return Integer.valueOf(aVar.aif.getInt());
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        return Integer.valueOf(aVar.IV(((Integer) comparable).intValue()));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        Integer num = (Integer) comparable;
        int position = this.Aqr.aif.position();
        this.Aqr.writeInt(num.intValue());
        a aVar = this.Aqq;
        aVar.size++;
        return position;
    }

    public o(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Aqq = iVar2.Aof.AoC;
            this.Aqr = iVar2.a(this.Aqq);
        }
    }

    protected final a c(i iVar) {
        return iVar.Aof.AoC;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            cVar.AqX.put(i, i3);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i >= 0) {
            cVar.Arl.IS(i);
        }
    }
}
