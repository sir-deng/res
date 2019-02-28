package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.search.ui.a.o;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class b extends c {
    public b(Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mRC = 32;
        gVar.fEe = this.fEe;
        gVar.mRI = hashSet;
        gVar.mRJ = com.tencent.mm.plugin.fts.a.c.a.mSj;
        gVar.mRK = this;
        gVar.handler = agVar;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN)) {
            i.a aVar = new i.a();
            aVar.hMM = -3;
            aVar.mUI = hVar.mRN;
            aVar.mRM = hVar.mRM;
            aVar.mUH = false;
            this.mUm.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2 = (i - aVar.mUE) - 1;
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mUI.size() && i2 >= 0) {
            j jVar = (j) aVar.mUI.get(i2);
            if (jVar.mRd.equals("create_chatroom​")) {
                bVar = new com.tencent.mm.plugin.search.ui.a.g(i);
                bVar.mRM = aVar.mRM;
            } else {
                com.tencent.mm.plugin.fts.d.a.b oVar = new o(i);
                oVar.iZi = jVar;
                oVar.mRM = aVar.mRM;
                oVar.cG(jVar.type, jVar.mRc);
                bVar = oVar;
            }
        }
        if (bVar != null) {
            bVar.mVl = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 4128;
    }
}
