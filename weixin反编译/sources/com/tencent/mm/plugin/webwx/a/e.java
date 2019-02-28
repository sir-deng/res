package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ua;
import com.tencent.mm.protocal.c.ub;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.e gLE;
    public final b hGV;
    public boolean tUL;

    public e(String str, String str2, boolean z) {
        this.tUL = z;
        a aVar = new a();
        com.tencent.mm.bp.a uaVar = new ua();
        com.tencent.mm.bp.a ubVar = new ub();
        aVar.hnT = uaVar;
        aVar.hnU = ubVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
        uaVar.wiB = str;
        uaVar.wiM = str2;
        uaVar.wiO = z;
        this.hGV = aVar.Kf();
    }

    public final int getType() {
        return 972;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
