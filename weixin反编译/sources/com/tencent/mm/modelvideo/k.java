package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class k {
    public static final String TV() {
        return g.Dq().gRT + "draft/";
    }

    public static final String no(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return TV() + str;
    }

    public static final String np(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return TV() + str + ".thumb";
    }
}
