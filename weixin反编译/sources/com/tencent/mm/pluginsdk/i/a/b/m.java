package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bej;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends n {
    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
    }

    protected final ns i(q qVar) {
        return (ns) ((b) qVar).hnR.hnY;
    }

    public m(int i) {
        x.i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", Integer.valueOf(i));
        bej bej = new bej();
        bej.kzz = i;
        this.vnX.clear();
        this.vnX.add(bej);
    }

    protected final q cai() {
        a aVar = new a();
        com.tencent.mm.bp.a nrVar = new nr();
        nrVar.wdt.addAll(this.vnX);
        aVar.hnT = nrVar;
        aVar.hnU = new ns();
        aVar.uri = "/cgi-bin/micromsg-bin/checkresupdate";
        aVar.hnS = 721;
        aVar.hnV = 0;
        aVar.hnW = 0;
        return aVar.Kf();
    }

    public final int getType() {
        return 721;
    }
}
