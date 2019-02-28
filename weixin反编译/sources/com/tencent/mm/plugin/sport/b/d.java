package com.tencent.mm.plugin.sport.b;

import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static final void qq(int i) {
        x.v("MicroMsg.Sport.SportReportLogic", "report action=%d", Integer.valueOf(i));
        com.tencent.mm.plugin.report.d.pVE.h(13168, Integer.valueOf(i));
    }
}
