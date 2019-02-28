package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atz;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    public b gLB;
    private com.tencent.mm.ad.e gLE;
    private byte[] pYH;
    private int pYI = 1;
    private String pYJ = "en";
    private String pYK = "zh_CN";
    private int pYL;

    public e(byte[] bArr, String str, String str2, int i) {
        this.pYH = bArr;
        this.pYI = 1;
        this.pYJ = str;
        this.pYK = str2;
        this.pYL = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new atz();
        aVar.hnU = new aua();
        aVar.uri = "/cgi-bin/micromsg-bin/ocrtranslation";
        aVar.hnS = 392;
        aVar.hnV = 199;
        aVar.hnW = 1000000199;
        this.gLB = aVar.Kf();
        atz atz = (atz) this.gLB.hnQ.hnY;
        atz.vUK = ((int) bi.Wy()) & Integer.MAX_VALUE;
        atz.vUL = new bes().bl(this.pYH);
        atz.vUO = this.pYI;
        atz.wIM = this.pYJ;
        atz.wIN = this.pYK;
        atz.vUP = this.pYL;
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        atz atz = (atz) ((b) qVar).hnQ.hnY;
        if (atz.vUK > 0 && !bi.oN(atz.wIN) && !bi.oN(atz.wIM) && atz.vUO >= 0 && atz.vUL != null && atz.vUL.wRk > 0) {
            return b.hoz;
        }
        x.e("MicroMsg.scanner.NetSceneOCRTranslate", "ERR: Security Check Failed");
        return b.hoA;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneOCRTranslate", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 392;
    }
}
