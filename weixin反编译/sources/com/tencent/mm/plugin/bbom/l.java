package com.tencent.mm.plugin.bbom;

import com.tencent.mm.af.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;

public final class l implements f, k {
    public final void a(arn arn, au auVar) {
        if (com.tencent.mm.af.f.eG(auVar.field_talker)) {
            arn.vNR = auVar.gkD;
            if (bi.oN(arn.vNR)) {
                arn.vNR = e.ku(auVar.gkD);
                return;
            }
            return;
        }
        arn.vNR = auVar.gkD;
    }

    public final String s(au auVar) {
        if (com.tencent.mm.af.f.eG(auVar.field_talker)) {
            return e.HJ();
        }
        return null;
    }
}
