package com.tencent.mm.plugin.order.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.ui.a.b;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI extends WalletPreferenceUI {
    protected f jPY;
    private int pil;
    private MallTransactionObject pim = null;
    private c pio;

    public void onCreate(Bundle bundle) {
        String string;
        String str = null;
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.c ag = a.ag(this);
        if (ag != null && (ag instanceof com.tencent.mm.plugin.order.a.a)) {
            string = bjq().getString("key_trans_id");
            str = bjq().getString("bill_id");
        } else if (getIntent().getIntExtra("scene", 0) == 1 || getIntent().getIntExtra("scene", 0) == 2) {
            string = getIntent().getStringExtra("trans_id");
            str = getIntent().getStringExtra("bill_id");
        } else {
            string = null;
        }
        if (bi.oN(string)) {
            x.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
            h.a(this.mController.xRr, i.uZS, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MallOrderTransactionInfoUI.this.finish();
                }
            });
        }
        this.pil = bjq().getInt("key_pay_type");
        initView();
        cCY().a(new com.tencent.mm.plugin.order.model.h(string, str), true, 1);
    }

    protected final void initView() {
        setMMTitle(i.uRP);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MallOrderTransactionInfoUI.this.finish();
                return false;
            }
        });
        this.jPY = this.yrJ;
        this.pio = new c(this);
        this.pio.init();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.pio != null) {
            this.pio.release();
        }
    }

    protected final int getLayoutId() {
        return g.uJH;
    }

    public final int XK() {
        return l.vgX;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final boolean g(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof com.tencent.mm.plugin.order.model.h) {
            MallOrderDetailObject mallOrderDetailObject = ((com.tencent.mm.plugin.order.model.h) kVar).pgM;
            if (mallOrderDetailObject != null) {
                List list;
                this.pim = mallOrderDetailObject.pfB;
                this.jPY.removeAll();
                Context context = this.mController.xRr;
                f fVar = this.jPY;
                MallTransactionObject mallTransactionObject = this.pim;
                Object[] objArr = new Object[]{this.pio};
                if (mallTransactionObject == null) {
                    list = null;
                } else {
                    com.tencent.mm.plugin.order.model.a.a bVar;
                    switch (mallTransactionObject.pfQ) {
                        case 21:
                            bVar = new b();
                            break;
                        default:
                            bVar = new com.tencent.mm.plugin.order.ui.a.a();
                            if (objArr[0] instanceof c) {
                                ((com.tencent.mm.plugin.order.ui.a.a) bVar).pio = (c) objArr[0];
                                break;
                            }
                            break;
                    }
                    list = bVar.a(context, fVar, mallTransactionObject);
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        this.jPY.a((Preference) list.get(i3));
                    }
                }
                this.jPY.notifyDataSetChanged();
            }
        }
        return true;
    }

    private Bundle bjq() {
        Bundle af = a.af(this);
        if (af == null) {
            return new Bundle();
        }
        return af;
    }
}
