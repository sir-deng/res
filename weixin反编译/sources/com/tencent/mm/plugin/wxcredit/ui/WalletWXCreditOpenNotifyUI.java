package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenNotifyUI extends WalletBaseUI {
    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uMI;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dq().Db().set(196658, Boolean.valueOf(false));
        initView();
    }

    protected final void initView() {
        int i = 0;
        setMMTitle(i.veF);
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(i.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletWXCreditOpenNotifyUI.this.setResult(-1);
                WalletWXCreditOpenNotifyUI.this.finish();
                return true;
            }
        });
        ((TextView) findViewById(f.uGP)).setText(e.u(this.vf.getDouble("key_total_amount")));
        Button button = (Button) findViewById(f.cAl);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("key_bankcard", WalletWXCreditOpenNotifyUI.this.vf.getParcelable("key_bankcard"));
                a.a(WalletWXCreditOpenNotifyUI.this, b.class, bundle);
            }
        });
        if (!this.vf.getBoolean("key_can_upgrade_amount", true)) {
            i = 8;
        }
        button.setVisibility(i);
    }
}
