package com.tencent.mm.ui.account;

import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.y.as;

public final class f extends b {
    private static f xXZ = null;
    public String hPj = null;
    public String xXT = null;
    public String xXU = null;
    public String xXV = null;
    public String xXW = null;
    public byte[] xXX = null;
    public int xXY = 0;

    public final void cox() {
        if (bi.oN(this.xXU)) {
            as.CN().a(new v(this.hPj, this.xXT, this.yfb.xXY, "", "", "", 0, "", false, false), 0);
            return;
        }
        as.CN().a(new v(this.hPj, this.xXU, this.yfb.xXY, "", "", "", 0, "", false, true), 0);
    }

    public static void a(f fVar) {
        xXZ = fVar;
    }

    public static String coH() {
        if (xXZ != null) {
            return xXZ.hPj;
        }
        return null;
    }

    public static String coI() {
        if (xXZ != null) {
            return xXZ.xXT;
        }
        return null;
    }
}
