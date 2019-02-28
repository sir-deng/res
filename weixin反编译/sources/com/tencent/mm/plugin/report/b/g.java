package com.tencent.mm.plugin.report.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.af;
import com.tencent.mm.protocal.c.ag;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private static boolean bgH = false;
    private static Object lock = new Object();
    private b gLB;
    private e gLE;
    private xt pVX = null;
    public ag pVY;

    private static void hH(boolean z) {
        synchronized (lock) {
            bgH = z;
        }
    }

    public g(int i, int i2) {
        hH(true);
        af afVar = new af();
        this.pVX = new xt();
        try {
            afVar.vLm = i;
            afVar.vLn = i2;
            this.pVX.wpi = afVar;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        try {
            this.pVY = null;
            if (com.tencent.mm.kernel.g.Dp().gRu == null || com.tencent.mm.kernel.g.Dp().gRu.hoF == null) {
                x.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.gLE.a(i2, i3, str, this);
            } else if (i2 != 0) {
                x.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
                this.gLE.a(i2, i3, str, this);
                hH(false);
            } else {
                x.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
                this.pVY = ((xu) this.gLB.hnR.hnY).wpj;
                this.gLE.a(i2, i3, str, this);
                hH(false);
            }
        } finally {
            hH(false);
        }
    }

    public final int getType() {
        return 914;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        com.tencent.mm.kernel.g.Do();
        if (a.CE()) {
            b.a aVar = new b.a();
            aVar.hnX = false;
            aVar.hnT = this.pVX;
            aVar.hnU = new xu();
            aVar.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            aVar.hnS = 914;
            this.gLB = aVar.Kf();
            int a = a(eVar, this.gLB, this);
            if (a >= 0) {
                return a;
            }
            x.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                this.pVY = null;
                hH(false);
                return a;
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bi.i(e));
                return a;
            }
        }
        x.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
        return -1;
    }
}
