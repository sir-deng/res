package com.tencent.mm.plugin.fingerprint.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class FingerPrintEntranceUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        x.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
        if (e.aLf()) {
            x.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
            x.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
            h.a((Context) this, getResources().getString(i.uUT), "", getResources().getString(((l) g.h(l.class)).aKO() ? i.uOE : i.dGf), getString(i.dEy), true, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
                    ((l) g.h(l.class)).cD(FingerPrintEntranceUI.this);
                    FingerPrintEntranceUI.this.finish();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FingerPrintEntranceUI.this.finish();
                }
            });
            e.aLa();
        } else if (e.aKZ()) {
            z = false;
        } else {
            x.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
            h.a((Context) this, getResources().getString(i.uUS), "", getResources().getString(i.uOD), getString(i.dEy), true, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
                    d.y(FingerPrintEntranceUI.this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                    FingerPrintEntranceUI.this.finish();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FingerPrintEntranceUI.this.finish();
                }
            });
            e.aKY();
        }
        if (!z) {
            x.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
