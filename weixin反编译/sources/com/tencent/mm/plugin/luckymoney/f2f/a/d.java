package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.ui;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    public String lUI;
    public String oeH;
    private ui oeU;
    private uj oeV;
    public String oeW;
    public String oeX;
    public int oeY;

    public d() {
        a aVar = new a();
        aVar.hnT = new ui();
        aVar.hnU = new uj();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
        this.hPx = aVar.Kf();
        this.oeU = (ui) this.hPx.hnQ.hnY;
        this.oeU.timestamp = System.currentTimeMillis() / 1000;
        av bLR = i.bLR();
        if (bLR != null) {
            this.oeU.latitude = bLR.latitude;
            this.oeU.longitude = bLR.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.oeV = (uj) ((b) qVar).hnR.hnY;
        this.oeH = this.oeV.oeH;
        this.lUI = this.oeV.lUI;
        this.oeY = this.oeV.wjd;
        this.oeW = this.oeV.oeW;
        this.oeX = this.oeV.oeX;
        if (this.gLE != null) {
            this.gLE.a(i2, this.oeV.lot, this.oeV.lou, this);
        }
    }

    public final int getType() {
        return 1990;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }
}
