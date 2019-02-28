package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aud;
import com.tencent.mm.protocal.c.aue;

public final class r extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gQm;
    public Object tag;
    public String tyG;

    public r(String str, String str2, int i) {
        a aVar = new a();
        aVar.hnT = new aud();
        aVar.hnU = new aue();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
        this.tyG = str;
        this.gLB = aVar.Kf();
        aud aud = (aud) this.gLB.hnQ.hnY;
        aud.wIQ = str;
        aud.wIT = str2;
        aud.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1254;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
