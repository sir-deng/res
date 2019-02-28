package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.bcj;
import com.tencent.mm.protocal.c.ug;
import com.tencent.mm.protocal.c.uh;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public int fMy;
    public int frq;
    private e gLE;
    private com.tencent.mm.ad.b hPx;
    private ug oeF;
    private uh oeG;
    public String oeH;
    public int oeI;
    public String oeJ;
    public int oeK;
    public bcj oeL;
    public int oeM;
    public String oeN;
    public String oeO;
    public String oeP;
    public int oeQ;

    public b(String str) {
        a aVar = new a();
        aVar.hnT = new ug();
        aVar.hnU = new uh();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
        this.hPx = aVar.Kf();
        this.oeF = (ug) this.hPx.hnQ.hnY;
        this.oeF.lUI = str;
        av bLR = i.bLR();
        if (bLR != null) {
            this.oeF.fXl = bLR.fXl;
            this.oeF.fXk = bLR.fXk;
            this.oeF.wiX = bLR.vME;
            this.oeF.wiY = bLR.vMF;
            this.oeF.wiZ = bLR.vMD;
            this.oeF.wja = bLR.latitude;
            this.oeF.wjb = bLR.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.oeG = (uh) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        x.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", Integer.valueOf(i2), Integer.valueOf(this.oeG.lot), this.oeG.lou);
        this.oeH = this.oeG.oeH;
        this.fMy = this.oeG.fMy;
        this.oeI = this.oeG.fMz;
        this.frq = this.oeG.frq;
        this.oeJ = this.oeG.ohP;
        this.oeK = this.oeG.oeK;
        this.oeL = this.oeG.wjc;
        this.oeM = this.oeG.oeM;
        this.oeN = this.oeG.oeN;
        this.oeO = this.oeG.oeO;
        this.oeP = this.oeG.oeP;
        this.oeQ = this.oeG.oeQ;
        if (this.gLE != null) {
            this.gLE.a(i2, this.oeG.lot, this.oeG.lou, this);
        }
    }

    public final int getType() {
        return 1997;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }
}
