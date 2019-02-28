package com.tencent.mm.plugin.wallet_payu.balance.ui;

import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

public class WalletPayUBalanceResultUI extends WalletBalanceResultUI {
    protected final void initView() {
        super.initView();
        this.sGj.setVisibility(8);
    }

    protected final void av() {
        if (this.pVi != null) {
            this.sGh.setText(e.d(this.pVi.pTQ, this.pVi.pgf));
            if (this.sGk != null && !bi.oN(this.sGk.field_bankName)) {
                if (bi.oN(this.sGk.field_bankcardTail)) {
                    this.pNs.setText(this.sGk.field_bankName);
                } else {
                    this.pNs.setText(this.sGk.field_bankName + " " + getString(i.vbm) + this.sGk.field_bankcardTail);
                }
            }
        }
    }
}
