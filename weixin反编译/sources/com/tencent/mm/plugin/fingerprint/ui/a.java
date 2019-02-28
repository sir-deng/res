package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
        c(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            x.i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
            c(activity, FingerPrintAuthUI.class, bundle);
        } else if (activity instanceof FingerPrintAuthUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        b(activity, new Bundle());
    }

    public final void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        x.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
        a(activity, "wallet", ".pwd.ui.WalletPasswordSettingUI", 0, intent, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aLn() {
        return "FingerprintAuth";
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new g(mMActivity, iVar) {
                public final boolean k(Object... objArr) {
                    a.this.mym.putString("pwd", (String) objArr[0]);
                    x.i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }
            };
        }
        return super.a(mMActivity, iVar);
    }
}
