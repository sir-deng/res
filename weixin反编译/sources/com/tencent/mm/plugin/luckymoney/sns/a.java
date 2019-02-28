package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.qa;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends c {
    static /* synthetic */ void ss(int i) {
        b qaVar = new qa();
        qaVar.fIA.key = i;
        qaVar.fIA.value = 1;
        qaVar.fIA.fIB = true;
        com.tencent.mm.sdk.b.a.xmy.m(qaVar);
    }

    public final c a(Activity activity, Bundle bundle) {
        if (activity instanceof SnsLuckyMoneyFreePwdSetting) {
            c(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        b(activity, bundle);
    }

    public final void d(Activity activity, int i) {
        b(activity, null);
    }

    public final void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        a(activity, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", -1, intent, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aLn() {
        return "LuckyFreePwdProcess";
    }

    public final g a(MMActivity mMActivity, i iVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new g(mMActivity, iVar) {
            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof com.tencent.mm.plugin.luckymoney.sns.a.a)) {
                    return false;
                }
                x.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
                if (i == 0 && i2 == 0) {
                    h.bu(this.zRe, this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.uRe));
                    a.ss(121);
                    a.this.mym.putBoolean("is_open_sns_pay", true);
                    a.this.a(this.zRe, 0, a.this.mym);
                    return true;
                }
                h.bu(this.zRe, this.zRe.getString(com.tencent.mm.plugin.wxpay.a.i.uRd));
                a.ss(122);
                a.this.d(this.zRe, 0);
                return true;
            }

            public final boolean k(Object... objArr) {
                this.zRf.a(new com.tencent.mm.plugin.luckymoney.sns.a.a(1, (String) objArr[0], ""), true, 1);
                return true;
            }
        } : super.a(mMActivity, iVar);
    }
}
