package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.plugin.wallet_payu.create.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.plugin.wallet_payu.remittance.a.i;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import java.util.HashMap;

public class d implements ap {
    public String tiX = null;
    private int tiY = -1;

    static {
        a.i("PayUOpenProcess", c.class);
        a.i("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
        a.i("PayUForgotPwdProcess", f.class);
        a.i("PayUModifyPasswordProcess", g.class);
        a.i("PayURemittanceProcess", i.class);
        a.i("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
    }

    public static d bOi() {
        return (d) p.s(d.class);
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
