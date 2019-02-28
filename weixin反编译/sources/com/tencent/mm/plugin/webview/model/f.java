package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    String appId;
    final b gLB;
    private e gQm;
    String iOA;

    public f(String str, String str2) {
        this.appId = str;
        this.iOA = str2;
        a aVar = new a();
        aVar.hnT = new apy();
        aVar.hnU = new apz();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
        this.gLB = aVar.Kf();
        apy apy = (apy) this.gLB.hnQ.hnY;
        apy.fGh = str;
        apy.wDG = str2;
        x.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", str, str2);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1035;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
