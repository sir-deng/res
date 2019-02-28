package com.tencent.mm.plugin.aj.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cbh;
import com.tencent.mm.protocal.c.cbi;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.e gLE;
    private b hGV;
    cbh tqM = new cbh();
    cbi tqN;

    public e(List<String> list, int i, long j, List<oz> list2) {
        a aVar = new a();
        aVar.hnS = 1948;
        aVar.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
        aVar.hnT = new cbh();
        aVar.hnU = new cbi();
        this.hGV = aVar.Kf();
        this.tqM = (cbh) this.hGV.hnQ.hnY;
        this.tqM.wDS = g.Af(0);
        this.tqM.lTZ = w.eM(ad.getContext());
        this.tqM.woK = g.bgl();
        this.tqM.wDT = g.Jk();
        this.tqM.sfa = i;
        this.tqM.vWt = 0;
    }

    public final int getType() {
        return 1948;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tqN = (cbi) this.hGV.hnR.hnY;
            if (this.tqN != null) {
                x.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", this.tqN.vUV);
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
