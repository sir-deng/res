package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bof;
import com.tencent.mm.protocal.c.bog;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class n extends k implements com.tencent.mm.network.k {
    public final boolean fKG;
    private b gLB;
    private e gLE;
    private String puG = "";

    public n(boolean z, String str) {
        this.fKG = z;
        this.puG = bi.oM(str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        aVar.hnT = new bof();
        aVar.hnU = new bog();
        aVar.uri = "/cgi-bin/micromsg-bin/switchpushmail";
        aVar.hnS = 129;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bof bof = (bof) this.gLB.hnQ.hnY;
        bof.wnQ = this.fKG ? 1 : 2;
        bof.wXN = this.puG;
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final boolean Kj() {
        return true;
    }

    public final int getType() {
        return 24;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            bog bog = (bog) this.gLB.hnR.hnY;
            as.Hm();
            c.Db().set(17, Integer.valueOf(bog.wnQ));
        }
        this.gLE.a(i2, i3, str, this);
    }
}
