package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ak.b;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;

@a(3)
public class WalletOrderInfoUI extends WalletBaseUI {
    private String pbT;
    private Orders sKw;
    protected b.a taS = new b.a() {
        public final void v(String str, boolean z) {
            g.Dr();
            x Xv = ((h) g.h(h.class)).Ff().Xv(str);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + str + " succ: " + z);
            WalletOrderInfoUI.this.L(Xv);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (boI()) {
            this.sKw = bNr();
            this.pbT = this.vf.getString("key_trans_id");
            int i = this.vf.getInt("key_pay_type", -1);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", this.pbT);
            if (this.pbT != null) {
                if (i == -1) {
                    NT(this.pbT);
                } else {
                    cu(this.pbT, i);
                }
            } else if (this.sKw != null) {
                d(this.sKw);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.sKw != null && !bi.oN(this.sKw.username)) {
            ak.a.hhv.hN(this.sKw.username);
        }
    }

    protected boolean boI() {
        return true;
    }

    public Orders bNr() {
        return (Orders) this.vf.getParcelable("key_orders");
    }

    protected int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uKM;
    }

    public void NT(String str) {
        l(new z(str));
    }

    protected void cu(String str, int i) {
        l(new z(str, i));
    }

    private void d(Orders orders) {
        com.tencent.mm.sdk.platformtools.x.k("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", Integer.valueOf(orders.sUp));
        if (orders.sUp == 1) {
            cCT().c(this, WalletOrderInfoNewUI.class, this.vf);
        } else {
            cCT().c(this, WalletOrderInfoOldUI.class, this.vf);
        }
        finish();
    }

    protected void L(x xVar) {
        if (xVar != null && ((int) xVar.gKO) != 0) {
            String AW = xVar.AW();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + AW + " username: " + xVar.field_username);
            if (this.sKw.sUf != null && this.sKw.sUf.size() > 0) {
                for (Commodity commodity : this.sKw.sUf) {
                    commodity.pgg = AW;
                }
            }
        }
    }

    protected static String d(String str, String str2, String str3, String str4, String str5) {
        try {
            CharSequence encode = URLEncoder.encode(URLEncoder.encode(str5, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.indexOf("%7Breqkey%7D") > 0 || str.indexOf("%7Btransid%7D") > 0 || str.indexOf("%7Bphone%7D") > 0 || str.indexOf("%7Bremark%7D") > 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
                return str.replace("%7Breqkey%7D", str2).replace("%7Btransid%7D", str3).replace("%7Bphone%7D", str4).replace("%7Bremark%7D", encode);
            } else if (str.indexOf("{reqkey}") > 0 || str.indexOf("{transid}") > 0 || str.indexOf("{phone}") > 0 || str.indexOf("{remark}") > 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
                return str.replace("{reqkey}", str2).replace("{transid}", str3).replace("{phone}", str4).replace("{remark}", encode);
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
                return str + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[]{str2, str3, str4, encode});
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WalletOrderInfoUI", e, "", new Object[0]);
            return str;
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof z) || i != 0 || i2 != 0) {
            return false;
        }
        this.sKw = ((z) kVar).sOZ;
        if (this.sKw != null) {
            if (!(this.sKw.sUf == null || this.sKw.sUf.size() == 0)) {
                Commodity commodity = (Commodity) this.sKw.sUf.get(0);
                this.pbT = commodity.fvD;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + commodity.toString());
                g.Dr();
                com.tencent.mm.k.a Xv = ((h) g.h(h.class)).Ff().Xv(commodity.pgg);
                if (Xv == null || ((int) Xv.gKO) == 0) {
                    ak.a.hhv.a(commodity.pgg, "", this.taS);
                } else {
                    L(Xv);
                }
            }
            d(this.sKw);
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
            com.tencent.mm.ui.base.h.a(this.mController.xRr, i.uZS, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletOrderInfoUI.this.finish();
                }
            });
        }
        return true;
    }
}
