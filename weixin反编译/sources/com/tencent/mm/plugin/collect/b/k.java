package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfa;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g;

public final class k extends g {
    public bfb lor;

    public k(String str, int i) {
        a aVar = new a();
        aVar.hnT = new bfa();
        aVar.hnU = new bfb();
        aVar.uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bfa bfa = (bfa) this.gLB.hnQ.hnY;
        bfa.wRt = str;
        bfa.scene = i;
        x.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", str, Integer.valueOf(i));
    }

    protected final void b(int i, int i2, String str, q qVar) {
        this.lor = (bfb) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.lor.lot), this.lor.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bfb bfb = (bfb) ((b) qVar).hnR.hnY;
        this.zQy = bfb.lot;
        this.zQz = bfb.lou;
    }

    public final int getType() {
        return 1800;
    }
}
