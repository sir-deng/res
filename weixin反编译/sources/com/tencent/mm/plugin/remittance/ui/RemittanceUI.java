package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public class RemittanceUI extends RemittanceBaseUI {
    public final void boo() {
        if (box()) {
            g.Dr();
            this.pRW = (String) g.Dq().Db().get(a.USERINFO_DELAY_TRANSFER_CONFIRM_WORDING_STRING, (Object) "");
            g.Dr();
            this.pRX = (String) g.Dq().Db().get(a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, (Object) "");
            g.Dr();
            this.pRY = ((Integer) g.Dq().Db().get(a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(0))).intValue();
            if (bi.oN(this.pRW) || bi.oN(this.pRX)) {
                ae.a(true, null);
            } else {
                ae.a(false, null);
            }
            x.d("MicroMsg.RemittanceUI", "do before transfer");
            b(new e(this.gBJ), false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jl(2783);
    }

    public void dX(String str, String str2) {
        if (this.pRC != null) {
            this.pRC.i(3, Integer.valueOf(this.pRF), Double.valueOf(this.pRD));
        }
        x.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)));
        k uVar = new u(this.pRD, "1", this.gBJ, this.pRV, this.pRF, this.itU, str, str2, this.pRG, r12, this.pSa);
        uVar.gQd = "RemittanceProcess";
        l(uVar);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof e)) {
            return super.d(i, i2, str, kVar);
        }
        final e eVar = (e) kVar;
        eVar.a(new com.tencent.mm.wallet_core.c.g.a() {
            public final void f(int i, int i2, String str, k kVar) {
                x.d("MicroMsg.RemittanceUI", "mask_name: %s", eVar.pPU.wbE);
                RemittanceUI.this.pRV = eVar.pPU.wbE;
                RemittanceUI.this.bov();
            }
        }).b(new com.tencent.mm.wallet_core.c.g.a() {
            public final void f(int i, int i2, String str, k kVar) {
                x.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            }
        }).c(new com.tencent.mm.wallet_core.c.g.a() {
            public final void f(int i, int i2, String str, k kVar) {
                x.e("MicroMsg.RemittanceUI", "net error: %s", eVar);
            }
        });
        return true;
    }

    public final void bor() {
        com.tencent.mm.ui.base.u.makeText(this.mController.xRr, i.uTv, 0).show();
    }

    public void onDestroy() {
        super.onDestroy();
        jm(2783);
    }

    public final void bou() {
        final b svVar = new sv();
        svVar.fLv.fLx = "7";
        svVar.frD = new Runnable() {
            public final void run() {
                if (bi.oN(svVar.fLw.fLy)) {
                    x.i("MicroMsg.RemittanceUI", "no bulletin data");
                } else {
                    com.tencent.mm.wallet_core.ui.e.a((TextView) RemittanceUI.this.findViewById(f.ulY), svVar.fLw.fLy, svVar.fLw.content, svVar.fLw.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.m(svVar);
    }
}
