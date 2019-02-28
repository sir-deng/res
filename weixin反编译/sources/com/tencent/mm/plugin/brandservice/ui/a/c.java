package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
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
        return ((m) g.k(m.class)).search(2, com.tencent.mm.plugin.fts.a.a.g.a(this.fEe, new int[]{131076}, null, -1, hashSet, com.tencent.mm.plugin.fts.a.c.b.mSk, this, agVar));
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN)) {
            i.a aVar = new i.a();
            aVar.hMM = -7;
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
            com.tencent.mm.plugin.fts.d.a.b a = a(i, jVar, aVar);
            a.cG(jVar.type, jVar.mRc);
            bVar = a;
        }
        if (bVar != null) {
            bVar.mVl = i2 + 1;
        }
        return bVar;
    }

    public final com.tencent.mm.plugin.fts.d.a.b a(int i, j jVar, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b aVar2 = new a(i);
        aVar2.iZi = jVar;
        aVar2.mRM = aVar.mRM;
        aVar2.cG(jVar.type, jVar.mRc);
        return aVar2;
    }

    public final int getType() {
        return 4192;
    }
}
