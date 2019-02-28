package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishUI extends WalletBaseUI {
    private Button oJc;
    private TextView sGX;
    private WalletTextView sGY;
    private TextView sGZ;
    private TextView sHa;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sGX = (TextView) findViewById(f.uDf);
        this.sGY = (WalletTextView) findViewById(f.ulf);
        this.oJc = (Button) findViewById(f.urf);
        this.sGZ = (TextView) findViewById(f.uAg);
        this.sHa = (TextView) findViewById(f.uDP);
        int intExtra = getIntent().getIntExtra("key_mode", 1);
        double doubleExtra = getIntent().getDoubleExtra("key_amount", 0.0d);
        CharSequence stringExtra = getIntent().getStringExtra("profile_date_wording");
        CharSequence stringExtra2 = getIntent().getStringExtra("profile_upgrade_wording");
        if (intExtra == 1) {
            this.sGX.setText(getString(i.uZB));
            setMMTitle(getString(i.uZB));
        } else if (intExtra == 2) {
            this.sGX.setText(getString(i.uZm));
            setMMTitle(getString(i.uZm));
        }
        this.sGY.setText(e.t(doubleExtra));
        this.oJc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletLqtSaveFetchFinishUI.this.finish();
            }
        });
        if (!bi.oN(stringExtra)) {
            this.sGZ.setText(stringExtra);
            this.sGZ.setVisibility(0);
        }
        if (!bi.oN(stringExtra2)) {
            this.sHa.setText(com.tencent.mm.pluginsdk.ui.d.i.e((Context) this, stringExtra2, (int) this.sHa.getTextSize()));
            this.sHa.setClickable(true);
            this.sHa.setOnTouchListener(new l());
            this.sHa.setVisibility(0);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uLJ;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
