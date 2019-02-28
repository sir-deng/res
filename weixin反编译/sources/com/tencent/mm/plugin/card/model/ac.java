package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.protocal.c.aar;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class ac extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public LinkedList<String> kOi;
    public int kOk;
    public int kOl;
    public int kOm;

    public ac(String str) {
        a aVar = new a();
        aVar.hnT = new aaq();
        aVar.hnU = new aar();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardserial";
        this.gLB = aVar.Kf();
        ((aaq) this.gLB.hnQ.hnY).fHP = str;
    }

    public final int getType() {
        return 577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aar aar = (aar) this.gLB.hnR.hnY;
            this.kOi = aar.kOi;
            this.kOk = aar.kOk;
            this.kOl = aar.kOl;
            this.kOm = aar.kOm;
        }
        x.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", Integer.valueOf(this.kOk), Integer.valueOf(this.kOl), Integer.valueOf(this.kOm));
        if (this.kOi != null) {
            x.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.kOi.size());
        }
        this.gLE.a(i2, i3, str, this);
    }
}
