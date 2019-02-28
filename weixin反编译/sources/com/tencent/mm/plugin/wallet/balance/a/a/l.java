package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.aun;
import com.tencent.mm.sdk.platformtools.x;

public final class l {
    private static l sEH;
    public aun sEI;

    public static l bJX() {
        if (sEH == null) {
            sEH = new l();
        }
        return sEH;
    }

    public final void a(aun aun) {
        x.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s, real_time_balbance %s", Integer.valueOf(aun.bMF), Integer.valueOf(aun.wJf), Integer.valueOf(aun.wJe), Integer.valueOf(aun.wJg));
        this.sEI = aun;
    }
}
