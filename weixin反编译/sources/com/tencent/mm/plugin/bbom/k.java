package com.tencent.mm.plugin.bbom;

import com.tencent.mm.bp.a;
import com.tencent.mm.f.a.jy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ak.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public final class k implements q<bx> {
    public final /* synthetic */ void e(a aVar) {
        final String a = n.a(((bx) aVar).vNM);
        if (s.eX(a)) {
            as.Hm();
            final com.tencent.mm.storage.q hH = c.Fo().hH(a);
            as.Hm();
            com.tencent.mm.k.a Xv = c.Ff().Xv(a);
            if (Xv == null || ((int) Xv.gKO) <= 0) {
                ak.a.hhv.a(a, null, new b.a() {
                    public final void v(String str, boolean z) {
                        if (hH != null && hH.ciE()) {
                            com.tencent.mm.sdk.b.b jyVar = new jy();
                            jyVar.fBT.chatroomName = a;
                            jyVar.fBT.fBU = hH.ciD();
                            com.tencent.mm.sdk.b.a.xmy.m(jyVar);
                        }
                    }
                });
            } else if (hH.ciE()) {
                com.tencent.mm.sdk.b.b jyVar = new jy();
                jyVar.fBT.chatroomName = a;
                jyVar.fBT.fBU = hH.ciD();
                com.tencent.mm.sdk.b.a.xmy.m(jyVar);
            }
        }
    }

    public final /* synthetic */ void f(a aVar) {
        String a = n.a(((bx) aVar).vNM);
        if (!bi.oN(a) && !((h) g.h(h.class)).Ff().Xx(a)) {
            ak.a.hhv.Q(a, "");
        }
    }
}
