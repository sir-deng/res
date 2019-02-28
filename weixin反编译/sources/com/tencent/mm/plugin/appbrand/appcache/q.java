package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.platformtools.bi;

public final class q {
    private final String appId;
    private final String iHe;
    private volatile String iHf;

    public q(String str, String str2) {
        this.appId = str;
        if (bi.oN(str2) || "__APP__".equals(str2)) {
            this.iHe = str2;
        } else {
            this.iHe = a.pQ(str2);
        }
    }

    public q(String str) {
        this.appId = str;
        this.iHe = null;
    }

    public final String toString() {
        if (bi.oN(this.iHf)) {
            this.iHf = this.appId + (bi.oN(this.iHe) ? "" : "$" + this.iHe);
        }
        return this.iHf;
    }
}
