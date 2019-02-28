package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lq;
import com.tencent.mm.protocal.c.lr;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    private final String TAG = "MicroMsg.NetSceneMDRcvVoice";
    private b gLB;
    private e gLE;
    public lr loJ;

    public n(int i, com.tencent.mm.bp.b bVar, String str) {
        a aVar = new a();
        aVar.hnT = new lq();
        aVar.hnU = new lr();
        aVar.hnS = 1317;
        aVar.uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        lq lqVar = (lq) this.gLB.hnQ.hnY;
        lqVar.oeK = i;
        lqVar.waW = 1;
        lqVar.loT = str;
        lqVar.waU = null;
        lqVar.waV = bVar;
        x.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", Integer.valueOf(i), str);
    }

    public final int getType() {
        return 1317;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.loJ = (lr) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", Integer.valueOf(this.loJ.lot), this.loJ.lou, Integer.valueOf(this.loJ.waW));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
