package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.bhe;
import java.util.LinkedList;

public final class ae extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public ae(int[] iArr) {
        a aVar = new a();
        aVar.hnT = new bhd();
        aVar.hnU = new bhe();
        aVar.uri = "/cgi-bin/micromsg-bin/sendinviteemail";
        this.gLB = aVar.Kf();
        LinkedList linkedList = new LinkedList();
        for (int valueOf : iArr) {
            linkedList.add(Integer.valueOf(valueOf));
        }
        ((bhd) this.gLB.hnQ.hnY).wSv = linkedList;
        ((bhd) this.gLB.hnQ.hnY).wSu = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 116;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
