package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bb.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hGV;
    private int scene;
    private String ttp;

    public j(bdu bdu) {
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchreport";
        aVar.hnT = bdu;
        aVar.hnU = new bdv();
        this.hGV = aVar.Kf();
        this.scene = bdu.sfa;
        this.ttp = bdu.wQx;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.gLE.a(i2, i3, str, this);
            g.it(6);
            g.a(this.scene, 5, i2, i3, this.ttp);
            return;
        }
        this.gLE.a(i2, i3, str, this);
        g.it(7);
    }

    public final int getType() {
        return 1134;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", Integer.valueOf(this.scene));
        g.it(5);
        g.c(this.scene, 4, this.ttp);
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }
}
