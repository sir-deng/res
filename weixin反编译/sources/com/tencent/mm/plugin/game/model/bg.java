package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bb;
import com.tencent.mm.plugin.game.c.bc;
import com.tencent.mm.sdk.platformtools.x;

public final class bg extends k implements com.tencent.mm.network.k {
    private e gLE;
    private final b lSH;

    public bg(String str, int i, int i2, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new bb();
        aVar.hnU = new bc();
        aVar.uri = "/cgi-bin/mmgame-bin/gamereport";
        this.lSH = aVar.Kf();
        bb bbVar = (bb) this.lSH.hnQ.hnY;
        bbVar.nkU = str;
        bbVar.nne = i;
        bbVar.nnf = i2;
        bbVar.nng = str2;
        bbVar.nnh = str3;
        bbVar.nnd = (int) (System.currentTimeMillis() / 1000);
    }

    public final int getType() {
        return 1223;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndex", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
