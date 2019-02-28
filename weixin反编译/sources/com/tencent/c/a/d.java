package com.tencent.c.a;

import com.tencent.c.e.a.b.a;
import com.tencent.c.e.a.c;

public final class d {

    /* renamed from: com.tencent.c.a.d$1 */
    static class AnonymousClass1 implements c {
        final /* synthetic */ b Abg;
        final /* synthetic */ com.tencent.c.b.c Abh;

        public AnonymousClass1(b bVar, com.tencent.c.b.c cVar) {
            this.Abg = bVar;
            this.Abh = cVar;
        }

        public final void Yw() {
            this.Abg.m(-10, new byte[0]);
        }

        public final com.tencent.c.e.a.b.d a(String str, String str2, a aVar) {
            boolean a = d.a(this.Abh, this.Abg, str, str2, aVar);
            com.tencent.c.e.a.b.d dVar = new com.tencent.c.e.a.b.d();
            if (!a) {
                dVar.errorCode = -1;
            }
            return dVar;
        }

        public final com.tencent.c.e.a.b.c b(String str, String str2, a aVar) {
            boolean a = d.a(this.Abh, this.Abg, str, str2, aVar);
            com.tencent.c.e.a.b.c cVar = new com.tencent.c.e.a.b.c();
            if (!a) {
                cVar.errCode = -1;
            }
            return cVar;
        }
    }

    static /* synthetic */ boolean a(com.tencent.c.b.c cVar, b bVar, String str, String str2, a aVar) {
        byte[] c = cVar.c(str, str2, aVar);
        if (c != null && c.length != 0) {
            return bVar.m(0, c);
        }
        bVar.m(-20, new byte[0]);
        return false;
    }
}
