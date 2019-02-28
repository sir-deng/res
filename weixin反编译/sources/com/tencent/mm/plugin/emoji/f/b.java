package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.protocal.c.sv;
import com.tencent.mm.sdk.platformtools.x;
import java.text.DecimalFormat;

public final class b extends k implements com.tencent.mm.network.k {
    public static int lEf = 6;
    public static int lEg = 7;
    public static int lEh = 10;
    private final com.tencent.mm.ad.b gLB;
    private e gQm;
    private String lEi;
    private sv lEj;

    public b(String str, sv svVar) {
        a aVar = new a();
        aVar.hnT = new dv();
        aVar.hnU = new dw();
        aVar.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
        this.gLB = aVar.Kf();
        this.lEi = str;
        this.lEj = svVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 830;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        dv dvVar = (dv) this.gLB.hnQ.hnY;
        dvVar.vPI = this.lEi;
        sv svVar = new sv();
        svVar.npE = this.lEj.npE;
        svVar.whT = this.lEj.whT;
        svVar.whS = new DecimalFormat("0.00").format(Float.valueOf(this.lEj.whS));
        dvVar.vPJ = svVar;
        return a(eVar, this.gLB, this);
    }

    public final dw aCu() {
        return (dw) this.gLB.hnR.hnY;
    }
}
