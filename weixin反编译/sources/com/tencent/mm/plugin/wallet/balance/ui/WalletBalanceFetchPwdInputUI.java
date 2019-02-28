package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletBalanceFetchPwdInputUI extends WalletBaseUI {
    private String mTitle = "";
    private String sFk = "";
    private n sFl;

    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        uV(4);
        this.mTitle = this.vf.getString("key_pwd_cash_title");
        this.sFk = this.vf.getString("key_pwd_cash_money");
        x.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", bi.oM(this.sFk), bi.oM(this.mTitle));
        if (bi.oN(this.mTitle) || bi.oN(this.sFk)) {
            i = 0;
        }
        if (i == 0) {
            h.a(this.mController.xRr, i.uZS, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletBalanceFetchPwdInputUI.this.finish();
                }
            });
        } else {
            showDialog();
        }
    }

    private void showDialog() {
        if (this.sFl != null && this.sFl.isShowing()) {
            this.sFl.dismiss();
        }
        String str = "";
        if (((Orders) this.vf.getParcelable("key_orders")).pQx > 0.0d) {
            str = getResources().getString(i.uVt, new Object[]{e.d(r0.pQx, r0.pgf)});
        }
        if (this.sFl == null) {
            this.sFl = n.a(this, this.mTitle, this.sFk, str, new c() {
                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    WalletBalanceFetchPwdInputUI.this.sFl.dismiss();
                    if (WalletBalanceFetchPwdInputUI.this.cCT() != null) {
                        WalletBalanceFetchPwdInputUI.this.cCU().k(str);
                    }
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    x.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: dialog cancel. finish");
                    WalletBalanceFetchPwdInputUI.this.sFl.dismiss();
                    WalletBalanceFetchPwdInputUI.this.finish();
                }
            }, new n.a() {
                public final void bhU() {
                    x.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: pwd cancel.finish");
                    WalletBalanceFetchPwdInputUI.this.sFl.dismiss();
                    WalletBalanceFetchPwdInputUI.this.finish();
                }
            });
            return;
        }
        this.sFl.bnq();
        this.sFl.show();
    }

    public final void uO(int i) {
        if (i == 0) {
            finish();
        } else if (i == 1) {
            showDialog();
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
