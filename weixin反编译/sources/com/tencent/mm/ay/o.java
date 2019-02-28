package com.tencent.mm.ay;

import com.tencent.mm.f.a.lw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.bp;
import com.tencent.smtt.sdk.QbSdk;

public final class o extends c<lw> {
    public o() {
        this.xmG = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (bi.bz(bi.a((Long) g.Dq().Db().get(66818, null), 0)) * 1000 > 1800000) {
            int a = bi.a((Integer) g.Dq().Db().get(66820, null), (int) QbSdk.EXTENSION_INIT_FAILURE);
            if (a != QbSdk.EXTENSION_INIT_FAILURE) {
                bp.r(9, String.valueOf(a));
                g.Dq().Db().set(66820, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE));
            }
            g.Dq().Db().set(66818, Long.valueOf(bi.Wx()));
        }
        return false;
    }
}
