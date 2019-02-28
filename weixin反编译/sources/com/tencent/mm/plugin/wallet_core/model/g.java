package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class g {
    private static g sSe;
    public String pfh;
    public int sSf = 0;
    JSONObject sSg;

    public static g bLJ() {
        if (sSe == null) {
            sSe = new g();
        }
        return sSe;
    }

    public final boolean aHO() {
        if (this.sSf != 1 || bi.oN(this.pfh)) {
            return false;
        }
        return true;
    }
}
