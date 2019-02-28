package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletECardCheckOtherCardUI extends WalletECardBaseUI implements a {
    private Button lXK;
    private String lsp;
    private WalletFormView pNy;
    private WalletFormView tgr;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lsp = this.vf.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfR, "");
        setMMTitle(getString(i.uPD));
        this.zSi.jl(385);
        initView();
    }

    protected final void initView() {
        this.pNy = (WalletFormView) findViewById(f.uof);
        this.tgr = (WalletFormView) findViewById(f.uog);
        this.lXK = (Button) findViewById(f.uoh);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.pNy);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.tgr);
        if (bi.oN(this.lsp)) {
            this.pNy.setHint(getString(i.uPB));
        } else {
            this.pNy.setHint(getString(i.uPA, new Object[]{this.lsp}));
        }
        this.tgr.setHint(getString(i.uPC));
        this.pNy.zST = this;
        this.tgr.zST = this;
        e(this.pNy, 0, false);
        e(this.tgr, 0, false);
        this.lXK.setEnabled(false);
        this.lXK.setClickable(false);
        this.lXK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
                if (WalletECardCheckOtherCardUI.this.pNy.XX() && WalletECardCheckOtherCardUI.this.tgr.XX()) {
                    String text = WalletECardCheckOtherCardUI.this.pNy.getText();
                    String text2 = WalletECardCheckOtherCardUI.this.tgr.getText();
                    WalletECardCheckOtherCardUI.this.cCU().k(text, text2);
                    return;
                }
                x.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uIm;
    }

    public void onDestroy() {
        super.onDestroy();
        this.zSi.jm(385);
    }

    public final void hB(boolean z) {
        x.d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", Boolean.valueOf(z));
        if (this.pNy.XX() && this.tgr.XX()) {
            this.lXK.setEnabled(true);
            this.lXK.setClickable(true);
            return;
        }
        this.lXK.setEnabled(false);
        this.lXK.setClickable(false);
    }
}
