package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends k {

    /* renamed from: com.tencent.mm.plugin.game.model.l$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ LinkedList nhs;

        AnonymousClass1(LinkedList linkedList) {
            this.nhs = linkedList;
        }

        public final void run() {
            LinkedList linkedList = new LinkedList();
            Iterator it = this.nhs.iterator();
            while (it.hasNext()) {
                Iterator it2 = k.n(((l) it.next()).optJSONArray("items")).iterator();
                while (it2.hasNext()) {
                    d dVar = (d) it2.next();
                    if (!bi.oN(dVar.field_appId)) {
                        linkedList.add(dVar.field_appId);
                    }
                }
            }
            it = c.aSB().iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!linkedList.contains(fVar.field_appId)) {
                    an.biT().b(fVar, new String[0]);
                    x.i("MicroMsg.GameDataSearchGameList", "delete appid : " + fVar.field_appId);
                }
            }
        }
    }

    protected l(String str) {
        super(str);
    }

    public final void aQM() {
        LinkedList n = k.n(optJSONArray("items"));
        Iterator it = n.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            dVar.cP(dVar.ngz);
        }
        d.V(n);
    }
}
