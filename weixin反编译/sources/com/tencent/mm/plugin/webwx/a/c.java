package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tu;
import com.tencent.mm.protocal.c.tv;

public final class c extends k implements com.tencent.mm.network.k {
    private e gLE;
    private final b hGV;

    public c(String str) {
        a aVar = new a();
        com.tencent.mm.bp.a tuVar = new tu();
        com.tencent.mm.bp.a tvVar = new tv();
        aVar.hnT = tuVar;
        aVar.hnU = tvVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
        tuVar.wiB = str;
        this.hGV = aVar.Kf();
    }

    public final int getType() {
        return 973;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
