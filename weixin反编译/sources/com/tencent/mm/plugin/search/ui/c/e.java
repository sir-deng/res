package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.a.l;
import com.tencent.mm.plugin.search.ui.a.p;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class e extends c {
    public e(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mRC = 64;
        gVar.fEe = this.fEe;
        gVar.mRF = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131081};
        gVar.mRH = 3;
        gVar.mRJ = com.tencent.mm.plugin.fts.a.c.b.mSk;
        gVar.mRI = hashSet;
        gVar.mRK = this;
        gVar.handler = agVar;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        i.a aVar = new i.a();
        aVar.hMM = -4;
        aVar.mUI = hVar.mRN;
        aVar.mUF = com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN);
        aVar.mRM = hVar.mRM;
        if (aVar.mUI.size() > 3) {
            aVar.mUH = true;
            aVar.mUI = aVar.mUI.subList(0, 3);
        }
        if (com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN)) {
            this.mUm.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b bVar;
        int i2 = 0;
        if (aVar.mUF) {
            int i3 = (i - aVar.mUE) - 1;
            if (i3 >= aVar.mUI.size() || i3 < 0) {
                i2 = i3;
                bVar = null;
            } else {
                j jVar = (j) aVar.mUI.get(i3);
                com.tencent.mm.plugin.fts.d.a.b a = a(i, jVar, aVar);
                if (a != null) {
                    a.cG(jVar.type, jVar.mRc);
                }
                i2 = i3;
                bVar = a;
            }
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.mVl = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 32;
    }

    public final com.tencent.mm.plugin.fts.d.a.b a(int i, j jVar, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b pVar;
        if (jVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || jVar.type == 131081) {
            pVar = new p(i);
            pVar.iZi = jVar;
            pVar.mRM = aVar.mRM;
            pVar.cG(jVar.type, jVar.mRc);
            return pVar;
        } else if (jVar.type != 131073 && jVar.type != 131074) {
            return null;
        } else {
            pVar = new l(i);
            pVar.iZi = jVar;
            pVar.mRM = aVar.mRM;
            pVar.cG(jVar.type, jVar.mRc);
            return pVar;
        }
    }
}
