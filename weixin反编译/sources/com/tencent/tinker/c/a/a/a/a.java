package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.c.a.c.a.AnonymousClass4;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class a extends i<com.tencent.tinker.a.a.a> {
    private com.tencent.tinker.a.a.t.a ApO = null;
    private e ApP = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cHs();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.a aVar2 = (com.tencent.tinker.a.a.a) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(aVar2.Ans.data.length);
        new a(new AnonymousClass4(byteArrayOutputStream)).b(new m(aVar2.Ans, 29));
        return new com.tencent.tinker.a.a.a(aVar2.dzH, aVar2.Anr, new k(aVar2.Ans.dzH, byteArrayOutputStream.toByteArray()));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.a aVar = (com.tencent.tinker.a.a.a) comparable;
        com.tencent.tinker.a.a.t.a aVar2 = this.ApO;
        aVar2.size++;
        return this.ApP.a(aVar);
    }

    public a(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ApO = iVar2.Aof.AoP;
            this.ApP = iVar2.a(this.ApO);
        }
    }

    protected final com.tencent.tinker.a.a.t.a c(i iVar) {
        return iVar.Aof.AoP;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.Arc.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Arq.IS(i2);
        }
    }
}
