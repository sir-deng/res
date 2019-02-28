package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.protocal.c.hz;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class c extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public c(String str, LinkedList<String> linkedList, int i, String str2, double d, double d2) {
        a aVar = new a();
        aVar.hnT = new hy();
        aVar.hnU = new hz();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
        this.gLB = aVar.Kf();
        hy hyVar = (hy) this.gLB.hnQ.hnY;
        hyVar.vPI = str;
        hyVar.sfa = i;
        hyVar.vUE = str2;
        hyVar.vUD = linkedList;
        hyVar.vUG = d2;
        hyVar.vUF = d;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1068;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
