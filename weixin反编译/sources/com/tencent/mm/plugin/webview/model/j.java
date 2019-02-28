package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afr;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gQm;
    public Object tag;

    public j(String str, String str2, int i, int i2) {
        x.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        a aVar = new a();
        aVar.hnT = new afr();
        aVar.hnU = new afs();
        aVar.uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
        this.gLB = aVar.Kf();
        afr afr = (afr) this.gLB.hnQ.hnY;
        afr.URL = str;
        afr.wun = str2;
        afr.Width = i;
        afr.Height = i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        this.gQm.a(i2, i3, str, this);
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        }
    }

    public final int getType() {
        return 673;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
