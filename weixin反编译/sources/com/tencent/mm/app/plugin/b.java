package com.tencent.mm.app.plugin;

import com.tencent.mm.bl.d;
import com.tencent.mm.j.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class b {
    public static boolean uB() {
        if (!d.Pu("translate")) {
            return false;
        }
        String value = g.Af().getValue("TranslateMsgOff");
        if (bi.oN(value)) {
            return true;
        }
        if (bi.Wo(value) == 0) {
            return true;
        }
        return false;
    }
}
