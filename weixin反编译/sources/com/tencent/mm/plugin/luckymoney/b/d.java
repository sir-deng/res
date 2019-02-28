package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    c ohp;

    public d() {
        init();
    }

    private void init() {
        this.ohp = new c();
        g.Dr();
        String str = (String) g.Dq().Db().get(356355, null);
        if (bi.oN(str)) {
            this.ohp.ohg = 2000.0d;
            this.ohp.ohf = 100;
            this.ohp.ohk = 200.0d;
            this.ohp.ohl = 0.01d;
            this.ohp.ohj = 200.0d;
        } else {
            try {
                this.ohp.aH(str.getBytes("ISO-8859-1"));
            } catch (Exception e) {
                x.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
                this.ohp.ohg = 2000.0d;
                this.ohp.ohf = 100;
                this.ohp.ohk = 200.0d;
                this.ohp.ohl = 0.01d;
                this.ohp.ohj = 200.0d;
            }
        }
        x.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.ohp.ohg + " maxTotalNum:" + this.ohp.ohf + " perGroupMaxValue:" + this.ohp.ohk + " perMinValue:" + this.ohp.ohl + " perPersonMaxValue:" + this.ohp.ohj);
    }

    public final c aXH() {
        if (this.ohp == null) {
            init();
        }
        return this.ohp;
    }
}
