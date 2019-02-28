package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxcredit.a.a;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class e extends c {
    public final c a(Activity activity, Bundle bundle) {
        if (!o.bMc().bMx()) {
            if (o.bMc().bMy()) {
                c(activity, WalletCheckPwdUI.class, bundle);
            } else {
                c(activity, WalletWXCreditOpenUI.class, bundle);
            }
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletWXCreditOpenUI) {
            c(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            C(activity);
            c(activity, WalletWXCreditOpenUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenUI) {
            c(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckIdentityUI) {
            if (bundle.getBoolean("key_need_bind_deposit", true)) {
                c(activity, WalletBindDepositUI.class, bundle);
            } else {
                c(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletBindDepositUI) {
            c(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            if (o.bMc().bMy()) {
                c(activity, WalletWXCreditOpenResultUI.class, bundle);
            } else {
                c(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            c(activity, WalletWXCreditOpenResultUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenResultUI) {
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
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof b) {
                        b bVar = (b) kVar;
                        e.this.mym.putString("KEY_SESSION_KEY", bVar.token);
                        e.this.mym.putString("key_pre_name", bVar.name);
                        e.this.mym.putString("key_pre_indentity", bVar.ufv);
                        e.this.mym.putBoolean("key_has_indentity_info", bVar.ufw);
                    }
                    e.this.a(this.zRe, 0, e.this.mym);
                    return true;
                }

                public final boolean k(Object... objArr) {
                    int i = 0;
                    e.this.mym.putString("key_pwd1", (String) objArr[0]);
                    i iVar = this.zRf;
                    String str = (String) objArr[0];
                    if (objArr[1] != null) {
                        i = bi.Wo((String) objArr[1]);
                    }
                    iVar.a(new b(str, i, e.this.mym.getString("key_bank_type")), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletCheckIdentityUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof a) {
                        a aVar = (a) kVar;
                        e.this.mym.putString("KEY_SESSION_KEY", aVar.token);
                        e.this.mym.putString("key_mobile", aVar.fBa);
                        e.this.mym.putBoolean("key_need_bind_deposit", aVar.fLD);
                        e.this.mym.putBoolean("key_is_bank_user", aVar.ufu);
                    }
                    e.this.a(this.zRe, 0, e.this.mym);
                    return true;
                }

                public final boolean k(Object... objArr) {
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    e.this.mym.putString("key_name", str);
                    e.this.mym.putString("key_indentity", str2);
                    this.zRf.a(new a(str, str2, e.this.mym.getString("KEY_SESSION_KEY"), e.this.mym.getString("key_bank_type")), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(mMActivity, iVar) {
                public final /* synthetic */ CharSequence uE(int i) {
                    if (e.this.mym.getBoolean("key_is_bank_user", false)) {
                        Bankcard bankcard = (Bankcard) e.this.mym.getParcelable("key_bankcard");
                        return this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.vdR, new Object[]{bankcard.field_bankName, bankcard.field_bankName, e.this.mym.getString("key_mobile")});
                    }
                    return this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.vdS, new Object[]{e.this.mym.getString("key_mobile")});
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.g) {
                        String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) kVar).fDP;
                        if (!bi.oN(str2)) {
                            e.this.mym.putString("key_bank_username", str2);
                        }
                        e.this.a(this.zRe, 0, e.this.mym);
                        return true;
                    } else if (kVar instanceof h) {
                        e.this.a(this.zRe, 0, e.this.mym);
                        return true;
                    } else if (kVar instanceof q) {
                        if (o.bMc().bMy()) {
                            this.zRf.a(new y(), true, 1);
                            return true;
                        }
                        e.this.a(this.zRe, 0, e.this.mym);
                        return true;
                    } else if (!(kVar instanceof y)) {
                        return false;
                    } else {
                        this.zRf.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.mym.getString("key_verify_code"), e.this.mym.getString("KEY_SESSION_KEY"), e.this.mym.getString("key_pwd1"), o.bMc().bMN(), e.this.mym.getString("key_bank_type")), true, 1);
                        return true;
                    }
                }

                public final boolean k(Object... objArr) {
                    String str = (String) objArr[0];
                    e.this.mym.putString("key_verify_code", str);
                    p pVar;
                    if (o.bMc().bMy()) {
                        if (!e.this.mym.getBoolean("key_need_bind_deposit", true) || e.this.mym.getBoolean("key_is_bank_user")) {
                            this.zRf.a(new com.tencent.mm.plugin.wxcredit.a.g(str, e.this.mym.getString("KEY_SESSION_KEY"), e.this.mym.getString("key_pwd1"), e.this.mym.getString("key_bind_serial"), e.this.mym.getString("key_bank_type")), true, 1);
                        } else {
                            pVar = (p) objArr[1];
                            pVar.flag = "2";
                            this.zRf.a(new q(pVar), true, 1);
                        }
                    } else if (e.this.mym.getBoolean("key_is_bank_user", false)) {
                        e.this.mym.putString("key_verify_code", str);
                        this.zRf.a(new h(str, e.this.mym.getString("KEY_SESSION_KEY"), e.this.mym.getString("key_pwd1"), e.this.mym.getString("key_bind_serial"), e.this.mym.getString("key_bank_type")), true, 1);
                    } else {
                        pVar = (p) objArr[1];
                        pVar.flag = "1";
                        this.zRf.a(new q(pVar), true, 1);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBindDepositUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet_core.b.a.a)) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet_core.b.a.a aVar = (com.tencent.mm.plugin.wallet_core.b.a.a) kVar;
                    new StringBuilder("reqKey  ").append(aVar.sKI);
                    e.this.mym.putString("kreq_token", aVar.token);
                    e.this.a(this.zRe, 0, e.this.mym);
                    return true;
                }

                public final boolean k(Object... objArr) {
                    com.tencent.mm.plugin.wallet_core.e.c.bNV();
                    Authen authen = new Authen();
                    authen.sQG = (String) objArr[0];
                    authen.pff = (String) objArr[1];
                    authen.sOP = (String) objArr[2];
                    e.this.mym.putString("key_bank_phone", (String) objArr[3]);
                    authen.fEo = o.bMc().bMy() ? 2 : 1;
                    authen.sQF = 1;
                    authen.pHW = (PayInfo) e.this.mym.getParcelable("key_pay_info");
                    authen.sQC = e.this.mym.getString("key_pwd1");
                    if (!e.this.mym.getBoolean("key_has_indentity_info", false)) {
                        authen.sQD = e.this.mym.getString("key_name");
                        authen.sQE = e.this.mym.getString("key_indentity");
                    }
                    e.this.mym.putString("key_mobile", com.tencent.mm.wallet_core.ui.e.abl(authen.sOP));
                    e.this.mym.putBoolean("key_is_oversea", false);
                    this.zRf.a(new com.tencent.mm.plugin.wallet_core.b.a.a(authen), true, 1);
                    return true;
                }

                public final boolean q(Object... objArr) {
                    this.zRf.a(new t("", (String) objArr[0], (PayInfo) e.this.mym.getParcelable("key_pay_info")), true, 1);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new g(mMActivity, iVar) {
                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a.b) {
                        this.zRf.a(new y(), true, 1);
                        return true;
                    } else if (kVar instanceof y) {
                        this.zRf.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.mym.getString("key_verify_code"), e.this.mym.getString("KEY_SESSION_KEY"), e.this.mym.getString("key_pwd1"), o.bMc().bMN(), e.this.mym.getString("key_bank_type")), true, 1);
                        return true;
                    } else if (!(kVar instanceof com.tencent.mm.plugin.wxcredit.a.g)) {
                        return false;
                    } else {
                        String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) kVar).fDP;
                        if (!bi.oN(str2)) {
                            e.this.mym.putString("key_bank_username", str2);
                        }
                        e.this.a(this.zRe, 0, e.this.mym);
                        return true;
                    }
                }

                public final boolean k(Object... objArr) {
                    if (e.this.mym.getBoolean("key_is_bank_user", false)) {
                        this.zRf.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.mym.getString("key_verify_code"), e.this.mym.getString("KEY_SESSION_KEY"), e.this.mym.getString("key_pwd1"), o.bMc().bMN(), e.this.mym.getString("key_bank_type")), true, 1);
                    } else {
                        this.zRf.a(new com.tencent.mm.plugin.wallet_core.b.a.b((p) objArr[0]), true, 1);
                    }
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletWXCreditOpenResultUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    return false;
                }
                e.this.a(this.zRe, 0, e.this.mym);
                return true;
            }

            public final boolean k(Object... objArr) {
                e.this.mym.putBoolean("key_is_follow_bank_username", ((Boolean) objArr[0]).booleanValue());
                e.this.cCd();
                this.zRf.a(new y(), true, 1);
                return true;
            }
        } : null;
    }

    public final String aLn() {
        return "WXCreditOpenProcess";
    }
}
