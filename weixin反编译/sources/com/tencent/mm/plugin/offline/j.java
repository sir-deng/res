package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.c;

public class j extends c {
    public final c a(Activity activity, Bundle bundle) {
        String str;
        String str2 = "";
        if (bundle != null) {
            if (bi.oN(bundle.getString("key_trans_id"))) {
                Orders orders = (Orders) bundle.getParcelable("key_orders");
                if (!(orders == null || orders.sUf == null || orders.sUf.size() <= 0)) {
                    str = ((Commodity) orders.sUf.get(0)).fvD;
                }
            } else {
                str = "key_trans_id";
            }
            g.Dr();
            g.Dp().gRu.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
            c(activity, WalletOrderInfoUI.class, bundle);
            g.Dr();
            g.Dq().Db().a(a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true));
            return this;
        }
        str = str2;
        g.Dr();
        g.Dp().gRu.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
        c(activity, WalletOrderInfoUI.class, bundle);
        g.Dr();
        g.Dq().Db().a(a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true));
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletOrderInfoUI) {
            C(activity);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        ah(activity);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aLn() {
        return "ShowOrderSuccessProcess";
    }
}
