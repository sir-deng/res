package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class i extends c {
    public i(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.fEe = this.fEe;
        gVar.mRK = this;
        gVar.handler = agVar;
        gVar.mRI = hashSet;
        gVar.mRJ = com.tencent.mm.plugin.fts.a.c.c.mSl;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(5, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN)) {
            com.tencent.mm.plugin.fts.d.i.a aVar = new com.tencent.mm.plugin.fts.d.i.a();
            aVar.hMM = -5;
            aVar.mRM = hVar.mRM;
            aVar.mUI = hVar.mRN;
            this.mUm.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, com.tencent.mm.plugin.fts.d.i.a aVar) {
        int i2 = (i - aVar.mUE) - 1;
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mUI.size() && i2 >= 0) {
            j jVar = (j) aVar.mUI.get(i2);
            com.tencent.mm.plugin.fts.d.a.b jVar2 = new com.tencent.mm.plugin.search.ui.a.j(i);
            jVar2.iZi = jVar;
            jVar2.mRM = aVar.mRM;
            jVar2.cG(jVar.type, jVar.mRc);
            bVar = jVar2;
        }
        if (bVar != null) {
            bVar.mVl = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 4144;
    }
}
