package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bm;
import com.tencent.mm.plugin.game.c.bn;
import com.tencent.mm.plugin.game.c.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class ba extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public ba(String str, LinkedList<String> linkedList, t tVar, t tVar2, t tVar3, boolean z) {
        s sVar;
        x.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", (String) it.next());
        }
        a aVar = new a();
        aVar.hnT = new bm();
        aVar.hnU = new bn();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4";
        aVar.hnS = 2994;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.lSH = aVar.Kf();
        bm bmVar = (bm) this.lSH.hnQ.hnY;
        bmVar.nnm = str;
        bmVar.nnJ = linkedList;
        String cP = g.cP(ad.getContext());
        if (bi.oN(cP)) {
            cP = bi.chi();
        }
        if (!bi.oN(m.countryCode)) {
            cP = m.countryCode;
        }
        bmVar.hxn = cP;
        if (tVar == null) {
            if (tVar2 != null) {
                tVar = tVar2;
            } else if (tVar3 != null) {
                tVar = tVar3;
            } else {
                tVar = null;
            }
        }
        bmVar.nnK = new s();
        if (tVar != null) {
            bmVar.nnK.nlU = tVar.nhU.niI;
            bmVar.nnK.nlV = tVar.field_appId;
            bmVar.nnK.nkS = tVar.niB;
            if (tVar.field_msgType == 100) {
                bmVar.nnK.nlX = tVar.niA;
            } else {
                bmVar.nnK.nlX = tVar.field_msgType;
            }
        }
        if (tVar2 != null) {
            sVar = bmVar.nnK;
            sVar.nlW |= 1;
        }
        if (tVar3 != null) {
            sVar = bmVar.nnK;
            sVar.nlW |= 2;
        }
        bmVar.nnL = SubCoreGameCenter.aRK().aRe();
        bmVar.nnM = z;
        bmVar.nnn = bi.chp() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", cP);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 2994;
    }
}
