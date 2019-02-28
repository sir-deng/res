package com.tencent.mm.platformtools;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k implements Runnable {
    String fFG;
    String hgu;
    String ieP;

    public k(String str, String str2, String str3) {
        this.fFG = str;
        this.hgu = str2;
        this.ieP = str3;
    }

    public final void run() {
        if (!bi.oN(this.fFG) && !bi.oN(this.hgu)) {
            x.d("MicroMsg.MoveDataFiles", "MoveDataFiles %s :" + this.fFG + " to :" + this.hgu, this.ieP);
            if (f.zl() && this.hgu.substring(0, e.bnF.length()).equals(e.bnF)) {
                com.tencent.mm.sdk.platformtools.k.r(this.fFG + "/" + this.ieP, this.hgu + "/" + this.ieP, true);
            }
        }
    }
}
