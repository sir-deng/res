package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ast;
import com.tencent.mm.protocal.c.asu;

public final class g extends k implements com.tencent.mm.network.k {
    private final String fGh;
    private e gLE;
    public final String qmb;
    public final int qmc;
    private final int scene;

    public g(String str, String str2, int i, int i2) {
        this.fGh = str;
        this.qmb = str2;
        this.qmc = i;
        this.scene = i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        asu asu = (asu) ((b) qVar).hnR.hnY;
        this.gLE.a(i2, asu.wfW.fun, asu.wfW.fuo, this);
    }

    public final int getType() {
        return 1144;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        com.tencent.mm.bp.a ast = new ast();
        ast.fGh = this.fGh;
        ast.wGW = this.qmb;
        ast.wGX = this.qmc;
        aVar.hnT = ast;
        aVar.uri = "/cgi-bin/mmbiz-bin/moduserauth";
        aVar.hnU = new asu();
        aVar.hnS = 1144;
        aVar.hnV = 0;
        aVar.hnW = 0;
        return a(eVar, aVar.Kf(), this);
    }
}
