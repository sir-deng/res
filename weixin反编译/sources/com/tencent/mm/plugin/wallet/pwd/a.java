package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet.pwd.a.f;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class a extends com.tencent.mm.plugin.wallet_core.b.a {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
        Bundle bundle2 = this.mym;
        String str = "key_is_oversea";
        p.bKx();
        bundle2.putBoolean(str, !p.bKy().bMD());
        bundle2 = this.mym;
        str = "key_support_bankcard";
        p.bKx();
        bundle2.putInt(str, p.bKy().bMD() ? 1 : 2);
        this.mym.putBoolean("key_is_forgot_process", true);
        c(activity, WalletForgotPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletForgotPwdUI) {
            if (bundle.containsKey("key_is_force_bind") && bundle.getBoolean("key_is_force_bind")) {
                c(activity, WalletForgotPwdBindNewUI.class, bundle);
            } else {
                c(activity, WalletCardElementUI.class, bundle);
            }
        } else if (activity instanceof WalletCardElementUI) {
            if (bNL()) {
                c(activity, WalletSetPasswordUI.class, bundle);
            } else {
                c(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletVerifyCodeUI) {
            c(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            w("startActivity2", activity, WalletCardElementUI.class, bundle, new StringBuilder("flag: 67108864").toString());
            Intent intent = new Intent(activity, WalletCardElementUI.class);
            intent.putExtra("process_id", getClass().hashCode());
            intent.addFlags(67108864);
            activity.startActivity(intent);
            if (bundle != null) {
                this.mym.putAll(bundle);
            }
            x.d("MicroMsg.ProcessManager", "bankcard tag :" + cBZ());
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        a(activity, WalletForgotPwdUI.class, -1, false);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletForgotPwdUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0 && (kVar instanceof y)) {
                        x.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", o.bLY().bMZ().field_reset_passwd_flag, o.bLY().bMZ().field_find_passwd_url);
                        if ((o.bMc().bMJ() == null ? 0 : o.bMc().bMJ().size()) <= 0 && !bi.oN(r2.field_find_passwd_url)) {
                            x.i("MicroMsg.ProcessManager", "hy: no bankcard and do not support add bank card to forget");
                            Context context = this.zRe;
                            h.a(context, true, context.getString(com.tencent.mm.plugin.wxpay.a.i.vaw), "", context.getString(com.tencent.mm.plugin.wxpay.a.i.dGf), context.getString(com.tencent.mm.plugin.wxpay.a.i.dEy), new com.tencent.mm.plugin.wallet.pwd.a.j.AnonymousClass1(context), new com.tencent.mm.plugin.wallet.pwd.a.j.AnonymousClass2(true, context));
                        }
                    }
                    return false;
                }

                public final boolean k(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof f)) {
                        return false;
                    }
                    a.this.mym.putString("kreq_token", ((f) kVar).token);
                    a.this.a(this.zRe, 0, a.this.mym);
                    return true;
                }

                public final boolean k(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    if (a.this.bNL()) {
                        authen.fEo = 4;
                    } else {
                        authen.fEo = 1;
                    }
                    this.zRf.a(new f(authen, a.this.mym.getBoolean("key_is_reset_with_new_card", false)), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof f)) {
                        return false;
                    }
                    a.this.mym.putString("kreq_token", ((f) kVar).token);
                    return true;
                }

                public final boolean k(Object... objArr) {
                    com.tencent.mm.plugin.wallet_core.model.p pVar = (com.tencent.mm.plugin.wallet_core.model.p) objArr[1];
                    pVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                    this.zRf.a(new com.tencent.mm.plugin.wallet.pwd.a.h(pVar), true, 1);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0 || !(kVar instanceof e)) {
                    return false;
                }
                a.this.a(this.zRe, 0, a.this.mym);
                return true;
            }

            public final boolean k(Object... objArr) {
                this.zRf.a(new e((com.tencent.mm.plugin.wallet_core.model.p) objArr[0]), true, 1);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return activity instanceof WalletPwdConfirmUI;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                h.a((Context) walletBaseUI, str, null, walletBaseUI.getString(com.tencent.mm.plugin.wxpay.a.i.uYq), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.this.b(walletBaseUI, a.this.mym);
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
        return com.tencent.mm.plugin.wxpay.a.i.uYq;
    }

    public final String aLn() {
        return "ForgotPwdProcess";
    }
}
