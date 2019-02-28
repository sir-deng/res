package com.tencent.mm.plugin.s;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.bi;

public final class g {
    public long aep = 0;
    private boolean kYN;
    public long ouW = 0;
    public long ouX = 0;
    public long ouY = -1;
    public long ouZ = 0;
    public long ova = 0;
    public long ovb = 0;
    public long ovc = 10;
    public boolean ovd = true;
    public boolean ove = true;
    public boolean ovf = false;
    public boolean ovg = false;
    boolean ovh = false;
    boolean ovi = false;

    public g(boolean z) {
        this.kYN = z;
    }

    public final String atw() {
        return hashCode();
    }

    public final void FJ(String str) {
        if (this.ovd) {
            com.tencent.mm.plugin.report.service.g.pWK.a(354, 152, 1, false);
            com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(500), Long.valueOf(bi.Wx()), str);
        }
    }

    public final void FK(String str) {
        if (this.ovd) {
            com.tencent.mm.plugin.report.service.g.pWK.a(354, 153, 1, false);
            com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(HardCoderJNI.SCENE_DB), Long.valueOf(bi.Wx()), str);
        }
    }

    public final void bal() {
        if (this.ovd) {
            com.tencent.mm.plugin.report.service.g.pWK.a(354, 155, 1, false);
            com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(503), Long.valueOf(bi.Wx()), "");
        }
    }
}
