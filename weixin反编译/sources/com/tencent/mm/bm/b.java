package com.tencent.mm.bm;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.mm.bp.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class b {
    public static void run() {
        long j = 0;
        if (as.Hp() && !as.Cz()) {
            long Wx = bi.Wx();
            as.Hm();
            long a = bi.a((Long) c.Db().get(331797, null), 0);
            if (10013 != r.ifN || r.ifO == 0) {
                j = a;
            }
            if (j < Wx) {
                as.Hm();
                c.Db().set(331797, Long.valueOf(432000 + Wx));
                try {
                    a ajq = new ajq();
                    ajq.wxN = "";
                    for (Account account : AccountManager.get(ad.getContext()).getAccountsByType("com.google")) {
                        if (!bi.oN(ajq.wxN)) {
                            break;
                        }
                        x.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", account.name);
                        ajq.wxN = account.name;
                    }
                    if (10013 == r.ifN && r.ifO != 0) {
                        ajq.wxN = "rssjbbk@gmail.com";
                    }
                    if (bi.oN(ajq.wxN)) {
                        x.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
                        return;
                    }
                    as.Hm();
                    c.Fe().b(new e.a(57, ajq));
                } catch (Exception e) {
                    x.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", e.getMessage());
                }
            }
        }
    }
}
