package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static Orders a(Orders orders, String str, String str2, int i, String str3) {
        if (orders == null || orders.sUf == null || orders.sUf.size() <= 0) {
            x.d("MicroMsg.OrdersWrapper", "hy: params error");
        } else {
            for (Commodity commodity : orders.sUf) {
                commodity.pgb = i;
                commodity.pfY = str.equals("1") ? "2" : "1";
                commodity.pfZ = str2;
                commodity.pgd = str3;
            }
        }
        return orders;
    }
}
