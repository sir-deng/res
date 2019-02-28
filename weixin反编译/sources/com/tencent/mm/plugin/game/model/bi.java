package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.dx;
import com.tencent.mm.plugin.game.c.dy;
import com.tencent.mm.sdk.platformtools.x;

public final class bi extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public bi(String str, String str2, String str3, boolean z) {
        a aVar = new a();
        aVar.hnT = new dx();
        aVar.hnU = new dy();
        aVar.uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
        this.lSH = aVar.Kf();
        dx dxVar = (dx) this.lSH.hnQ.hnY;
        dxVar.nkU = str;
        dxVar.nnm = str2;
        dxVar.nkS = str3;
        dxVar.nlh = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameSubscription", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1219;
    }
}
