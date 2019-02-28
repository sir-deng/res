package com.tencent.mm.y.a;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import java.util.HashMap;

public class g implements ap {
    private c hjW = null;

    private static g Io() {
        return (g) p.s(g.class);
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        c Ip = Ip();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Ip.ii((String) com.tencent.mm.kernel.g.Dq().Db().get(328193, null));
            if (Ip.In()) {
                f.ik(Ip.hjQ.hjM);
            }
        } catch (Exception e) {
            x.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e.toString());
        }
        x.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        c Ip = Ip();
        Ip.hjR = null;
        Ip.hjQ = null;
    }

    public static c Ip() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Io().hjW == null) {
            Io().hjW = new c();
        }
        return Io().hjW;
    }
}
