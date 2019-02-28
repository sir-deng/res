package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class av extends k implements com.tencent.mm.network.k {
    public String foW;
    private e gLE;
    public final b lSH;

    public av(String str, String str2, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hnT = new wx();
        aVar.hnU = new wy();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
        if (str2 == null) {
            this.foW = "";
        } else {
            this.foW = str2.trim();
        }
        this.lSH = aVar.Kf();
        wx wxVar = (wx) this.lSH.hnQ.hnY;
        wxVar.nnm = str;
        wxVar.wnX = str2;
        wxVar.wnY = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1329;
    }
}
