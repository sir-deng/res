package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.plugin.wallet_payu.balance.a.a;
import com.tencent.mm.pluginsdk.wallet.h;

public class WalletPayUBalanceSaveUI extends WalletBalanceSaveUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sFs.setVisibility(8);
    }

    protected final void bKi() {
        l(new a(this.pRD, "ZAR"));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof a)) {
            h.a((Context) this, ((a) kVar).fvC, "", 11, 1);
        }
        return false;
    }
}
