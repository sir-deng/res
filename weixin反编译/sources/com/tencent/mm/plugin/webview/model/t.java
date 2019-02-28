package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfl;
import com.tencent.mm.protocal.c.bfm;

public final class t extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gQm;

    public t(String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.hnT = new bfl();
        aVar.hnU = new bfm();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
        this.gLB = aVar.Kf();
        bfl bfl = (bfl) this.gLB.hnQ.hnY;
        bfl.fGh = str;
        bfl.scope = str2;
        bfl.state = str3;
        bfl.wRC = str4;
        bfl.wRD = str5;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1388;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
