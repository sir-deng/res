package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.ayw;
import com.tencent.mm.protocal.c.ayx;
import com.tencent.mm.protocal.c.bex;
import com.tencent.mm.protocal.c.tr;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public LinkedList<tr> pjF;
    public LinkedList<at> pjG;
    public String pju;

    public j(LinkedList<bex> linkedList, int i) {
        int i2 = 0;
        a aVar = new a();
        aVar.hnT = new ayw();
        aVar.hnU = new ayx();
        aVar.uri = "/cgi-bin/micromsg-bin/presubmitorder";
        this.gLB = aVar.Kf();
        ayw ayw = (ayw) this.gLB.hnQ.hnY;
        ayw.vXR = linkedList;
        if (linkedList != null) {
            i2 = linkedList.size();
        }
        ayw.phc = i2;
        ayw.wMt = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        ayx ayx = (ayx) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0 && ayx.vXT == 0) {
            x.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + ayx.wsH);
            x.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + ayx.vXS);
            this.pjF = ayx.wMu;
            this.pju = ayx.vXS;
            this.pjG = ayx.wMv;
        }
        if (i3 == 0 && ayx.vXT != 0) {
            i3 = ayx.vXT;
            str = ayx.vXU;
        }
        x.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + i3 + ", errMsg " + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
