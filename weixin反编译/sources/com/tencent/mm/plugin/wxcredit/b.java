package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
        c(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            c(activity, WalletWXCreditChangeAmountUI.class, bundle);
        } else if (activity instanceof WalletWXCreditChangeAmountUI) {
            c(activity, WalletWXCreditChangeAmountResultUI.class, bundle);
        } else if (activity instanceof WalletWXCreditChangeAmountResultUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletWXCreditChangeAmountUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof e) {
                        b.this.mym.putString("kreq_token", ((e) kVar).token);
                        return false;
                    } else if (!(kVar instanceof com.tencent.mm.plugin.wxcredit.a.c)) {
                        return false;
                    } else {
                        b.this.mym.putDouble("key_credit_amount", ((com.tencent.mm.plugin.wxcredit.a.c) kVar).ufx);
                        b.this.a(this.zRe, 0, b.this.mym);
                        return true;
                    }
                }

                public final boolean k(Object... objArr) {
                    this.zRf.a(new e(((Bankcard) b.this.mym.getParcelable("key_bankcard")).field_bindSerial), true, 1);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletCheckPwdUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    return false;
                }
                b.this.a(this.zRe, 0, b.this.mym);
                this.zRe.finish();
                return true;
            }

            public final boolean k(Object... objArr) {
                b.this.mym.putString("key_pwd1", (String) objArr[0]);
                this.zRf.a(new r((String) objArr[0], 5, ""), true, 1);
                return true;
            }
        } : null;
    }

    public final String aLn() {
        return "WXCreditChangeAmountProcess";
    }
}
