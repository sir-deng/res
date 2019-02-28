package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g;

public final class c extends g {
    public bfe lpg;

    public c(String str, int i) {
        a aVar = new a();
        aVar.hnT = new bfd();
        aVar.hnU = new bfe();
        aVar.uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bfd bfd = (bfd) this.gLB.hnQ.hnY;
        bfd.wRt = str;
        bfd.scene = i;
        x.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", str, Integer.valueOf(i));
    }

    protected final void b(int i, int i2, String str, q qVar) {
        this.lpg = (bfe) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.lpg.lot), this.lpg.lou);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bfe bfe = (bfe) ((b) qVar).hnR.hnY;
        this.zQy = bfe.lot;
        this.zQz = bfe.lou;
    }

    public final int getType() {
        return 2811;
    }

    public final boolean azz() {
        return true;
    }
}
