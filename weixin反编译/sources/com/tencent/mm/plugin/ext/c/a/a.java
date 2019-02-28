package com.tencent.mm.plugin.ext.c.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    public e gLE;
    public String mUrl = null;
    public int mhh = -1;

    public a(String str, int i, int i2) {
        this.mUrl = str;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new mx();
        aVar.hnU = new my();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
        aVar.hnS = 782;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        x.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", str);
        mx mxVar = (mx) this.gLB.hnQ.hnY;
        mxVar.URL = this.mUrl;
        mxVar.wcr = i;
        mxVar.wcs = i2;
    }

    public final int getType() {
        return 782;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        my myVar = (my) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0) {
            this.mhh = myVar.kzz;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
