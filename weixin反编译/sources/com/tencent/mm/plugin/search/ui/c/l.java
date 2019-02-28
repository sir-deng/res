package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import android.view.View;
import com.tencent.mm.bb.e;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.search.ui.a.k;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public class l extends c {
    protected boolean qkT = false;

    public l(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected a a(ag agVar, HashSet<String> hashSet) {
        this.qkT = false;
        g gVar = new g();
        gVar.fEe = this.fEe;
        gVar.mRI = hashSet;
        gVar.mRK = this;
        gVar.handler = agVar;
        gVar.mRC = 1;
        gVar.mRH = 3;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(3, gVar);
    }

    protected void a(h hVar, HashSet<String> hashSet) {
        if (com.tencent.mm.plugin.fts.d.b.aW(hVar.mRN)) {
            i.a aVar = new i.a();
            aVar.hMM = -2;
            aVar.mRM = hVar.mRM;
            aVar.mUI = hVar.mRN;
            if (aVar.mUI.size() > 3) {
                if (((j) hVar.mRN.get(3)).mRd.equals("create_talker_message​")) {
                    aVar.mUH = false;
                    aVar.mUI = aVar.mUI.subList(0, 4);
                } else {
                    aVar.mUH = true;
                    aVar.mUI = aVar.mUI.subList(0, 3);
                }
            } else if (hVar.mRN.size() == 1 && ((j) hVar.mRN.get(0)).mRd.equals("create_talker_message​")) {
                aVar.mUF = false;
            }
            this.mUm.add(aVar);
        }
    }

    protected com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2;
        int i3 = i - aVar.mUE;
        if (aVar.mUF) {
            i2 = i3 - 1;
        } else {
            i2 = i3;
        }
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mUI.size() && i2 >= 0) {
            j jVar = (j) aVar.mUI.get(i2);
            if (jVar.mRd.equals("create_talker_message​")) {
                com.tencent.mm.plugin.fts.d.a.b hVar = new com.tencent.mm.plugin.search.ui.a.h(i);
                hVar.qkj = aVar.mUI.size() == 1;
                this.qkT = true;
                bVar = hVar;
            } else {
                com.tencent.mm.plugin.fts.d.a.b kVar = new k(i);
                kVar.iZi = jVar;
                kVar.cG(jVar.type, jVar.mRc);
                bVar = kVar;
            }
        }
        if (bVar != null) {
            bVar.mVl = i2 + 1;
            bVar.mRM = aVar.mRM;
        }
        return bVar;
    }

    public int getType() {
        return MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    }

    public boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        if (bVar instanceof k) {
            e.a(bVar, bqY(), this.qkT);
        }
        return false;
    }

    protected int bqY() {
        return 0;
    }
}
