package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditCheckPwdProcess");
        c(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            e.l(activity, bundle.getString("key_url"), false);
        } else {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    return false;
                }
                c.this.a(this.zRe, 0, c.this.mym);
                this.zRe.finish();
                return true;
            }

            public final boolean k(Object... objArr) {
                c.this.mym.putString("key_pwd1", (String) objArr[0]);
                this.zRf.a(new r((String) objArr[0], 5, ""), true, 1);
                return true;
            }

            public final boolean p(Object... objArr) {
                return false;
            }
        } : super.a(mMActivity, iVar);
    }

    public final String aLn() {
        return "WXCreditCheckPwdProcess";
    }
}
