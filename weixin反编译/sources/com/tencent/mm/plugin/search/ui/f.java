package com.tencent.mm.plugin.search.ui;

import android.view.View;
import com.tencent.mm.bb.e;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.c.g;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class f extends b implements b {
    private ag jFp = new ag();
    private boolean qij;
    private g qim;

    public f(c cVar, String str, String str2, String str3, int i, int i2) {
        super(cVar);
        this.qim = new g(cVar.getContext(), this, i);
        this.qim.mRE = str2;
        this.qim.talker = str;
        this.qim.mRD = str3;
        this.qim.showType = i2;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b qx(int i) {
        com.tencent.mm.plugin.fts.d.a.b qx = this.qim.qx(i);
        if (qx != null) {
            qx.pageType = 5;
        }
        return qx;
    }

    protected final void bqD() {
        this.qij = false;
        this.qim.a(this.fEe, this.jFp, new HashSet());
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        boolean a = this.qim.a(view, bVar, z);
        if (bVar.mVr && !this.qij) {
            this.qij = true;
            e.b(this.fEe, true, this.qim.aNV(), -2);
        }
        if (a) {
            clearCache();
            wh(this.qim.qw(0));
            notifyDataSetChanged();
            H(getCount(), true);
        }
        return a;
    }

    public final void a(i iVar, String str) {
        wh(iVar.qw(0));
        notifyDataSetChanged();
        H(getCount(), true);
    }

    public final void finish() {
        super.finish();
        if (!this.qij) {
            this.qij = true;
            e.b(this.fEe, false, this.qim.aNV(), -2);
        }
    }

    protected final int aNW() {
        return this.qim.aNV();
    }
}
