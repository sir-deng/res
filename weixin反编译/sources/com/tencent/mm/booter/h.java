package com.tencent.mm.booter;

import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class h {
    public static boolean wU() {
        try {
            as.Hm();
            t.d((Long) c.Db().get(66817, null));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", e, "", new Object[0]);
        }
        if (t.bz(0) * 1000 > 1800000) {
            return true;
        }
        return false;
    }
}
