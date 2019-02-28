package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.abh;
import com.tencent.mm.protocal.c.abi;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private static boolean bgH = false;
    private static Object lock = new Object();
    private b gLB;
    private e gLE;
    private a pVV = new a();
    private abh pVZ = null;

    public static boolean isRunning() {
        boolean z;
        synchronized (lock) {
            z = bgH;
        }
        return z;
    }

    private static void hH(boolean z) {
        synchronized (lock) {
            bgH = z;
        }
    }

    public h() {
        hH(true);
        this.pVZ = SmcProtoBufUtil.toMMGetStrategyReq();
        if (this.pVZ != null) {
            this.pVZ.wdU = new akp();
            this.pVZ.wdU.wyx = this.pVV.vP(0);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (g.Dp().gRu == null || g.Dp().gRu.hoF == null) {
            x.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.gLE.a(i2, i3, str, this);
        } else if (i2 != 0) {
            x.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnStrategyResp(i2, i3, null, 1);
            SmcLogic.OnStrategyResp(i2, i3, null, 2);
            this.gLE.a(i2, i3, str, this);
            hH(false);
        } else {
            x.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
            abi abi = (abi) this.gLB.hnR.hnY;
            this.pVV.a(abi.wee, 0);
            try {
                f toSmcKVStrategyResp = SmcProtoBufUtil.toSmcKVStrategyResp(abi);
                c toSmcIdkeyStrategyResp = SmcProtoBufUtil.toSmcIdkeyStrategyResp(abi);
                SmcLogic.OnStrategyResp(0, 0, toSmcKVStrategyResp.toByteArray(), 1);
                SmcLogic.OnStrategyResp(0, 0, toSmcIdkeyStrategyResp.toByteArray(), 2);
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bi.i(e));
            }
            this.gLE.a(i2, i3, str, this);
            hH(false);
        }
    }

    public final int getType() {
        g.Do();
        return a.CE() ? 988 : 989;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        g.Do();
        boolean CE = a.CE();
        if (!CE) {
            this.pVZ.wdT = com.tencent.mm.bp.b.be(bi.chc());
        }
        b.a aVar = new b.a();
        aVar.hnX = false;
        aVar.hnT = this.pVZ;
        aVar.hnU = new abi();
        aVar.uri = CE ? "/cgi-bin/micromsg-bin/getkvidkeystrategy" : "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
        aVar.hnS = getType();
        this.gLB = aVar.Kf();
        if (!CE) {
            this.gLB.a(ac.cez());
            this.gLB.fKU = 1;
        }
        int a = a(eVar, this.gLB, this);
        if (a < 0) {
            x.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                SmcLogic.OnStrategyResp(3, -1, null, 1);
                SmcLogic.OnStrategyResp(3, -1, null, 2);
                hH(false);
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bi.i(e));
            }
        }
        return a;
    }
}
