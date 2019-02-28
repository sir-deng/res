package com.tencent.mm.plugin.card.ui.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public final class f extends a {
    public f(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean axp() {
        return this.lbI;
    }

    public final boolean axq() {
        return this.kOv.aue() && super.axq() && (this.kOv.auc() || !bi.oN(this.kOv.auj().code));
    }

    public final boolean axr() {
        return true;
    }

    public final boolean axu() {
        return this.kOv.aue() && super.axu();
    }
}
