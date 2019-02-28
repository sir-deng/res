package com.tencent.mm.t.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.cda;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gQm;
    private a<c> gQp;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public c(String str, LinkedList<String> linkedList, String str2, String str3, a<c> aVar) {
        this(str, linkedList, 0, str2, str3, 0, -1, aVar);
    }

    public c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3, a<c> aVar) {
        this(str, linkedList, i, str2, str3, i2, i3);
        this.gQp = aVar;
    }

    private c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3) {
        x.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new amz();
        aVar.hnU = new ana();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar.hnS = 1029;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        amz amz = (amz) this.gLB.hnQ.hnY;
        amz.nlV = str;
        amz.wAl = linkedList;
        amz.wAq = i;
        amz.nlE = str2;
        amz.wAr = str3;
        amz.wAn = i2;
        if (i3 > 0) {
            amz.wAo = new cda();
            amz.wAo.scene = i3;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gQm != null) {
            this.gQm.a(i2, i3, str, this);
        }
        if (this.gQp != null) {
            this.gQp.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1029;
    }

    public final ana Ce() {
        return (ana) this.gLB.hnR.hnY;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
