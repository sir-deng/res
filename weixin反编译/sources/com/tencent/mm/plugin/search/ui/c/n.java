package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.as;
import java.util.HashSet;
import java.util.List;

public final class n extends c {
    private boolean qkS = false;

    public n(Context context, b bVar, int i) {
        boolean z;
        super(context, bVar, i);
        as.Hm();
        String str = (String) com.tencent.mm.y.c.Db().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.qkS = z;
        this.qkS &= bi.PZ();
    }

    protected final a a(ag agVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mRF = this.qkS ? new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131073, 131074, 262144, 131076} : new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 262144, 131076};
        gVar.mRH = 3;
        gVar.mRK = this;
        gVar.handler = agVar;
        gVar.scene = 0;
        gVar.mRI = hashSet;
        if (this.fEe.startsWith("@@")) {
            gVar.fEe = this.fEe.substring(2);
            return ((m) com.tencent.mm.kernel.g.k(m.class)).search(10000, gVar);
        }
        gVar.fEe = this.fEe;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(1, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        for (j jVar : hVar.mRN) {
            hashSet.add(jVar.mRd);
        }
        if (com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN)) {
            i.a aVar = new i.a();
            aVar.hMM = -8;
            List list = hVar.mRN;
            if (com.tencent.mm.plugin.fts.d.b.aW(list) && list.size() > 3) {
                list = list.subList(0, 3);
            }
            aVar.mUI = list;
            aVar.mUH = false;
            aVar.mRM = hVar.mRM;
            this.mUm.add(aVar);
        }
        d.aU(hVar.mRN);
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b a;
        int i2 = (i - aVar.mUE) - 1;
        if (i2 < aVar.mUI.size() && i2 >= 0) {
            j jVar = (j) aVar.mUI.get(i2);
            c cVar = jVar.type == 131075 ? (c) com.tencent.mm.plugin.fts.d.h.a(48, this.context, this.mUk, this.mUl) : (jVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || jVar.type == 131073 || jVar.type == 131074) ? (c) com.tencent.mm.plugin.fts.d.h.a(32, this.context, this.mUk, this.mUl) : jVar.type == 262144 ? (c) com.tencent.mm.plugin.fts.d.h.a(64, this.context, this.mUk, this.mUl) : jVar.type == 131076 ? (c) com.tencent.mm.plugin.fts.d.h.a(96, this.context, this.mUk, this.mUl) : null;
            if (cVar != null) {
                a = cVar.a(i, jVar, aVar);
                if (a != null) {
                    a.mVl = i2 + 1;
                }
                return a;
            }
        }
        a = null;
        if (a != null) {
            a.mVl = i2 + 1;
        }
        return a;
    }

    public final int getType() {
        return 16;
    }
}
