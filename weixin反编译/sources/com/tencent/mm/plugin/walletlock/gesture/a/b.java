package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public final class b {
    public static boolean bOC() {
        return ((Boolean) g.Dq().Db().get(a.USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    public static boolean bOD() {
        g bOE = d.bOE();
        x.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", Long.valueOf(bOE.tmx), Long.valueOf(bOE.tmy));
        if (bOE.tmx != -1) {
            e.a(bOE);
            if (bOE.tmy / 1000 < 600) {
                d.I(bOE.tmx, bOE.tmy);
                return true;
            }
            d.bOF();
        }
        return false;
    }
}
