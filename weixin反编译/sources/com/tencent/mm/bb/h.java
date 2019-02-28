package com.tencent.mm.bb;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.c.aqm;
import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    public int fEg;
    private e gLE;
    private b hGV;
    private int hMG;
    public aqn hML;
    public int hMM;
    public String hMN;
    public int scene;

    public h(int i, int i2, int i3, int i4, String str, long j, String str2) {
        this.scene = i;
        this.hMG = i3;
        this.fEg = i4;
        this.hMM = i2;
        this.hMN = str2;
        x.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2));
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchguide";
        aVar.hnT = new aqm();
        aVar.hnU = new aqn();
        this.hGV = aVar.Kf();
        aqm aqm = (aqm) this.hGV.hnQ.hnY;
        aqm.sfa = i;
        aqm.wDS = i3;
        aqm.wDT = g.Jk();
        aqm.wDU = i2;
        aqm.lTZ = str;
        aqm.wDV = j;
    }

    public final int getType() {
        return 1048;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.hML = (aqn) this.hGV.hnR.hnY;
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
