package com.tencent.mm.ui.contact;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class x {
    public static final void m(String str, int i, int i2, int i3) {
        if (!bi.oN(str)) {
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)}));
            g.pWK.k(13234, r0);
        }
    }

    public static void GH(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", Integer.valueOf(13941), Integer.valueOf(i));
        g.pWK.h(13941, Integer.valueOf(i));
    }
}
