package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bgp;
import com.tencent.mm.protocal.c.bgq;

public final class h extends k implements com.tencent.mm.network.k {
    private String foW;
    private e gLE;
    public byte[] qma;
    public bgq qmd;

    public h(String str) {
        this.foW = str;
    }

    public h(byte[] bArr) {
        this.qma = bArr;
    }

    public final int getType() {
        return 1169;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        com.tencent.mm.bp.a bgp = new bgp();
        bgp.foW = this.foW;
        if (this.qma != null) {
            bgp.wvB = n.N(this.qma).wRm;
        }
        aVar.hnT = bgp;
        aVar.hnU = new bgq();
        aVar.hnS = 1169;
        aVar.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
        aVar.hnV = 0;
        aVar.hnW = 0;
        return a(eVar, aVar.Kf(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.qmd = (bgq) ((b) qVar).hnR.hnY;
        this.gLE.a(i2, this.qmd.wfW.fun, this.qmd.wfW.fuo, this);
    }
}
