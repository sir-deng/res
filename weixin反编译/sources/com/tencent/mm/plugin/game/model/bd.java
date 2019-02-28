package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bu;
import com.tencent.mm.plugin.game.c.bv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class bd extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public bd(int i, LinkedList<String> linkedList, int i2, boolean z) {
        a aVar = new a();
        aVar.hnT = new bu();
        aVar.hnU = new bv();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
        this.lSH = aVar.Kf();
        bu buVar = (bu) this.lSH.hnQ.hnY;
        buVar.nok = i;
        buVar.nol = 15;
        buVar.nnm = w.cfV();
        buVar.hxn = bi.chi();
        buVar.nom = i2;
        buVar.nnJ = linkedList;
        buVar.non = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetLibGameList", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1218;
    }
}
