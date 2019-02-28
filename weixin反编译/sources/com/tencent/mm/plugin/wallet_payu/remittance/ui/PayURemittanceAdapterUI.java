package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ak.b;

@a(7)
public class PayURemittanceAdapterUI extends RemittanceAdapterUI {
    protected final void bon() {
        b(new e(this.gBJ), false);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        super.d(i, i2, str, kVar);
        if (kVar instanceof e) {
            this.pRx = false;
        }
        if (i != 0 || i2 != 0 || !(kVar instanceof e)) {
            return false;
        }
        final e eVar = (e) kVar;
        this.gBJ = eVar.username;
        if (bi.oN(this.gBJ)) {
            x.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.itU);
            finish();
            return true;
        }
        final Intent intent = new Intent();
        intent.putExtra("fee", eVar.loS);
        intent.putExtra("desc", eVar.desc);
        intent.putExtra("scan_remittance_id", eVar.pQQ);
        intent.putExtra("receiver_true_name", com.tencent.mm.wallet_core.ui.e.abk(eVar.pQP));
        g.Dr();
        if (((h) g.h(h.class)).Ff().Xu(this.gBJ) != null) {
            c(this.gBJ, eVar.scene, intent);
        } else {
            x.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
            final long Wy = bi.Wy();
            ak.a.hhv.a(this.gBJ, "", new b.a() {
                public final void v(String str, boolean z) {
                    if (z) {
                        x.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (bi.Wy() - Wy) + " ms");
                        com.tencent.mm.ac.b.I(str, 3);
                        n.JY().jb(str);
                    } else {
                        x.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
                    }
                    PayURemittanceAdapterUI.this.c(PayURemittanceAdapterUI.this.gBJ, eVar.scene, intent);
                }
            });
        }
        return true;
    }

    protected final void c(String str, int i, Intent intent) {
        Intent intent2;
        x.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.itU + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        intent2.setClass(this, PayURemittanceUI.class);
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.itU);
        intent2.putExtra("pay_scene", i);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
