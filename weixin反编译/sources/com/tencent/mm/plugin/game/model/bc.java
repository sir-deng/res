package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bp.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bs;
import com.tencent.mm.plugin.game.c.bt;
import com.tencent.mm.plugin.game.c.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class bc extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public bc(String str, LinkedList<String> linkedList, t tVar, t tVar2, t tVar3, boolean z) {
        s sVar;
        x.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", (String) it.next());
        }
        a bsVar = new bs();
        bsVar.nnm = str;
        bsVar.nnJ = linkedList;
        String cP = g.cP(ad.getContext());
        if (bi.oN(cP)) {
            cP = bi.chi();
        }
        if (!bi.oN(m.countryCode)) {
            cP = m.countryCode;
        }
        bsVar.hxn = cP;
        if (tVar == null) {
            if (tVar2 != null) {
                tVar = tVar2;
            } else if (tVar3 != null) {
                tVar = tVar3;
            } else {
                tVar = null;
            }
        }
        bsVar.nnK = new s();
        if (tVar != null) {
            bsVar.nnK.nlU = tVar.nhU.niI;
            bsVar.nnK.nlV = tVar.field_appId;
            bsVar.nnK.nkS = tVar.niB;
            if (tVar.field_msgType == 100) {
                bsVar.nnK.nlX = tVar.niA;
            } else {
                bsVar.nnK.nlX = tVar.field_msgType;
            }
        }
        if (tVar2 != null) {
            sVar = bsVar.nnK;
            sVar.nlW |= 1;
        }
        if (tVar3 != null) {
            sVar = bsVar.nnK;
            sVar.nlW |= 2;
        }
        bsVar.nnL = SubCoreGameCenter.aRK().aRe();
        bsVar.nnM = z;
        bsVar.nnn = bi.chp() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", cP);
        b.a aVar = new b.a();
        aVar.hnT = bsVar;
        aVar.hnU = new bt();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
        aVar.hnS = 2855;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.lSH = aVar.Kf();
    }

    public final int getType() {
        return 2855;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
