package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class au extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public au(String str, LinkedList<String> linkedList, LinkedList<String> linkedList2, int i) {
        a aVar = new a();
        aVar.hnT = new xa();
        aVar.hnU = new xb();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearch";
        this.lSH = aVar.Kf();
        xa xaVar = (xa) this.lSH.hnQ.hnY;
        xaVar.nnm = str;
        xaVar.wof = linkedList;
        xaVar.wnY = linkedList2;
        xaVar.wog = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1328;
    }
}
