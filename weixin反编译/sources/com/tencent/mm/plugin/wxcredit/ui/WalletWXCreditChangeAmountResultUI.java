package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditChangeAmountResultUI extends WalletBaseUI {
    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uMC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        ((TextView) findViewById(f.uGP)).setText(e.u(this.vf.getDouble("key_credit_amount")));
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(i.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletWXCreditChangeAmountResultUI.this.cCT().a(WalletWXCreditChangeAmountResultUI.this.mController.xRr, 0, WalletWXCreditChangeAmountResultUI.this.vf);
                return true;
            }
        });
    }
}
