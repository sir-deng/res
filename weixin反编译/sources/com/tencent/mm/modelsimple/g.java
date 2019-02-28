package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.protocal.c.un;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class g extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public int opType;

    public g(int i, String str) {
        this.opType = i;
        a aVar = new a();
        aVar.hnT = new um();
        aVar.hnU = new un();
        aVar.uri = "/cgi-bin/micromsg-bin/facebookauth";
        this.gLB = aVar.Kf();
        um umVar = (um) this.gLB.hnQ.hnY;
        if (bi.oN(str)) {
            str = "";
        }
        umVar.wjf = str;
        umVar.nne = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 183;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            un unVar = (un) this.gLB.hnR.hnY;
            int i4 = unVar.wRa.vQL;
            if (i4 != 0) {
                x.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = " + i4);
                this.gLE.a(4, i4, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + unVar.wjh + ", fbusername = " + unVar.wji);
            if (this.opType == 0 || this.opType == 1) {
                as.Hm();
                c.Db().set(65825, unVar.wjh);
                com.tencent.mm.ac.b.iT(unVar.wjh);
                as.Hm();
                c.Db().set(65826, unVar.wji);
                as.Hm();
                c.Db().lO(true);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
