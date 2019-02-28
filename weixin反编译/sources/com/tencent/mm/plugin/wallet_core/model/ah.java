package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.w.a;

public final class ah {
    public static boolean aHO() {
        g.Dr();
        if (((Boolean) g.Dq().Db().get(a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()) {
            return false;
        }
        return true;
    }
}
