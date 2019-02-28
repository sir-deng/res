package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.c.bl;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;

public final class ak extends ad {
    public static void a(bl blVar) {
        if (blVar != null && !bi.cC(blVar.noc)) {
            Iterator it = blVar.noc.iterator();
            while (it.hasNext()) {
                ag agVar = (ag) it.next();
                if (agVar.nmp != null && agVar.nmp.nkO != null) {
                    d.a(ad.a(agVar.nmp.nkO));
                } else if (agVar.nmr != null && !bi.cC(agVar.nmr.nlu)) {
                    Iterator it2 = agVar.nmr.nlu.iterator();
                    while (it2.hasNext()) {
                        d.a(ad.a(((aa) it2.next()).nkO));
                    }
                } else if (!(agVar.nmq == null || agVar.nmq.nkO == null)) {
                    d.a(ad.a(agVar.nmq.nkO));
                }
            }
        }
    }
}
