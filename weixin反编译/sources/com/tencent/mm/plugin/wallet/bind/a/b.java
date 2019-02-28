package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class b extends l {
    private com.tencent.mm.ad.b gLB;
    private e gLE;
    private String sHQ;

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneSetMainBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            p.bKx();
            p.bKy();
            ag.ND(this.sHQ);
        }
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return 621;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
