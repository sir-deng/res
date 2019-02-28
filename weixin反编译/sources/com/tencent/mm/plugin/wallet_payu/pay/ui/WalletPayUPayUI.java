package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ta;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.e;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

@a(3)
public class WalletPayUPayUI extends WalletPayUI {
    private String tjx = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
        super.onNewIntent(intent);
    }

    protected final void bKS() {
        b(new c(bLe().fvC), bLe().vGj);
        b(new com.tencent.mm.plugin.wallet_core.c.b.a(bLe().fvC), bLe().vGj);
    }

    protected final void bKJ() {
        if (XT()) {
            x.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
            this.sFl = b.a(this, this.pVi, this.sKV, this.sFp, new b() {
                public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                    WalletPayUPayUI.this.aWY();
                    WalletPayUPayUI.this.mFy = str;
                    WalletPayUPayUI.this.tjx = str2;
                    WalletPayUPayUI.this.jK(false);
                    com.tencent.mm.plugin.wallet_core.e.c.bNV();
                }
            }, new OnClickListener() {
                public final void onClick(View view) {
                    WalletPayUPayUI.this.sKV = (FavorPayInfo) view.getTag();
                    if (WalletPayUPayUI.this.sKV != null) {
                        WalletPayUPayUI.this.sKV.sTg = "";
                    }
                    WalletPayUPayUI.this.c(false, 0, "");
                    WalletPayUPayUI.this.sFl.dismiss();
                    WalletPayUPayUI.this.mFy = null;
                    WalletPayUPayUI.this.sFl = null;
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    WalletPayUPayUI.this.mFy = null;
                    WalletPayUPayUI.this.sFl = null;
                    if (WalletPayUPayUI.this.aYL()) {
                        WalletPayUPayUI.this.finish();
                    }
                }
            }, "CREDITCARD_PAYU".equals(this.sFp.field_bankcardType));
        }
    }

    protected final void I(Bundle bundle) {
        boolean z = true;
        this.sLL = true;
        if (this.pVi != null) {
            bundle.putInt("key_support_bankcard", this.pVi.sOT);
        }
        String str = "key_is_oversea";
        if (bKX()) {
            z = false;
        }
        bundle.putBoolean(str, z);
        com.tencent.mm.wallet_core.a.a(this, e.class, bundle);
    }

    protected final void jK(boolean z) {
        if (this.sKT.fDQ == 32 || this.sKT.fDQ == 31) {
            int i;
            if (this.sKT.fDQ == 32) {
                x.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            r(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.sKT.fvC, this.mFy, this.sKT.vGl.getDouble("total_fee"), this.sKT.vGl.getString("fee_type"), i, this.sKT.vGl.getString("extinfo_key_1"), this.sFp.field_bindSerial, this.sKT.vGl.getString("extinfo_key_4")));
        } else if (this.sKT.fDQ == 11) {
            String str = this.mFy;
            String str2 = this.tjx;
            String str3 = this.sKT.fvC;
            double d = this.sKT.vGl.getDouble("total_fee");
            String string = this.sKT.vGl.getString("fee_type");
            String str4 = this.sFp.field_bindSerial;
            String str5 = this.sFp.field_bankcardType;
            p.bKx();
            r(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str, str2, str3, d, string, str4, str5, p.bKy().sFY.field_bindSerial));
        } else {
            l(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.sKT.fvC, this.sKT.vGl.getDouble("total_fee"), this.sKT.vGl.getString("fee_type"), this.sFp.field_bankcardType, this.sFp.field_bindSerial, this.tjx, this.mFy));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        com.tencent.mm.plugin.wallet_payu.pay.a.b bVar;
        if (i == 0 && i2 == 0) {
            Bundle bundle;
            if (kVar instanceof c) {
                this.pVi = ((c) kVar).pVi;
                if (this.pVi != null) {
                    i3 = this.pVi.sUf.size();
                }
                this.mCount = i3;
                x.d("MicroMsg.WalletPayUPayUI", "get mOrders! bankcardTag : " + (this.pVi != null ? Integer.valueOf(this.pVi.sOT) : ""));
                XT();
                if (!(this.pVi == null || this.pVi.sUf == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.pVi.sUf) {
                        if (bi.oN(commodity.fvD)) {
                            commodity.fvD = this.sKT.fvC;
                        }
                        linkedList.add(commodity.fvD);
                    }
                    if (linkedList.size() > 0) {
                        com.tencent.mm.sdk.b.b taVar = new ta();
                        taVar.fMk.fMm = linkedList;
                        com.tencent.mm.sdk.b.a.xmy.m(taVar);
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putDouble("total_fee", this.pVi.pTQ);
                    bundle2.putString("fee_type", "ZAR");
                    if (this.sKT.vGl == null) {
                        this.sKT.vGl = bundle2;
                    } else {
                        this.sKT.vGl.putAll(bundle2);
                    }
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
                p.bKx();
                this.sFo = p.bKy().jG(bKG());
                p.bKx();
                this.sFp = p.bKy().a(null, null, bKG(), false);
                this.pTn.setClickable(true);
                if (!(this.pVi == null || this.sFo == null || this.sKT == null)) {
                    com.tencent.mm.plugin.wallet_core.e.c.a(this.sKT, this.pVi);
                    g gVar = g.pWK;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.sKT.fDQ);
                    objArr[1] = Integer.valueOf(0);
                    p.bKx();
                    objArr[2] = Integer.valueOf(p.bKy().bMy() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.pVi.pTQ * 100.0d));
                    objArr[4] = this.pVi.pgf;
                    gVar.h(10690, objArr);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
                bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
                bundle = this.vf;
                bundle.putParcelable("key_pay_info", this.sKT);
                bundle.putParcelable("key_bankcard", this.sFp);
                bundle.putString("key_bank_type", this.sFp.field_bankcardType);
                if (!bi.oN(this.mFy)) {
                    bundle.putString("key_pwd1", this.mFy);
                }
                bundle.putString("kreq_token", bVar.biB());
                bundle.putParcelable("key_authen", bKW());
                bundle.putBoolean("key_need_verify_sms", false);
                bundle.putString("key_mobile", this.sFp.field_mobile);
                if (bVar.isSuccess()) {
                    bundle.putParcelable("key_orders", d.a(this.pVi, bVar.tjt, bVar.tju, bVar.cRQ, bVar.sXi));
                }
                this.vf.putBoolean("key_should_redirect", bVar.tjr);
                this.vf.putString("key_gateway_code", bVar.thV);
                this.vf.putString("key_gateway_reference", bVar.thU);
                this.vf.putBoolean("key_should_force_adjust", bVar.tjs);
                this.vf.putString("key_force_adjust_code", bVar.thX);
                bundle.putInt("key_pay_flag", 3);
                I(bundle);
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) {
                com.tencent.mm.plugin.wallet_payu.remittance.a.a aVar = (com.tencent.mm.plugin.wallet_payu.remittance.a.a) kVar;
                bundle = this.vf;
                bundle.putParcelable("key_pay_info", this.sKT);
                bundle.putParcelable("key_bankcard", this.sFp);
                bundle.putString("key_bank_type", this.sFp.field_bankcardType);
                if (!bi.oN(this.mFy)) {
                    bundle.putString("key_pwd1", this.mFy);
                }
                bundle.putString("kreq_token", aVar.biB());
                bundle.putParcelable("key_authen", bKW());
                bundle.putBoolean("key_need_verify_sms", false);
                bundle.putString("key_mobile", this.sFp.field_mobile);
                bundle.putParcelable("key_orders", this.pVi);
                bundle.putInt("key_pay_flag", 3);
                I(bundle);
                return true;
            }
            av();
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            switch (i2) {
                case com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX /*402*/:
                case ap.CTRL_INDEX /*403*/:
                case av.CTRL_INDEX /*408*/:
                    String string;
                    bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
                    this.sLP = this.vf;
                    this.sLP.putParcelable("key_pay_info", this.sKT);
                    this.sLP.putParcelable("key_bankcard", this.sFp);
                    if (!bi.oN(this.mFy)) {
                        this.sLP.putString("key_pwd1", this.mFy);
                    }
                    this.sLP.putString("kreq_token", bVar.biB());
                    this.sLP.putString("key_mobile", this.sFp.field_mobile);
                    this.sLP.putInt("key_err_code", i2);
                    this.sLP.putParcelable("key_orders", this.pVi);
                    if (bi.oN(str)) {
                        string = getString(i.vbB);
                    } else {
                        string = str;
                    }
                    h.a((Context) this, string, "", getString(i.vbA), getString(i.dEy), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletPayUPayUI.this.sLP.putInt("key_pay_flag", 3);
                            WalletPayUPayUI.this.I(WalletPayUPayUI.this.sLP);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (WalletPayUPayUI.this.aYL()) {
                                WalletPayUPayUI.this.finish();
                            }
                        }
                    });
                    return true;
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    if (!(this.sFp == null || this.pVi == null)) {
                        this.sFp.sRn = this.pVi.fvC;
                        if (this.sFo == null || this.sFo.size() <= 1) {
                            b(true, 4, str);
                            return true;
                        }
                        c(true, 4, str);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
