package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
        c(activity, WalletSetPasswordUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, WalletResetPwdAdapterUI.class);
        intent.putExtra("RESET_PWD_USER_ACTION", bundle.getInt("RESET_PWD_USER_ACTION", 0));
        a(activity, WalletResetPwdAdapterUI.class, -1, intent, false);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean k(Object... objArr) {
                    this.zRf.a(new r((String) objArr[0], 3, (String) objArr[1]), true, 1);
                    return true;
                }

                public final CharSequence uE(int i) {
                    switch (i) {
                        case 0:
                            return this.zRe.getString(a.i.uXw);
                        case 1:
                            return this.zRe.getString(a.i.vaN);
                        default:
                            return super.uE(i);
                    }
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if (i == 0 && i2 == 0) {
                    if (!(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.g)) {
                        return true;
                    }
                    c.this.mym.putInt("RESET_PWD_USER_ACTION", 1);
                    c.this.a(this.zRe, 0, c.this.mym);
                    h.bu(this.zRe, this.zRe.getString(a.i.vaJ));
                    return true;
                } else if (!(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.g)) {
                    return false;
                } else {
                    h.a(this.zRe, str, "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            c.this.mym.putInt("RESET_PWD_USER_ACTION", 2);
                            c.this.a(AnonymousClass2.this.zRe, 0, c.this.mym);
                        }
                    });
                    return true;
                }
            }

            public final boolean k(Object... objArr) {
                p pVar = (p) objArr[0];
                c.this.mym.getString("key_pwd1");
                this.zRf.a(new com.tencent.mm.plugin.wallet.pwd.a.g(pVar.sVs, pVar.token), true, 1);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                h.a((Context) walletBaseUI, str, null, walletBaseUI.getString(a.i.vdm), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        c.this.b(walletBaseUI, c.this.mym);
                        if (walletBaseUI.aYL()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.cCR();
                    }
                });
                return true;
            default:
                return false;
        }
    }

    public final int b(MMActivity mMActivity, int i) {
        return a.i.vdm;
    }

    public final String aLn() {
        return "ResetPwdProcessByToken";
    }
}
