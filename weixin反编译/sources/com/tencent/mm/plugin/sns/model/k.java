package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bc;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    private b gLB;
    public e gLE;
    private LinkedList<bi> qZL;

    public k(LinkedList<bi> linkedList) {
        a aVar = new a();
        aVar.hnT = new bc();
        aVar.hnU = new bd();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        this.gLB = aVar.Kf();
        ((bc) this.gLB.hnQ.hnY).vMY = linkedList;
        this.qZL = linkedList;
    }

    public final int getType() {
        return 1295;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gLE.a(i2, i3, str, this);
    }
}
