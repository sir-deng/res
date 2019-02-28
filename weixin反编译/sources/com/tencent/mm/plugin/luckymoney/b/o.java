package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public final int getType() {
        return 980;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAsyncBizSubscribe", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
