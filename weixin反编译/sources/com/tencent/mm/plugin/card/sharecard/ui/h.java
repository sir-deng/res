package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g kUy;

    public h(g gVar) {
        this.kUy = gVar;
    }

    public final void onCreate() {
        this.kUy.notifyDataSetChanged();
    }

    public final void onDestroy() {
        if (this.kUy != null) {
            g gVar = this.kUy;
            gVar.kUm.release();
            gVar.kUm = null;
            gVar.kUx.clear();
            gVar.mContext = null;
            this.kUy = null;
        }
    }

    public final void HB() {
        if (this.kUy != null) {
            this.kUy.notifyDataSetChanged();
        }
    }

    public final b nV(int i) {
        if (this.kUy != null) {
            return this.kUy.nV(i);
        }
        return null;
    }
}
