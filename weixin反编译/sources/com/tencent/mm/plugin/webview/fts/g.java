package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.protocal.c.byw;
import com.tencent.mm.protocal.c.byx;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    public int fEg = -1;
    b gLB;
    private e gLE;

    public g() {
        a aVar = new a();
        aVar.hnT = new byw();
        aVar.hnU = new byx();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/weappsearchguide";
        aVar.hnS = 1866;
        this.gLB = aVar.Kf();
        aou Jk = com.tencent.mm.plugin.aj.a.g.Jk();
        byw byw = (byw) this.gLB.hnQ.hnY;
        if (Jk != null) {
            byw.xfV = (double) Jk.vXy;
            byw.xfW = (double) Jk.vXx;
        }
        byw.xfX = com.tencent.mm.plugin.aj.a.g.bgl();
    }

    public final int getType() {
        return this.gLB.hnS;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
