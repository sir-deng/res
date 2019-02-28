package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.a.f;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class g extends c {
    public g(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
        gVar.fEe = this.fEe;
        gVar.mRJ = d.mSm;
        gVar.mRK = this;
        gVar.handler = agVar;
        gVar.mRI = hashSet;
        gVar.mRJ = h.jbn;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(10, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN)) {
            i.a aVar = new i.a();
            aVar.hMM = -15;
            aVar.mUI = hVar.mRN;
            aVar.mRM = hVar.mRM;
            for (j jVar : hVar.mRN) {
                hashSet.add(jVar.mRd);
            }
            if (aVar.mUI.size() > 3) {
                aVar.mUH = true;
                aVar.mUI = aVar.mUI.subList(0, 3);
            }
            this.mUm.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2 = (i - aVar.mUE) - 1;
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mUI.size() && i2 >= 0) {
            j jVar = (j) aVar.mUI.get(i2);
            com.tencent.mm.plugin.fts.d.a.b cVar = new c(i);
            cVar.iZi = jVar;
            cVar.mRM = aVar.mRM;
            cVar.cG(jVar.type, jVar.mRc);
            bVar = cVar;
        }
        if (bVar != null) {
            bVar.mVl = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }
}
