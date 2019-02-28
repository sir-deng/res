package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.protocal.c.nx;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    public static int hOu = 1;
    public static int hOv = 2;
    public static int hOw = 3;
    public static int hOx = 4;
    private b gLB;
    private e gLE;

    public h(int i) {
        a aVar = new a();
        aVar.hnT = new nx();
        aVar.hnU = new ny();
        aVar.uri = "/cgi-bin/micromsg-bin/checkunbind";
        aVar.hnS = i.CTRL_BYTE;
        this.gLB = aVar.Kf();
        ((nx) this.gLB.hnQ.hnY).wdA = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final String RJ() {
        try {
            String str = ((ny) this.gLB.hnR.hnY).wdB;
            x.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() " + str);
            return str;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", e, "", new Object[0]);
            return null;
        }
    }

    public final int getType() {
        return i.CTRL_BYTE;
    }

    public final ny RK() {
        return (ny) this.gLB.hnR.hnY;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
