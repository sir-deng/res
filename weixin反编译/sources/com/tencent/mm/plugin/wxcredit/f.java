package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class f extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            a(activity, "wallet", ".bind.ui.WalletBankcardDetailUI", bundle);
        } else {
            c(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity.getClass().getSimpleName().equalsIgnoreCase("WalletBankcardDetailUI")) {
            c(activity, WalletCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final g a(MMActivity mMActivity, i iVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wxcredit.a.f)) {
                    return false;
                }
                f.this.a(this.zRe, 0, f.this.mym);
                return true;
            }

            public final boolean k(Object... objArr) {
                if (f.this.mym.getBoolean("key_is_show_detail", true)) {
                    return false;
                }
                Bankcard bankcard = (Bankcard) f.this.mym.getParcelable("key_bankcard");
                this.zRf.a(new com.tencent.mm.plugin.wxcredit.a.f(bankcard.field_bankcardType, bankcard.field_bindSerial, f.this.mym.getString("key_pwd1")), true, 1);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aLn() {
        return "WXCreditUnbindProcess";
    }
}
