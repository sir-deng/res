package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;

public final class d {
    public int endPos = -1;
    public int hna = -1;
    public int startOffset = -1;
    public int ubl = -1;

    public d() {
        set(-1, -1, -1, -1);
    }

    public d(int i, int i2, int i3, int i4) {
        set(i, i2, i3, i4);
    }

    public final void set(int i, int i2, int i3, int i4) {
        this.hna = i;
        this.startOffset = i2;
        this.endPos = i3;
        this.ubl = i4;
    }

    public final int bXR() {
        if (this.hna < 0 || this.startOffset < 0 || this.endPos < 0 || this.ubl < 0 || this.hna > this.endPos || (this.hna == this.endPos && this.startOffset > this.ubl)) {
            return 0;
        }
        b BL = c.bXc().BL(this.hna);
        b BL2 = c.bXc().BL(this.endPos);
        if (BL == null || BL2 == null) {
            return 0;
        }
        if (this.hna == this.endPos && this.startOffset == this.ubl) {
            return 1;
        }
        if (this.hna == this.endPos && BL.getType() == 1) {
            return 2;
        }
        return 3;
    }
}
