package com.tencent.mm.plugin.soter.d;

import com.tencent.d.b.e.e;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class c implements a<Boolean, com.tencent.mm.vending.j.c<Boolean, Boolean>> {
    private b iiC = null;

    public final /* synthetic */ Object call(Object obj) {
        final com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
        x.v("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc call");
        if (((Boolean) cVar.get(0)).booleanValue()) {
            this.iiC = g.cAI();
            if (!com.tencent.d.b.a.cGP()) {
                return Boolean.valueOf(false);
            }
            e eVar = com.tencent.mm.kernel.g.Do().CF() ? new com.tencent.mm.plugin.soter.b.e() : new f();
            x.v("MicroMsg.SoterPrepareAskFunc", "alvinluo has ask: %b", Boolean.valueOf(com.tencent.d.a.a.cGE()));
            this.iiC.cAH();
            com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>() {
                public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                    com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                    x.i("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc onResult errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.foE);
                    if (cVar.isSuccess()) {
                        c.this.iiC.t(cVar.get(1));
                        return;
                    }
                    com.tencent.mm.plugin.soter.c.a.dQ(1, cVar.errCode);
                    c.this.iiC.cm(g.u(Integer.valueOf(cVar.errCode), cVar.foE));
                }
            }, false, eVar);
            x.v("MicroMsg.SoterPrepareAskFunc", "alvinluo prepareask isNeedSaveDeviceInfo: %b", cVar.get(1));
            return (Boolean) cVar.get(1);
        }
        x.i("MicroMsg.SoterPrepareAskFunc", "alvinluo not need prepare ask, return");
        return (Boolean) cVar.get(1);
    }
}
