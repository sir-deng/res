package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.c.b.a;

public class WalletPayUBalanceManagerUI extends WalletBalanceManagerUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void bKd() {
        p.bKx();
        b(new a(), p.bKy().sFY == null);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof a)) {
            av();
        }
        return false;
    }

    protected final void bKe() {
        G(WalletPayUBalanceSaveUI.class);
    }
}
