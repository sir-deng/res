package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ym;
import com.tencent.mm.protocal.c.yn;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b lSH;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new ym();
        aVar.hnU = new yn();
        aVar.uri = "/cgi-bin/mmbiz-bin/getappticket";
        this.lSH = aVar.Kf();
        ym ymVar = (ym) this.lSH.hnQ.hnY;
        ymVar.fGh = str;
        ymVar.signature = str2;
    }

    public final int getType() {
        return 1097;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetAppTicket", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
