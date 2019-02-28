package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zw;
import com.tencent.mm.protocal.c.zx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class i extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public i(String str, String str2, Map<String, Object> map) {
        a aVar = new a();
        aVar.hnT = new zw();
        aVar.hnU = new zx();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
        this.gLB = aVar.Kf();
        zw zwVar = (zw) this.gLB.hnQ.hnY;
        zwVar.wfm = str;
        zwVar.vVt = str2;
        zwVar.wqn = (String) map.get("groupId");
        zwVar.sSA = (String) map.get("timestamp");
        zwVar.kZQ = (String) map.get("nonceStr");
        zwVar.signature = (String) map.get("signature");
        zwVar.wqo = map.get("params").toString();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1393;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
        return a(eVar, this.gLB, this);
    }

    public final zx bRo() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (zx) this.gLB.hnR.hnY;
    }
}
