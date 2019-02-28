package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bi;
import com.tencent.mm.plugin.game.c.bj;
import com.tencent.mm.plugin.game.c.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class az extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public az(String str, LinkedList<String> linkedList, t tVar, t tVar2, t tVar3, boolean z) {
        s sVar;
        x.i("MicroMsg.NetSceneGetGameIndex2", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndex2", "install id:[%s]", (String) it.next());
        }
        a aVar = new a();
        aVar.hnT = new bi();
        aVar.hnU = new bj();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex2";
        aVar.hnS = 1238;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.lSH = aVar.Kf();
        bi biVar = (bi) this.lSH.hnQ.hnY;
        biVar.nnm = str;
        biVar.nnJ = linkedList;
        String cP = g.cP(ad.getContext());
        if (com.tencent.mm.sdk.platformtools.bi.oN(cP)) {
            cP = com.tencent.mm.sdk.platformtools.bi.chi();
        }
        if (!com.tencent.mm.sdk.platformtools.bi.oN(m.countryCode)) {
            cP = m.countryCode;
        }
        biVar.hxn = cP;
        if (tVar == null) {
            if (tVar2 != null) {
                tVar = tVar2;
            } else if (tVar3 != null) {
                tVar = tVar3;
            } else {
                tVar = null;
            }
        }
        biVar.nnK = new s();
        if (tVar != null) {
            biVar.nnK.nlU = tVar.nhU.niI;
            biVar.nnK.nlV = tVar.field_appId;
            biVar.nnK.nkS = tVar.niB;
            if (tVar.field_msgType == 100) {
                biVar.nnK.nlX = tVar.niA;
            } else {
                biVar.nnK.nlX = tVar.field_msgType;
            }
        }
        if (tVar2 != null) {
            sVar = biVar.nnK;
            sVar.nlW |= 1;
        }
        if (tVar3 != null) {
            sVar = biVar.nnK;
            sVar.nlW |= 2;
        }
        biVar.nnL = SubCoreGameCenter.aRK().aRe();
        biVar.nnM = z;
        biVar.nnn = com.tencent.mm.sdk.platformtools.bi.chp() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndex2", "Country Code: %s", cP);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndex2", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1238;
    }
}
