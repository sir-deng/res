package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.f.a.kr;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.q;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c extends b {
    static /* synthetic */ void d(MMActivity mMActivity) {
        String string = ((WalletBaseUI) mMActivity).vf.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).vf.getInt("offline_add_fee", 0);
        Bankcard biq = a.biq();
        if (biq != null) {
            ((WalletBaseUI) mMActivity).r(new k(biq, string, i));
        }
    }

    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        return super.a(activity, bundle);
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        super.a(activity, i, bundle);
    }

    public final void b(Activity activity, Bundle bundle) {
        com.tencent.mm.sdk.b.a.xmy.m(new kr());
        if (a.bin()) {
            c(activity, WalletOfflineEntranceUI.class);
        } else if (bundle.getInt("key_entry_scene", -1) == 2) {
            d(activity, "offline", "ui.WalletOfflineEntranceUI");
        } else {
            d(activity, "mall", ".ui.MallIndexUI");
        }
        if (activity != null) {
            activity.finish();
        }
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(mMActivity, iVar) {
                public final boolean k(Object... objArr) {
                    p pVar = (p) objArr[1];
                    pVar.flag = "2";
                    this.zRf.a(new q(pVar), true, 1);
                    return true;
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof y) {
                            if (!(((WalletBaseUI) this.zRe).vf == null || ((WalletBaseUI) this.zRe).vf.getInt("key_bind_scene", -1) != 5 || a.bin())) {
                                c.d(this.zRe);
                                return true;
                            }
                        } else if (kVar instanceof k) {
                            com.tencent.mm.wallet_core.a.j(this.zRe, ((WalletBaseUI) this.zRe).vf);
                            a.F(this.zRe);
                            return true;
                        }
                    }
                    return false;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new g(mMActivity, iVar) {
            public final boolean k(Object... objArr) {
                this.zRf.a(new com.tencent.mm.plugin.wallet_core.b.a.b((p) objArr[0]), true, 1);
                return true;
            }

            public final boolean d(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                if (i == 0 && i2 == 0) {
                    if (kVar instanceof y) {
                        if (!(((WalletBaseUI) this.zRe).vf == null || ((WalletBaseUI) this.zRe).vf.getInt("key_bind_scene", -1) != 5 || a.bin())) {
                            c.d(this.zRe);
                            return true;
                        }
                    } else if (kVar instanceof k) {
                        Bundle bundle = ((WalletBaseUI) this.zRe).vf;
                        bundle.putBoolean("intent_bind_end", true);
                        com.tencent.mm.wallet_core.a.j(this.zRe, bundle);
                        a.F(this.zRe);
                        return true;
                    }
                }
                return false;
            }
        } : super.a(mMActivity, iVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return super.c(activity, bundle);
    }

    public final String aLn() {
        return "OfflineBindCardProcess";
    }
}
