package com.tencent.mm.plugin.sns.ui.widget;

import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class b {
    private static b rXN = new b();
    private a rXL = null;
    public int rXM = 0;

    public static b bDn() {
        return rXN;
    }

    public final a bDo() {
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), (int) (14.0f * com.tencent.mm.bu.a.ev(ad.getContext())));
        if (this.rXL == null || ((int) this.rXL.gVS) != fromDPToPix) {
            this.rXL = com.tencent.mm.kiss.widget.textview.a.b.Er().P((float) fromDPToPix).gH(ad.getContext().getResources().getColor(c.qEA)).gG(16).gVC;
        }
        return this.rXL;
    }
}
