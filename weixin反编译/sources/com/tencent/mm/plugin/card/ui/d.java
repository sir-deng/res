package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;

public final class d implements a {
    private c kVX;

    public final /* synthetic */ b nV(int i) {
        return this.kVX != null ? (CardInfo) this.kVX.getItem(i) : null;
    }

    public d(c cVar) {
        this.kVX = cVar;
    }

    public final void onCreate() {
        if (this.kVX != null) {
            am.avh().c(this.kVX);
        }
    }

    public final void onDestroy() {
        if (this.kVX != null) {
            am.avh().j(this.kVX);
            this.kVX.release();
            this.kVX = null;
        }
    }

    public final void HB() {
        if (this.kVX != null) {
            this.kVX.a(null, null);
        }
    }
}
