package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.af;

public final class t extends af {
    public final void transfer(int i) {
        if (gO(i)) {
            g.Dq().Db().a(a.APPBRAND_PREDOWNLOAD_DONE_USAGE_USERNAME_DUPLICATE_BEFORE_BOOLEAN_SYNC, Boolean.valueOf(false));
        }
    }

    public final boolean gO(int i) {
        int i2 = 1;
        int i3 = i != 0 ? 1 : 0;
        if (i >= 637927936) {
            i2 = 0;
        }
        return i2 & i3;
    }

    public final String getTag() {
        return "MicroMsg.AppBrand.DuplicateUsageUsernameSetFlagDataTransfer";
    }
}
