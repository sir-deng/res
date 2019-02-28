package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.List;

public final class b extends m {
    private String fEe;
    private ag handler = new ag();
    private x jQP;
    private a mRL;
    private List<j> mUI;
    private k pni = new k() {
        public final void b(h hVar) {
            if (hVar.bjW == 0) {
                b.this.mUI = hVar.mRN;
                if (b.this.zbP != null) {
                    b.this.zbP.r(hVar.mON.fEe, b.this.mUI.size(), true);
                }
            }
            b.this.notifyDataSetChanged();
        }
    };

    public b(l lVar, int i, x xVar) {
        super(lVar, false, i);
        this.jQP = xVar;
    }

    protected final com.tencent.mm.ui.contact.a.a je(int i) {
        com.tencent.mm.ui.contact.a.a eVar = new e(i);
        as.Hm();
        eVar.jQP = c.Ff().Xv(((j) this.mUI.get(i)).mRd);
        return eVar;
    }

    public final int getCount() {
        if (this.mUI == null) {
            return 0;
        }
        return this.mUI.size();
    }

    public final void a(String str, int[] iArr, boolean z) {
        this.fEe = str;
        g gVar = new g();
        gVar.fEe = str;
        gVar.handler = this.handler;
        gVar.mRK = this.pni;
        gVar.mRD = this.jQP.field_username;
        gVar.mRC = 7;
        this.mRL = ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).search(2, gVar);
    }

    public final void abi() {
        this.fEe = null;
        if (this.mRL != null) {
            ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).cancelSearchTask(this.mRL);
        }
    }
}
