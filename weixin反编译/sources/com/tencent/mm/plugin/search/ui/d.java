package com.tencent.mm.plugin.search.ui;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public final class d extends b implements k {
    private ag jFp = new ag();
    private String mRD;
    private a mRL;
    private h mRz;
    private q qid;

    public d(c cVar, String str) {
        super(cVar);
        this.mRD = str;
        if (s.eX(str)) {
            as.Hm();
            this.qid = c.Fo().hG(str);
        }
    }

    protected final b qx(int i) {
        b cVar = new com.tencent.mm.plugin.search.ui.a.c(i);
        cVar.iZi = (j) this.mRz.mRN.get(i);
        cVar.mRM = this.mRz.mRM;
        cVar.mVj = -14;
        cVar.qid = this.qid;
        cVar.mVk = i;
        cVar.pageType = 6;
        if (cVar.position == getCount() - 1) {
            cVar.mVi = true;
        }
        return cVar;
    }

    protected final void bqD() {
        clearCache();
        if (this.mRL != null) {
            ((m) g.k(m.class)).cancelSearchTask(this.mRL);
        }
        com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
        gVar.fEe = this.fEe;
        gVar.mRD = this.mRD;
        gVar.mRJ = e.mSn;
        gVar.mRK = this;
        gVar.handler = this.jFp;
        gVar.mRC = 3;
        this.mRL = ((m) g.k(m.class)).search(3, gVar);
        x.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", this.fEe);
    }

    public final void b(h hVar) {
        switch (hVar.bjW) {
            case -3:
            case -2:
            case -1:
                wh(0);
                notifyDataSetChanged();
                H(getCount(), true);
                return;
            case 0:
                this.mRz = hVar;
                wh(hVar.mRN.size());
                notifyDataSetChanged();
                H(getCount(), true);
                return;
            default:
                return;
        }
    }

    public final void finish() {
        super.finish();
        if (this.mRL != null) {
            ((m) g.k(m.class)).cancelSearchTask(this.mRL);
        }
    }

    protected final boolean a(View view, b bVar, boolean z) {
        return false;
    }
}
