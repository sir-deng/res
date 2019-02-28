package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.a.o;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class c extends com.tencent.mm.plugin.fts.d.c {
    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mRC = 96;
        gVar.mRH = 3;
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
            aVar.mUI = hVar.mRN;
            aVar.hMM = -3;
            aVar.mRM = hVar.mRM;
            if (aVar.mUI.size() > 3) {
                if (((j) aVar.mUI.get(3)).mRd.equals("create_chatroom​")) {
                    boolean z;
                    if (aVar.mUI.size() > 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar.mUH = z;
                    aVar.mUI = aVar.mUI.subList(0, 4);
                } else {
                    aVar.mUH = true;
                    aVar.mUI = aVar.mUI.subList(0, 3);
                }
            }
            this.mUm.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b gVar;
        int i2 = (i - aVar.mUE) - 1;
        if (i2 < aVar.mUI.size() && i2 >= 0) {
            j jVar = (j) aVar.mUI.get(i2);
            if (jVar.mRd.equals("create_chatroom​")) {
                gVar = new com.tencent.mm.plugin.search.ui.a.g(i);
                gVar.mRM = aVar.mRM;
            } else if (jVar.type == 131075) {
                com.tencent.mm.plugin.fts.d.a.b a = a(i, jVar, aVar);
                a.cG(jVar.type, jVar.mRc);
                gVar = a;
            }
            if (gVar != null) {
                gVar.mVl = i2 + 1;
            }
            return gVar;
        }
        gVar = null;
        if (gVar != null) {
            gVar.mVl = i2 + 1;
        }
        return gVar;
    }

    public final int getType() {
        return 48;
    }

    public final com.tencent.mm.plugin.fts.d.a.b a(int i, j jVar, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b oVar = new o(i);
        oVar.iZi = jVar;
        oVar.mRM = aVar.mRM;
        oVar.cG(jVar.type, jVar.mRc);
        return oVar;
    }
}
