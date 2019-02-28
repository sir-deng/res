package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sw;
import com.tencent.mm.f.a.th;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.d.g;

public class a extends b {
    private int bjW = 0;
    private boolean kRY = false;
    private int mMode;
    private String sPm = null;
    private String sPn = null;
    private boolean sPo = false;
    private int sPp = -1;

    public final c a(Activity activity, Bundle bundle) {
        boolean z;
        w("start", activity, bundle);
        if (this.mym == null) {
            this.mym = new Bundle();
        }
        if (bundle == null) {
            bundle = this.mym;
        }
        if (bundle != null) {
            this.mMode = bundle.getInt("real_name_verify_mode", 0);
        } else {
            this.mMode = 0;
        }
        this.sPp = this.mMode;
        bundle.putBoolean("key_is_realname_verify_process", true);
        this.sPm = bundle.getString("realname_verify_process_jump_plugin", "");
        this.sPn = bundle.getString("realname_verify_process_jump_activity", "");
        if (bundle.getInt("realname_verify_process_allow_idverify", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.sPo = z;
        x.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", Boolean.valueOf(this.sPo), this.sPm, this.sPn);
        switch (this.mMode) {
            case 0:
                o.HS(10);
                c(activity, SwitchRealnameVerifyModeUI.class, bundle);
                break;
            case 1:
                bundle.putBoolean("key_need_bind_response", true);
                o.HS(10);
                super.a(activity, bundle);
                break;
            case 2:
                c(activity, WalletRealNameVerifyUI.class, bundle);
                break;
        }
        return this;
    }

    public final void d(Activity activity, int i) {
        w("back", activity, Integer.valueOf(i));
        o.cCm();
        if (activity instanceof SwitchRealnameVerifyModeUI) {
            if (i == 0) {
                b(activity, this.mym);
            }
        } else if ((activity instanceof WalletRealNameVerifyUI) || (activity instanceof WalletBankcardIdUI)) {
            if (this.sPp != 0) {
                b(activity, this.mym);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, this.mym);
        }
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        w("forward", activity, "actionCode:" + i, bundle);
        int i2 = this.mym.getInt("real_name_verify_mode", this.mMode);
        if (this.mMode != i2) {
            this.mMode = i2;
        }
        if (this.mMode == 2) {
            if (activity instanceof WalletRealNameVerifyUI) {
                c(activity, WalletSetPasswordUI.class, bundle);
            } else if (activity instanceof WalletSetPasswordUI) {
                c(activity, WalletPwdConfirmUI.class, bundle);
            } else if (!(activity instanceof WalletPwdConfirmUI) && (activity instanceof SwitchRealnameVerifyModeUI)) {
                c(activity, WalletRealNameVerifyUI.class, bundle);
                this.mMode = 2;
            }
        } else if (this.mMode == 1) {
            if (activity instanceof SwitchRealnameVerifyModeUI) {
                if (com.tencent.mm.plugin.wallet_core.model.o.bMc().bMy()) {
                    c(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    c(activity, WalletBankcardIdUI.class, bundle);
                }
            } else if (activity instanceof WalletCheckPwdUI) {
                c(activity, WalletBankcardIdUI.class, bundle);
            } else {
                super.a(activity, i, bundle);
            }
        } else if (activity instanceof WalletRealNameVerifyUI) {
            c(activity, WalletBankcardIdUI.class, bundle);
            this.mMode = 1;
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final void b(final Activity activity, Bundle bundle) {
        Bundle bundle2;
        w("end", activity, bundle);
        o.cCm();
        if (bundle == null) {
            bundle2 = this.mym;
        } else {
            bundle2 = bundle;
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (this.mMode == 1) {
            cCd();
            if (bundle2.getBoolean("intent_bind_end", false)) {
                this.bjW = -1;
            } else {
                this.bjW = 0;
            }
        } else if (bundle2.containsKey("realname_verify_process_ret")) {
            this.bjW = bundle2.getInt("realname_verify_process_ret", -1);
        } else {
            this.bjW = 0;
        }
        if (bundle2.containsKey("intent_bind_end")) {
            bundle2.remove("intent_bind_end");
        }
        if (bundle2.containsKey("key_is_bind_reg_process")) {
            bundle2.remove("key_is_bind_reg_process");
        }
        bundle2.putInt("realname_verify_process_ret", this.bjW);
        final Intent intent = new Intent();
        intent.putExtras(bundle2);
        if (this.bjW == -1) {
            Toast.makeText(activity, activity.getString(i.uTs), 0).show();
        }
        final sw swVar = new sw();
        if (this.bjW == -1) {
            swVar.fLz.scene = 17;
        } else if (this.bjW == 0) {
            swVar.fLz.scene = 18;
        } else {
            swVar.fLz.scene = 0;
        }
        swVar.frD = new Runnable() {
            public final void run() {
                swVar.frD = null;
                a.this.kRY = true;
                com.tencent.mm.sdk.b.b thVar;
                if (bi.oN(a.this.sPm) || bi.oN(a.this.sPn)) {
                    a.this.ah(activity);
                    if (a.this.bjW == -1) {
                        thVar = new th();
                        thVar.fMD.result = a.this.bjW;
                        com.tencent.mm.sdk.b.a.xmy.m(thVar);
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + a.this.sPm + a.this.sPn);
                boolean z = a.this.mym.getBoolean("process_finish_stay_orgpage", true);
                intent.putExtra("key_process_is_end", true);
                intent.putExtra("key_process_is_stay", z);
                a.this.a(activity, a.this.sPm, a.this.sPn, a.this.bjW, intent, z);
                if (a.this.bjW == -1) {
                    thVar = new th();
                    thVar.fMD.result = a.this.bjW;
                    com.tencent.mm.sdk.b.a.xmy.m(thVar);
                }
            }
        };
        swVar.frD.run();
    }

    public final g a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.i iVar) {
        if (!(mMActivity instanceof WalletPwdConfirmUI)) {
            return mMActivity instanceof WalletRealNameVerifyUI ? new g(mMActivity, iVar) {
                public final CharSequence uE(int i) {
                    if (i != 0) {
                        return null;
                    }
                    String string = this.zRe.getString(i.vcb);
                    String string2 = this.zRe.getString(i.vca);
                    string = this.zRe.getString(i.vcd, new Object[]{string, string2});
                    com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this.zRe);
                    SpannableString spannableString = new SpannableString(string);
                    spannableString.setSpan(gVar, string.length() - string2.length(), string.length(), 33);
                    return spannableString.subSequence(0, spannableString.length());
                }

                public final boolean k(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }
            } : super.a(mMActivity, iVar);
        } else {
            if (this.mMode == 2) {
                return new g(mMActivity, iVar) {
                    public final boolean k(Object... objArr) {
                        p pVar = (p) objArr[0];
                        String string = a.this.mym.getString("key_real_name_token");
                        if (pVar == null || bi.oN(pVar.sVs)) {
                            x.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
                        } else if (bi.oN(string)) {
                            x.e("MicroMsg.RealNameVerifyProcess", "get token error");
                        } else {
                            this.zRf.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.c(pVar.sVs, string, a.this.mym.getInt("entry_scene", -1)), true);
                        }
                        return true;
                    }

                    public final boolean d(int i, int i2, String str, k kVar) {
                        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.c) {
                            if (i == 0 && i2 == 0) {
                                a.this.mym.putInt("realname_verify_process_ret", -1);
                                x.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                                com.tencent.mm.plugin.wallet_core.model.o.bMc().aJO();
                                com.tencent.mm.sdk.b.b swVar = new sw();
                                swVar.fLz.scene = 16;
                                swVar.frD = new Runnable() {
                                    public final void run() {
                                        x.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                                    }
                                };
                                com.tencent.mm.sdk.b.a.xmy.m(swVar);
                                a.this.a(this.zRf);
                                a.this.b(this.zRe, a.this.mym);
                                return true;
                            }
                        } else if (kVar instanceof h) {
                            return true;
                        }
                        return false;
                    }
                };
            }
            return super.a(mMActivity, iVar);
        }
    }

    public final String aLn() {
        return "realname_verify_process";
    }

    public final int b(MMActivity mMActivity, int i) {
        return i.uYN;
    }
}
