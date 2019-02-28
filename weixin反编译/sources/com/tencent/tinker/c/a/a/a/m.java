package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.a.AnonymousClass3;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class m extends i<k> {
    private a Aqk = null;
    private e Aql = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cHw();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        k kVar = (k) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(kVar.data.length);
        new a(new AnonymousClass3(byteArrayOutputStream)).c(new com.tencent.tinker.a.a.m(kVar, 28));
        return new k(kVar.dzH, byteArrayOutputStream.toByteArray());
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        k kVar = (k) comparable;
        a aVar = this.Aqk;
        aVar.size++;
        return this.Aql.a(kVar);
    }

    public m(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Aqk = iVar2.Aof.AoQ;
            this.Aql = iVar2.a(this.Aqk);
        }
    }

    protected final a c(i iVar) {
        return iVar.Aof.AoQ;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.Arg.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Aru.IS(i2);
        }
    }
}
