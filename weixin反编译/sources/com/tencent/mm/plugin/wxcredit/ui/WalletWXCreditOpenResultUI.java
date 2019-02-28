package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class WalletWXCreditOpenResultUI extends WalletBaseUI {
    private CheckBox ugI;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uMJ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dq().Db().set(196658, Boolean.valueOf(true));
        o.bMc().sWp = bi.Wx();
        initView();
    }

    protected final void initView() {
        setMMTitle(i.veG);
        TextView textView = (TextView) findViewById(f.uGZ);
        this.ugI = (CheckBox) findViewById(f.ulh);
        if (((Bankcard) this.vf.getParcelable("key_bankcard")) != null) {
            this.ugI.setText(getString(i.veH, new Object[]{r1.field_bankName}));
            textView.setText(i.veI);
        }
        ((Button) findViewById(f.cAl)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletWXCreditOpenResultUI.this.bLk();
            }
        });
    }

    private void bLk() {
        cCU().k(Boolean.valueOf(this.ugI.isChecked()));
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        bLk();
        return true;
    }
}
