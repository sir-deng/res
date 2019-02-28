package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.mm.f.a.gw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.g;

public final class a {
    private Dialog ion = null;
    private Context mContext;
    a sKM = null;

    public interface a {
        void c(boolean z, String str, String str2);
    }

    public a(Context context, a aVar) {
        this.mContext = context;
        this.sKM = aVar;
    }

    public final void release() {
        this.sKM = null;
        this.mContext = null;
    }

    public final void a(boolean z, int i, String str) {
        final b gwVar = new gw();
        gwVar.fxQ = null;
        gwVar.fxP.fxR = z;
        if (z && (this.ion == null || !(this.ion == null || this.ion.isShowing()))) {
            if (this.ion != null) {
                this.ion.dismiss();
            }
            this.ion = g.a(this.mContext, false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.bKF();
                }
            });
        }
        gwVar.fxP.fxS = i;
        gwVar.fxP.fxT = str;
        gwVar.frD = new Runnable() {
            public final void run() {
                x.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
                gw.b bVar = gwVar.fxQ;
                if (bVar != null && bVar.ftC) {
                    x.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
                    a.this.bKF();
                    if (a.this.sKM != null) {
                        a.this.sKM.c(bVar.ftC, bVar.fxU, bVar.fxV);
                    }
                } else if (bVar == null || bVar.ftC) {
                    x.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
                } else {
                    a.this.bKF();
                    if (a.this.sKM != null) {
                        a.this.sKM.c(bVar.ftC, bVar.fxU, bVar.fxV);
                    }
                    x.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.a(gwVar, Looper.getMainLooper());
    }

    public final void bKF() {
        if (this.ion != null) {
            this.ion.dismiss();
            this.ion = null;
        }
    }
}
