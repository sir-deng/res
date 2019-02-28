package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.a;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d.g;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
        c(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            c(activity, WalletPayUCardElementUI.class, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        if (this.mym.getInt("key_errcode_payu", -1) == 0) {
            u.makeText(activity, i.vag, 0).show();
            a(activity, WalletPayUBankcardManageUI.class, -1, false);
            return;
        }
        u.makeText(activity, i.uYa, 0).show();
        a(activity, WalletPayUBankcardManageUI.class, 0, false);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.i iVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new a(mMActivity, iVar, this.mym) {
                public final CharSequence uE(int i) {
                    if (i == 0) {
                        return this.zRe.getString(i.uXt);
                    }
                    return super.uE(i);
                }
            };
        }
        return mMActivity instanceof WalletPayUCardElementUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if ((kVar instanceof a) && i == 0 && i2 == 0) {
                    c.this.mym.putInt("key_errcode_payu", 0);
                    c.this.b(this.zRe, c.this.mym);
                }
                if (kVar instanceof NetScenePayUElementQuery) {
                    if (i == 0 && i2 == 0) {
                        PayUBankcardElement payUBankcardElement = ((NetScenePayUElementQuery) kVar).tib;
                        if (bi.oN(payUBankcardElement.tic)) {
                            payUBankcardElement.tie = ad.getContext().getString(i.vbE);
                        }
                        c.this.mym.putParcelable("key_card_element", ((NetScenePayUElementQuery) kVar).tib);
                    } else {
                        Parcelable payUBankcardElement2 = new PayUBankcardElement();
                        if (bi.oN(str)) {
                            str = "err card element";
                        }
                        payUBankcardElement2.tie = str;
                        c.this.mym.putParcelable("key_card_element", payUBankcardElement2);
                    }
                }
                return false;
            }

            public final boolean k(Object... objArr) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) c.this.mym.getParcelable("key_card_element");
                this.zRf.a(new a(payUBankcardElement.pgd, payUBankcardElement.tie, c.this.mym.getString("key_bank_username"), c.this.mym.getString("key_card_id"), c.this.mym.getString("key_expire_data"), payUBankcardElement.cardType, c.this.mym.getString("key_cvv"), c.this.mym.getString("key_pwd1")), true);
                return false;
            }
        } : super.a(mMActivity, iVar);
    }

    public final String aLn() {
        return "PayUBindProcess";
    }
}
