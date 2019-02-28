package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.List;

public final class f extends c {
    public f(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.fEe = this.fEe;
        gVar.mRJ = d.mSm;
        gVar.mRK = this;
        gVar.handler = agVar;
        gVar.mRI = hashSet;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(7, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        List list = hVar.mRN;
        if (!(list == null || list.isEmpty())) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            String str = this.fEe;
            if (str != null) {
                str = str.replaceAll(",", " ");
            }
            dVar.q("20KeyWordId", str + ",");
            dVar.q("21ViewType", "2,");
            dVar.q("22OpType", "1,");
            dVar.q("23ResultCount", list.size() + ",");
            dVar.q("24ClickPos", ",");
            dVar.q("25ClickAppUserName", ",");
            x.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", dVar.SG());
            com.tencent.mm.plugin.report.service.g.pWK.h(13963, dVar);
        }
        if (com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN)) {
            i.a aVar = new i.a();
            aVar.hMM = -13;
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
            com.tencent.mm.plugin.fts.d.a.b dVar = new d(i);
            dVar.iZi = jVar;
            dVar.mRM = aVar.mRM;
            dVar.cG(jVar.type, jVar.mRc);
            bVar = dVar;
        }
        if (bVar != null) {
            bVar.mVl = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 4208;
    }
}
