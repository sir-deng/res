package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.c;
import com.tencent.mm.plugin.fts.d.a.d;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.a.f;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class g extends m {
    public String mRD;
    public int showType;
    public String talker;

    public g(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final int getType() {
        return ar.CTRL_INDEX;
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        this.qkT = false;
        com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
        gVar.fEe = this.fEe;
        gVar.mRJ = e.mSn;
        gVar.mRD = this.mRD;
        gVar.mRE = this.mRE;
        gVar.talker = this.talker;
        gVar.mRK = this;
        gVar.handler = agVar;
        gVar.mRC = 11;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(3, gVar);
    }

    protected final c b(int i, i.a aVar) {
        c eVar = new com.tencent.mm.plugin.search.ui.a.e(i);
        eVar.qjU = aVar.mUK;
        eVar.mRD = this.mRD;
        return eVar;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2;
        if (aVar.mUF) {
            i2 = (i - aVar.mUE) - 1;
        } else {
            i2 = i - aVar.mUE;
        }
        if (i2 < 0 || i2 >= aVar.mUI.size()) {
            return null;
        }
        j jVar = (j) aVar.mUI.get(i2);
        if (jVar.mRd.equals("no_result​")) {
            return new d(i);
        }
        com.tencent.mm.plugin.fts.d.a.b fVar = new f(i);
        fVar.iZi = jVar;
        fVar.mRM = fVar.iZi.mRM;
        fVar.cG(jVar.type, jVar.mRc);
        return fVar;
    }

    public final int bqY() {
        return this.showType;
    }
}
