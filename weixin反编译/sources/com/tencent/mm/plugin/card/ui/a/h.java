package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h extends a {
    public h(MMActivity mMActivity) {
        super(mMActivity);
    }

    protected final void axb() {
        super.axb();
    }

    public final boolean axl() {
        ArrayList wU = b.wU(this.kOv.aun());
        if ((!this.kWZ.kPK || this.kWZ.kKY == 4) && !TextUtils.isEmpty(this.kOv.auo())) {
            return true;
        }
        if (this.kWZ.kPK && wU != null && wU.size() > 0) {
            return true;
        }
        if (TextUtils.isEmpty(this.kOv.auo()) || !axm()) {
            return false;
        }
        return true;
    }

    public final boolean axm() {
        return this.kWZ.kKY == 3;
    }

    public final boolean axn() {
        return false;
    }

    public final boolean axp() {
        return this.lbI;
    }

    public final boolean axs() {
        return false;
    }

    public final boolean axt() {
        return this.lbI && super.axt();
    }

    public final boolean axx() {
        return false;
    }

    public final boolean axy() {
        return false;
    }

    public final boolean axq() {
        return false;
    }

    public final boolean axz() {
        if (super.axz() || axA()) {
            return true;
        }
        if (this.kOv.atO() && this.lbI) {
            return true;
        }
        return false;
    }

    public final boolean axA() {
        return !this.lbI && this.kOv.aui().vZj == 1;
    }
}
