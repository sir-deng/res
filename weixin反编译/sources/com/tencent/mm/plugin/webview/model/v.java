package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpt;
import com.tencent.mm.protocal.c.bpu;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gQm;

    public v(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new bpt();
        aVar.hnU = new bpu();
        aVar.uri = "/cgi-bin/mmbiz-bin/transid";
        this.gLB = aVar.Kf();
        bpt bpt = (bpt) this.gLB.hnQ.hnY;
        bpt.fGh = str;
        bpt.wYK = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1142;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
