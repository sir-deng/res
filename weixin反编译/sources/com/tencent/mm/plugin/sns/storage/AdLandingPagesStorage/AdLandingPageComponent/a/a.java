package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mj;
import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.sdk.platformtools.bi;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public a(String str, String str2) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new mj();
        aVar.hnU = new mk();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
        this.gLB = aVar.Kf();
        mj mjVar = (mj) this.gLB.hnQ.hnY;
        mjVar.wbQ = str2;
        mjVar.wbN = str;
        mjVar.wbR = bi.chp();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return this.gLB.hnS;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
