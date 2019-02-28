package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletCheckIdentityUI extends WalletBaseUI {
    private WalletFormView sNi;
    private WalletFormView sXs;
    private String ufY;

    static /* synthetic */ boolean a(WalletCheckIdentityUI walletCheckIdentityUI, String str, String str2) {
        if (bi.oN(str)) {
            u.makeText(walletCheckIdentityUI, i.uXp, 0).show();
            return false;
        } else if (!bi.oN(str2) && str2.length() >= 4 && (!bi.oN(walletCheckIdentityUI.ufY) || walletCheckIdentityUI.sNi.XX())) {
            return true;
        } else {
            u.makeText(walletCheckIdentityUI, i.uEU, 0).show();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uME;
    }

    public final void initView() {
        setMMTitle(i.uXq);
        this.sXs = (WalletFormView) findViewById(f.uyk);
        a.e(this, this.sXs);
        this.sNi = (WalletFormView) findViewById(f.urs);
        a.b(this.sNi);
        e(this.sNi, 1, false);
        CharSequence string = this.vf.getString("key_pre_name");
        this.ufY = this.vf.getString("key_pre_indentity");
        if (!bi.oN(string)) {
            this.sXs.pJP.setText(string);
            this.sXs.setHint(getString(i.uXj));
        }
        if (!bi.oN(this.ufY)) {
            this.sNi.pKl = 4;
            this.sNi.pJP.setText(this.ufY);
            this.sNi.setHint(getString(i.uWS));
        }
        findViewById(f.cAl).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (WalletCheckIdentityUI.a(WalletCheckIdentityUI.this, WalletCheckIdentityUI.this.sXs.getText(), WalletCheckIdentityUI.this.sNi.getText())) {
                    WalletCheckIdentityUI.this.cCU().k(r0, r1);
                }
            }
        });
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
