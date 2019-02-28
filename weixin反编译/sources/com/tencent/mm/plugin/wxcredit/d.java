package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.f;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.WXCreditManagerProcess", "start Process : WXCreditManagerProcess");
        c(activity, WalletWXCreditDetailUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (i == 1) {
            c(activity, WalletWXCreditErrDetailUI.class, bundle);
            activity.finish();
        } else if (activity instanceof WalletWXCreditDetailUI) {
            c(activity, WalletCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
        } else if (activity instanceof WalletWXCreditErrDetailUI) {
            c(activity, WalletCheckPwdUI.class, bundle);
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
        if (mMActivity instanceof WalletWXCreditDetailUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean k(Object... objArr) {
                    return false;
                }

                public final boolean p(Object... objArr) {
                    Bankcard bankcard = (Bankcard) objArr[0];
                    this.zRf.a(new com.tencent.mm.plugin.wxcredit.a.d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletCheckPwdUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    return false;
                }
                if (kVar instanceof f) {
                    this.zRf.a(new y(), true);
                    return true;
                } else if (!(kVar instanceof y)) {
                    return true;
                } else {
                    d.this.b(this.zRe, d.this.mym);
                    return true;
                }
            }

            public final boolean k(Object... objArr) {
                Bankcard bankcard = (Bankcard) d.this.mym.getParcelable("key_bankcard");
                this.zRf.a(new f(bankcard.field_bankcardType, bankcard.field_bindSerial, (String) objArr[0]), true, 1);
                return true;
            }

            public final boolean p(Object... objArr) {
                Bankcard bankcard = (Bankcard) objArr[0];
                this.zRf.a(new com.tencent.mm.plugin.wxcredit.a.d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final String aLn() {
        return "WXCreditManagerProcess";
    }
}
