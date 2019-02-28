package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aky;
import com.tencent.mm.protocal.c.bpx;
import com.tencent.mm.protocal.c.bpy;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    public String ffG = null;
    b gLB = null;
    private e gLE = null;
    public int lSN = 0;

    public n(aky aky, String str, String str2, int i) {
        a aVar = new a();
        aVar.hnT = new bpx();
        aVar.hnU = new bpy();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
        aVar.hnS = 1717;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bpx bpx = (bpx) this.gLB.hnQ.hnY;
        bpx.vQr = str;
        bpx.weM = str2;
        bpx.wYM = aky;
        bpx.wYN = i;
        this.ffG = str2;
        this.lSN = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1717;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
