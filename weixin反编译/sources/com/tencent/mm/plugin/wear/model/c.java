package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.pluginsdk.q.w.a;
import com.tencent.mm.protocal.c.bzy;
import com.tencent.mm.sdk.platformtools.bi;

public final class c implements a {
    public final String bPj() {
        bzy bzy = a.bPh().tok.toC.tps;
        if (bzy != null) {
            return bzy.xgx + "\n" + bzy.xgy + "\n" + bzy.xgz;
        }
        return "Not Connect";
    }

    public final void bPk() {
        a.bPh().tor.a(new com.tencent.mm.plugin.wear.model.f.a());
    }

    public final boolean bPl() {
        String str = null;
        bzy bzy = a.bPh().tok.toC.tps;
        return (bi.oN(str) && bi.oN(str)) ? bzy != null : bi.oN(str) ? bzy != null && str.equals("gh_43f2581f6fd6") : bi.oN(str) ? bzy != null && str.equals(bzy.xgu) : bzy != null && str.equals("gh_43f2581f6fd6") && str.equals(bzy.xgu);
    }
}
