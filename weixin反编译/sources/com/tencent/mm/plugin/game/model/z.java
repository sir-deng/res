package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class z implements e {
    public z() {
        as.CN().a(1223, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    public static void b(String str, int i, int i2, String str2, String str3) {
        x.i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", str, Integer.valueOf(i), Integer.valueOf(i2), str3);
        as.CN().a(new bg(str, i, i2, str2, str3), 0);
    }
}
