package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bp.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.bq;
import com.tencent.mm.plugin.game.c.br;
import com.tencent.mm.plugin.game.c.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class bb extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public bb(String str, LinkedList<String> linkedList, t tVar, t tVar2, t tVar3, boolean z) {
        s sVar;
        x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", (String) it.next());
        }
        a bqVar = new bq();
        bqVar.nnm = str;
        bqVar.nnJ = linkedList;
        String cP = g.cP(ad.getContext());
        if (bi.oN(cP)) {
            cP = bi.chi();
        }
        if (!bi.oN(m.countryCode)) {
            cP = m.countryCode;
        }
        bqVar.hxn = cP;
        if (tVar == null) {
            if (tVar2 != null) {
                tVar = tVar2;
            } else if (tVar3 != null) {
                tVar = tVar3;
            } else {
                tVar = null;
            }
        }
        bqVar.nnK = new s();
        if (tVar != null) {
            bqVar.nnK.nlU = tVar.nhU.niI;
            bqVar.nnK.nlV = tVar.field_appId;
            bqVar.nnK.nkS = tVar.niB;
            if (tVar.field_msgType == 100) {
                bqVar.nnK.nlX = tVar.niA;
            } else {
                bqVar.nnK.nlX = tVar.field_msgType;
            }
        }
        if (tVar2 != null) {
            sVar = bqVar.nnK;
            sVar.nlW |= 1;
        }
        if (tVar3 != null) {
            sVar = bqVar.nnK;
            sVar.nlW |= 2;
        }
        bqVar.nnL = SubCoreGameCenter.aRK().aRe();
        bqVar.nnM = z;
        bqVar.nnn = bi.chp() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", cP);
        b.a aVar = new b.a();
        aVar.hnT = bqVar;
        aVar.hnU = new br();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
        aVar.hnS = 2586;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.lSH = aVar.Kf();
    }

    public final int getType() {
        return 2586;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
