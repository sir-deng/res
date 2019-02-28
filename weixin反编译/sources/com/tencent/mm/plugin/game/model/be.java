package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bw;
import com.tencent.mm.plugin.game.c.bx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class be extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public be(int i, int i2, int i3) {
        x.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", Integer.valueOf(i), Integer.valueOf(15), Integer.valueOf(i2), Integer.valueOf(i3));
        a aVar = new a();
        aVar.hnT = new bw();
        aVar.hnU = new bx();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
        this.lSH = aVar.Kf();
        bw bwVar = (bw) this.lSH.hnQ.hnY;
        bwVar.nok = i;
        bwVar.nol = 15;
        bwVar.nnm = w.cfV();
        bwVar.nos = i2;
        bwVar.not = i3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1220;
    }
}
