package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class c extends com.tencent.mm.plugin.fts.d.c {
    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mRC = 2;
        gVar.fEe = this.fEe;
        gVar.mRI = hashSet;
        gVar.handler = agVar;
        gVar.mRK = this;
        gVar.mRJ = d.mSm;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(6, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN)) {
            i.a aVar = new i.a();
            aVar.hMM = -1;
            aVar.mRM = hVar.mRM;
            aVar.mUI = hVar.mRN;
            this.mUm.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2 = (i - aVar.mUE) - 1;
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mUI.size() && i2 >= 0) {
            j jVar = (j) aVar.mUI.get(i2);
            com.tencent.mm.plugin.fts.d.a.b aVar2 = new a(i);
            aVar2.iZi = jVar;
            aVar2.mRM = aVar.mRM;
            aVar2.cG(jVar.type, jVar.mRc);
            bVar = aVar2;
        }
        if (bVar != null) {
            bVar.mVl = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 4176;
    }
}
