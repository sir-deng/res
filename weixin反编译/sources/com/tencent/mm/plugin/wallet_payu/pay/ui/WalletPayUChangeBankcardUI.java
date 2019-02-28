package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.lp;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUChangeBankcardUI extends WalletChangeBankcardUI {
    private String tjx = null;
    private c tjy = new c<lp>() {
        {
            this.xmG = lp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            lp lpVar = (lp) bVar;
            x.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: on request proceed pay");
            g gVar = new g(lpVar);
            WalletPayUChangeBankcardUI.this.vf.putString("app_id", gVar.appId);
            WalletPayUChangeBankcardUI.this.vf.putString("package", gVar.packageExt);
            WalletPayUChangeBankcardUI.this.vf.putString("timestamp", gVar.timeStamp);
            WalletPayUChangeBankcardUI.this.vf.putString("noncestr", gVar.nonceStr);
            WalletPayUChangeBankcardUI.this.vf.putString("pay_sign", gVar.fDO);
            WalletPayUChangeBankcardUI.this.vf.putString("sign_type", gVar.signType);
            WalletPayUChangeBankcardUI.this.vf.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
            WalletPayUChangeBankcardUI.this.vf.putBoolean("from_jsapi", true);
            WalletPayUChangeBankcardUI.this.vf.putString("key_trans_id", ((PayInfo) WalletPayUChangeBankcardUI.this.vf.getParcelable("key_pay_info")).fvC);
            WalletPayUChangeBankcardUI.this.vf.putBoolean("key_should_redirect", false);
            com.tencent.mm.wallet_core.a.j(WalletPayUChangeBankcardUI.this, WalletPayUChangeBankcardUI.this.vf);
            return true;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xmy.b(this.tjy);
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.tjy);
    }

    protected final f bKI() {
        return new a(this, this.sFo, this.sKR, this.pVi);
    }

    protected final void bKJ() {
        x.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
        String string = this.vf.getString("key_pwd1");
        if (bi.oN(string)) {
            uV(4);
            this.sFl = b.a(this, this.pVi, this.sKV, this.sFp, new b.b() {
                public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                    WalletPayUChangeBankcardUI.this.sKV = favorPayInfo;
                    WalletPayUChangeBankcardUI.this.vf.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.this.sKV);
                    WalletPayUChangeBankcardUI.this.mFy = str;
                    WalletPayUChangeBankcardUI.this.tjx = str2;
                    WalletPayUChangeBankcardUI.this.aWY();
                    WalletPayUChangeBankcardUI.this.Nr(str);
                }
            }, new OnClickListener() {
                public final void onClick(View view) {
                    if (WalletPayUChangeBankcardUI.this.sFl != null) {
                        WalletPayUChangeBankcardUI.this.sFl.dismiss();
                    }
                    WalletPayUChangeBankcardUI.this.sKS.d(WalletPayUChangeBankcardUI.this.sFo, true);
                    WalletPayUChangeBankcardUI.this.sKV = (FavorPayInfo) view.getTag();
                    if (WalletPayUChangeBankcardUI.this.sKV != null) {
                        WalletPayUChangeBankcardUI.this.sKV.sTg = "";
                    }
                    WalletPayUChangeBankcardUI.this.vf.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.this.sKV);
                    WalletPayUChangeBankcardUI.this.av();
                    WalletPayUChangeBankcardUI.this.uV(0);
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    WalletPayUChangeBankcardUI.this.mFy = null;
                    if (WalletPayUChangeBankcardUI.this.mController.contentView.getVisibility() != 0) {
                        WalletPayUChangeBankcardUI.this.bKL();
                    }
                }
            }, "CREDITCARD_PAYU".equals(this.sFp.field_bankcardType));
            return;
        }
        Nr(string);
    }

    protected final void Nr(String str) {
        this.sJc.sQC = str;
        if (this.sFp != null) {
            this.vf.putString("key_mobile", this.sFp.field_mobile);
            this.vf.putParcelable("key_bankcard", this.sFp);
            this.sJc.pfg = this.sFp.field_bindSerial;
            this.sJc.pff = this.sFp.field_bankcardType;
            if (this.sKV != null) {
                this.sJc.sQO = this.sKV.sTc;
            } else {
                this.sJc.sQO = null;
            }
            if (!(this.pVi == null || this.pVi.sUg == null)) {
                this.sJc.sQN = this.pVi.sUg.sJu;
            }
            if (this.pVi != null && this.pVi.sOT == 3) {
                boolean z;
                if (this.sFp.bLE()) {
                    this.sJc.fEo = 3;
                } else {
                    this.sJc.fEo = 6;
                }
                Bundle bundle = this.vf;
                String str2 = "key_is_oversea";
                if (this.sFp.bLE()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.vf.putParcelable("key_authen", this.sJc);
        if (this.sKT.fDQ == 32 || this.sKT.fDQ == 31) {
            int i;
            if (this.sKT.fDQ == 32) {
                x.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            r(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.sKT.fvC, this.mFy, this.sKT.vGl.getDouble("total_fee"), this.sKT.vGl.getString("fee_type"), i, this.sKT.vGl.getString("extinfo_key_1"), this.sFp.field_bindSerial, this.sKT.vGl.getString("extinfo_key_4")));
        } else if (this.sKT.fDQ == 11) {
            String str3 = this.mFy;
            String str4 = this.tjx;
            String str5 = this.sKT.fvC;
            double d = this.sKT.vGl.getDouble("total_fee");
            String string = this.sKT.vGl.getString("fee_type");
            String str6 = this.sFp.field_bindSerial;
            String str7 = this.sFp.field_bankcardType;
            p.bKx();
            r(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str3, str4, str5, d, string, str6, str7, p.bKy().sFY.field_bindSerial));
        } else {
            l(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.sKT.fvC, this.sKT.vGl.getDouble("total_fee"), this.sKT.vGl.getString("fee_type"), this.sFp.field_bankcardType, this.sFp.field_bindSerial, this.tjx, str));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) && !(kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) && !(kVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b)) {
            return false;
        }
        Bundle bundle = this.vf;
        if (!bi.oN(this.mFy)) {
            bundle.putString("key_pwd1", this.mFy);
        }
        bundle.putBoolean("key_need_verify_sms", false);
        bundle.putParcelable("key_pay_info", this.sKT);
        bundle.putInt("key_pay_flag", 3);
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            com.tencent.mm.plugin.wallet_payu.pay.a.b bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
            bundle.putString("transid", bVar.lnQ);
            bundle.putBoolean("key_should_redirect", bVar.tjr);
            bundle.putString("key_gateway_code", bVar.thV);
            bundle.putString("key_gateway_reference", bVar.thU);
            bundle.putString("key_force_adjust_code", bVar.thX);
            bundle.putBoolean("key_should_force_adjust", bVar.tjs);
            if (bVar.isSuccess()) {
                bundle.putParcelable("key_orders", d.a(this.pVi, bVar.tjt, bVar.tju, bVar.cRQ, bVar.sXi));
            }
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b) {
            com.tencent.mm.plugin.wallet_payu.balance.a.b bVar2 = (com.tencent.mm.plugin.wallet_payu.balance.a.b) kVar;
            bundle.putString("transid", bVar2.lnQ);
            bundle.putBoolean("key_should_redirect", bVar2.isRedirect);
            bundle.putString("key_gateway_code", bVar2.thV);
            bundle.putString("key_gateway_reference", bVar2.thU);
            bundle.putString("key_force_adjust_code", bVar2.thX);
            bundle.putBoolean("key_should_force_adjust", bVar2.thW);
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 23351) {
            x.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", Integer.valueOf(i2));
            if (i2 == -1) {
                this.vf.putBoolean("key_should_redirect", false);
                com.tencent.mm.wallet_core.a.j(this, this.vf);
            }
            if (i2 == 0) {
                com.tencent.mm.wallet_core.a.c(this, this.vf, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
