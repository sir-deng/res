package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.fl;
import com.tencent.mm.plugin.remittance.model.n;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class RemittanceResultUI extends WalletBaseUI {
    private Orders pVi;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (boI()) {
            int i;
            boolean z;
            int i2;
            PayInfo payInfo;
            b flVar;
            uV(4);
            getWindow().setBackgroundDrawableResource(c.transparent);
            this.pVi = (Orders) this.vf.getParcelable("key_orders");
            PayInfo payInfo2 = (PayInfo) this.vf.getParcelable("key_pay_info");
            if (payInfo2 != null) {
                i = payInfo2.fDQ;
            } else {
                i = 0;
            }
            if (i == 31 || i == 5) {
                z = false;
            } else {
                z = true;
            }
            String str = "MicroMsg.RemittanceResultUI";
            String str2 = "orders==null:%s, paysScene: %s, needFetchF2fData: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.pVi == null);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.pVi != null) {
                x.i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", Integer.valueOf(this.pVi.sUp));
                if (this.pVi.sUp != 1) {
                    z(RemittanceResultOldUI.class);
                } else if (z) {
                    Orders orders = this.pVi;
                    if (payInfo2 == null || payInfo2.vGl == null) {
                        z(RemittanceResultNewUI.class);
                        finish();
                    } else {
                        x.i("MicroMsg.RemittanceResultUI", "fetch f2f data");
                        String string = payInfo2.vGl.getString("extinfo_key_11");
                        String str3 = "";
                        if (orders != null && orders.sUf.size() > 0) {
                            str3 = ((Commodity) orders.sUf.get(0)).fvD;
                        }
                        int i3 = payInfo2.vGl.getInt("extinfo_key_15", 0);
                        str2 = payInfo2.vGl.getString("extinfo_key_7");
                        String string2 = payInfo2.vGl.getString("extinfo_key_3");
                        int i4 = payInfo2.vGl.getInt("extinfo_key_12", 0);
                        String string3 = payInfo2.vGl.getString("extinfo_key_13");
                        String string4 = payInfo2.vGl.getString("extinfo_key_14");
                        String string5 = payInfo2.vGl.getString("extinfo_key_16");
                        if (bi.oN(string5)) {
                            string5 = str3;
                        }
                        x.i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", string, string5, Integer.valueOf(i3), str2, string2, Integer.valueOf(i4), string3, string4, Integer.valueOf(payInfo2.fDM), Integer.valueOf(payInfo2.fDQ));
                        jl(2773);
                        int i5 = payInfo2.fDM;
                        int i6 = payInfo2.fDQ;
                        l(new n(string, string5, i3, str2, string2, i5, i4, string3, string4));
                    }
                }
                i2 = 0;
                payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
                if (payInfo != null) {
                    i2 = payInfo.fDQ;
                }
                if (i2 != 33 || i2 == 32 || i2 == 48 || i2 == 31) {
                    flVar = new fl();
                    flVar.fvB.fvC = payInfo.fvC;
                    if (i2 != 31) {
                        flVar.fvB.type = 0;
                    } else if (i2 == 32 || i2 == 33) {
                        flVar.fvB.type = 1;
                    }
                    if (!(this.pVi == null || this.pVi.sUf.isEmpty())) {
                        flVar.fvB.fvD = ((Commodity) this.pVi.sUf.get(0)).fvD;
                    }
                    com.tencent.mm.sdk.b.a.xmy.m(flVar);
                }
                return;
            }
            z(RemittanceResultNewUI.class);
            finish();
            i2 = 0;
            payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
            if (payInfo != null) {
                i2 = payInfo.fDQ;
            }
            if (i2 != 33) {
            }
            flVar = new fl();
            flVar.fvB.fvC = payInfo.fvC;
            if (i2 != 31) {
                flVar.fvB.type = 1;
            } else {
                flVar.fvB.type = 0;
            }
            flVar.fvB.fvD = ((Commodity) this.pVi.sUf.get(0)).fvD;
            com.tencent.mm.sdk.b.a.xmy.m(flVar);
        }
    }

    private void z(Class<?> cls) {
        if (cCT() == null) {
            a(cls, getIntent());
        } else {
            cCT().c(this, cls, this.vf);
        }
    }

    protected boolean boI() {
        return true;
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof n)) {
            return false;
        }
        x.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        n nVar = (n) kVar;
        if (i == 0 && i2 == 0) {
            lg lgVar = nVar.pQn;
            x.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", Integer.valueOf(lgVar.lot), lgVar.lou, lgVar.sUS);
            if (lgVar.lot == 0) {
                try {
                    this.vf.putByteArray("key_succpage_resp", lgVar.toByteArray());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RemittanceResultUI", e, "pass succ page resp error: %s", e.getMessage());
                }
                z(RemittanceResultNewUI.class);
                finish();
                return true;
            }
            Toast.makeText(this, lgVar.lou, 1).show();
        }
        z(RemittanceResultNewUI.class);
        finish();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        jm(2773);
    }

    protected int getLayoutId() {
        return -1;
    }
}
