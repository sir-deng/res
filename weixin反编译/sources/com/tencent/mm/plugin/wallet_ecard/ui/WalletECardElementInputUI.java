package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI extends WalletECardBaseUI {
    private Button sIX;
    private ElementQuery sPU;
    private WalletFormView sYj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uPE);
        initView();
        av();
    }

    protected final void initView() {
        this.sYj = (WalletFormView) findViewById(f.uEZ);
        this.sYj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletECardElementInputUI.this.vf.getInt("key_support_bankcard", 3));
                bundle.putInt("key_bind_scene", WalletECardElementInputUI.this.vf.getInt("key_bind_scene", -1));
                if (!bi.oN(WalletECardElementInputUI.this.sYj.getText())) {
                    bundle.putString("key_bank_type", WalletECardElementInputUI.this.sPU.pff);
                    bundle.putInt("key_bankcard_type", WalletECardElementInputUI.this.sPU.sSI);
                }
                c ag = a.ag(WalletECardElementInputUI.this);
                if (ag != null) {
                    ag.a(WalletECardElementInputUI.this, WalletCardSelectUI.class, bundle, 1);
                }
            }
        });
        this.sIX = (Button) findViewById(f.cAl);
        this.sIX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", WalletECardElementInputUI.this.sPU.pff);
                WalletECardElementInputUI.this.cCU().k(WalletECardElementInputUI.this.sPU);
            }
        });
    }

    private void av() {
        if (this.sPU == null) {
            this.sPU = new ElementQuery();
        }
        if (bi.oN(this.sPU.nHt)) {
            this.sYj.setText("");
        } else if (!bi.oN(this.sPU.sSJ)) {
            this.sYj.setText(this.sPU.nHt + " " + this.sPU.sSJ);
        } else if (2 == this.sPU.sSI) {
            this.sYj.setText(this.sPU.nHt + " " + getString(i.uXF));
        } else {
            this.sYj.setText(this.sPU.nHt + " " + getString(i.uXU));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uIn;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.sPU = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    av();
                    return;
                default:
                    super.onActivityResult(i, i2, intent);
                    return;
            }
        }
    }
}
