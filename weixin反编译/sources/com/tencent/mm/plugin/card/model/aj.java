package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yq;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.sdk.platformtools.x;

public final class aj extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public com.tencent.mm.bp.b kRX;
    public boolean kRY;
    public String kRy;

    public aj(String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, com.tencent.mm.bp.b bVar) {
        a aVar = new a();
        aVar.hnT = new yq();
        aVar.hnU = new yr();
        aVar.uri = "/cgi-bin/micromsg-bin/getavailablecard";
        this.gLB = aVar.Kf();
        yq yqVar = (yq) this.gLB.hnQ.hnY;
        yqVar.kPE = str;
        yqVar.kZN = i;
        yqVar.kZO = str2;
        yqVar.kZP = str3;
        yqVar.time_stamp = i2;
        yqVar.kZQ = str4;
        yqVar.kPy = str5;
        yqVar.kZR = str6;
        yqVar.kRX = bVar;
        if ("INVOICE".equalsIgnoreCase(str6)) {
            yqVar.wpG = 1;
        } else {
            yqVar.wpG = 0;
        }
    }

    public final int getType() {
        return 664;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            yr yrVar = (yr) this.gLB.hnR.hnY;
            this.kRy = yrVar.kRy;
            this.kRX = yrVar.kRX;
            this.kRY = yrVar.wpH != 0;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
