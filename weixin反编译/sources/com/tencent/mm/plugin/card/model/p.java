package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ak;
import com.tencent.mm.protocal.c.al;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class p extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String kRA;
    public String kRy;
    public int kRz;

    public p(LinkedList<kp> linkedList, int i, String str, String str2, int i2) {
        a aVar = new a();
        aVar.hnT = new ak();
        aVar.hnU = new al();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
        this.gLB = aVar.Kf();
        ak akVar = (ak) this.gLB.hnQ.hnY;
        akVar.vLx = linkedList;
        akVar.fHR = i;
        akVar.vLt = str;
        akVar.vLs = str2;
        akVar.vLu = i2;
    }

    public final int getType() {
        return 687;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            al alVar = (al) this.gLB.hnR.hnY;
            this.kRy = alVar.kRy;
            this.kRz = alVar.kRz;
            this.kRA = alVar.kRA;
            x.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.kRz + " ret_msg = " + this.kRA);
        }
        this.gLE.a(i2, i3, str, this);
    }
}
