package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.protocal.c.aj;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String kRA;
    public String kRy;
    public int kRz;

    public o(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, bmz bmz) {
        a aVar = new a();
        aVar.hnT = new ai();
        aVar.hnU = new aj();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcarditem";
        this.gLB = aVar.Kf();
        ai aiVar = (ai) this.gLB.hnQ.hnY;
        aiVar.fHP = str;
        aiVar.kQJ = str2;
        aiVar.fHR = i;
        aiVar.fHQ = str3;
        aiVar.vLt = str4;
        aiVar.vLs = str5;
        aiVar.vLu = i2;
        aiVar.vLv = i3;
        aiVar.vLw = bmz;
    }

    public final int getType() {
        return 651;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        aj ajVar;
        if (i2 == 0 && i3 == 0) {
            ajVar = (aj) this.gLB.hnR.hnY;
            if (ajVar != null) {
                this.kRy = ajVar.kRy;
                this.kRz = ajVar.kRz;
                this.kRA = ajVar.kRA;
            }
        } else {
            ajVar = (aj) this.gLB.hnR.hnY;
            if (ajVar != null) {
                this.kRy = ajVar.kRy;
                this.kRz = ajVar.kRz;
                this.kRA = ajVar.kRA;
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
