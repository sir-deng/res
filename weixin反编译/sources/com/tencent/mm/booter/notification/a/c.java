package com.tencent.mm.booter.notification.a;

import com.tencent.mm.R;
import com.tencent.mm.bk.a;
import com.tencent.mm.j.f;

public final class c {
    public int gCa = -1;

    public final int y(String str, int i) {
        this.gCa = a.bYI();
        if (f.fT(i)) {
            if (f.eT(str)) {
                try {
                    this.gCa = R.g.bHJ;
                } catch (Exception e) {
                }
            } else if (f.eU(str)) {
                try {
                    this.gCa = R.g.bHJ;
                } catch (Exception e2) {
                }
            }
        }
        if (this.gCa < 0) {
            this.gCa = a.bYI();
        }
        return this.gCa;
    }
}
