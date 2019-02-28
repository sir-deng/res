package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.az;
import com.tencent.mm.plugin.game.c.ba;
import com.tencent.mm.sdk.platformtools.x;

public final class at extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public at(String str) {
        this(str, 0, 0);
    }

    public at(String str, int i, int i2) {
        a aVar = new a();
        aVar.hnT = new az();
        aVar.hnU = new ba();
        aVar.uri = "/cgi-bin/mmgame-bin/gamemsgblock";
        aVar.hnS = 1221;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.lSH = aVar.Kf();
        az azVar = (az) this.lSH.hnQ.hnY;
        azVar.nkU = str;
        azVar.nnb = i;
        azVar.nnc = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameMsgBlock", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1221;
    }
}
