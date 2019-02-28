package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

public class g extends e {
    public final c a(Activity activity, Bundle bundle) {
        c(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            c(activity, WalletPayUSetPasswordUI.class, bundle);
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new a(mMActivity, iVar, this.mym) {
                public final CharSequence uE(int i) {
                    if (i == 0) {
                        return this.zRe.getString(a.i.uXx);
                    }
                    return super.uE(i);
                }
            };
        }
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof b)) {
                    return false;
                }
                x.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
                if (i != 0 || i2 != 0) {
                    return false;
                }
                g.this.mym.putInt("key_errcode_payu", 0);
                com.tencent.mm.wallet_core.a.c(this.zRe, g.this.mym, 0);
                return true;
            }

            public final boolean k(Object... objArr) {
                p pVar = (p) objArr[0];
                this.zRf.a(new b(g.this.mym.getString("key_pwd1"), pVar.sVs), true);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final String aLn() {
        return "PayUModifyPasswordProcess";
    }
}
