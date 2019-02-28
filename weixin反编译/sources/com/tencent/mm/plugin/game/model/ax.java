package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bg;
import com.tencent.mm.plugin.game.c.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class ax extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public ax(String str, String str2, boolean z) {
        a aVar = new a();
        aVar.hnT = new bg();
        aVar.hnU = new bh();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
        this.lSH = aVar.Kf();
        bg bgVar = (bg) this.lSH.hnQ.hnY;
        bgVar.nnm = str;
        bgVar.nkU = str2;
        bgVar.nnw = z;
        bgVar.nny = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1217;
    }
}
