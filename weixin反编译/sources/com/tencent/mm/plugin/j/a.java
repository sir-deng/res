package com.tencent.mm.plugin.j;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.protocal.c.jx;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.p;

public final class a extends p implements com.tencent.mm.plugin.auth.a.a {
    private static a lex;

    private a() {
        super(g.class);
    }

    public static synchronized a aya() {
        a aVar;
        synchronized (a.class) {
            if (lex == null) {
                lex = new a();
            }
            aVar = lex;
        }
        return aVar;
    }

    public final void a(f fVar, i.g gVar, boolean z) {
    }

    public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
        if (bVar.vIF.lTO != 0) {
            final jx jxVar = bVar.vIF.vZH;
            final jx jxVar2 = bVar.vIF.vZI;
            final jx jxVar3 = bVar.vIF.vZJ;
            ah.y(new Runnable() {
                public final void run() {
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    long j = -1;
                    g.MM();
                    if (!(g.MO() == null || jxVar == null)) {
                        g.MM();
                        g.MO().a(jxVar, jxVar2, jxVar3);
                        j = aVar.zp();
                    }
                    x.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", Long.valueOf(aVar.zp()), Long.valueOf(j));
                }
            });
        }
    }
}
