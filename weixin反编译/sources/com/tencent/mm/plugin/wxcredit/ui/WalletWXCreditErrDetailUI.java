package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditErrDetailUI extends WalletBaseUI {
    private Bankcard sGk;
    private String ugD;
    private TextView ugE;
    private TextView ugF;

    protected final int getLayoutId() {
        return g.uMH;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uWl);
        initView();
    }

    protected final void initView() {
        this.sGk = (Bankcard) this.vf.getParcelable("key_bankcard");
        this.ugD = this.vf.getString("key_repayment_url");
        if (this.sGk != null) {
            this.ugE = (TextView) findViewById(f.uEy);
            this.ugE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    e.l(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.ugD, false);
                }
            });
            this.ugF = (TextView) findViewById(f.uEz);
            this.ugF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.j(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.vf);
                }
            });
            this.ugF.setVisibility(this.vf.getBoolean("key_can_unbind", true) ? 0 : 8);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
