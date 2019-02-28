package com.tencent.mm.plugin.wallet.bind.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(19)
public class WalletResetInfoUI extends WalletBaseUI implements WalletFormView.a {
    private TextView jIt;
    private Orders pVi;
    private Bankcard sGk;
    private Button sIX;
    private WalletFormView sIY;
    private WalletFormView sIZ;
    private WalletFormView sJa;
    private WalletFormView sJb;
    private Authen sJc;
    private ElementQuery sJd;

    protected final int getLayoutId() {
        return g.uMm;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        this.jIt = (TextView) findViewById(f.uGE);
        Bankcard bankcard = (Bankcard) this.vf.getParcelable("key_switch_phone_reset_bank_card");
        if (bankcard == null) {
            bankcard = (Bankcard) this.vf.getParcelable("key_bankcard");
        }
        this.sGk = bankcard;
        this.pVi = (Orders) this.vf.getParcelable("key_orders");
        this.sJc = (Authen) this.vf.getParcelable("key_authen");
        if (TextUtils.isEmpty(this.vf.getString("key_pwd1", ""))) {
            this.vf.putString("key_pwd1", this.sJc.sQC);
            x.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
        }
        this.sJd = (ElementQuery) this.vf.getParcelable("elemt_query");
        this.sIY = (WalletFormView) findViewById(f.ulH);
        this.sIZ = (WalletFormView) findViewById(f.upz);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.sIZ);
        this.sJa = (WalletFormView) findViewById(f.upy);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.sJa);
        this.sJb = (WalletFormView) findViewById(f.uyb);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.sJb);
        this.sIZ.zST = this;
        this.sJa.zST = this;
        this.sJb.zST = this;
        MMScrollView mMScrollView = (MMScrollView) findViewById(f.cYF);
        mMScrollView.a(mMScrollView, mMScrollView);
        if (this.sGk != null) {
            this.sIY.setText(this.sGk.field_desc);
        } else {
            this.sIY.setVisibility(8);
        }
        bKw();
        if (bKv()) {
            b(new t("", "", null), true);
        }
    }

    private boolean bKv() {
        return this.vf.getInt("key_err_code", av.CTRL_INDEX) == av.CTRL_INDEX && this.sJd == null;
    }

    private void bKw() {
        switch (this.vf.getInt("key_err_code", av.CTRL_INDEX)) {
            case e.CTRL_INDEX /*402*/:
                setMMTitle(i.vcH);
                this.sJa.setVisibility(0);
                this.jIt.setText(i.vcG);
                break;
            case ap.CTRL_INDEX /*403*/:
                setMMTitle(i.vcM);
                this.sIZ.setVisibility(0);
                this.jIt.setText(i.vcL);
                break;
            default:
                if (this.vf.getBoolean("key_balance_change_phone_need_confirm_phone", true)) {
                    setMMTitle(i.vcK);
                    this.sJb.setVisibility(0);
                } else {
                    setMMTitle(i.vcI);
                }
                if (this.sGk != null) {
                    x.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", this.sGk.field_bankPhone);
                    this.jIt.setText(String.format(getString(i.vcJ), new Object[]{this.sGk.field_bankPhone}));
                }
                if (this.sJd == null && this.sGk != null) {
                    this.sJd = o.bMk().Ny(this.sGk.field_bankcardType);
                }
                if (this.sJd != null && this.sJd.sSD) {
                    this.sJa.setVisibility(0);
                }
                if (this.sJd != null && this.sJd.sSE) {
                    this.sIZ.setVisibility(0);
                    break;
                }
        }
        this.sIX = (Button) findViewById(f.cAl);
        this.sIX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (WalletResetInfoUI.this.XT()) {
                    if (WalletResetInfoUI.this.sJa.getVisibility() == 0) {
                        WalletResetInfoUI.this.sJc.sQH = WalletResetInfoUI.this.sJa.getText();
                    }
                    if (WalletResetInfoUI.this.sIZ.getVisibility() == 0) {
                        WalletResetInfoUI.this.sJc.sQI = bi.aD(WalletResetInfoUI.this.sIZ.getText(), "");
                    }
                    if (WalletResetInfoUI.this.sJb.getVisibility() == 0) {
                        WalletResetInfoUI.this.sJc.sOP = bi.aD(WalletResetInfoUI.this.sJb.getText(), "");
                        WalletResetInfoUI.this.vf.putString("key_mobile", com.tencent.mm.wallet_core.ui.e.abl(WalletResetInfoUI.this.sJc.sOP));
                    }
                    x.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", WalletResetInfoUI.this.sJc.pff, WalletResetInfoUI.this.sJc.pfg);
                    WalletResetInfoUI.this.sJc.sQB = 1;
                    if (WalletResetInfoUI.this.vf.getBoolean("key_is_changing_balance_phone_num", false)) {
                        WalletResetInfoUI.this.l(new c(WalletResetInfoUI.this.sJc, WalletResetInfoUI.this.pVi, WalletResetInfoUI.this.vf.getBoolean("key_isbalance", false)));
                        return;
                    }
                    k a = com.tencent.mm.plugin.wallet.pay.a.a.a(WalletResetInfoUI.this.sJc, WalletResetInfoUI.this.pVi, false);
                    if (a != null) {
                        WalletResetInfoUI.this.l(a);
                        return;
                    }
                    return;
                }
                x.w("Micromsg.WalletResetInfoUI", "input format illegal!");
            }
        });
        XT();
        if (bKv()) {
            uV(4);
        } else {
            uV(0);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.d("Micromsg.WalletResetInfoUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.vf;
            if ((kVar instanceof b) || (kVar instanceof c)) {
                b bVar = (b) kVar;
                bundle.putBoolean("key_need_verify_sms", !bVar.sKv);
                bundle.putString("kreq_token", bVar.token);
                if (bVar.sLK) {
                    bundle.putParcelable("key_orders", bVar.sKw);
                }
                Parcelable parcelable = bVar.pbX;
                if (parcelable != null) {
                    bundle.putParcelable("key_realname_guide_helper", parcelable);
                }
                bundle.putInt("key_err_code", 0);
                com.tencent.mm.wallet_core.a.j(this, bundle);
                return true;
            } else if ((kVar instanceof t) && this.sGk != null) {
                this.sJd = o.bMk().Nz(this.sGk.field_bindSerial);
                bKw();
            }
        }
        return false;
    }

    private boolean XT() {
        boolean z;
        if (this.sIZ.dQ(null)) {
            z = true;
        } else {
            z = false;
        }
        if (!this.sJb.dQ(null)) {
            z = false;
        }
        if (!this.sJa.dQ(null)) {
            z = false;
        }
        if (this.pVi == null || this.sJc == null) {
            z = false;
        }
        if (z) {
            this.sIX.setEnabled(true);
            this.sIX.setClickable(true);
        } else {
            this.sIX.setEnabled(false);
            this.sIX.setClickable(false);
        }
        return z;
    }

    public final void hB(boolean z) {
        XT();
    }
}
