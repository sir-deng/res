package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashMap;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(19)
public class WalletPayUCardElementUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private Button lXK;
    private WalletFormView tii;
    WalletFormView tij;
    private WalletFormView tik;
    private TextView til;
    private TextView tim;
    private TextView tin;
    private b tio;
    private boolean tip = false;
    private boolean tiq = false;
    private boolean tir = false;
    private HashMap<String, PayUBankcardElement> tis = null;
    private HashSet<String> tit = null;

    protected class b {
        boolean tiv;
        boolean tiw;
        boolean tix;

        protected b() {
        }

        protected final void bOg() {
            this.tiv = WalletPayUCardElementUI.this.tii.XX();
            this.tiw = WalletPayUCardElementUI.this.tij.XX();
            this.tix = WalletPayUCardElementUI.this.tik.XX();
            if (!WalletPayUCardElementUI.this.tir || this.tix) {
                WalletPayUCardElementUI.this.tim.setVisibility(4);
            } else {
                WalletPayUCardElementUI.this.tim.setVisibility(0);
                WalletPayUCardElementUI.this.tim.setText(i.uWJ);
            }
            boolean z;
            if (!WalletPayUCardElementUI.this.tip) {
                z = false;
            } else if (!this.tiv) {
                WalletPayUCardElementUI.this.til.setVisibility(0);
                WalletPayUCardElementUI.this.til.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(c.btC));
                WalletPayUCardElementUI.this.til.setText(i.uWE);
                z = false;
            } else if (!WalletPayUCardElementUI.this.tis.containsKey(WalletPayUCardElementUI.this.tii.getText()) || WalletPayUCardElementUI.this.tit.contains(WalletPayUCardElementUI.this.tii.getText())) {
                WalletPayUCardElementUI.this.b(new NetScenePayUElementQuery(WalletPayUCardElementUI.this.tii.getText()), false);
                WalletPayUCardElementUI.this.tit.add(WalletPayUCardElementUI.this.tii.getText());
                WalletPayUCardElementUI.this.til.setVisibility(0);
                WalletPayUCardElementUI.this.til.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(c.bsO));
                WalletPayUCardElementUI.this.til.setText(WalletPayUCardElementUI.this.getString(i.uWv));
                z = true;
            } else {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) WalletPayUCardElementUI.this.tis.get(WalletPayUCardElementUI.this.tii.getText());
                WalletPayUCardElementUI.this.til.setVisibility(0);
                if (bi.oN(payUBankcardElement.tic)) {
                    WalletPayUCardElementUI.this.til.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(c.btC));
                    WalletPayUCardElementUI.this.til.setText(payUBankcardElement.tie);
                    this.tiv = false;
                    z = false;
                } else {
                    WalletPayUCardElementUI.this.til.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(c.bsO));
                    WalletPayUCardElementUI.this.til.setText(payUBankcardElement.tie);
                    z = false;
                }
            }
            if (this.tiv && this.tiw && this.tix && !z) {
                WalletPayUCardElementUI.this.lXK.setEnabled(true);
            } else {
                WalletPayUCardElementUI.this.lXK.setEnabled(false);
            }
        }
    }

    private abstract class a implements TextWatcher {
        private a() {
        }

        /* synthetic */ a(WalletPayUCardElementUI walletPayUCardElementUI, byte b) {
            this();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    static /* synthetic */ void a(WalletPayUCardElementUI walletPayUCardElementUI, View view, Editable editable) {
        if (!(editable == null || editable.length() == 0)) {
            if (view.getId() == walletPayUCardElementUI.tii.getId()) {
                walletPayUCardElementUI.tip = true;
            } else if (view.getId() == walletPayUCardElementUI.tik.getId()) {
                walletPayUCardElementUI.tir = true;
            } else if (view.getId() == walletPayUCardElementUI.tij.getId()) {
                walletPayUCardElementUI.tiq = true;
            }
        }
        walletPayUCardElementUI.tio.bOg();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tio = new b();
        this.tis = new HashMap();
        this.tit = new HashSet();
        this.tii = (WalletFormView) findViewById(f.unU);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.tii);
        this.tij = (WalletFormView) findViewById(f.upz);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.tij);
        this.tik = (WalletFormView) findViewById(f.upy);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.tik);
        this.til = (TextView) findViewById(f.uEW);
        this.tim = (TextView) findViewById(f.uEN);
        this.lXK = (Button) findViewById(f.cAl);
        e(this.tii, 0, false);
        e(this.tik, 0, false);
        this.tii.zST = this;
        this.tik.zST = this;
        this.tij.zST = this;
        this.tii.zSX = 0;
        this.tik.a(new a() {
            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.tik, editable);
            }
        });
        this.tij.a(new a() {
            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.tij, editable);
            }
        });
        this.tii.a(new a() {
            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.tii, editable);
            }
        });
        this.lXK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) WalletPayUCardElementUI.this.tis.get(WalletPayUCardElementUI.this.tii.getText());
                if (payUBankcardElement == null) {
                    x.e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
                    return;
                }
                WalletPayUCardElementUI.this.tii.zSX = 50;
                WalletPayUCardElementUI.this.vf.putParcelable("key_card_element", payUBankcardElement);
                WalletPayUCardElementUI.this.vf.putString("key_card_id", WalletPayUCardElementUI.this.tii.getText());
                WalletPayUCardElementUI.this.vf.putString("key_cvv", WalletPayUCardElementUI.this.tik.getText());
                WalletPayUCardElementUI.this.vf.putString("key_expire_data", WalletPayUCardElementUI.this.tij.getText());
                WalletPayUCardElementUI.this.cCU().k(new Object[0]);
            }
        });
        ((TextView) findViewById(f.uGu)).setText(u.cCt());
        this.tin = (TextView) findViewById(f.uDa);
        com.tencent.mm.plugin.wallet_payu.a.c.a(this, this.tin);
    }

    public void onResume() {
        super.onResume();
        this.tio.bOg();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof NetScenePayUElementQuery) {
            this.tis.put(((NetScenePayUElementQuery) kVar).thZ, (PayUBankcardElement) this.vf.getParcelable("key_card_element"));
            this.tio.bOg();
            this.tit.remove(((NetScenePayUElementQuery) kVar).thZ);
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.bind.model.a)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                return false;
            }
            this.tii.zSX = 0;
            return false;
        }
    }

    protected final int getLayoutId() {
        return g.uJP;
    }

    public final void hB(boolean z) {
    }

    protected final boolean bKK() {
        return true;
    }
}
