package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenUI extends WalletBaseUI {
    private Button lXK;
    private Bankcard sJg;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uMK;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sJg = (Bankcard) this.vf.getParcelable("key_bankcard");
        initView();
    }

    protected final void initView() {
        setMMTitle(i.veJ);
        ((CheckBox) findViewById(f.ukX)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                WalletWXCreditOpenUI.this.lXK.setEnabled(z);
            }
        });
        findViewById(f.bJD).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                e.a(WalletWXCreditOpenUI.this, WalletWXCreditOpenUI.this.sJg.field_bankcardType, WalletWXCreditOpenUI.this.sJg.field_bankName, true, false);
            }
        });
        this.lXK = (Button) findViewById(f.cAl);
        this.lXK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletWXCreditOpenUI.this.bKh();
            }
        });
    }
}
