package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class o extends k implements com.tencent.mm.network.k, b {
    public final com.tencent.mm.ad.b gLB;
    private e gQm;
    private final int tyA;
    public ame tyB;

    public o(ame ame, String str, String str2, String str3, String str4, String str5, String str6, String str7, com.tencent.mm.bp.b bVar, int i, LinkedList<anf> linkedList, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i));
        this.tyB = ame;
        this.tyA = i2;
        a aVar = new a();
        aVar.hnT = new amr();
        aVar.hnU = new ams();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
        this.gLB = aVar.Kf();
        amr amr = (amr) this.gLB.hnQ.hnY;
        amr.url = str;
        amr.fGh = str2;
        amr.wzP = str3;
        amr.fry = str4;
        amr.wzR = str5;
        amr.signature = str6;
        amr.wzS = str7;
        amr.wzU = i;
        amr.wzT = bVar;
        amr.wzY = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1096;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int bRr() {
        return this.tyA;
    }
}
