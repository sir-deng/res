package com.tencent.mm.plugin.bbom;

import com.tencent.mm.R;
import com.tencent.mm.booter.notification.e;
import com.tencent.mm.j.a;
import com.tencent.mm.j.f;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i implements b {
    public final void a(long j, String str, String str2, String str3, String str4, int i) {
        String string;
        if (bi.oN(str2)) {
            string = ad.getContext().getString(f.eX(str) ? R.l.dSY : R.l.epO);
        } else {
            string = str2;
        }
        e eVar = a.gBQ.gBP;
        if (!a.zx()) {
            e.cancel();
        }
        try {
            eVar.gBH.a(j, str, string, str3, str4, false, i);
        } catch (Throwable e) {
            x.e("MicroMsg.Notification.Handle", "push:notify, error");
            x.printErrStackTrace("MicroMsg.Notification.Handle", e, "", new Object[0]);
        }
    }

    public final void arJ() {
        a.gBQ.n(-1, null);
    }
}
