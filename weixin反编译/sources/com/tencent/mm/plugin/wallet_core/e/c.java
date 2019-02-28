package com.tencent.mm.plugin.wallet_core.e;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;

public final class c {
    public static long tfk = 0;
    public static int tfl = 2;
    public static int tfm = 1;
    public static int tfn = 2;

    public static void bNV() {
        tfk = System.currentTimeMillis();
    }

    public static int bNW() {
        return (int) ((System.currentTimeMillis() - tfk) / 1000);
    }

    public static void b(Activity activity, Bundle bundle, int i) {
        com.tencent.mm.wallet_core.c ag = a.ag(activity);
        if (!o.bMc().bMy() && ag != null && ag.cCb()) {
            Orders orders = (Orders) bundle.getParcelable("key_orders");
            if (((PayInfo) bundle.getParcelable("key_pay_info")) != null && orders != null) {
                g.pWK.h(10725, Integer.valueOf(i), Integer.valueOf(r0.fDQ), Integer.valueOf((int) (orders.pTQ * 100.0d)), orders.pgf);
            }
        } else if (!o.bMc().bMy() && bundle != null && bundle.getBoolean("key_is_bind_reg_process", false)) {
            g.pWK.h(10932, Integer.valueOf(i), Integer.valueOf(bundle.getInt("key_bind_scene", 0)));
        }
    }

    public static void ee(int i, int i2) {
        g.pWK.h(10932, Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static void a(PayInfo payInfo, Orders orders) {
        if (!o.bMc().bMy() && payInfo != null && orders != null) {
            g.pWK.h(10725, Integer.valueOf(1), Integer.valueOf(payInfo.fDQ), Integer.valueOf((int) (orders.pTQ * 100.0d)), orders.pgf);
        }
    }
}
