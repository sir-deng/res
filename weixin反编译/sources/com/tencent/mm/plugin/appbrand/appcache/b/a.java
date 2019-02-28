package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.boj;
import com.tencent.mm.protocal.c.gk;
import com.tencent.mm.protocal.c.gl;
import com.tencent.mm.vending.g.g;
import java.util.List;

public final class a extends com.tencent.mm.ad.a<gl> {
    private final b gLB;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.a$2 */
    static class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, Boolean> {
        final /* synthetic */ Runnable iJr;

        public AnonymousClass2(Runnable runnable) {
            this.iJr = runnable;
        }

        public final /* synthetic */ Object call(Object obj) {
            this.iJr.run();
            g.cAI().cm(Boolean.valueOf(true));
            return zLb;
        }
    }

    /* synthetic */ a(List list, byte b) {
        this(list);
    }

    private a(List<boj> list) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a gkVar = new gk();
        gkVar.vSu.addAll(list);
        aVar.hnT = gkVar;
        aVar.hnU = new gl();
        aVar.hnS = 2763;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
        b Kf = aVar.Kf();
        this.gLB = Kf;
        this.gLB = Kf;
    }
}
