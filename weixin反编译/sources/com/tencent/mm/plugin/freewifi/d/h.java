package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.protocal.c.aez;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.protocal.c.wr;

public final class h extends c {
    protected final void aMC() {
        a aVar = new a();
        aVar.hnT = new aez();
        aVar.hnU = new afa();
        aVar.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
        aVar.hnS = 1760;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int getType() {
        return 1760;
    }

    public h(String str, int i, String str2) {
        aMC();
        aez aez = (aez) this.gLB.hnQ.hnY;
        aez.appId = str;
        aez.mNW = i;
        aez.fsK = str2;
    }

    public final wr aMG() {
        afa afa = (afa) this.gLB.hnR.hnY;
        if (afa != null) {
            return afa.vKW;
        }
        return null;
    }
}
