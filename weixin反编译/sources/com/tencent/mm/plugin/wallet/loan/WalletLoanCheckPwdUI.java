package com.tencent.mm.plugin.wallet.loan;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletLoanCheckPwdUI extends WalletCheckPwdUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (cCT() != null) {
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.wallet_core.a.m(WalletLoanCheckPwdUI.this, 0);
                    return true;
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof s) || (i == 0 && i2 == 0)) {
            return super.d(i, i2, str, kVar);
        }
        return false;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
