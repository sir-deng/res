package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class a {
    private static a sDh;
    public h str = new h(ad.getContext());

    private a() {
    }

    public static a bJJ() {
        if (sDh == null) {
            sDh = new a();
        }
        return sDh;
    }

    public static a bJK() {
        if (sDh == null) {
            sDh = bJJ();
        }
        return sDh;
    }

    public final void bJL() {
        if (this.str != null) {
            this.str.m(R.k.dAv, 0, true);
        }
    }

    public final void stopRing() {
        if (this.str != null) {
            this.str.stop();
        }
    }

    public final boolean bIf() {
        if (this.str != null) {
            return this.str.aiV();
        }
        return true;
    }
}
