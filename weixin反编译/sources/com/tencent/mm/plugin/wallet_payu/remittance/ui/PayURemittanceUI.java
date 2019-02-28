package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.remittance.ui.RemittanceUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.d;
import com.tencent.mm.plugin.wallet_payu.remittance.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.u;

public class PayURemittanceUI extends RemittanceUI {
    private final String tki = "ZAR";

    public final void bop() {
        l(new g(this.gBJ, this.pRG));
    }

    public final void dX(String str, String str2) {
        l(new d(this.pRD, "ZAR", this.gBJ, this.itU));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(kVar instanceof d)) {
            return true;
        }
        d dVar = (d) kVar;
        if (bi.oN(dVar.fAK)) {
            u.makeText(this.mController.xRr, i.veR, 0).show();
            return true;
        }
        String str2 = dVar.fAK;
        String str3 = this.gBJ;
        PayInfo payInfo = new PayInfo();
        payInfo.fvC = str2;
        payInfo.fDQ = this.pRF;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", getIntent().getStringExtra("desc"));
        bundle.putString("extinfo_key_4", getIntent().getStringExtra("scan_remittance_id"));
        bundle.putString("fee_type", "ZAR");
        bundle.putDouble("total_fee", this.pRD);
        payInfo.vGl = bundle;
        h.a((Context) this, payInfo, 1);
        return true;
    }
}
