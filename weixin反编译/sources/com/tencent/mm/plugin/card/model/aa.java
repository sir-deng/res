package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aam;
import com.tencent.mm.protocal.c.aan;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.sdk.platformtools.x;

public final class aa extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String kRy;

    public aa(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, bmz bmz) {
        a aVar = new a();
        aVar.hnT = new aam();
        aVar.hnU = new aan();
        aVar.uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
        this.gLB = aVar.Kf();
        aam aam = (aam) this.gLB.hnQ.hnY;
        aam.fHP = str;
        aam.fHR = i;
        aam.kQJ = str2;
        aam.fHQ = str3;
        aam.vLt = str4;
        aam.vLs = str5;
        aam.vLu = i2;
        aam.wqy = str6;
        aam.vLw = bmz;
    }

    public final int getType() {
        return 645;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.kRy = ((aan) this.gLB.hnR.hnY).kRy;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
