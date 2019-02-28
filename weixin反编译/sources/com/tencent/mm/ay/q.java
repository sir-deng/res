package com.tencent.mm.ay;

import com.tencent.mm.f.a.lw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends c<lw> {
    private static long gAs = 86400000;

    public q() {
        this.xmG = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return QM();
    }

    private static boolean QM() {
        x.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + wU());
        if (wU()) {
            c.QI().update();
        }
        return false;
    }

    private static boolean wU() {
        if (bi.bz(Long.valueOf(bi.c((Long) g.Dq().Db().get(81938, null))).longValue()) * 1000 > gAs) {
            return true;
        }
        return false;
    }
}
