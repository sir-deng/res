package com.tencent.mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet.bind.a.d;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            d(activity, bundle);
        } else {
            c(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public void d(Activity activity, Bundle bundle) {
        c(activity, WalletBankcardDetailUI.class, bundle);
    }

    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBankcardDetailUI) {
            c(activity, WalletCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public void b(Activity activity, Bundle bundle) {
        if (this.mym.getInt("scene", -1) == 1) {
            Activity activity2 = activity;
            a(activity2, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", bundle.getInt("key_process_result_code", 0), false);
        } else if (this.mym.getInt("scene", -1) == 2) {
            d(activity, "wallet", ".balance.ui.WalletBalanceManagerUI");
        } else {
            d(activity, "mall", ".ui.MallIndexUI");
        }
    }

    public g a(MMActivity mMActivity, i iVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new g(mMActivity, iVar) {
            private String fvC = null;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (kVar instanceof d) {
                    if (i == 0 && i2 == 0) {
                        a.this.mym.putInt("key_process_result_code", -1);
                        if (a.this.c(this.zRe, null)) {
                            this.zRf.a(new y(this.fvC, 14), true, 1);
                        } else {
                            a.this.a(this.zRe, 0, null);
                            if (this.zRe instanceof WalletBaseUI) {
                                ((WalletBaseUI) this.zRe).uO(0);
                            }
                            this.zRe.finish();
                        }
                        return true;
                    }
                    a.this.mym.putInt("key_process_result_code", 1);
                }
                return false;
            }

            public final boolean p(Object... objArr) {
                Bankcard bankcard = (Bankcard) a.this.mym.getParcelable("key_bankcard");
                if (bankcard == null || bankcard.field_bankcardState != 1) {
                    a.this.mym.putInt("key_process_result_code", 1);
                    return super.p(objArr);
                }
                this.zRf.a(new d(bankcard.field_bankcardType, bankcard.field_bindSerial, a.this.mym.getInt("scene", -1) == 2), true, 1);
                a.this.mym.putBoolean("key_is_expired_bankcard", true);
                return true;
            }

            public final boolean k(Object... objArr) {
                Bankcard bankcard = (Bankcard) a.this.mym.getParcelable("key_bankcard");
                String str = (String) objArr[0];
                this.fvC = (String) objArr[1];
                if (bankcard != null) {
                    this.zRf.a(new d(bankcard.field_bankcardType, bankcard.field_bindSerial, str, a.this.mym.getInt("scene", -1) == 2), true, 1);
                    return true;
                }
                a.this.mym.putInt("key_process_result_code", 1);
                return false;
            }

            public final CharSequence uE(int i) {
                switch (i) {
                    case 1:
                        return this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.uYG);
                    default:
                        return super.uE(i);
                }
            }
        } : super.a(mMActivity, iVar);
    }

    public boolean c(Activity activity, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            return true;
        }
        return false;
    }

    public final String aLn() {
        return "UnbindProcess";
    }
}
